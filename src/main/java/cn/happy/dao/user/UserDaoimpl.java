package cn.happy.dao.user;
import cn.happy.bean.Users;
import cn.happy.util.BaseDao;
import cn.happy.util.PageUtil;
import cn.happy.util.ResultSetUtil;
import org.junit.jupiter.api.Test;


import java.io.Serializable;
import java.sql.SQLException;
import java.util.List;

/**
 * 真正执行增删改查操作
 */
public class UserDaoimpl extends BaseDao implements UserDao {




    /*注册
    *
    *
    * */
    @Override
    public int add(Users users) {
        String sql = "INSERT INTO news_user(userName,`password`,email,userType) VALUES(?,?,?,?)";
        Object[] params = {users.getUserName(), users.getPassword(), users.getEmail(), users.getUserType()};
        System.out.println(sql + "===");
        return executeUpdate(sql, params);
    }

    /*
    * 验证用户名是否存在的操作/密码是否正确
     */
    @Override
    public String validateName(String userName) {
        String sql = "SELECT password FROM news_user WHERE userName=?";
        rs = executeQuery(sql, userName);
        String password = null;
        try { //获取密码
            if (rs.next()) {
                password = rs.getString("password");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return password;
    }

    /**
     * 登录
     */
    @Override
    public Users login(String userName, String password) {
        String sql = "SELECT id as users_id,userName,PASSWORD,email,userType FROM news_user where userName=? and password=?";
        Object[] params = {userName, password};
        rs = executeQuery(sql, params);
        Users users = ResultSetUtil.eachOne(rs, Users.class);
        System.out.println("111");
        return users;
    }


    @Override
    public int deleteByCondition(Serializable id) {
        String sql="delete from news_user where id=?";
        int num= executeUpdate(sql,id);
        return num;
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
    /*
    * 查询总记录数
    *
    * */
    public int findRownum() {
        //查询总记录数：
        String sql = "SELECT COUNT(id) as count FROM news_user";
        rs = executeQuery(sql);//查询带有表的记录数
        int count = 0;
        try {
            if (rs.next()) {
                count = rs.getInt("count");

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return count;
    }

    /*
    * 根据分页查询
    *1 limit 分页sql
    *   数组 分页。
    *   executeQuery 方法查询 sql，p
    *   再用反射过来的属性 Users.class
    *  Object 当前页数-1 *页码数
    * */
    public List<Users> findAllByPage(PageUtil util, Object... params) {
        String sql="SELECT id as users_id,userName,PASSWORD,email,userType FROM news_user limit ?,?";
        Object[] p={(util.getPageIndex()-1)*util.getPageSize(),util.getPageSize()};
        rs= executeQuery(sql,p);
        List<Users>  list= ResultSetUtil.eachList(rs,Users.class);
        return list;
    }
}

