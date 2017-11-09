package cn.itcast.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import cn.itcast.dao.IActivityDao;
import cn.itcast.entity.Activity;

public class ActivityDaoImpl implements IActivityDao {

	//IOC容器（依赖）注入SessionFactory对象
	private SessionFactory sessionFactory;
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	@Override
	public List<Activity> getAllActivities() {
		return sessionFactory.getCurrentSession()
				.createQuery("from Activity order by actTime DESC")
				.list();
	}
	
	@Override
	public List<Activity> getActivitiesByAdminId(int adminId) {
		return sessionFactory.getCurrentSession()
				.createQuery("from Activity where adminId=? order by actTime DESC")
				.setInteger(0, adminId)
				.list();
				
	}

	@Override
	public Activity getActivityById(int id) {
		return (Activity) sessionFactory.getCurrentSession()
				.createQuery("from Activity where id=?")
				.setInteger(0, id)
				.uniqueResult();
	}

	@Override
	public void addActivity(Activity activity) {
		sessionFactory.getCurrentSession().save(activity);
	}

	@Override
	public void updateActivity(Activity activity) {
		sessionFactory.getCurrentSession().update(activity);
	}

	@Override
	public void deleteActivityById(int id) {
		Session session = sessionFactory.getCurrentSession();
		Activity a = (Activity) session.get(Activity.class, id);
		session.delete(a);
	}

	//获取已完成的活动
	@Override
	public List<Activity> getFinishedActivitiesByVolId(int volId) {
		return sessionFactory.getCurrentSession()
				.createQuery("from Activity where id in (select actId from Record where volId=? and isJoined=true and isFinished=true)")
				.setInteger(0, volId)
				.list();
	}

	//获取未完成的活动
	@Override
	public List<Activity> getUnFinishedActivitiesByVolId(int volId) {
		return sessionFactory.getCurrentSession()
				.createQuery("from Activity where id in (select actId from Record where volId=? and isJoined=true and isFinished=false)")
				.setInteger(0, volId)
				.list();
	}

	//获取收藏的活动
	@Override
	public List<Activity> getCollectedActivitiesByVolId(int volId) {
		return sessionFactory.getCurrentSession()
				.createQuery("from Activity where id in (select actId from Record where volId=? and isCollected=true)")
				.setInteger(0, volId)
				.list();
	}

	@Override
	public List<Activity> getJoinedActivitiesByVolId(int volId) {
		return sessionFactory.getCurrentSession()
				.createQuery("from Activity where id in (select actId from Record where volId=? and isJoined=true)")
				.setInteger(0, volId)
				.list();
	}
	
}
