package Phonebook;

public class Person implements Comparable<Person>{

	private Address address = new Address();
	
	private String firstName;
	private String lastName;
	private String middleName;
	
	private String phoneNumber;
	
	public Person() {
		
	}
	public Person addPerson(String inputEntry) {
		//John Doe, 114 Market St, St Louis, MO, 63403, 636643569
		//int counter =0;
		//int commaLocation =0;
		
		String[] commaSplitter = inputEntry.split(",");
		
		//Capture name portion
		
		String[] spaceTrimmer= commaSplitter[0].split(" ");
		
		if (spaceTrimmer.length ==2) {
			setFirstName(spaceTrimmer[0]);
			setLastName(spaceTrimmer[1]);
			setMiddleName(null);
			
		}
		else if (spaceTrimmer.length ==3) {
			setFirstName(spaceTrimmer[0]);
			setMiddleName(spaceTrimmer[1]);
			setLastName(spaceTrimmer[2]);
			
		}
		else if (spaceTrimmer.length ==4) {
			setFirstName(spaceTrimmer[0]);
			setMiddleName(spaceTrimmer[1] + " " + spaceTrimmer[2]);
			setLastName(spaceTrimmer[3]);
		}
		//Capture address portion
		address.setStreet(commaSplitter[1].trim());
		address.setCity(commaSplitter[2].trim());
		address.setState(commaSplitter[3].trim());
		address.setZipcode(commaSplitter[4].trim());
		
		//Capture phone portion
		setPhoneNumber(commaSplitter[5].trim());
		
		
		
		return this;
	}

	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getMiddleName() {
		return middleName;
	}
	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}
	public String getPhoneNumber() {
		
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = "(" + phoneNumber.substring(0, 3) + ")-" + phoneNumber.substring(3, 6) + "-" + phoneNumber.substring(6, 10);
	}
	

	
		
	
	/*public Phone getPhone() {
		return phone;
	}
	public void setPhone(Phone phone) {
		this.phone = phone;
	}*/
	
	
	@Override
	public String toString() {
		String tempFullName="";
		if (null==getMiddleName())
		{
			tempFullName = getFirstName()+ " " +getLastName();
			
		}
		else{
			tempFullName = getFirstName()+ " " + getMiddleName().trim()+ " " + getLastName();
		}
		return tempFullName + ", "+ address +", " + getPhoneNumber();
		
	}
	@Override
	public int compareTo(Person o) {
		return this.firstName.compareTo(o.firstName);
	}
	
	
	
	
}
