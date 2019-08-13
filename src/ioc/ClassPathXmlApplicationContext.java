//import org.dom4j.io.SAXReader;
//
//import java.util.HashMap;
//import java.util.Map;
//
///**
// * @Author yangwen-bo
// * @Date 2019/8/12.
// * @Version 1.0
// *
// * 创建装置 bean 的集合，这里使用 Map 集合，因为其 key-value 的存储结构方便存取 bean。
// * 在 ClassPathXmlApplicationContext 类的构造函数中完成 IoC 的核心业务，解析 XML 配置文件，
// * 通过反射机制创建定义好的 bean，并保存在上一步创建的集合中。
// * 实现抽象方法 getBean，通过 id 从集合中找到对应的 bean 进行返回。
// */
//public class ClassPathXmlApplicationContext implements ApplicationContext {
//    private Map<String,Object> ioc = new HashMap<>(  );
//    public ClassPathXmlApplicationContext(String path){
//        try {
//            //读取解析xml文件的类
//            //需要导入dom4j-1.6.1.jar和jaxen-1.2.0-atlassian-2.jar
//            SAXReader reader = new SAXReader();
//            //生成和解析xml文件
//            Document document = reader.read("./src/main/resources/"+path);
//            Element root = document.getRootElement();
//            Iterator<Element> iterator = root.elementIterator();
//            while(iterator.hasNext()){
//                Element element = iterator.next();
//                String id = element.attributeValue("id");
//                String className = element.attributeValue("class");
//                //通过反射机制创建对象
//                Class clazz = Class.forName(className);
//                //获取无参构造函数，创建目标对象
//                Constructor constructor = clazz.getConstructor();
//                Object object = constructor.newInstance();
//                //给目标对象赋值
//                Iterator<Element> beanIter = element.elementIterator();
//                while(beanIter.hasNext()){
//                    Element property = beanIter.next();
//                    String name = property.attributeValue("name");
//                    String valueStr = property.attributeValue("value");
//                    String methodName = "set"+name.substring(0,1).toUpperCase()+name.substring(1);
//                    Field field = clazz.getDeclaredField(name);
//                    Method method = clazz.getDeclaredMethod(methodName,field.getType());
//                    //根据成员变量的数据类型将 value 进行转换
//                    Object value = null;
//                    if(field.getType().getName() == "long"){
//                        value = Long.parseLong(valueStr);
//                    }
//                    if(field.getType().getName() == "java.lang.String"){
//                        value = valueStr;
//                    }
//                    if(field.getType().getName() == "int"){
//                        value = Integer.parseInt(valueStr);
//                    }
//                    method.invoke(object,value);
//                    ioc.put(id,object);
//                }
//            }
//        } catch (DocumentException e) {
//            e.printStackTrace();
//        } catch (ClassNotFoundException e){
//            e.printStackTrace();
//        } catch (NoSuchMethodException e){
//            e.printStackTrace();
//        } catch (InstantiationException e){
//            e.printStackTrace();
//        } catch (IllegalAccessException e){
//            e.printStackTrace();
//        } catch (InvocationTargetException e){
//            e.printStackTrace();
//        } catch (NoSuchFieldException e){
//            e.printStackTrace();
//        }
//    }
//
//    @Override
//    public Object getBean(String id) {
//        return ioc.get(id);
//    }
//}
