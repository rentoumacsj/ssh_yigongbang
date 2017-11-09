package cn.itcast.service.impl;

import cn.itcast.dao.IRecordDao;
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

	@Override
	public void join(Record record) {
		Record r = recordDao.findByRecord(record);
		record.setIsJoined(true);
		if(r==null){
			recordDao.save(record);
		}else{
			recordDao.update(record);
		}
	}

	@Override
	public void finish(Record record) {
		record.setIsFinished(true);
		recordDao.update(record);
	}

	@Override
	public void collect(Record record) {
		Record r = recordDao.findByRecord(record);
		record.setIsCollected(true);
		if(r==null){
			recordDao.save(record);
		}else{
			recordDao.update(record);
		}
	}

	@Override
	public void cancelCollect(Record record) {
		record.setIsCollected(true);
		recordDao.update(record);
	}


}
