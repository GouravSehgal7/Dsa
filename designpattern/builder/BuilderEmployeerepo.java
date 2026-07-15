package designpattern.builder;

import java.util.ArrayList;
import java.util.List;

public class BuilderEmployeerepo {
    public static class Builder {
        private int id;
        private String name;
        private int salary;
        private int account;
        private int batchid;
        public Builder setid(int id){
            this.id = id;
            return this;
        }
        public Builder sename(String st){
            this.name = st;
            return this;
        }
        public Builder setsalary(int sal){
            this.salary = sal;
            return this;
        }
        public Builder setaccount(int acc){
            this.account = acc;
            return this;
        }
        public Builder setbatchid(int bcid){
            this.batchid = bcid;
            return this;
        }
        public BuilderEmployeerepo build(){
            List<String> errors = new ArrayList<>();
            if(name == null || name.isBlank())
                errors.add("Name is required");
            if(salary < 0)
                errors.add("Salary must be positive");
            if(account <= 0)
                errors.add("Account number is invalid");
            if(!errors.isEmpty())
                throw new IllegalArgumentException(
                    String.join(", ", errors)
            );
            return new BuilderEmployeerepo(this);
        }
    }
    private int id;
    private String name;
    private int salary;
    private int account;
    private int batchid;
    private BuilderEmployeerepo(Builder builder){
        this.account = builder.account;
        this.id = builder.id;
        this.batchid = builder.batchid;
        this.salary = builder.salary;
        this.name = builder.name;
    }

}
