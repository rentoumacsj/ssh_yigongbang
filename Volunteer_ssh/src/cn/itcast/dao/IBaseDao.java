package cn.itcast.dao;

import java.util.List;

/**
 * 所有dao的通用操作接口定义
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
