package cn.itcast.service;

import java.util.List;

import cn.itcast.entity.Activity;

public interface IActivityService {

	List<Activity> getAllActivities();
	List<Activity> getActivitiesByAdminId(int adminId);
	List<Activity> getJoinedActivitiesByVolId(int volId);
	List<Activity> getFinishedActivitiesByVolId(int volId);
	List<Activity> getUnFinishedActivitiesByVolId(int volId);
	List<Activity> getCollectedActivitiesByVolId(int volId);
	Activity getActivityById(int id);
	void addActivity(Activity activity);
	void updateActivity(Activity activity);
	void deleteActivityById(int id);
}
