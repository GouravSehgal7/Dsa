package adapter;

public class App {
    Thirdparty t = new Thirdparty();
    IReport r = new Adapter(t);
    Client c = new Client(r);
    String rep = c.getreportdatainjson("this is raw string");
}
