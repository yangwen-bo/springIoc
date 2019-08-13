package ioc;

/**
 * Created by lenovo on 2019/8/12.
 * @ yangwen-bo
 *
 * 读取 XML 文件，获取 POJO 的相关信息
 * 定义 getBean 方法，通过 id 返回 bean
 */
public interface ApplicationContext {
    public Object getBean(String id);
}
