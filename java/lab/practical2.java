import java.util.Scanner;

public class IPClassFinder {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter an IP address (e.g., 192.168.1.1): ");
        String ip = sc.nextLine();

        // Split IP into parts
        String[] parts = ip.split("\\.");
        
        if(parts.length != 4){
            System.out.println("Invalid IP address format.");
            return;
        }

        try {
            int firstOctet = Integer.parseInt(parts[0]);

            if(firstOctet >= 1 && firstOctet <= 126){
                System.out.println("Class A");
            } else if(firstOctet >= 128 && firstOctet <= 191){
                System.out.println("Class B");
            } else if(firstOctet >= 192 && firstOctet <= 223){
                System.out.println("Class C");
            } else if(firstOctet >= 224 && firstOctet <= 239){
                System.out.println("Class D (Multicast)");
            } else if(firstOctet >= 240 && firstOctet <= 254){
                System.out.println("Class E (Experimental)");
            } else {
                System.out.println("Invalid IP address range.");
            }
        } catch (NumberFormatException e) {
            System.out.println("Invalid input. Please enter numbers only.");
        }
    }
}