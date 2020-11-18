package io.bruce.school;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author bruce
 */
@Configuration
@ConditionalOnClass(School.class)
@EnableConfigurationProperties(SchoolProperties.class)
@ConditionalOnProperty(prefix = "school", value = "enabled", havingValue = "true")
@PropertySource("classpath:application.properties")
public class SchoolAutoConfiguration {

    @Autowired
    private SchoolProperties schoolProperties;

    @Bean
    public School mySchool() {
        List<Integer> studentIds = schoolProperties.getStudentIds();
        List<String> studentNames = schoolProperties.getStudentNames();
        Integer student100Id = schoolProperties.getStudent100Id();
        String student100Name = schoolProperties.getStudent100Name();

        List<Student> students = new ArrayList<>(studentIds.size());
        for (int i=0; i<studentIds.size(); i++) {
            students.add(new Student(studentIds.get(i), studentNames.get(i)));
        }

        Klass klass = new Klass();
        klass.setStudents(students);

        Student student100 = new Student(student100Id,student100Name);

        System.out.println(studentIds.toString());
        System.out.println(studentNames.toString());
        System.out.println(klass.toString());
        System.out.println(student100.toString());

        School school = new School();
        school.setClass1(klass);
        school.setStudent100(student100);
        return school;
    }
}
