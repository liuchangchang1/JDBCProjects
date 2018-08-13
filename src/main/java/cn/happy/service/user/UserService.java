package cn.happy.service.user;

import cn.happy.bean.Users;
import cn.happy.service.IBaseService;
import cn.happy.util.PageUtil;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Administrator on 2018-8-9.
 */
public interface UserService extends IBaseService<Users>{
    /*
    * 验证
    *
    * **/
    String validateName(String userName);

    Users login(String userName, String password);

}
