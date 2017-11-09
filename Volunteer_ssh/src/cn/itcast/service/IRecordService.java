package cn.itcast.service;

import cn.itcast.entity.Record;

public interface IRecordService {

	void join(Record record);
	void cancelJoin(Record record);
	void finish(Record record);
	void collect(Record record);
	void cancelCollect(Record record);
	Record getRecordInfo(Record record);
}
