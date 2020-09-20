package com.itheima.demo;

import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.io.File;
import java.util.List;

public class Demo01 {
    public static void main(String[] args) throws DocumentException {
        // 1.获取一个解析器对象
        SAXReader saxReader = new SAXReader();

        // 2.利用解析器把xml文件加载到内存中，并返回一个文档对象
        Document read = saxReader.read(new File("day17\\src\\com\\itheima\\xml\\student.xml"));

        // 3.获取根标签
        Element rootElement = read.getRootElement();

        // 4.通过根标签来回去student标签
        List<Element> elements = rootElement.elements();

        // 5.遍历获取每个元素信息
        for (Element element : elements) {
            // 获取id
            Attribute attribute = element.attribute("id");
            String id = attribute.getValue();
            System.out.println(id);

            // 获取name标签
            Element name = element.element("name");
            String text = name.getText();
            System.out.println(text);

            // 获取age标签
            Element age = element.element("age");
            String text1 = age.getText();
            System.out.println(text1);
        }
    }
}