package cn.happy.service;

import cn.happy.service.user.Userserviceimpl;

/**
 * Created by Administrator on 2018-8-9.
 */
public class ServiceFactory {

    /**
     * 什么时候使用工厂模式？
     * 01.需要实例化很多对象
     * 02.这些对象有共同的父类或者接口
     */

        //创建本类的静态对象
        private static  ServiceFactory factory;

        //私有化构造
        private ServiceFactory(){}

        static {
            if (factory==null){
                synchronized (ServiceFactory.class){
                    if (factory==null){
                        factory=new ServiceFactory();
                    }
                }
            }
        }

        public static IBaseService getServiceImpl(String serviceName) {
            IBaseService  service=null;
            switch (serviceName){
                case "userService":
                    service=new Userserviceimpl();
                default:
                    break;
            }
            return  service;
        }
}
