package designpattern.factory;

public class Episodenode extends Node {
    public Episodenode(
    int id,
    int parent,
    int scriptid,
    String title,
    String Discription
    ){
        super(id,parent,scriptid,title,Discription);
    }
    @Override
    public void loadscript() {
        System.out.println("load scean script");
    }
}


