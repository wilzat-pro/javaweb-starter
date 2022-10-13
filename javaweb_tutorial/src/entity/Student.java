package entity;

public class Student {

    private Integer stuid;

    private String name;

    private String sex;

    private Integer age;

    public Integer getStuid() {
        return stuid;
    }

    public String getName() {
        return name;
    }

    public String getSex() {
        return sex;
    }

    public Integer getAge() {
        return age;
    }

    public void setStuid(Integer stuid) {
        this.stuid = stuid;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Student(Integer stuid, String name, String sex, Integer age) {
        this.stuid = stuid;
        this.name = name;
        this.sex = sex;
        this.age = age;
    }
}
