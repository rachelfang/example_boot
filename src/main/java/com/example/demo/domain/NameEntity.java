package com.example.demo.domain;

/**
 * Created by fangjing on 2019/1/15.
 */

public class NameEntity {
    private String name;
    private  String surname;
    private int age;

    public NameEntity() { };

    public NameEntity(String name, String surname, int age)
    {
        this.name = name;
        this.surname = surname;
        this.age= age;
    }

    public void setName(String name)
    {
        this.name = name;

    }

    public void setSurname(String surname)
    {
        this.surname = surname;
    }

    public void setAge(int age)
    {
        this.age = age;
    }

    public String getName()
    {
//        System.out.println(String.format("name: %s", name));
        return name;
    }

    public String getSurname()
    {
        return surname;
    }

    public int getAge()
    {
        return age;
    }
}
