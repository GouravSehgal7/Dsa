package designpattern.builder;

public class Employeerepo {
    private int id;
    public String name;
    public int salary;
    private int account;
    public int batchid;
    Employeerepo(int id,String name, int sal, int acc, int batchid){
        this.account = acc;
        this.id = id;
        this.batchid = batchid;
        this.salary = sal;
        this.name = name;
    }
}



