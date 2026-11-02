package state;

import state.state.StateMethods;

public class document {
    private StateMethods currentstate;
    public document(){
        currentstate = null;
    }
    public void setstate(StateMethods s){
        this.currentstate = s;
    }
    public void publishdocs(){
        if(currentstate != null){
            currentstate.publishaction();
        }
    }
    public void archivedocs(){
        if(currentstate != null){
            currentstate.archiveaction();
        }
    }
    public void nextactiondoc(){
        if(currentstate!=null){
            currentstate.nextaction();
        }
    }
}
