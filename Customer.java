package MainAccount;

public class Customer {

	int UniqueID;
	String name;
	String address;
	String PhoneNum;
	static int count = 0;
	
	Customer()
	{
		UniqueID = 10;
		name = "";
		address = "";
		PhoneNum = "";
	}

	Customer(String name, String address, String PhoneNum)
	{
		this.name = name;
		this.address = address;
		this.PhoneNum = PhoneNum;
		UniqueID = count++;
	}

	public String getName() {
		return name;
	}

	public String getAddress() {
		return address;
	}

	public String getPhoneNumber() {
		// TODO Auto-generated method stub
		return PhoneNum;
	}

	public int getAccountNum() {
		return UniqueID;
	}
}
