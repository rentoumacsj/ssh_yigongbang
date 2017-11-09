package cn.itcast.dao.impl;

import org.hibernate.SessionFactory;

import cn.itcast.dao.IRecordDao;
import cn.itcast.entity.Record;

public class RecordDaoImpl implements IRecordDao{

	//IOC»›∆˜£®“¿¿µ£©◊¢»ÎSessionFactory∂‘œÛ
	private SessionFactory sessionFactory;
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}	
	
	@Override
	public void save(Record record) {
		sessionFactory.getCurrentSession().save(record);
	}

	@Override
	public void update(Record record) {
		sessionFactory.getCurrentSession().update(record);
	}

	@Override
	public Record findByRecord(Record record) {
		return (Record) sessionFactory.getCurrentSession()
				.createQuery("from Record where volId=? and actId=?")
				.setInteger(0, record.getVolId())
				.setInteger(1, record.getActId())
				.uniqueResult();
	}

}
