import java.util.List;

public class Strings {



    public static String timeConversion(String s) {
    // Write your code here
        if(s.contains("PM")){
            String sn[] = s.replace("PM", "").split(":");
            int val = Integer.parseInt(sn[0])+12;
            if(val < 24){
                sn[0] = Integer.toString(val);
                return sn[0]+":"+sn[1]+":"+sn[2];
            }
            return sn[0]+":"+sn[1]+":"+sn[2];
        }
        
        if(s.contains("AM")){
            String sn[] = s.replace("AM", "").split(":");
            int val = Integer.parseInt(sn[0])-12;
            if(val >-1){
                // sn[0] = Integer.toString(val);
                
                return String.format("%02d",val)+":"+sn[1]+":"+sn[2];
            }
            return sn[0]+":"+sn[1]+":"+sn[2];
        }
        return "Invalid String";
    }

    public static void main(String[] args) {
        // String s = "12:15:09AM";
        // String a = timeConversion(s);
        // System.out.println(a);

        // String [] code = {"GROCERY15","ELECTRONICS_50","DISCOUNT10"};
        // String []businessLine = {"grocery","electronics","invalid"};
        // boolean []isActive = {false,true,true};
        // List<String> sk = validateCoupons(code,businessLine,isActive);

// Note: Please do not copy the description during the contest to maintain the integrity of your submissions.

        String st = "dufh";
        
        System.out.println(st.equals("dufh"));


    }
}
