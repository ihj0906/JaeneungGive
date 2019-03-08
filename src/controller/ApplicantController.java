package controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import dto.Applicant;
import service.ApplicantService;
import service.GiveService;

@Controller
@RequestMapping("/applicant")
public class ApplicantController {

	@Autowired
	private ApplicantService applicantSvc;

	@Autowired
	private GiveService giveSvc;

	@RequestMapping(value = "/add")
	public String addApplicant(@RequestParam("url") String url,
			@RequestParam(value = "people", required = false) String peopleS, Applicant applicant) {
		if (peopleS != null) {
			int people = Integer.parseInt(peopleS);
			// 1) 해당 글의 총 인원수 값을 가져옴 v
			// 2) 해당 글의 현재 지원자 count 값을 가져옴
			int count = applicantSvc.countOfApplicant(applicant.getBoard_id(), applicant.getBoard_no());
			if (count < people) {
				// 3-1 ) 해당 글의 지원자 숫자가 총인원수보다 작을 경우 지원
				applicantSvc.addApplicant3(applicant);
				// 3-2 ) 해당 글의 지원자 숫자가 총인원수보다 -1 일 경우 지원 성공 및 글 상태 완료로 변경
				if (count == people - 1) {
					giveSvc.updateDonationProgress(3, applicant.getBoard_no());
				}
			}
			// 3-3 ) 지원자수 = 총인원수
			return "redirect:" + url;
		}
//		교환 신청시 
		applicantSvc.addApplicant1(applicant);
		return "redirect:" + url;
	}

	/**
	 * 
	 * @param url 
	 * @param board_no
	 * @param board_id
	 * @param id 신청
	 * @param peopleS 기부 총 인원수 
	 * @return
	 */
	@RequestMapping(value = "/del")
	public String delApplicant(@RequestParam("url") String url, @RequestParam("board_no") int board_no,
			@RequestParam("board_id") int board_id, @RequestParam("id") String id,
			@RequestParam(value = "people", required = false) String peopleS) {
		if (peopleS != null) {
			int people = Integer.parseInt(peopleS);
			int count = applicantSvc.countOfApplicant(board_id, board_no);
			if (count == people) {
				giveSvc.updateDonationProgress(1, board_no);
			}
			applicantSvc.delApplicant(board_no, board_id, id);
			return "redirect:" + url;
		}
		applicantSvc.delApplicant(board_no, board_id, id);
		return "redirect:" + url;
	}

	// 진행상태 (1 진행중 2 완료(승인) 3 거절)
	@RequestMapping(value = "/submit")
	public String submitApplicant(@RequestParam("url") String url, @RequestParam("board_no") int board_no,
			@RequestParam("board_id") int board_id, @RequestParam("appli_confirmId") String id) {
		ArrayList<Applicant> listOfApplicant = applicantSvc.listOfApplicant(board_no, board_id);
		int progress = 1;
		for (int i = 0; i < listOfApplicant.size(); i++) {
			Applicant applicant = listOfApplicant.get(i);
			if (applicant.getId().equals(id)) {
				progress = 2;
				applicantSvc.confirmApplicant(applicant, progress);
			} else {
				progress = 3;
				applicantSvc.confirmApplicant(applicant, progress);
			}
			giveSvc.updateExchangeProgress(board_no);
		}
		return "redirect:" + url;
	}

}
