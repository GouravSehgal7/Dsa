package bridge;

import bridge.hld.EmailNotification;
import bridge.hld.Notification;
import bridge.hld.SMSNotification;
import bridge.lld.DelevaryMethods;
import bridge.lld.SimpleDelevary;
import bridge.lld.Urgantdelevary;;

public class app {
    public static void main(String[] args) {

        // Create implementation objects
        DelevaryMethods simple = new SimpleDelevary();
        DelevaryMethods urgent = new Urgantdelevary();

        // Combine abstraction with implementation
        Notification email = new EmailNotification(simple);

        Notification sms = new SMSNotification(urgent);

        email.dotaskinnotification();
        sms.dotaskinnotification();
        
    }
}
