package cn.itcast.service.impl;

import cn.itcast.dao.IActivityDao;
import cn.itcast.dao.IRecordDao;
import cn.itcast.dao.impl.ActivityDaoImpl;
import cn.itcast.entity.Activity;
import cn.itcast.entity.Record;
import cn.itcast.service.IRecordService;

public class RecordServiceImpl implements IRecordService{

	//注入dao 【这里一定要用接口接收】
	private IRecordDao recordDao;
	public void setRecordDao(IRecordDao recordDao) {
		this.recordDao = recordDao;
	}
	
	@Override
	public Record getRecordInfo(Record record) {
		return recordDao.findByRecord(record);
	}
	
	private IActivityDao activityDao;
	public IActivityDao getActivityDao() {
		return activityDao;
	}
	public void setActivityDao(IActivityDao activityDao) {
		this.activityDao = activityDao;
	}

	@Override
	public void join(Record record) {
		Record r = recordDao.findByRecord(record);
		if(r==null){
			record.setIsJoined(true);
			recordDao.save(record);
			Activity activity = activityDao.getActivityById(record.getActId());
			activity.setCurPeople(activity.getCurPeople()+1);
			activityDao.updateActivity(activity);
		}else{
			r.setIsJoined(true);
			recordDao.update(r);
			Activity activity = activityDao.getActivityById(r.getActId());
			activity.setCurPeople(activity.getCurPeople()+1);
			activityDao.updateActivity(activity);
		}
	}
	
	@Override
	public void cancelJoin(Record record) {
		Record r = recordDao.findByRecord(record);
		r.setIsJoined(false);
		recordDao.update(r);
		Activity activity = activityDao.getActivityById(r.getActId());
		activity.setCurPeople(activity.getCurPeople()-1);
		activityDao.updateActivity(activity);
	}
	
	

	@Override
	public void finish(Record record) {
		Record r = recordDao.findByRecord(record);
		r.setIsFinished(true);
		recordDao.update(r);
	}

	@Override
	public void collect(Record record) {
		Record r = recordDao.findByRecord(record);
		if(r==null){
			record.setIsJoined(true);
			recordDao.save(record);
		}else{
			r.setIsJoined(true);
			recordDao.update(r);
		}
	}

	@Override
	public void cancelCollect(Record record) {
		Record r = recordDao.findByRecord(record);
		r.setIsCollected(false);
		recordDao.update(r);
	}


}
