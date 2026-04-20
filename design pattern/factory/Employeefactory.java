package factory;

public class Employeefactory {
    // get employee

    public static Employee getEmployee(String emptype){
        if(emptype.trim().equals("androiddev")){
            return new Anddev();
        }
        else if(emptype.trim().equals("webdev")){
            return new Webdev();
        }else{
            return null;
        }
    }
}
 