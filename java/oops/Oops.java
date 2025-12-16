package oops;

public class Oops {

    private String name;
    private int age;

    public Oops(String name, int age ){
        this.name = name;
        this.age = age;
    }

    public void SetName(String name){
        this.name = name;
    }

    public void SetAge(int age){
        this.age = age;
    }

    public String GetName(){
        return this.name ;
    }

    public int GetAge(){
        return this.age ;
    }

    public void displayDetails() {
        System.out.println("Employee: " + this.name);
        System.out.println("Age: " + this.age);
    }

    public static void main(String[] args) {
        Oops o = new Oops("evaan", 0);
        System.out.println(o.GetName());
        System.out.println(o.getClass());
        o.SetName("eeva");
        System.out.println(o.GetName());
        o.displayDetails();
    }
    
}
