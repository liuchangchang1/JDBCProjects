package cn.happy.dao;

import cn.happy.util.PageUtil;

import java.io.Serializable;
import java.util.List;

/**
 * 所有接口的父接口
 * 所有接口的公共方法
 */
public interface  IBaseDao<T> {
       //注册,增加，删除，修改
       int add(T t);
    int deleteByCondition(Serializable id);
    int update(T t);
    T findByCondition(Serializable id);
    List<T> findAll();
    int findRownum();
    List<T>  findAllByPage(PageUtil util, Object ...params);



}
