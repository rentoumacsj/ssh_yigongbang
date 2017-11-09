package cn.itcast.dao;

import cn.itcast.entity.Admin;

public interface IAdminDao {

	void save(Admin admin);
	Admin findByAdmin(Admin admin);
}
