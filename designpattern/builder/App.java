package designpattern.builder;

public class App {
    // without builder
    Employeerepo e = new Employeerepo(0, "null", 0, 0, 0);
    // with builder
    BuilderEmployeerepo b = new BuilderEmployeerepo.Builder()
                                                        .setaccount(10)
                                                        .sename("name")
                                                        .setid(32)
                                                        .build();

}
