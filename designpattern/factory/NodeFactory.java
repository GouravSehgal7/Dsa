package designpattern.factory;

public class NodeFactory {
    public static Node createNode(
        String type, 
        int id,
        int parent,
        int scriptid,
        String title,
        String Discription
    ){
        switch (type) {
            case "Episode":
                return new Episodenode(id, parent, scriptid, title, Discription);
            case "Scean" :
                return new SceanNode(id, parent, scriptid, title, Discription);
            case "Season" :
                return new SeasonNode(id, parent, scriptid, title, Discription);
            default:
                throw new Error();
        }
    }
}
