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
    int add(T t) throws Exception;//<T> 代表 你想写什么就写什么
    int dele(Serializable id);
    int updateById(T t);
    T findAllCondition(Serializable id);
    List<T> findall();
    int  findRownum();
    List<T>finallPage(PageUtil util,Object ...params);




}
