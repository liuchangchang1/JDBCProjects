package cn.happy.dao.user;

import cn.happy.bean.Users;
import cn.happy.dao.IBaseDao;

/**
 * Created by Administrator on 2018-8-9.
 * 书写自己特有的功能
 */
public interface UserDao extends IBaseDao<Users>{
 /*
 *
 * 登陆的操作！
 * */

 public int validateName(String userName);
public  Users login(String userName,String password);
}
