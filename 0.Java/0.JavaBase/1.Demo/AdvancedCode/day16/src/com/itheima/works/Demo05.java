package com.itheima.works;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Properties;

public class Demo05 {
    /*
    已知一个类，定义如下

    package com.itcast.test05;
    public class DemoClass {
        public void run() {
            System.out.println("welcome to heima!");
        }
    }
    (1) 写一个Properties格式的配置文件，配置文件内容如下：

    className=com.itcast.test07.DemoClass

    (2)写一个程序，读取这个Properties配置文件，获得类的完整名称并加载这个类，

    (3)用反射的方式运行run方法。
     */
    public static void main(String[] args) throws IOException, ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        InputStream is = ClassLoader.getSystemResourceAsStream("prop.properties");
        Properties prop = new Properties();
        prop.load(is);

        Class<?> clazz = Class.forName((String) prop.get("className"));
        Constructor<?> constructor = clazz.getConstructor();

        Object o = constructor.newInstance();

        Method run = clazz.getMethod("run");
        run.invoke(o);
    }
}
