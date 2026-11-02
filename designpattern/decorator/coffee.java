package decorator;

public class coffee {

    interface Coffee{
        int getprice();
        String getdiscription();
    }

    public static class Basecoffee implements Coffee {
        @Override
        public int getprice() {
            // TODO Auto-generated method stub
            return 20;
        }
        @Override
        public String getdiscription() {
            // TODO Auto-generated method stub
            return "Base coffee of 20";
        }
    }
    
}
