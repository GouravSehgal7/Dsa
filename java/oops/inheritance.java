package oops;

public class inheritance {

    public interface interface1 {
        void print();
    }

    public interface interface2 {
        void bark();
    }

    public class Account {
        protected int accountid;
        protected int accountholder;
        protected int ExpirayDate;
        protected boolean hasanylone ;
        protected int loanamount;
        public Account(int ai, int ah, int ed){
            this.accountid = ai;
            this.accountholder=ah;
            this.ExpirayDate = ed;
            this.hasanylone = false;
            this.loanamount = 0;
        }
        public void setaccountdetail(int ai,int ah,int ed){
            this.ExpirayDate = ed;
            this.accountid = ai;
            this.accountholder = ah;
        }
        public void printDetails(){
            System.out.println(this.accountid);
            System.out.println(this.accountholder);
            System.out.println(this.ExpirayDate);
        }
        public void updateLoneStatus(int amt){}
    }

    public class Lone extends Account {
        protected int loanid ;
        protected int loanhoalder;
        public Lone(int li,int ai, int ah, int ed){
            super(ai,ah,ed);
            this.loanid = li;
        }
        public void setLoandetails(int li){
            this.loanid = li;
            this.loanhoalder = this.accountholder;
        }
        public void getLoanDetails(){
            System.out.println(this.loanid);
            System.out.println(this.loanhoalder);
            this.printDetails();
        }
        @Override
        public void updateLoneStatus(int amt){
            this.hasanylone = true;
            this.loanamount = amt;
        }
    }
    
    public class Document implements interface1,interface2 {
        @Override
        public void bark() {
            return;
        }
        @Override
        public void print() {
            return;
        }
    }
    
    public static void main(String[] args) {
        
    }
}
