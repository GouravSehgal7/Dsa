package decorator;

import decorator.coffee.Coffee;

public class decurator {

    abstract static class CoffeeDecurator implements Coffee {
        protected Coffee coffee;
        public  CoffeeDecurator(Coffee coffee){
            this.coffee = coffee;
        }
    }

    public static class MilkCoffee extends CoffeeDecurator {
        MilkCoffee(Coffee coffee){
            super(coffee);
        }
        @Override
        public int getprice() {
            return this.coffee.getprice() + 10;
        }
        @Override
        public String getdiscription() {
            return  this.coffee.getdiscription()+" price of mile is 10 ";
        }
    }

    public static class ChocoCoffee extends CoffeeDecurator {
        ChocoCoffee(Coffee coffee){
            super(coffee);
        }
        @Override
        public int getprice() {
            return this.coffee.getprice() + 30;
        }
        @Override
        public String getdiscription() {
            return  this.coffee.getdiscription()+" price of mile is 30 ";
        }
    }
    
}
