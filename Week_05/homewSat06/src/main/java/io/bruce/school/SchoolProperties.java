package io.bruce.school;

import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.List;

/**
 * @author bruce
 */
@ConfigurationProperties(prefix = "school")
public class SchoolProperties {

    private List<Integer> studentIds;
    private List<String> studentNames;
    private Integer student100Id;
    private String student100Name;

    public List<Integer> getStudentIds() {
        return studentIds;
    }

    public void setStudentIds(List<Integer> studentIds) {
        this.studentIds = studentIds;
    }

    public List<String> getStudentNames() {
        return studentNames;
    }

    public void setStudentNames(List<String> studentNames) {
        this.studentNames = studentNames;
    }

    public Integer getStudent100Id() {
        return student100Id;
    }

    public void setStudent100Id(Integer student100Id) {
        this.student100Id = student100Id;
    }

    public String getStudent100Name() {
        return student100Name;
    }

    public void setStudent100Name(String student100Name) {
        this.student100Name = student100Name;
    }
}
