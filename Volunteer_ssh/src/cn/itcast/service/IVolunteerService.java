package cn.itcast.service;

import cn.itcast.entity.Volunteer;

public interface IVolunteerService {

	void register(Volunteer volunteer);
	Volunteer login(Volunteer volunteer);
	void update(Volunteer volunteer);
}
