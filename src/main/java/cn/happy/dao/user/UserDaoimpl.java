package cn.happy.dao.user;
import cn.happy.bean.Users;
import cn.happy.dao.IBaseDao;
import cn.happy.util.BaseDao;
import cn.happy.util.PageUtil;
import cn.happy.util.ResultUtil;
import com.mysql.jdbc.util.ResultSetUtil;

import java.io.Serializable;
import java.sql.SQLException;
import java.util.List;

/**
 * 真正执行增删改查操作
 */
public class UserDaoimpl extends BaseDao implements UserDao{
/*注册
*
*
* */
    @Override
   public int add(Users users) {
     String sql="INSERT INTO news_user(userName,`password`,email,userType) VALUES(?,?,?,?)";
     Object[]params={users.getUserName(),users.getPassword(),users.getEmail(),users.getUserType()};
        System.out.println(sql+"===");
     return  executeUpdate(sql,params);
    }

    @Override
    public int dele(Serializable id) {
        return 0;
    }


    @Override
    public int updateById(Users users) {
        return 0;
    }

    @Override
    public Users findAllCondition(Serializable id) {
        return null;
    }

    @Override
    public List<Users> findall() {
        return null;
    }

    @Override
    public int findRownum() {
        return 0;
    }

    @Override
    public List<Users> finallPage(PageUtil util, Object... params) {
        return null;
    }

    @Override
    public int validateName(String userName) {
        String sql="select userName from news_user where userName=?";
        rs=executeQuery(sql,userName);
        if(rs!=null) {
            return  1;//找到了

        }
        return 0;//没找到
    }

    @Override
    public Users login(String userName, String password) {
      String sql="select id,userName,password,email,userType from `news_user`";
      Object []param={userName,password};
      rs=executeQuery(sql,param);
        ResultSetUtil.eachOne(rs,Users.class);
      Users ii=new Users();
        try {
            if(rs.next()){
             ii.setUser_id(rs.getInt("id"));
             ii.setUserName(rs.getString("userName"));
             ii.setPassword(rs.getString("password"));
             ii.setEmail(rs.getString("email"));
             ii.setUserType(rs.getInt("userType"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }


        return null;
    }
}
