package singalton;
// eager way
//  not good for big project as it always keep create the object even though it is not used
public class ClassB {
    private static ClassB cb = new ClassB();
    public static ClassB getinstance(){
        return cb;
    }
}
