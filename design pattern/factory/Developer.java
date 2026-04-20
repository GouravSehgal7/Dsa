package factory;

public class Developer {
    public static void main(String[] args) {
        Employee emp = Employeefactory.getEmployee("webdev");
        int sal = emp.getsal();
        System.out.println(sal);

    }
}
