package cn.happy.dao.user;
import cn.happy.bean.Users;
import cn.happy.dao.IBaseDao;
import cn.happy.util.BaseDao;
import cn.happy.util.PageUtil;
import java.io.Serializable;
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
}
