package decorator;

import decorator.coffee.Basecoffee;
import decorator.coffee.Coffee;
import decorator.decurator.ChocoCoffee;
import decorator.decurator.CoffeeDecurator;
import decorator.decurator.MilkCoffee;

public class app {

    public static void main(String[] args) {
        Coffee c = new Basecoffee();
        // milkcoffee
        CoffeeDecurator milkcoffee = new MilkCoffee(c);
        // chococoffee
        CoffeeDecurator chococoffee = new ChocoCoffee(c);
    }
    
}
