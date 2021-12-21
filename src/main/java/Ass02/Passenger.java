package Ass02;

import java.io.FileWriter;
import java.io.IOException;

public class Passenger extends Flight{

	private String name;
	private String gender;
	private int age;
	private String address;
	private String passportNumber;
	private String typeofPlane;
	private String origin;
	private String destinationPoint;
	private String flightDate;
	public int pNo;
	
	Passenger()
	{
		this.name = "Adeeba Khan";
		this.gender = "Female";
		this.age = 20;
		this.address = "House No. 32, Westridge Road";
		this.passportNumber = "110301849";
		this.typeofPlane = "AIR 0626";
		this.destinationPoint = "Maldives";
		this.origin = "Islamabad";
		this.flightDate = "01-03-22";
		this.pNo = 0;
	}
	
	Passenger(String name, String gender, int age, String address, String PassportNumber, String typeofPlane, String destinationPoint)
	{
		pNo++;
		this.name = name;
		this.gender = gender;
		this.age = age;
		this.address = address;
		this.passportNumber = passportNumber;
		this.typeofPlane = typeofPlane;
		this.destinationPoint = destinationPoint;
		this.origin = origin;
		this.flightDate = flightDate;
	}
	
	/* Setters */
	public void SetName(String name)
	{
		this.name = name;
	}
	public void SetGender(String gender)
	{
		this.gender = gender;
	}
	public void SetAge(int age)
	{
		this.age = age;
	}
	public void SetAddress(String address)
	{
		this.address = address;
	}
	public void SetPassportNumber(String passportNumber)
	{
		this.passportNumber = passportNumber;
	}
	public void SetTypeofPlane(String typeofPlane)
	{
		this.typeofPlane = typeofPlane;
	}
	public void SetDestinationPoint(String destinationPoint)
	{
		this.destinationPoint = destinationPoint; 
	}
	public void SetOrigin(String origin)
	{
		this.origin = origin;
	}
	public void SetFlightDate(String flightDate)
	{
		this.flightDate = flightDate;
	}
	
	/* Getters */
	public String GetName()
	{
		return name;
	}
	public String GetGender()
	{
		return gender;
	}
	public int GetAge()
	{
		return age;
	}
	public String GetAddress()
	{
		return address;
	}
	public String GetPassportNumber()
	{
		return passportNumber;
	}
	public String GetTypeofPlane()
	{
		return typeofPlane;
	}
	public String GetDestinationPoint()
	{
		return destinationPoint;
	}
	public String GetOrigin()
	{
		return origin;
	}
	public String GetFlightDate()
	{
		return flightDate;
	}
}
