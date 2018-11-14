package Phonebook;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class Application {
	private static ArrayList<Person> person = new ArrayList<>(); 
	 
		public static void main(String[] args) {
			int mainChoice=0;
			
			Scanner input = new Scanner(System.in);
			
			do {
				mainChoice= Menu.menuChoice();
				//Add entry
				if (mainChoice==1) {
					System.out.println("Enter this format: First Middle Last Name, address, city, state, zipcode, ten digits telephone number");
					String er = input.nextLine();
					person.add(new Person().addPerson(er));
				}
				//Delete entry
				else if (mainChoice==2) {
					System.out.println("Enter this format: (314)-345-6789");
					removePerson(input.nextLine());
				}
				//Search entry
				else if(mainChoice==3) {
					int searchOption=Menu.searchChoice();
					System.out.println("----------------------------------------------------------------------------------");
					searchParameter(searchOption);
					
				}
				//Update contact
				else if (mainChoice==4) {
					System.out.print("Please enter a telephone to continue to update (e.g. (314)-123-4567): ");
					int personArray = matchTelephone(input.next());
					if (personArray != 1000) {
						updateParameter(Menu.updateChoice(), personArray);
						//from update menu
					}
					else {
						System.out.println("Sorry, number is not in contact list");
					}
					////(input.next());
					//int updateOption=Menu.updateChoice(); --need to update with a given telephone #
					
				}
				if (mainChoice==5) {
					System.out.println("----------------------------------------------------------------------------------");
					showPhonebookList();
				}
			} while ( mainChoice != 6 );
			System.out.println("----------------------------------------------------------------------------------");
			System.out.println(" -------------------");
			System.out.println("|Have a nice day!!!!|");
			System.out.println(" -------------------");
		}
		
		private static void showPhonebookList() {
			//John Doe, 114 Market St, St Louis, MO, 63403, 636643569
			if (person.size()>0) {
				System.out.println("----------------------------------------------------------------------------------");
				Collections.sort(person);
				for (int i=0; i<person.size(); i++) {
					System.out.println(i+1 +")"+ person.get(i));
				}
			}
			else {
				System.out.println("Your phonebook is emptied");
			}
		}

		public static void removePerson(String inputNumber) {
			for (int i=0; i< person.size(); i++) {
				if (person.get(i).getPhoneNumber().equals(inputNumber)) {
					person.remove(i);
					System.out.println("You have successfully deleted this number from your phonebook list");
				}
			}
			
		}
		
		public static void searchParameter (int parameter) {
			Scanner input = new Scanner(System.in);
			if (parameter ==1) {
				System.out.print("Enter first name ");
				searchFirstName(input.nextLine());
			}
			else if (parameter==2) {
				System.out.print("Enter last name ");
				searchLastName(input.next());
			}
			else if (parameter==3) {
				System.out.print("Enter full name (e.g. John Mee Doe): ");
				//String test = input.nextLine();
				searchFullName(input.nextLine());
			}
			else if (parameter==4) {
				System.out.print("Enter phonenumber (e.g. (314)-123-4567): ");
				searchPhone(input.next());
			}
			else if (parameter==5) {
				System.out.print("Enter city (e.g. St.Louis); ");
				searchCity(input.next());
			}
			else if (parameter==6) {
				System.out.print("Enter state (e.g. MO): ");
				searchState(input.next());
			}
			else if (parameter==7) {
				System.out.print("Enter zipcode (e.g. 63456): ");
				searchZipcode(input.next());
			}
			
			
		}
		
		public static void searchFirstName(String firstName) {
			for (int i=0; i<person.size(); i++) {
				if (person.get(i).getFirstName().toLowerCase().equals(firstName.toLowerCase())) {
					System.out.println(person.get(i));
				}
			}
		}
		
		public static void searchLastName(String lastName) {
			for (int i=0; i<person.size(); i++) {
				if (person.get(i).getLastName().toLowerCase().equals(lastName.toLowerCase())) {
					System.out.println(person.get(i));
				}
			}
		}
		
		public static void searchFullName(String fullName) {
			for (int i=0; i<person.size(); i++) {
				String tempFullName ="";
				
				if(person.get(i).getMiddleName().equals(""))
				{
					tempFullName = person.get(i).getFirstName().toLowerCase() + " " + person.get(i).getLastName().toLowerCase();
					
				}
				else{
					tempFullName = person.get(i).getFirstName().toLowerCase() + " " + person.get(i).getMiddleName().trim()+ " " + person.get(i).getLastName().toLowerCase();
				}
				
				fullName = fullName.toLowerCase();
				//System.out.println(fullName + " " + tempFullName+ " "+ tempFullName.equals(fullName)); */
				if ( tempFullName.equals(fullName)) {
					System.out.println(person.get(i)); 
				}
			}
		}
		
		public static void searchPhone(String phoneNumber) {
			for (int i=0; i<person.size(); i++) {
				if (person.get(i).getPhoneNumber().equals(phoneNumber)) {
					System.out.println(person.get(i));
				}
			}
		}
		
		public static void searchCity(String city) {
			for (int i=0; i<person.size(); i++) {
				String tempCity =person.get(i).getAddress().getCity().toLowerCase();
				//System.out.println(tempCity.trim() + " " + city + " " + tempCity.trim().equals(city.toLowerCase()));
				if (tempCity.trim().equals(city.toLowerCase())) {
					System.out.println(person.get(i));
				}
			}
		}
		
		public static void searchState(String state) {
			for (int i=0; i<person.size(); i++) {
				String tempState =person.get(i).getAddress().getState().toLowerCase();
				if (tempState.trim().equals(state.toLowerCase())) {
					System.out.println(person.get(i));
				}
			}
		}
		
		public static void searchZipcode(String zipcode) {
			for (int i=0; i<person.size(); i++) {
				String tempZipcode =person.get(i).getAddress().getZipcode().toLowerCase();
				if (tempZipcode.trim().equals(zipcode)) {
					System.out.println(person.get(i));
				}
			}
		}
		
		public static int matchTelephone(String phoneNumber) {
			int match = 1000;
			for (int i=0; i<person.size(); i++) {
				if (person.get(i).getPhoneNumber().equals(phoneNumber)) {
					match= i;
				}
			}
			return match;

		}
		
		//Choices to update
		public static void updateParameter(int parameter, int personNumber) {
			Scanner input = new Scanner(System.in);
			if (parameter==1) {
				System.out.println("Current first name: " + person.get(personNumber).getFirstName());
				System.out.print("Please enter new first name: ");
				String tempFirst = input.next().toLowerCase();
				tempFirst = (tempFirst.substring(0,1).toUpperCase() + tempFirst.substring(1)).trim();
 				person.get(personNumber).setFirstName(tempFirst);
 				System.out.println("----------------------------------------------------------------------------------");
				System.out.println("Updated contact is :" + person.get(personNumber));
				
			}
			if (parameter==2) {
				System.out.println("Current last name: " + person.get(personNumber).getLastName());
				System.out.print("Please enter new last name: ");
				String tempLast = input.next().toLowerCase();
				tempLast = (tempLast.substring(0,1).toUpperCase() + tempLast.substring(1)).trim();
 				person.get(personNumber).setLastName(tempLast);
 				System.out.println("----------------------------------------------------------------------------------");
				System.out.println("Updated contact is :" + person.get(personNumber));
				
			}
			if (parameter==3) {
				System.out.println("Current telephone number: " + person.get(personNumber).getPhoneNumber());
				System.out.print("Please enter new telephone number (e.g. 1234567890): ");
				String tempPhoneNumber = input.next();
				person.get(personNumber).setPhoneNumber(tempPhoneNumber);
				System.out.println("----------------------------------------------------------------------------------");
				System.out.println("Updated contact is :" + person.get(personNumber));
			}
			if (parameter==4) {
				System.out.println("Current address: " + person.get(personNumber).getAddress());
				System.out.print("Please enter new address like the above the format above: ");
				String tempAddress = input.nextLine();
				//trimmer and split:   123 walker st, st.louis, mo, 63126
				String[] commaSplitter = tempAddress.split(",");
				person.get(personNumber).getAddress().setStreet(commaSplitter[0].trim());
				person.get(personNumber).getAddress().setCity(commaSplitter[1].trim());
				person.get(personNumber).getAddress().setState(commaSplitter[2].trim());
				person.get(personNumber).getAddress().setZipcode(commaSplitter[3].trim());
				System.out.println("----------------------------------------------------------------------------------");
				System.out.println("Updated contact is :" + person.get(personNumber));
				
			}
		}
		
	
		
}

//John Doe, 114 Market St, St.Louis, MO, 63403, 6366435693
//Mary Doe, 2445 Fyler Ave, St.Louis, MO, 63139, 3146014399
//Lou Nguyen, 3504 Arsenal St, St.Louis, M), 63118, 3147724246
//(636)-643-5693