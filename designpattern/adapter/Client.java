package adapter;

public class Client {
    private IReport mycode;
    public Client(IReport r){
        this.mycode= r;
    }
    public String getreportdatainjson(String rawtextreport){
        return this.mycode.getjsondata(rawtextreport);
    }
}
