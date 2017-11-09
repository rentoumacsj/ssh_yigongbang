package cn.itcast.dao.impl;

import org.hibernate.SessionFactory;

import cn.itcast.dao.IVolunteerDao;
import cn.itcast.entity.Volunteer;

public class VolunteerDaoImpl implements IVolunteerDao{

	//IOC»›∆˜£®“¿¿µ£©◊¢»ÎSessionFactory∂‘œÛ
	private SessionFactory sessionFactory;
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	@Override
	public void save(Volunteer volunteer){
		sessionFactory.getCurrentSession().save(volunteer);
	}

	@Override
	public Volunteer findByVolunteer(Volunteer volunteer) {
		return (Volunteer)sessionFactory.getCurrentSession()
				.createQuery("from Volunteer where phone=? and password=?")
				.setString(0, volunteer.getPhone())
				.setString(1, volunteer.getPassword())
				.uniqueResult();
	}

	@Override
	public void update(Volunteer volunteer) {
		sessionFactory.getCurrentSession().update(volunteer);
	}

	@Override
	public void delete(int id) {
		sessionFactory.getCurrentSession().delete(id);
	}

}
