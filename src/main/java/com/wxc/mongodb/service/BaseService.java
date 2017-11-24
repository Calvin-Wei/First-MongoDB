package com.wxc.mongodb.service;

import java.io.Serializable;
import java.util.List;

import com.wxc.mongodb.dao.IBaseDao;
import com.wxc.mongodb.util.PageModel;

/**
 * 基本Service实现类
 * @author Administrator
 *
 */
public abstract class BaseService<T> {
	protected abstract IBaseDao<T> getDao();
	/**
	 * 保存-实体
	 * @param entity
	 */
	public void save(T entity) {
		getDao().save(entity);
	}
	/**
	 * 修改实体
	 * @param entity
	 */
	public void update(T entity) {
		getDao().update(entity);
	}
	/**
	 * 删除实体[数组]
	 * @param ids
	 */
	public void delete(Serializable... ids) {
		getDao().delete(ids);
	}
	/**
	 * 根据ID查询
	 * @param id
	 * @return
	 */
	public T find(Serializable id) {
		return getDao().find(id);
	}
	
	
	
	/**
	 * 查询所有记录
	 * @return
	 */
	public List<T> findAll(){
		return getDao().findAll();
	}
	/**
	 * 查询所有记录并排序
	 * @param order
	 * @return
	 */
	public List<T> findAll(String order){
		return getDao().findAll(order);
	}
	/**
	 * 根据单一参数查询记录
	 * @param propName
	 * @param propValue
	 * @return
	 */
	public List<T> findByProp(String propName,Object propValue){
		return getDao().findByProp(propName, propValue);
	}
	/**
	 * 根据单一参数查询记录并排序
	 * @param propName
	 * @param propValue
	 * @param order
	 * @return
	 */
	public List<T> findByProp(String propName,Object propValue,String order){
		return getDao().findByProp(propName, propValue,order);
	}
	/**
	 * 根据单一参数查询唯一结果
	 * @param propName
	 * @param propValue
	 * @return
	 */
	public T uniqueByProp(String propName,Object propValue) {
		return getDao().uniqueByProp(propName, propValue);
	}
	/**
	 * 根据多个参数查询唯一结果
	 * @param propName
	 * @param propValue
	 * @return
	 */
	public T uniqueByProps(String[] propName,Object[] propValue) {
		return getDao().uniqueByProps(propName, propValue);
	}
	/**
	 * 分页查询所有结果集合
	 * @param pageNo
	 * @param pageSize
	 * @return
	 */
	public PageModel<T> pageAll(int pageNo,int pageSize){
		return getDao().pageAll(pageNo, pageSize);
	}
	/**
	 * 分页查询所有结果集合，并排序
	 * @param pageNo
	 * @param pageSize
	 * @param order
	 * @return
	 */
	public PageModel<T> pageAll(int pageNo,int pageSize,String order){
		return getDao().pageAll(pageNo, pageSize, order);
	}
	/**
	 * 根据参数分页查询结果集合
	 * @param pageNo
	 * @param pageSize
	 * @param param
	 * @param value
	 * @return
	 */
	public PageModel<T> pageByProp(int pageNo,int pageSize,String param,Object value){
		return getDao().pageByProp(pageNo, pageSize, param, value);
	}
	/**
	 * 根据参数分页查询结果集合
	 * @param pageNo
	 * @param pageSize
	 * @param params
	 * @param values
	 * @return
	 */
	public PageModel<T> pageByProps(int pageNo,int pageSize,String[] params,Object[] values){
		return getDao().pageByProps(pageNo,pageSize,params,values);
	}
}
