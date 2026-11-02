package bridge;

import bridge.lld.DelevaryMethods;

public class hld {
    /**
     * Innerhld
     */
    public static abstract class Notification {
        protected  DelevaryMethods delevaryMethods;
        public Notification(DelevaryMethods delevarymehtods){
            this.delevaryMethods = delevarymehtods;
        }
        public abstract void dotaskinnotification();
        // common functions
    }
    
    public static class EmailNotification extends Notification {
        // methods to implement simple delevary
        public EmailNotification(DelevaryMethods deliveryMethods){
            super(deliveryMethods);
        }
        @Override
        public void dotaskinnotification() {
            // TODO Auto-generated method stub
            
        }

    }

    public static  class SMSNotification   extends Notification {
        public SMSNotification(DelevaryMethods delevarymehtods) {
            super(delevarymehtods);
            //TODO Auto-generated constructor stub
        }

        // methods to implement 
        @Override
        public void dotaskinnotification() {
            // TODO Auto-generated method stub
            
        }
    }
    
}
