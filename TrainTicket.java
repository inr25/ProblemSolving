import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class TrainTicket {
    public static void main(String[] args) {

        TicketDetails tckt = new TicketDetails();
        char[] stations = { 'A', 'B', 'C', 'D', 'E' };
        final int totalSeats = 8;
        Map<Character, Integer> ticketDetails = new HashMap<>();
        for (int i = 0; i < stations.length; i++) {
            ticketDetails.put(stations[i], totalSeats);
        }
        Scanner scan = new Scanner(System.in);
        boolean flag = true;
        while (flag) {
            System.out.println("Please select from menu \n1. Book Ticket :");
            System.out.println("2. Cancel Ticket :");
            System.out.println("3. View Chart :");
            System.out.println("4. Exit.");
            int action = scan.nextInt();

            switch (action) {
                case 1:
                    System.out.println("Booking ticket...");
                    tckt = BookTicket.bookTicket(scan, ticketDetails, stations, totalSeats, tckt);
                    continue;
                case 2:
                    System.out.println("Cancel Ticket ...");
                    tckt = BookTicket.cancelTicket(scan, ticketDetails, stations, totalSeats, tckt);
                    continue;
                case 3:
                    System.out.println("View Chart ...");
                    BookTicket.printChart(ticketDetails, stations, totalSeats, tckt);
                    continue;
                case 4:
                    flag = false;
                    continue;
                default:
                    System.out.println("Invalid Input ...");
                    flag = false;
                    continue;
            }
        }

        scan.close();
    }

}

class Ticket {
    int pnrNo;
    int seats;
    char source;
    char destination;
    String ticketStatus;

    @Override
    public String toString() {
        return "PNR: " + pnrNo + ", Seats: " + seats + ", Source: " + source +
                ", Destination: " + destination + ", Status: " + ticketStatus;
    }
}

class TicketDetails {
    int pnr = 1;
    int waitingListSeats = 2;
    List<Ticket> booked = new LinkedList<>();
    List<Ticket> cancelled = new LinkedList<>();
    List<Ticket> waitingList = new LinkedList<>();
    List<Ticket> partiallyCancelled = new LinkedList<>();
}

class BookTicket {

    public static TicketDetails cancelTicket(Scanner scan, Map<Character, Integer> ticketDetails, char[] stations,
            int totalSeats, TicketDetails tkt) {

        System.out.println("Enter pnrNo :");
        int pnrNo = scan.nextInt();

        System.out.println("How many tickets need to cancel");
        int ticketCancel = scan.nextInt();

        for (int i = 0; i < tkt.booked.size(); i++) {
            if (pnrNo == tkt.booked.get(i).pnrNo) {
                if (tkt.booked.get(i).seats < ticketCancel) {
                    System.out.println("Invalid seat count");
                    return tkt;
                } else {
                    tkt.booked.get(i).seats = tkt.booked.get(i).seats - ticketCancel;
                    if (tkt.booked.get(i).seats == 0) {
                        tkt.booked.remove(i);
                    } else {
                        Ticket partialCancel = new Ticket();
                        if (tkt.partiallyCancelled.size() > 0) {
                            for (int j = 0; j < tkt.partiallyCancelled.size(); j++) {
                                if (tkt.partiallyCancelled.get(j).pnrNo == tkt.booked.get(j).pnrNo) {
                                    tkt.partiallyCancelled.get(j).destination = tkt.booked.get(i).destination;
                                    tkt.partiallyCancelled.get(j).seats += ticketCancel;
                                    tkt.partiallyCancelled.get(j).ticketStatus = "Partially Cancelled";
                                    tkt.partiallyCancelled.get(j).source = tkt.booked.get(i).source;
                                    tkt.partiallyCancelled.get(j).pnrNo = tkt.booked.get(i).pnrNo;
                                    return tkt;
                                }
                            }

                        }
                        partialCancel.destination = tkt.booked.get(i).destination;
                        partialCancel.seats += ticketCancel;
                        partialCancel.ticketStatus = "Partially Cancelled";
                        partialCancel.source = tkt.booked.get(i).source;
                        partialCancel.pnrNo = tkt.booked.get(i).pnrNo;

                        tkt.partiallyCancelled.add(partialCancel);
                    }

                }
            }

        }

        return tkt;
    }

    public static TicketDetails bookTicket(Scanner scan, Map<Character, Integer> ticketDetails, char[] stations,
            int totalSeats, TicketDetails tkt) {

        System.out.print("Stations : ");
        for (int i = 0; i < stations.length; i++) {
            System.out.print(stations[i] + " ");
        }
        System.out.println();
        System.out.println("Enter source station");
        char sourceStation = scan.next().charAt(0);

        System.out.println("Enter destination station");
        char destStation = scan.next().charAt(0);

        System.out.println("Enter total number of seats");
        int seatCount = scan.nextInt();

        if (seatCount > totalSeats) {
            System.out.println("Invalid seat count");
            return tkt;
        }

        Ticket tick = new Ticket();
        tick.destination = destStation;
        tick.seats = seatCount;
        tick.ticketStatus = "";
        tick.source = sourceStation;
        boolean flag = false;
        for (int i = 0; i < stations.length; i++) {
            if (stations[i] >= sourceStation && stations[i] < destStation) {
                int val = ticketDetails.get(stations[i]);
                val -= seatCount;
                if (val < 0) {
                    flag = true;
                    break;
                }
                ticketDetails.put(stations[i], val);
                tick.ticketStatus = "Booked";

            }
        }
        if (tkt.waitingListSeats > 0 && seatCount <= tkt.waitingListSeats && flag) {
            for (int j = 0; j < stations.length; j++) {
                if (stations[j] >= sourceStation && stations[j] < destStation) {
                    tick.ticketStatus = "Waiting List";
                }
            }
        }
        if (tick.ticketStatus.equals("Booked")) {
            tick.pnrNo = tkt.pnr++;
            tkt.booked.add(tick);
        } else if (tick.ticketStatus.equals("Waiting List")) {
            tick.pnrNo = tkt.pnr++;
            tkt.waitingList.add(tick);
        }
        return tkt;
    }

    public static void printChart(Map<Character, Integer> ticketDetails, char[] stations, int totalSeats,
            TicketDetails tkt) {

        System.out.println();
        System.out.println("Tickets Booked...");
        for (int i = 0; i < tkt.booked.size(); i++) {
            System.out.println(tkt.booked.get(i));
        }
        System.out.println();
        System.out.println("Tickets Cancelled...");
        for (int i = 0; i < tkt.cancelled.size(); i++) {
            System.out.println(tkt.cancelled.get(i));
        }
        System.out.println();
        System.out.println("Waiting list...");
        for (int i = 0; i < tkt.waitingList.size(); i++) {
            System.out.println(tkt.waitingList.get(i));
        }
        System.out.println();

        System.out.print(" ");
        for (int i = 0; i < totalSeats; i++) {
            System.out.print(" " + (i + 1));
        }
        System.out.println();
        for (int i = 0; i < stations.length; i++) {
            System.out.print(stations[i]);
            for (int j = tkt.booked.get(i).seats; j < totalSeats; j++) {
                System.out.print(" *");
            }
            System.out.println();
        }
    }
}