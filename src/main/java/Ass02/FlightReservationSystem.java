package Ass02;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Random;
import java.util.Scanner;
import java.time.format.DateTimeFormatter;  
import java.time.LocalDateTime;
public class FlightReservationSystem extends Passenger{

	public static <Passsenger> void main(String[] args) throws AdminCheckException, IDCheckException, AgeCheckException, PassportCheckException, TicketNoCheckException, SeatNoCheckException, DestinationCheckException, OriginCheckException, ClassCheckException, IOException {
		
		Passenger[] data= new Passenger[50];
		for (int i=0 ;i<50 ; i++)
		{
			data[i] = new Passenger();
		}
		
		Ticket[] data2= new Ticket[50];
		for (int i=0 ;i<50 ; i++)
		{
			data2[i] = new Ticket();
		}
		
		Flight[] data3= new Flight[50];
		for (int i=0 ;i<50 ; i++)
		{
			data3[i] = new Flight();
		}
		
		int PC = 0; int TC = 0; int FC = 0;
		int count = 0;
		int ch;
		
		do {
		System.out.println("\n---------------------------------------------------------------------");
		System.out.println("                FLIGHT RESERVATION MANAGEMENT SYSTEM                 ");
		System.out.println("---------------------------------------------------------------------");
		
		System.out.println("\n1. Continue as Admin");
		System.out.println("2. Continue as a Customer");
		System.out.println("0. Exit");
		
		Scanner sc = new Scanner(System.in);
		Scanner scs = new Scanner(System.in);
		System.out.print("\nEnter your choice : ");
		ch = sc.nextInt();
		
		switch(ch)
		{
		case 1:
		{
			int ch1; String aid = " "; String n = " "; int a = 0; String add = " "; String g = " ";
			do {
			System.out.println("\n---------------------------------------------------------------------");
			System.out.println("\n3. Already an Admin : Login");
			System.out.println("4. Register as an Admin");
			System.out.println("0. Return to Menu");
			
			System.out.print("\nEnter your choice : ");
			ch1 = sc.nextInt();
			
			switch(ch1)
			{
			case 3:
			{	
				if (count >= 1)
				{
					System.out.print("\nEnter your Admin ID (4-digits): ");
					String aID = scs.nextLine();
					
					try
					{
					if (aid.length() > 4)
					{
						throw new IDCheckException(" *** ID can be only 4 digit !!!");	
					}
					}catch(IDCheckException e)
				    {
				        System.err.println(e) ;
				    }
					
					Admin a2 = new Admin(n,g,a,add,aid);
					
					if (a2.SearchAdmin(aID) == 1)
					{
						System.out.println("\n *** Congratulations. You have Successfully Logged In !!!");
						
						System.out.println("\n---------------------------------------------------------------------");
						System.out.println("ADMIN MENU: ");
						System.out.println("1. View Flight Schedule");
						System.out.println("2. View Admin Details");
						int ch3 = 0;
						System.out.print("Enter operation : ");
						ch3 = sc.nextInt();
						
						switch(ch3)
						{
						case 1:
						{
							ReservationSystemDataBase base = new ReservationSystemDataBase();
							base.CreateSchedule();
							base.PrintData();
							break;
						}
						case 2:
						{	
							a2.PrintAdminDetails();
							break;
						}
						default:
							System.out.println("Exiting ... ");
							break;
						}
						
					}
					else if (a2.SearchAdmin(aID) == 0)
					{
						System.out.println("\n *** You Failed to Login !!!");
					}
					else
						System.out.println("\n *** Something went Wrong !!!");
				}
				else if (count == 0)
				{
					System.out.println("\n *** Resister To Login !!!");
				}
				break;
			}
			case 4:
			{
				try{
				if (count >= 1)
				{
					throw new AdminCheckException(" *** There can be only one Admin !!!");
				}}catch(AdminCheckException e)
			    {
			        System.err.println(e);
			    }
				if (count == 0)
				{
					System.out.println("\n---------------------------------------------------------------------");
					System.out.print("\nEnter your Admin ID : ");
					aid = scs.nextLine();
					try {
					if (aid.length() > 4)
					{
						throw new IDCheckException(" *** ID can be only 4 digit !!!");	
					}}catch(IDCheckException e)
				    {
				        System.err.println(e) ;
				    }
					System.out.print("Enter your Admin Name : ");
					n = scs.nextLine();
					System.out.print("Enter your Admin Age : ");
					a = sc.nextInt();
					try {
					if (a < 18)
					{
						throw new AgeCheckException(" *** You must be 18 or older !!!");
					}}catch(AgeCheckException e)
				    {
				        System.err.println(e) ;
				    }
					
					System.out.print("Enter your Admin Address : ");
					add = scs.nextLine();
					System.out.print("Enter your Admin Gender : ");
					g = scs.nextLine();
					
					try
				    {
				        if((!g.equals("male")) && (!g.equals("female")))
				        {
				            throw new GenderCheckException("Gender can be only male or female");
				        }
				    }catch(GenderCheckException e)
				    {
				        System.err.println(e) ;
				    }
					Admin a1 = new Admin(n,g,a,add,aid);
					System.out.println("\n *** You have entered your information Successfully !!!");
					a1.PrintAdminDetails();
					a1.WriteAdminDetails();
				}
				count++;
				break;
			}
			case 0:
			{
				break;
			}
			default:
			{
				System.out.println("Entered an invalid choice !!!");
				break;
			}
			}
			}while(ch1 != 0);
			break;
		}
		case 2:
		{
			int ch2;
			System.out.println("\n---------------------------------------------------------------------");
			System.out.println("\nCustomer : " + (PC + 1));
			System.out.print("Name : ");
			String n = scs.nextLine();
			System.out.print("Gender : ");
			String g = scs.nextLine();
			try
		    {
		        if((!g.equals("male")) && (!g.equals("female")))
		        {
		            throw new GenderCheckException("Gender can be only male or female");
		        }
		    }catch(GenderCheckException e)
		    {
		        System.err.println(e) ;
		    }
			System.out.print("Age : ");
			int a = sc.nextInt();
			try {
			if (a < 18)
			{
				throw new AgeCheckException(" *** You must be 18 or older !!!");
			}}catch(AgeCheckException e)
		    {
		        System.err.println(e) ;
		    }
			System.out.print("Address : ");
			String add = scs.nextLine();
			
			do {
			System.out.println("\n---------------------------------------------------------------------");
			System.out.println("CUSTOMER MAIN MENU: ");
			System.out.println("\n5. Reserve Ticket");
			System.out.println("6. Cancel Ticket");
			System.out.println("7. View Schedule");
			System.out.println("8. Print Ticket");
			System.out.println("0. Return to Main Menu");
			
			System.out.print("\nEnter your choice : ");
			ch2 = sc.nextInt();
			
			switch(ch2)
			{
			case 5:
			{
				ReservationSystemDataBase RSD = new ReservationSystemDataBase();
				RSD.CreateSchedule();
				
				System.out.println("\n------------- RESERVE TICKET -----------------");
				System.out.print("Enter origin : ");
				String o = scs.nextLine();
				
				try
			    {
			        if((!o.equals("Islamabad")) && (!o.equals("Lahore")) && (!o.equals("Karachi")) && (!o.equals("Quetta")))
			        {
			        	throw new OriginCheckException(" *** Origin can be : 1. Islamabad  2. Lahore  3. Karachi  4. Quetta !!!");
			        }
			    }catch(OriginCheckException e)
			    {
			        System.err.println(e) ;
			    }
				
				System.out.print("Enter destination : ");
				String d = scs.nextLine();
				
				try
			    {
			        if((!d.equals("London")) && (!d.equals("Dubai")) && (!d.equals("Toronto")) && (!d.equals("Skardu")))
			        {
			        	throw new DestinationCheckException(" *** Destination can be : 1. London  2. Dubai  3. Toronto  4. Skardu !!!");
			        }
			    }catch(DestinationCheckException e)
			    {
			        System.err.println(e) ;
			    }
				
				Flight type = new Flight();
				type.FindDirectFlight(o,d);
				type.FindIndirectFlight(o,d);
				System.out.println("\nDirect Flight/Flights Available -> " + type.GetDC());
				System.out.println("InDirect Flight/Flights Available -> " + type.GetINDC());
				
				if (type.GetDC() == 0)
				{
					System.out.println("\n *** We Apologize No Direct Flight/Flights Available !!!");	
				}
				else if (type.GetINDC() == 0)
				{
					System.out.println("\n *** We Apologize No InDirect Flight/Flights Available !!!");	
				}
				
				System.out.print("\nDo you want to continue with the reservation (1 for Yes, 0 for No): ");
				int c = sc.nextInt();
				
				if(c == 1)
				{
				System.out.print("\nDo you want a Direct Flight or Indirect : ");
				String ft = scs.nextLine();
				
				if (ft.equals("Direct") || ft.equals("Indirect"))
				{
					System.out.println("\n------------------------------------------------------");
					System.out.println("\nSELECT FROM THE DATE MENTIONED DATES:");
					
					if (ft.equals("Direct"))
					{
					System.out.println("                   *** DIRECT                          ");
					for (int i=0; i<type.GetDC(); i++)
					{
						System.out.print((i+1) + ". " + RSD.Flight_Date[(type.dp[i])] + "      ");
					}
					}
					else if(ft.equals("Indirect"))
					{
					System.out.println("\n        *** INDIRECT (The similar dates mentioned have different time slots)           ");
					
					for (int i=0; i<type.GetINDC(); i++)
					{
						System.out.print((i+1) + ". " + RSD.Flight_Date[(type.indp[i])] + "      ");
					}
					}
					
					System.out.print("\n\nEnter option for date : ");
					int date = sc.nextInt();
					String cd = RSD.Flight_Date[(type.indp[date-1])];
					String f = RSD.Fare[date-1];
					System.out.print("Enter Passport # (9-digits) : ");
					String pass = scs.nextLine();
					
					try {
					if (pass.length() > 9)
					{
						throw new PassportCheckException(" *** Passport Must be (9-digits) !!!");
					}}catch(PassportCheckException e)
				    {
				        System.err.println(e) ;
				    }
					
					System.out.print("Enter class : ");
					String clas = scs.nextLine();

					try
				    {
				        if((!clas.equals("Economy")) && (!clas.equals("Business")))
				        {
				        	throw new ClassCheckException(" *** Class can be : 1. Business  2. Economy !!!");
				        }
				    }catch(ClassCheckException e)
				    {
				        System.err.println(e) ;
				    }
					
					Random randNo = new Random();
					int ticketNo = randNo.nextInt(100000);
					
					try {
					if (ticketNo > 100000)
					{
						throw new TicketNoCheckException(" *** Ticket No. is not greater than 5 digits !!!");
					}}catch(TicketNoCheckException e)
				    {
				        System.err.println(e) ;
				    }
					
					int seatNo = randNo.nextInt(50);
					
					try {
					if (seatNo > 50)
					{
						throw new SeatNoCheckException(" *** Seat No. must be within 50 !!!");
					}}catch(SeatNoCheckException e)
				    {
				        System.err.println(e) ;
				    }
					
					data[PC].SetName(n);
					data[PC].SetAddress(add);
					data[PC].SetAge(a);
					data[PC].SetGender(g);
					data[PC].SetDestinationPoint(d);
					data[PC].SetOrigin(o);
					data[PC].SetPassportNumber(pass);
					data[PC].SetTypeofPlane("AIR-0626");
					data[PC].pNo = PC;
					data[PC].SetFlightDate(cd);
					
					TC++;
					data2[TC].SetClassName(clas);
					data2[TC].SetPlaneName("Emirates Airlines");
					data2[TC].SetTNum(ticketNo);
					
					FC++;
					data3[FC].seatsNo = seatNo;
					data3[FC].fare = f;
					
					System.out.println("\n *** YOUR RESERVATION HAS BEEN DONE SUCCESSFULLY !!! ");
					
					if (PC == 0)
					{
						try {
							FileWriter passengerfile = new FileWriter("Passenger.txt");
							passengerfile.write("Writing Passenger Details ... ");
							passengerfile.write("\nPassenger : " + (data[PC].pNo+1));
							passengerfile.write("\nName             : " + data[PC].GetName());
							passengerfile.write("\nGender           : " + data[PC].GetGender());
							passengerfile.write("\nAge              : " + data[PC].GetAge());
							passengerfile.write("\nAddress          : " + data[PC].GetAddress());
							passengerfile.write("\nPassport Number  : " + data[PC].GetPassportNumber());
							
							passengerfile.close();
						} catch(IOException e)
						{
							System.out.println("Error Occurred");
							e.printStackTrace();
						}
						
						try {
							FileWriter frsfile = new FileWriter("Flights_Reservation_Schedule.txt");
							frsfile.write("Writing Reservation/Flight Details ... ");
							frsfile.write("\nPassenger : " + (data[PC].pNo+1));
							frsfile.write("\nName                 : " + data[PC].GetName());
							frsfile.write("\nGender               : " + data[PC].GetGender());
							frsfile.write("\nAge                  : " + data[PC].GetAge());
							frsfile.write("\nAddress              : " + data[PC].GetAddress());
							frsfile.write("\nPassport Number      : " + data[PC].GetPassportNumber());
							frsfile.write("\nTicket No #          : " + data2[TC].GetTNum());
							frsfile.write("\nType of Plane        : " + data[PC].GetTypeofPlane());
							frsfile.write("\nOrigin Point         : " + data[PC].GetOrigin());
							frsfile.write("\nDestination Point    : " + data[PC].GetDestinationPoint());
							frsfile.write("\nFlight Date          : " + data[PC].GetFlightDate());
							frsfile.write("\nFlight Time          : " + (java.time.LocalTime.now()));
							frsfile.write("\nClass Name           : " + data2[TC].GetClassName());
							frsfile.write("\nPlane Name           : " + data2[TC].GetPlaneName());
							frsfile.write("\nSeat Number          : " + data3[FC].seatsNo);
							frsfile.write("\nFare                 : " + data3[FC].fare);
							
							frsfile.close();
						} catch(IOException e)
						{
							System.out.println("Error Occurred");
							e.printStackTrace();
						}
					}
					
					else if (PC>0)
					{	
					FileWriter fw = null; 
					BufferedWriter bw = null; 
					PrintWriter pw = null;
					try { 
						fw = new FileWriter("Passenger.txt", true); 
						bw = new BufferedWriter(fw); 
						pw = new PrintWriter(bw); 
						pw.write("\n");
						pw.write("\nPassenger : " + (data[PC].pNo+1));
						pw.write("\nName             : " + data[PC].GetName());
						pw.write("\nGender           : " + data[PC].GetGender());
						pw.write("\nAge              : " + data[PC].GetAge());
						pw.write("\nAddress          : " + data[PC].GetAddress());
						pw.write("\nPassport Number  : " + data[PC].GetPassportNumber());
						
						pw.flush();
						}finally { 
							try { 
								pw.close(); 
								bw.close(); 
								fw.close(); 
								} catch (IOException io) { }
						}
					
					FileWriter fw1 = null; 
					BufferedWriter bw1 = null; 
					PrintWriter pw1 = null;
					try { 
						fw1 = new FileWriter("Flights_Reservation_Schedule.txt", true); 
						bw1 = new BufferedWriter(fw1); 
						pw1 = new PrintWriter(bw1); 
						pw1.write("\n");
						pw1.write("\nPassenger : " + (data[PC].pNo+1));
						pw1.write("\nName                 : " + data[PC].GetName());
						pw1.write("\nGender               : " + data[PC].GetGender());
						pw1.write("\nAge                  : " + data[PC].GetAge());
						pw1.write("\nAddress              : " + data[PC].GetAddress());
						pw1.write("\nPassport Number      : " + data[PC].GetPassportNumber());
						pw1.write("\nTicket No #          : " + data2[TC].GetTNum());
						pw1.write("\nType of Plane        : " + data[PC].GetTypeofPlane());
						pw1.write("\nOrigin Point         : " + data[PC].GetOrigin());
						pw1.write("\nDestination Point    : " + data[PC].GetDestinationPoint());
						pw1.write("\nFlight Date          : " + data[PC].GetFlightDate());
						pw1.write("\nFlight Time          : " + (java.time.LocalTime.now()));
						pw1.write("\nClass Name           : " + data2[TC].GetClassName());
						pw1.write("\nPlane Name           : " + data2[TC].GetPlaneName());
						pw1.write("\nSeat Number          : " + data3[FC].seatsNo);
						pw1.write("\nFare                 : " + data3[FC].fare);
						pw1.flush();
						}finally { 
							try { 
								pw1.close(); 
								bw1.close(); 
								fw1.close(); 
								} catch (IOException io) { }
						}
					}
				}
				PC++;
				}
				else
				{
					break;
				}
				break;
			}
			case 6:
			{
				if (TC == 0)
				{
					System.out.println("\n *** No Tickets to Cancel !!!");
				}
				else
				{
					System.out.print("Enter Ticket # To cancel Reservation : ");
					int t = sc.nextInt();
					
					for (int i=1; i<TC ; i++)
					{
						System.out.println(t + " " + data2[i].GetTNum());
						if(t == data2[i].GetTNum())
						{
							System.out.println("\n *** Your Reservation has been cancelled Successfully !!!");
							break;
						}
					}
				}
				System.out.println("\n *** The Ticket # you entered was not present in the DataBase !!!");
				break;
			}
			case 7:
			{
				if (PC == 0)
				{
					System.out.println("\n *** No Schedule to Print !!!");
				}
				else
				for (int i=0; i<PC ; i++)
				{
					data2[TC].Print_Schedule(data[i],data3[i]);
				}
				break;
			}
			case 8:
			{
				if (TC == 0)
				{
					System.out.println("\n *** No Tickets to Print !!!");
				}
				else
				data2[TC].Print_E_Ticket(data[PC],data3[FC]);
				break;
			}
			case 0:
			{
				break;
			}
			default:
			{
				System.out.println("Entered an invalid choice !!!");
				break;
			}
			}
			}while(ch2 != 0);
			
			break;
		}
		case 0:
		{
			System.out.println("You have 'Exit' the System !!!");
			break;
		}
		default:
		{
			System.out.println("Entered an invalid choice !!!");
			break;
		}
		}
		}while(ch!=0);
	}
}
