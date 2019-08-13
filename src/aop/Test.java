package aop;

/**
 * @Author yangwen-bo
 * @Date 2019/8/13.
 * @Version 1.0
 */
public class Test {
    public static void main(String[] args) {
        //委托对象
        Cal cal = new CalImpl();
        MyInvocationHandler mh = new MyInvocationHandler();
        //代理对象
        Cal cal2 = (Cal) mh.bind(cal);
        cal2.add(10, 3);
        cal2.sub(10, 3);
        cal2.mul(10, 3);
        cal2.div(10, 3);
    }
}
