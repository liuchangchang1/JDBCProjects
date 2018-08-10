package cn.happy.controller;

import cn.happy.bean.Users;
import cn.happy.service.ServiceFactory;
import cn.happy.service.user.UserService;
import cn.happy.util.Md5Encrypt;
import cn.happy.util.ResultUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;

/**
 * Created by Administrator on 2018-8-7.
 */
@WebServlet("/login")
public class Uservlet extends  BaseServlet {
    @Override
    public Class getServletClass() {//都像Baseservlet靠拢
        System.out.println("=====02:UserServlet===》getServletClass");
        return Uservlet.class;//确定Uservlet这个类，执行 Uservlet。
    }

    //不实例化service层对象  让工厂去实例化

    //不实例化service层对象  让工厂去实例化
    private UserService userService;
    private ResultUtil util;

    //当用户访问我们这个servlet的时候 先执行init
    @Override
    public void init() throws ServletException {
        userService = (UserService) ServiceFactory.getServiceImpl("userService");
    }

    /**
     * 用户注册的方法
     */
    public String register(HttpServletRequest req, HttpServletResponse resp) throws Exception {
        //获取用户输入的参数
        String userName = req.getParameter("username");
        String password = req.getParameter("password");
        Users users = new Users();
        users.setUserName(userName);
        try {
            users.setPassword(Md5Encrypt.getEncryptedPwd(password));
            System.out.println(users.getPassword());
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        users.setUserType(0);  //设置用户类型
        users.setEmail("55");
        int num = userService.add(users);
        if (num > 0) {//如果加进去值了，
            return "main";
        } else {
            return "register";
        }
    }


    public ResultUtil login(HttpServletRequest req, HttpServletResponse resp) {
        System.out.println("====>UserServlet===>login");
        //获取用户登录的用户名和密码
        String userName = req.getParameter("username");
        String password = req.getParameter("password");
        ResultUtil util = new ResultUtil();
        //得从数据库中获取一个用户名  如果没有用户名不需要再执行后续代码
        if (userName.equals("admin")) {
            util.resultSuccess(userName);
        } else {
            util.resultFail("用户名错误");
        }
        //调用MD5验证密码
        return util;
    }



    public ResultUtil validateName(HttpServletRequest req, HttpServletResponse resp){
        System.out.println("进入了validatename===");
        String userName=req.getParameter("username");
        int num=userService.validateName(userName);
        if(num==0){
            util.resultSuccess();//可以注册
        }
        else{
            util.resultFail("该名称以经被占用 ");
        }

        return  util;
    }
}
