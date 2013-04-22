package com.easycms.base;
import java.io.Serializable;
import java.util.List;

import javax.annotation.Resource;
import com.easycms.dao.Idao;
import com.easycms.common.GetEntityClassUtil;

public abstract class AbstractBaseDao<T,PK extends Serializable> implements BaseDao<T,PK>{
	Class entityClass = GetEntityClassUtil.getEntityClass(getClass());
	@Resource
	private Idao<T, Serializable> idao;
	@Override
	public void save(T entity) {
		idao.save(entity);
	}
	@Override
	public void delete(PK pk) {
		idao.delete(entityClass,pk);
		
	}
	@Override
	public void update(T entity) {
		idao.update(entity);
		
	}
	@Override
	public T findById(PK pk) {
		return idao.findById(entityClass, pk);
	}
	@Override
	public List<T> findAll() {
		return idao.findAll(entityClass);
	}


}