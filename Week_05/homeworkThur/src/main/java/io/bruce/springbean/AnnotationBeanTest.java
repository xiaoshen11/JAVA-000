package io.bruce.springbean;

import io.bruce.BeanTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;


public class AnnotationBeanTest {

    @Autowired
    private AnnotationBean annotationBean;

    public static void main(String[] args) {
        SpringApplication.run(BeanTest.class, args);
        AnnotationBeanTest beanTest = new AnnotationBeanTest();
        beanTest.annotationBean.sayHello();
    }
}
