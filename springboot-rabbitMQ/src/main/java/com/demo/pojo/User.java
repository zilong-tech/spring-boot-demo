package com.demo.pojo;

/**
 * Description:
 * <p>
 * Create on 2019/02/21
 *
 * @author zouyongsheng
 */
public class User {

    private String name;
    private String age;

    @Override
    public String toString(){
        return "[ name = " + name + "; " + " age = " + age + " ]";
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

}
