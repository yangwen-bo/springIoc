package aop;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;

/**
 * @Author yangwen-bo
 * @Date 2019/8/13.
 * @Version 1.0
 *
 * 动态代理类
 */
public class MyInvocationHandler implements InvocationHandler {
    //委托对象
    private Object obj = null;

    //将外部传进来的委托对象保存到成员变量中
    //返回创建一个代理对象
    public Object bind(Object obj){
        this.obj = obj;
        //我们知道对象是 JVM 根据运行时类来创建的，此时需要动态创建一个代理对象的运行时类，
        // 同时需要将这个动态创建的运行时类加载到 JVM 中，这一步需要获取到类加载器才能实现
        //通过委托对象的运行时类来获取类加载器,代理对象需要获取委托对象的所有接口，当前代理类
        return Proxy.newProxyInstance(obj.getClass().getClassLoader(), obj.getClass().getInterfaces(), this);
    }

    /**
     * invoke 方法：method 是描述委托对象所有方法的对象，agrs 是描述委托对象方法参数列表的对象。
     * method.invoke(this.obj,args) 是通过反射机制来调用委托对象的方法，即业务方法。
     */
    @Override
    public Object invoke(Object proxy, Method method, Object[] args)
            throws Throwable {
        // TODO Auto-generated method stub
        System.out.println(method.getName()+"的参数是:"+ Arrays.toString(args));
        Object result = method.invoke(this.obj, args);
        System.out.println(method.getName()+"的结果是:"+result);
        return result;
    }
}
