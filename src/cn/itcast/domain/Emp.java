package cn.itcast.domain;

public class Emp {
    private int student_id;
    private String name;
    private String major;
    private double gpa;

    public Emp(int student_id, String name, String major, double gpa) {
        this.student_id = student_id;
        this.name = name;
        this.major = major;
        this.gpa = gpa;
    }

    public int getStudent_id() {
        return student_id;
    }

    public void setStudent_id(int student_id) {
        this.student_id = student_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public double getGpa() {
        return gpa;
    }

    public void setGpa(double gpa) {
        this.gpa = gpa;
    }

    @Override
    public String toString() {
        return "Emp{" +
                "student_id=" + student_id +
                ", name='" + name + '\'' +
                ", major='" + major + '\'' +
                ", gpa=" + gpa +
                '}';
    }
}
