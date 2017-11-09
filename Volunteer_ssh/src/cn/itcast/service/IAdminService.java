package cn.itcast.service;

import cn.itcast.entity.Admin;

public interface IAdminService {

	void register(Admin admin);
	Admin login(Admin admin);
}
