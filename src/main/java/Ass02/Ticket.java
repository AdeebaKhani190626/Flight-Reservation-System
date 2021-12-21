package Ass02;

public class Ticket extends Passenger{

	private String className;
	private String planeName = "Emirates AirLines";
	private int TicketNo;
	private int sc;

	Ticket(String className, int TicketNo)
	{
		this.className = className;
		this.planeName = "Emirates Airlines";
		this.TicketNo = TicketNo;
		this.sc = 0;
	}
	
	public Ticket() {
	}

	/* Setters */
	public void SetClassName(String className)
	{
		this.className = className;
	}
	public void SetPlaneName(String planeName)
	{
		this.planeName = planeName;
	}
	public void SetTNum(int TicketNo)
	{
		this.TicketNo = TicketNo;
	}
	
	/* Getters */
	public String GetClassName()
	{
		return className;
	}
	public String GetPlaneName()
	{
		return planeName;
	}
	public int GetTNum()
	{
		return TicketNo;
	}
	
	public void Print_E_Ticket(Passenger p, Flight f)
	{
		System.out.println("\n--------------------------------------------------------");
		System.out.println("                       PRINT TICKET                       ");
		
		System.out.println("\nTicket No      : " + TicketNo);
		System.out.println("Passenger Name : " + p.GetName());
		System.out.println("Plane Name     : " + planeName);
		System.out.println("Class Name     : " + className);
		System.out.println("Plane Type     : " + p.GetTypeofPlane());
		System.out.println("Origin         : " + p.GetOrigin());
		System.out.println("Destination    : " + p.GetDestinationPoint());
		System.out.println("Fare           : Rs. " + f.GetFare());
		System.out.println("Passport No    : " + p.GetPassportNumber());
		System.out.println("Flight Date    : " + p.GetFlightDate());
		System.out.println("Seat No        : " + f.GetSeats());
	}
	
	public String SearchTicket(Ticket t)
	{
		System.out.println(this.TicketNo + " " + t.TicketNo);
		if (TicketNo == t.TicketNo)
			return "Found";
		else
		return "Not Found";
	}
	
	public void Print_Schedule(Passenger p, Flight f)
	{
		System.out.println("\n------------------------------------------------------------");
		System.out.println("                       PRINTING SCHEDULE " + sc);
		sc++;
		System.out.println("\nTicket No      : " + TicketNo);
		System.out.println("Passenger Name : " + p.GetName());
		System.out.println("Plane Name     : " + planeName);
		System.out.println("Class Name     : " + className);
		System.out.println("Plane Type     : " + p.GetTypeofPlane());
		System.out.println("Origin         : " + p.GetOrigin());
		System.out.println("Destination    : " + p.GetDestinationPoint());
		System.out.println("Fare           : Rs. " + f.GetFare());
		System.out.println("Passport No    : " + p.GetPassportNumber());
		System.out.println("Flight Date    : " + p.GetFlightDate());
		System.out.println("Seat No        : " + f.GetSeats());
		System.out.println("Flight Time    : " + (java.time.LocalTime.now()));
	}
}
