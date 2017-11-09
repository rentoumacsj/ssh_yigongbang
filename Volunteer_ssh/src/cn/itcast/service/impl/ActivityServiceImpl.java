package cn.itcast.service.impl;

import java.util.List;

import cn.itcast.dao.IActivityDao;
import cn.itcast.entity.Activity;
import cn.itcast.service.IActivityService;

public class ActivityServiceImpl implements IActivityService {

	//注入dao 【这里一定要用接口接收】
	private IActivityDao activityDao;
	public void setActivityDao(IActivityDao activityDao) {
		this.activityDao = activityDao;
	}
	
	@Override
	public List<Activity> getAllActivities() {
		return activityDao.getAllActivities();
	}

	@Override
	public List<Activity> getActivitiesByAdminId(int adminId) {
		return activityDao.getActivitiesByAdminId(adminId);
	}

	@Override
	public Activity getActivityById(int id) {
		return activityDao.getActivityById(id);
	}

	@Override
	public void addActivity(Activity activity) {
		activityDao.addActivity(activity);
	}

	@Override
	public void updateActivity(Activity activity) {
		activityDao.updateActivity(activity);
	}

	@Override
	public void deleteActivityById(int id) {
		activityDao.deleteActivityById(id);
	}

	@Override
	public List<Activity> getFinishedActivitiesByVolId(int volId) {
		return activityDao.getFinishedActivitiesByVolId(volId);
	}

	@Override
	public List<Activity> getUnFinishedActivitiesByVolId(int volId) {
		return activityDao.getUnFinishedActivitiesByVolId(volId);
	}

	@Override
	public List<Activity> getCollectedActivitiesByVolId(int volId) {
		return activityDao.getCollectedActivitiesByVolId(volId);
	}

	@Override
	public List<Activity> getJoinedActivitiesByVolId(int volId) {
		return activityDao.getJoinedActivitiesByVolId(volId);
	}

}
