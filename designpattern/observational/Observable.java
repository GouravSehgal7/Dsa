package observational;

import java.util.ArrayList;
import java.util.List;

public class Observable implements IObservable {

    int id;
    String name;
    List<Objects> ls;
    public Observable(int id , String name){
        this.id = id;
        this.name = name;
        this.ls = new ArrayList<>();
    }

    public void adduser(Objects o) {
        // TODO Auto-generated method stub
        ls.add(o);
        
    }

    @Override
    public void notifyall() {
        // TODO Auto-generated method stub
        
        
    }
    
    
}
