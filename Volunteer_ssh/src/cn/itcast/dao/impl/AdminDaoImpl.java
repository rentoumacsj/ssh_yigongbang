package cn.itcast.dao.impl;

import org.hibernate.SessionFactory;

import cn.itcast.dao.IAdminDao;
import cn.itcast.entity.Admin;

public class AdminDaoImpl implements IAdminDao{

	//IOC»›∆˜£®“¿¿µ£©◊¢»ÎSessionFactory∂‘œÛ
	private SessionFactory sessionFactory;
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	@Override
	public void save(Admin admin) {
		sessionFactory.getCurrentSession().save(admin);
	}

	@Override
	public Admin findByAdmin(Admin admin) {
		return (Admin)sessionFactory.getCurrentSession()
				.createQuery("from Admin where phone=? and password=?")
				.setString(0, admin.getPhone())
				.setString(1, admin.getPassword())
				.uniqueResult();
	}

}
