package cn.itcast.dao;

import cn.itcast.entity.Volunteer;

public interface IVolunteerDao {

	void save(Volunteer volunteer);
	Volunteer findByVolunteer(Volunteer volunteer);
	void update(Volunteer volunteer);
	void delete(int id);
}
