package service;

import dao.AdminDao;
import dto.Admin;

public class AdminLoginService {
	private AdminDao adminDao;

	public AdminLoginService(AdminDao adminDao) {
		this.adminDao = adminDao;
	}

	public Admin selectId(String id, String password) {
		return adminDao.selectId(id);
	}
}
