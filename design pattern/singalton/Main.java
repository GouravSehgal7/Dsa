package singalton;

public class Main {
    
    public static void main(String[] args) {
        ClassA inst = ClassA.Getinstance();
        System.out.println(inst.hashCode());
        ClassA inst2 = ClassA.Getinstance();
        System.out.println(inst2.hashCode());
    }
}
