package adapter;
 

public class Adapter implements IReport {
    private static Thirdparty thirdparty;
    Adapter(Thirdparty t){
        this.thirdparty = t;
    }
    @Override
    public String getjsondata(String rawstr) {
        String xmldata = this.thirdparty.getxmldata(rawstr);
        // did soome process to convert to json
        String jsondata = xmldata;
        return jsondata;
    }
}
