package cn.happy.service.user;

import cn.happy.bean.Users;
import cn.happy.dao.user.UserDao;
import cn.happy.dao.user.UserDaoimpl;
import cn.happy.util.PageUtil;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Administrator on 2018-8-9.
 */
public class Userserviceimpl implements UserService {
    //耦合 加上动态代理
    private UserDao userDao1 = new UserDaoimpl();


    @Override
    public int add(Users users) throws Exception {
            return userDao1.add(users);
    }

    @Override
    public int deleteByCondition(Serializable id) {
        return userDao1.deleteByCondition(id);
    }

    @Override
    public int update(Users users) {
        return 0;
    }

    @Override
    public Users findByCondition(Serializable id) {
        return null;
    }

    @Override
    public List<Users> findAll() {
        return null;
    }

    @Override
    public int findRownum() {
        return userDao1.findRownum();
    }

    @Override
    public List<Users> findAllByPage(PageUtil util, Object... params) {
        return userDao1.findAllByPage(util);
    }

    /*验证名字是否存在*/
    @Override
    public String validateName(String userName) {
        return userDao1.validateName(userName);
    }

    @Override
    public Users login(String userName, String password) {
        return userDao1.login(userName,password);
    }


    /**
     * 注册
     *
     */



}
