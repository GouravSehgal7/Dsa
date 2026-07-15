package designpattern.factory;

public abstract class Node {
    public int id;
    public int parent;
    public int scriptid;
    public String title;
    public String Discription;
    public Node(int id, int parent, int scriptid, String title, String Discription){
        this.id = id;
        this.parent = parent;
        this.scriptid = scriptid;
        this.title = title;
        this.Discription = Discription;
    }
    public abstract void loadscript();
}
