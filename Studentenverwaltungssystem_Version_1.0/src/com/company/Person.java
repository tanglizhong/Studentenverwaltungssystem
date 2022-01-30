package com.company;
public class Person {
    private Integer id;    //Matrikelnummer
    private String name ;
    private char sex ;     // Geschlecht
    private Integer age ;   //Alter
    private String addr ;   //E-Mail Adresse
    private String tel ;   // Telefonnummer

    public Person() {
    }

    public Person(Integer id, String name, char sex, Integer age, String addr, String tel) {
        this.id = id;
        this.name = name;
        this.sex = sex;
        this.age = age;
        this.addr = addr;
        this.tel = tel;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public char getSex() {
        return sex;
    }

    public void setSex(char sex) {
        this.sex = sex;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getAddr() {
        return addr;
    }

    public void setAddr(String addr) {
        this.addr = addr;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }
}


