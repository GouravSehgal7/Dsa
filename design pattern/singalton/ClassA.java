package singalton;
// lazy way to create singoltone 
// not thread safe only one call work but will crash for multithreading
// means all thread will make multiple object
public class ClassA {
    private static ClassA instance;
    private ClassA(){}

    public static ClassA Getinstance(){
        if(instance == null){
            instance = new ClassA();
        }
        return instance;
    }

    // thread safe but blocking code untill one is working
    public synchronized static ClassA Getinstancesync(){
        if(instance == null){
            instance = new ClassA();
        }
        return instance;
    }

    public synchronized static ClassA Getinstancesyncmultithread(){
        if(instance == null){
            synchronized(ClassA.class){
                instance = new ClassA();
            }
        }
        return instance;
    }

    
}