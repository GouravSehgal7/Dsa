package parkinglotSystem;

/** INTENT: runnable proof that the entry and exit movies work end to end. */
public class App {

    public static void main(String[] args) {
        ParkingLot lot = ParkingLot.getInstance(
                new LowestFloorFirstPolicy(),
                new HourlyFeeStrategy(),
                new InMemoryTicketRepository());

        Floor ground = new Floor(0);
        ground.addSpot(new ParkingSpot("F0-BIKE-1", 0, 1));
        ground.addSpot(new ParkingSpot("F0-CAR-1", 0, 2));
        ground.addSpot(new ParkingSpot("F0-TRUCK-1", 0, 3));
        lot.addFloor(ground);

        Floor first = new Floor(1);
        first.addSpot(new ParkingSpot("F1-CAR-1", 1, 2));
        lot.addFloor(first);

        Vehical bike = new Bike("KA-01-BIKE");
        Vehical car = new Car("KA-02-CAR");

        Ticket bikeTicket = lot.parkVehical(bike);
        Ticket carTicket = lot.parkVehical(car);

        System.out.println("Bike ticket: " + bikeTicket.getTicketId());
        System.out.println("Bike spot  : " + bikeTicket.getSpot().getSpotId());
        System.out.println("Car ticket : " + carTicket.getTicketId());
        System.out.println("Car spot   : " + carTicket.getSpot().getSpotId());

        System.out.println(lot.exitVehical(bikeTicket.getTicketId(), new UpiPayment()));
        System.out.println(lot.exitVehical(carTicket.getTicketId(), new PhonePePayment()));
        System.out.println("Second exit attempt: "
                + lot.exitVehical(carTicket.getTicketId(), new UpiPayment()));
    }
}
