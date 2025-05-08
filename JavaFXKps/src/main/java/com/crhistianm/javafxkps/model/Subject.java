package com.crhistianm.javafxkps.model;

/**
 * Subject
 */
public class Subject {
    private int id;
    private String name;
    private String description;
    private Teacher teacher;
    private Semester semester;

    public Subject(Semester semester, Teacher teacher, String description, String name, int id) {
        this.semester = semester;
        this.teacher = teacher;
        this.description = description;
        this.name = name;
        this.id = id;
    }
    public Subject() {
    }

    public void setId(int id) {
	    this.id = id;
    }
    public int getId() {
	    return id;
    }
    public void setName(String name) {
	    this.name = name;
    }
    public String getName() {
	    return name;
    } 
    public void setDescription(String description) {
	    this.description = description;
    } 
    public String getDescription() {
	    return description;
    }
    public Teacher getTeacher() {
	    return teacher;
    } 
    public void setTeacher(Teacher teacher) {
	    this.teacher = teacher;
    }
    public Semester getSemester() {
	    return semester;
    }
    public void setSemester(Semester semester) {
	    this.semester = semester;
    }


    @Override
    public String toString() {
        return "Subject{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", teacher=" + teacher +
                ", semester=" + semester +
                '}';
    }
}
