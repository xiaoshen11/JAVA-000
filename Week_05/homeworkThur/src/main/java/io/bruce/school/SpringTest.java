package io.bruce.school;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringTest {

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        Student student100 = (Student) context.getBean("student100");
        System.out.println(student100.toString());

        School school = (School) context.getBean("school");
        System.out.println(school.toString());

        Klass klass = (Klass) context.getBean("class1");
        System.out.println(klass.toString());

        Klass class1 = context.getBean(Klass.class);
        System.out.println(class1);
        System.out.println("Klass对象AOP代理后的实际类型："+class1.getClass());
        System.out.println("Klass对象AOP代理后的实际类型是否是Klass子类："+(class1 instanceof Klass));

        school.ding();

        class1.dong();

    }
}
