public static class TicketCalculator {
    protected int NO_TICKET_MAX_SPEED = 60;
    protected int SMALL_TICKET_MIN_SPEED = 61;
    protected int SMALL_TICKET_MAX_SPEED = 80;
    protected int BIG_TICKET_MIN_SPEED = 81;

    public int getTicket(int speed) {
    if (isNoTicket(speed)) {
      return Ticket.NO_TICKET;
    } else if (isSmallTicket(speed)) {
      return Ticket.SMALL_TICKET;
    } else if (isBigTicket(speed)) {
      return Ticket.BIG_TICKET;
    } else {
      return Ticket.ERROR_CODE;
    }
}

    private boolean isNoTicket(int speed) {
    return speed <= NO_TICKET_MAX_SPEED; 
  }

    private boolean isSmallTicket(int speed) {
    return speed >= SMALL_TICKET_MIN_SPEED && speed <= SMALL_TICKET_MAX_SPEED;
  }

    private boolean isBigTicket(int speed) {
    return speed >= BIG_TICKET_MIN_SPEED;
  }
 }

 public static class TicketCalculatorOnMotorway extends TicketCalculator {
  public TicketCalculatorOnMotorway() {
    super();
    adjustSpeedLimitsForMotorway();
  }

  public static void generateTicket (int speed, boolean isMotorway) {
    TicketCalculator ticket;
    if (!isMotorway) {
    ticket = new TicketCalculator();
  } else {
    ticket = new TicketCalculatorOnMotorway();
  }
    System.out.println(ticket.getTicket(speed));
 }

  private void adjustSpeedLimitsForMotorway() {
    int adjustSpeedBy = 10;

    NO_TICKET_MAX_SPEED += adjustSpeedBy;
    SMALL_TICKET_MIN_SPEED += adjustSpeedBy;
    SMALL_TICKET_MAX_SPEED += adjustSpeedBy;
    BIG_TICKET_MIN_SPEED += adjustSpeedBy;
   }
}

 public class Ticket {
  public final static string NO_TICKET = "No ticket";
  public final static string SMALL_TICKET = "Small ticket";
  public final static string BIG_TICKET = "Big ticket";
  public final static string ERROR_CODE = "Error";
}

 public static void main(String[] args) {
    generateTicket(60, false);
    generateTicket(65, false);
    generateTicket(65, true);
 }