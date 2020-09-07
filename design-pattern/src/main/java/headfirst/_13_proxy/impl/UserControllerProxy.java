package headfirst._13_proxy.impl;

import headfirst._13_proxy.IUserController;
import headfirst._13_proxy.MetricsCollector;
import headfirst._13_proxy.RequestInfo;
import headfirst._13_proxy.UserController;
import headfirst._13_proxy.UserVo;

public class UserControllerProxy implements IUserController {

    private MetricsCollector metricsCollector;
    private UserController userController;

    public UserControllerProxy(UserController userController) {
        this.userController = userController;
        this.metricsCollector = new MetricsCollector();
    }

    @Override
    public UserVo login(String telephone, String password) {
        long startTimestamp = System.currentTimeMillis();
        UserVo userVo = userController.login(telephone, password);
        long endTimeStamp = System.currentTimeMillis();
        long responseTime = endTimeStamp - startTimestamp;
        RequestInfo requestInfo = new RequestInfo("login", responseTime, startTimestamp, endTimeStamp);
        metricsCollector.recordRequest(requestInfo);
        return userVo;
    }

    @Override
    public UserVo register(String telephone, String password) {
        long startTimestamp = System.currentTimeMillis();
        UserVo userVo = userController.register(telephone, password);
        long endTimeStamp = System.currentTimeMillis();
        long responseTime = endTimeStamp - startTimestamp;
        RequestInfo requestInfo = new RequestInfo("register", responseTime, startTimestamp, endTimeStamp);
        metricsCollector.recordRequest(requestInfo);
        return userVo;
    }
}