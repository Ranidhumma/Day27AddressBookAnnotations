package com.java;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class AddressBookNew {
	Scanner scanner = new Scanner(System.in);
	String name;
	/**
	 * We have created a list of ContactPerson type and also a HashMap for multiple
	 * address book.
	 */
	public Map<String, ContactPerson> contacts = new HashMap<String, ContactPerson>();
	public static HashMap<String, ArrayList<ContactPerson>> personByCity = new HashMap<String, ArrayList<ContactPerson>>();
	public static HashMap<String, ArrayList<ContactPerson>> personByState = new HashMap<String, ArrayList<ContactPerson>>();
	ContactPerson person = new ContactPerson();

	/**
	 * We have created this class to take number of contacts from the user. We have
	 * used the For loop and called the check method.
	 */
	public void addContact() {
		System.out.println("Enter the number of contacts you want to enter");
		int number = scanner.nextInt();
		for (int i = 0; i < number; i++) {
			System.out.println("Enter the contact details of person ");
			addPerson();
		}
	}

	public void addPerson() {
		ContactPerson person = new ContactPerson();
		Scanner scan = new Scanner(System.in);
		System.out.println(" Please Enter First Name: ");
		String firstName = scan.next();

		if (contacts.containsKey(firstName)) {
			System.out.println("Contact Already Exists");
			return;
		}

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
		addPersonToCity(person);
		addPersonToState(person);

		contacts.put(firstName, person);
	}

	public void editContact() {
		ContactPerson contact = new ContactPerson();

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
			System.out.println("Please enter a number between 1-8");
			break;
		}
		System.out.println("The contact after editing is : " + contact);

	}

	public void displayContact() {
		System.out.println(contacts);
		System.out.println("Value is " + contacts.values());
	}

	public void deleteContact() { // to delete contact

		System.out.println("Enter the first name of the person to be deleted");
		String firstName = scanner.next();
		if (contacts.containsKey(firstName)) {
			contacts.remove(firstName);
			System.out.println("Successfully Deleted");
		} else {
			System.out.println("Contact Not Found!");
		}
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
