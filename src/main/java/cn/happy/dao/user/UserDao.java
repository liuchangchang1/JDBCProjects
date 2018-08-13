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
 * 验证用户名的操作!
 * */


  String validateName(String userName);

  Users login(String userName, String password);
}
