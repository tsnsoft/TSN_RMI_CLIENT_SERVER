package kz.proffix4.rmi;

import java.io.Serializable;

public class RemoteHello implements Serializable {

    private static final long serialVersionUID = 1L;

    public RemoteHello(String name, int age) {
        super();
        this.name = name;
        this.age = age;
    }

    private String name;
    private int age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return String.format("name=%s, age=%s", name, age);
    }

}
