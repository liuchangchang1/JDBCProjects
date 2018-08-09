package cn.happy.service;

import cn.happy.util.PageUtil;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Administrator on 2018-8-9.
 */
public interface IBaseService<T> {
    int add(T t) throws Exception; //代表你想些什么就写什么类型
    int deleteByCondition(Serializable id);
    int update(T t);
    T findByCondition(Serializable id);
    List<T> findAll();
    int findRownum();
    List<T>  findAllByPage(PageUtil util, Object ...params);

}
