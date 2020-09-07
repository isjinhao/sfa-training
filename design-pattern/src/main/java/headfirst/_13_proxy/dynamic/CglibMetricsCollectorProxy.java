package headfirst._13_proxy.dynamic;

import headfirst._13_proxy.MetricsCollector;
import headfirst._13_proxy.RequestInfo;
import headfirst._13_proxy.UserController;
import java.lang.reflect.Method;
import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

/**
 * @author 01395265
 * @description TODO
 * @date 2020/8/17
 */
public class CglibMetricsCollectorProxy {

    private MetricsCollector metricsCollector;

    private Enhancer enhancer = new Enhancer();

    Object object;

    public CglibMetricsCollectorProxy() {
        this.metricsCollector = new MetricsCollector();
    }

    public Object createProxy(Object proxiedObject) {
        object = proxiedObject;
        enhancer.setSuperclass(proxiedObject.getClass());
        enhancer.setCallback(new MetricsCollectorMethodInterceptor());
        return enhancer.create();
    }


    class MetricsCollectorMethodInterceptor implements MethodInterceptor {

        @Override
        public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {

            System.out.println(o.getClass());
            System.out.println(method.getName());

            System.out.println(objects[0]);
            System.out.println(objects[1]);
            System.out.println(methodProxy.getSuperName());

//            Thread.sleep(100000);

            long startTimestamp = System.currentTimeMillis();
            Object result = method.invoke(object, objects);
            long endTimeStamp = System.currentTimeMillis();
            long responseTime = endTimeStamp - startTimestamp;
            String apiName = o.getClass().getName() + ":" + method.getName();
            RequestInfo requestInfo = new RequestInfo(apiName, responseTime, startTimestamp, endTimeStamp);
            metricsCollector.recordRequest(requestInfo);
            System.out.println(methodProxy.getClass());
            return result;

        }
    }

    public static void main(String[] args) {

        CglibMetricsCollectorProxy cglibMetricsCollectorProxy = new CglibMetricsCollectorProxy();
        UserController proxy = (UserController)cglibMetricsCollectorProxy.createProxy(new UserController());
        proxy.login("123", "!@3");

    }

}