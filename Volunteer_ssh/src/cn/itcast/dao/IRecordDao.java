package cn.itcast.dao;

import cn.itcast.entity.Record;

public interface IRecordDao {

	void save(Record record);
	void update(Record record);
	Record findByRecord(Record record);
}
