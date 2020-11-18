package io.bruce.springbean;

import org.springframework.stereotype.Component;

@Component
public class AnnotationBean {

    public void sayHello(){
        System.out.println("Hello World--Annotation");
    }
}
