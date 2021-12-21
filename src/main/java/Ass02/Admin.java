package Ass02;

import java.io.FileWriter;
import java.io.IOException;

public class Admin {

	private String ID;
	private String name;
	private String gender;
	private int age;
	private String address;
	private int count;
	
	Admin()
	{
		this.name = "Adeeba Khan";
		this.gender = "Female";
		this.age = 20;
		this.address = "House No. 32, Westridge Road";
		this.ID = "5643";
		this.count = 0;
	}
	
	Admin(String name, String gender, int age, String address, String ID)
	{
		count++;
		this.name = name;
		this.gender = gender;
		this.age = age;
		this.address = address;
		this.ID = ID;
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
	public void SetID(String ID)
	{
		this.ID = ID;
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
	public String GetID()
	{
		return ID;
	}
	public int GetCount()
	{
		return count;
	}
	
	public int SearchAdmin(String ID)
	{
		if (this.ID.equals(ID))
		{
			return 1;
		}
		else
		{
		return 0;
		}
	}
	
	public void PrintAdminDetails()
	{
		System.out.println("\n--------------------------------------------------------");
		System.out.println(" * * * * * * * *    ADMIN INFORMATION    * * * * * * * *  ");
		System.out.println("\nAdmin ID : " + GetID());
		System.out.println("Admin Name : " + GetName());
		System.out.println("Admin Age : " + GetAge());
		System.out.println("Admin Address : " + GetAddress());
		System.out.println("Admin Gender : " + GetGender());
	}
	
	public void WriteAdminDetails()
	{
		try {
			
			FileWriter adminfile = new FileWriter("Admin.txt");
			adminfile.write("Writing Admin Details ... ");
			adminfile.write("\nAdmin ID      : " + GetID());
			adminfile.write("\nAdmin Name    : " + GetName());
			adminfile.write("\nAdmin Age     : " + GetAge());
			adminfile.write("\nAdmin Address : " + GetAddress());
			adminfile.write("\nAdmin Gender  : " + GetGender());
			adminfile.close();
			
			System.out.println("Admin Information Written Successfully");
		} catch(IOException e)
		{
			System.out.println("Error Occurred");
			e.printStackTrace();
		}
	}
}
