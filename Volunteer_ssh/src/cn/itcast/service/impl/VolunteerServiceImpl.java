package cn.itcast.service.impl;

import cn.itcast.dao.IVolunteerDao;
import cn.itcast.entity.Volunteer;
import cn.itcast.service.IVolunteerService;

public class VolunteerServiceImpl implements IVolunteerService {

	private IVolunteerDao volunteerDao;
	public void setVolunteerDao(IVolunteerDao volunteerDao) {
		this.volunteerDao = volunteerDao;
	}
	
	@Override
	public void register(Volunteer volunteer) {
		volunteerDao.save(volunteer);
	}

	@Override
	public Volunteer login(Volunteer volunteer) {
		return volunteerDao.findByVolunteer(volunteer);
	}

	@Override
	public void update(Volunteer volunteer) {
		volunteerDao.update(volunteer);
	}

}
