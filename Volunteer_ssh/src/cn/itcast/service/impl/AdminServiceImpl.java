package cn.itcast.service.impl;

import cn.itcast.dao.IAdminDao;
import cn.itcast.entity.Admin;
import cn.itcast.service.IAdminService;

public class AdminServiceImpl implements IAdminService{

	//注入dao 【这里一定要用接口接收】
	private IAdminDao adminDao;
	public void setAdminDao(IAdminDao adminDao) {
		this.adminDao = adminDao;
	}
	
	@Override
	public void register(Admin admin) {
		adminDao.save(admin);
	}

	@Override
	public Admin login(Admin admin) {
		return adminDao.findByAdmin(admin);
	}

}
