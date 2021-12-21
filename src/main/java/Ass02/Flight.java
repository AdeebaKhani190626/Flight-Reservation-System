package Ass02;

public class Flight{
	
	protected String fare;
	protected int seatsNo;
	protected int dc = 0;
	protected int indc = 0;
	public int []dp;
	public int []indp;
	
	Flight()
	{
		dp = new int[500];
		indp = new int[500];
	}
	
	public String FindDirectFlight(String o, String d)
	{
		ReservationSystemDataBase RSD = new ReservationSystemDataBase();
		RSD.CreateSchedule();
		String [] OF = RSD.Origin_From;
		String [] OD = RSD.Destination_To;
		String [] ODa = RSD.Flight_Date;
		
		for (int i=0; i<OF.length; i++)
		{
			if (o.equals(OF[i]))
			{
				if (d.equals(OD[i]))
				{
					dp[i] = i;
					dc++;
				}
			}
		}
		
		if (dc>0)
		{
			return "Flight Available";
		}
		else
		return "Sorry";
	}
	
	public String FindIndirectFlight(String o, String d)
	{
		ReservationSystemDataBase RSD = new ReservationSystemDataBase();
		RSD.CreateSchedule();
		String [] OF = RSD.Origin_From;
		String [] OD = RSD.Destination_To;
		for (int i=0; i<OF.length; i++)
		{
			if (o.equals(OF[i]))
			{
				for(int j=0; j<OD.length; j++)
				{
					if (d.equals(OD[j]))
					{
						if (i != j)
						{
						indp[i] = i;
						indc++;
						}
					}
				}
			}
		}
		if (indc>0)
		{
			return "Flight Available";
		}
		else
		return "Sorry";
	}
	
	/* Getter */
	public String GetFare()
	{
		return fare;
	}
	
	public int GetSeats()
	{
		return seatsNo;
	}
	
	public int GetDC()
	{
		return dc;
	}
	
	public int GetINDC()
	{
		return indc;
	}
}
