package com.wxc.mongodb.dao;

import java.io.Serializable;
import java.util.List;

import com.wxc.mongodb.util.PageModel;

/**
 * 通用基本操作方法接口
 * 
 * @author Administrator
 *
 */
public interface IBaseDao<T> {
	// 保存实体
	public void save(T entity);

	// 修改实体
	public void update(T entity);

	// 删除实体
	public void delete(Serializable... ids);

	// 根据ID查询
	public T find(Serializable id);

	// 查询所有记录
	public List<T> findAll();

	// 查询所有记录并排序
	public List<T> findAll(String order);

	// 根据单一参数查询记录
	public List<T> findByProp(String propName, Object propValue);

	// 根据单一参数查询记录并排序
	public List<T> findByProp(String propName, Object propValue, String order);

	// 根据多个参数查询记录
	public List<T> findByProps(String[] propName, Object[] propValue);

	// 根据多个参数查询记录
	public List<T> findByProps(String[] propName, Object[] propValue, String order);

	// 根据单一参数查询唯一结果
	public T uniqueByProp(String propName, Object propValue);

	// 根据多个参数查询唯一结果
	public T uniqueByProps(String[] propName, Object[] propValue);

	// 分页查询所有结果集合
	public PageModel<T> pageAll(int pageNo, int pageSize);

	// 分页查询所有结果集合 并排序
	public PageModel<T> pageAll(int pageNo, int pageSize, String order);

	// 根据参数分页查询结果集合
	public PageModel<T> pageByProp(int pageNo, int pageSize, String param, Object value);

	// 根据参数分页查序结果集合
	public PageModel<T> pageByProps(int pageNo, int pageSize, String[] params, Object[] values);

	// 根据参数分页查询结果集合并排序
	public PageModel<T> pageByProps(int pageNo, int pageSize, String[] params, Object[] values, String order);

	// 根据条件查询总记录数
	public int countByCondition(String[] params, Object[] values);

}
