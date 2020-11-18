package io.bruce.school;

import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.Resource;

@Data
public class School {

    @Autowired() //primary
    Klass class1;

    @Resource(name = "student100")
    Student student100;

    public void ding(){

        System.out.println("Class1 have " + class1.getStudents().size() + " students and one is " + student100);

    }
}
