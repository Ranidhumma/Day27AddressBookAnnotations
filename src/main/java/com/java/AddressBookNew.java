package com.java;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class AddressBookNew {
	Scanner scanner = new Scanner(System.in);
	List<ContactPerson> contacts = new ArrayList<>();
	Map<String, AddressBookNew> addressBookMap = new HashMap<>();

	public static HashMap<String, ArrayList<ContactPerson>> personByCity = new HashMap<String, ArrayList<ContactPerson>>();
	public static HashMap<String, ArrayList<ContactPerson>> personByState = new HashMap<String, ArrayList<ContactPerson>>();
	ContactPerson person = new ContactPerson();
	String name;;

	public void duplicateCheck() {
		System.out.print(" Please enter the first name: ");
		name = scanner.next();
		for (ContactPerson i : contacts) {
			if (i.getFirstName().equals(name)) {
				System.out.println(" Given name already exists");
			}
			return;
		}
		addPerson();
	}

	public void addContact() { // taking input from console to add user
		System.out.println("Enter the number of contacts you want to enter");
		int number = scanner.nextInt();
		for (int i = 0; i < number; i++) {
			System.out.println("Enter the contact details of person ");
			duplicateCheck();
		}
	}

	public void addPerson() {
		ContactPerson person = new ContactPerson();
		Scanner scan = new Scanner(System.in);

		System.out.print(" Please enter the first name: ");
		String firstName = scan.next();
		System.out.print(" Please enter the last name: ");
		String lastName = scan.next();
		System.out.print(" Please enter the address: ");
		String address = scan.next();
		System.out.print(" Please enter the city : ");
		String city = scan.next();
		System.out.print(" Please enter the state: ");
		String state = scan.next();
		System.out.print(" Please enter the zip: ");
		int zip = scan.nextInt();
		System.out.print(" Please enter the phone number: ");
		Long phoneNumber = scan.nextLong();
		System.out.print(" Please enter the email: ");
		String email = scan.next();

		person.setFirstName(firstName);
		person.setLastName(lastName);
		person.setAddress(address);
		person.setCity(city);
		person.setState(state);
		person.setZip(zip);
		person.setPhoneNumber(phoneNumber);
		person.setEmail(email);
		contacts.add(person);

	}

	public ContactPerson findContact() { // to find the contacts
		System.out.println("\n Enter the first name of the contact to edit: ");
		String name = scanner.next();
		int duplicate = 0; // will increment the duplicate if found multiple contacts with same name
		ContactPerson temp = null;
		for (ContactPerson contact : contacts) {
			if (contact.getFirstName().equals(name)) {
				duplicate++;
				temp = contact;
			}
		}
		if (duplicate == 1) {
			return temp;

		} else if (duplicate > 1) {
			System.out.print(" There are multiple contacts with given name.\n Please enter their email id: ");
			String email = scanner.next();
			for (ContactPerson contact : contacts) {
				if (contact.getFirstName().equals(name) && contact.getEmail().equals(email)) {
					return contact;
				}
			}
		} else {
			System.out.println("No contact with the given first name. Please enter the correct first name");
			findContact();
		}
		return temp;
	}

	public void editContact() {
		ContactPerson contact = findContact();

		System.out.println("Enter your choice to edit: " + "\n 1.Edit first name" + "\n 2.Edit last name"
				+ "\n 3.Edit address" + "\n 4.Edit city" + "\n 5.Edit state" + "\n 6.Edit zipcode"
				+ "\n 7.Edit phone number" + "\n 8.Edit email");

		int choice = scanner.nextInt(); // with the help of setters setting the new details
		switch (choice) {
		case 1:
			System.out.println("Enter new first name");
			String newFirstName = scanner.next();
			contact.setFirstName(newFirstName);
			System.out.println("new first name updated");

			break;
		case 2:
			System.out.println("Enter new last name");
			String newLastName = scanner.next();
			contact.setLastName(newLastName);
			System.out.println("new last name updated");

			break;
		case 3:
			System.out.println("Enter new address");
			String newAddress = scanner.next();
			contact.setAddress(newAddress);
			System.out.println("new newaddress updated");

			break;
		case 4:
			System.out.println("Enter new city");
			String newCity = scanner.next();
			contact.setCity(newCity);
			System.out.println("new city updated");

			break;
		case 5:
			System.out.println("Enter new state");
			String newState = scanner.next();
			contact.setState(newState);
			System.out.println("new state updated");

			break;
		case 6:
			System.out.println("Enter new zip code");
			int newZipCode = scanner.nextInt();
			contact.setZip(newZipCode);
			System.out.println("new zip code updated");
			break;

		case 7:
			System.out.println("Enter new phone number");
			long newPhoneNumber = scanner.nextLong();
			contact.setPhoneNumber(newPhoneNumber);
			System.out.println("new phone number updated");

			break;

		case 8:
			System.out.println("Enter new email");
			String newEmail = scanner.next();
			contact.setEmail(newEmail);
			System.out.println("new email updated");

			break;

		default:
			System.out.println("Please enter a number between 1 to 8 only...");
			break;
		}
		System.out.println("The contact after editing is : " + contact);

	}

	public void displayContact() {
		System.out.println(contacts);
	}

	public void deleteContact() { // to delete contact
		ContactPerson contact = findContact();
		if (contact == null) {
			System.out.println("No contact found with the given name");
			return;
		}
		contacts.remove(contact); // remove method to delete the contact
		System.out.println("contact deleted from the Address Book");
	}

	public void addPersonToCity(ContactPerson contact) {
		if (personByCity.containsKey(contact.getCity())) {
			personByCity.get(contact.getCity()).add(contact);
		} else {
			ArrayList<ContactPerson> cityList = new ArrayList<ContactPerson>();
			cityList.add(contact);
			personByCity.put(contact.getCity(), cityList);
		}
	}

	/**
	 * In this method we are checking the person by state
	 * 
	 * @param contact- We are parsing the contact there
	 */
	public void addPersonToState(ContactPerson contact) {
		if (personByState.containsKey(contact.getState())) {
			personByState.get(contact.getState()).add(contact);
		} else {
			ArrayList<ContactPerson> stateList = new ArrayList<ContactPerson>();
			stateList.add(contact);
			personByState.put(contact.getState(), stateList);
		}
	}

}
