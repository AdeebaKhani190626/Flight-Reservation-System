package Ass02;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.StringTokenizer;

public class ReservationSystemDataBase {

	public String Flight_Date[]; // = {"01-03-2022","13-05-2023","12-12-2021","10-05-2022","15-06-2024","19-06-2024"};
	public String Origin_From[]; // = {"Islamabad","Lahore","Islamabad","Karachi","Islamabad","Quetta"};
	public String Destination_To[]; // = {"London","Dubai","Toronto","Skardu","Toronto","London"};
	public String Fare[]; // = {"2,15,000","45,000","3,25,000","15,000","2,45,000","1,50,000"};
	public String Seats[]; // = {"50","50","50","50","50"};
	
	ReservationSystemDataBase()
	{
		Flight_Date = new String[6];
		Origin_From = new String[6];
		Destination_To = new String[6];
		Fare = new String[6];
		Seats = new String[6];
	}
	
	public void CreateSchedule()
	{
		StringTokenizer StrToken;
		int c1 = 0; int c2 = 0; int c3 = 0; int c4 = 0; int c5 = 0;
		int c = 0;
		try 
		 {
		      File myObj = new File("Database.txt");
		      Scanner myReader = new Scanner(myObj);
		      while (myReader.hasNextLine()) 
		      {
		    	  	String data = myReader.nextLine();
		    	  	StrToken = new StringTokenizer(data);
		    	  	c++;
		    	  	
		    	  	if (c == 1)
		    	  	{
		    	  		while (StrToken.hasMoreTokens())
			    	  	{ 
		    	  			String word = StrToken.nextToken(",");
		    	  		    Flight_Date[c1] = word;
		    	  			c1++;
			    	  	}
		    	  	}
		    	  	if (c == 2)
		    	  	{
		    	  		while (StrToken.hasMoreTokens())
			    	  	{
		    	  			String word = StrToken.nextToken(",");
		    	  			Origin_From[c2] = word;
		    	  			c2++;
			    	  	}
		    	  	}
		    	  	if (c == 3)
		    	  	{
		    	  		while (StrToken.hasMoreTokens())
			    	  	{
		    	  			String word = StrToken.nextToken(",");
		    	  			Destination_To[c3] = word;
		    	  			c3++;
			    	  	}
		    	  	}
		    	  	if (c == 4)
		    	  	{
		    	  		while (StrToken.hasMoreTokens())
			    	  	{
		    	  			String word = StrToken.nextToken(" ");
		    	  			Fare[c4] = word;
		    	  			c4++;
			    	  	}
		    	  	}
		    	  	if (c == 5)
		    	  	{
		    	  		while (StrToken.hasMoreTokens())
			    	  	{
		    	  			String word = StrToken.nextToken(",");
		    	  			Seats[c5] = word;
		    	  			c5++;
			    	  	}
		    	  	} 
		    	  	
		      }myReader.close();
		 } catch (FileNotFoundException e)
        {
		      System.out.println("An error occurred.");
		      e.printStackTrace();
		 }
		
	}
	
	
	public void PrintData()
	{
		System.out.println("----------------------------------------------------------------------------------------------");
		System.out.println("                               FLIGHT DETAILS/SCHEDULE                                      ");
		System.out.println("----------------------------------------------------------------------------------------------");
		
		System.out.print("Flight Date    | ");
		for (int i=0; i<Flight_Date.length; i++)
		{
			System.out.print(Flight_Date[i] + " | ");
		}
		
		System.out.print("\n_____________________________________________________________________________________________");
		System.out.print("\nOrigin         | ");
		for (int i=0; i<Origin_From.length; i++)
		{
			if (i == 0)
				System.out.print(Origin_From[i] + "  | ");
			if (i == 1)
				System.out.print(Origin_From[i] + "     | ");
			if (i == 2)
				System.out.print(Origin_From[i] + "  | ");
			if (i == 3)
				System.out.print(Origin_From[i] + "    | ");
			if (i == 4)
				System.out.print(Origin_From[i] + "  | ");
			if (i == 5)
				System.out.print(Origin_From[i] + "     | ");
		}

		System.out.print("\n_____________________________________________________________________________________________");
		System.out.print("\nDestination    | ");
		for (int i=0; i<Destination_To.length; i++)
		{
			if (i == 0)
				System.out.print(Destination_To[i] + "     | ");
			if (i == 1)
				System.out.print(Destination_To[i] + "      | ");
			if (i == 2)
				System.out.print(Destination_To[i] + "    | ");
			if (i == 3)
				System.out.print(Destination_To[i] + "     | ");
			if (i == 4)
				System.out.print(Destination_To[i] + "    | ");
			if (i == 5)
				System.out.print(Destination_To[i] + "     | ");
		}

		System.out.print("\n_____________________________________________________________________________________________");
		System.out.print("\nFare           | ");
		for (int i=0; i<Fare.length; i++)
		{
			if (i == 0)
				System.out.print(Fare[i] + "   | ");
			if (i == 1)
				System.out.print(Fare[i] + "     | ");
			if (i == 2)
				System.out.print(Fare[i] + "   | ");
			if (i == 3)
				System.out.print(Fare[i] + "     | ");
			if (i == 4)
				System.out.print(Fare[i] + "   | ");
			if (i == 5)
				System.out.print(Fare[i] + "   | ");
		}

		System.out.print("\n_____________________________________________________________________________________________");
		System.out.print("\nSeats          | ");
		for (int i=0; i<Seats.length; i++)
		{
			System.out.print(Seats[i] + "         | ");
		}
		
		System.out.print("\n_____________________________________________________________________________________________\n\n");
	}
}
