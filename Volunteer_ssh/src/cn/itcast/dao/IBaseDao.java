package cn.itcast.dao;

import java.util.List;

/**
 * ����dao��ͨ�ò����ӿڶ���
 * @author rentoumcasj
 *
 */
public interface IBaseDao<T> {

	void save(T t);
	void update(T t);
	void delete(int id);
	T findById(int id);
	List<T> getAll();
}
