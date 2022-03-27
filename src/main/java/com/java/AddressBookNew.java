package com.java;

import java.util.List;
import java.util.Scanner;

public class AddressBookNew {
	Scanner scan = new Scanner(System.in);

	public void addContact(List<ContactPerson> contacts) {

		System.out.print(" Please enter the first name: ");
		String firstName = scan.next();

		System.out.print(" Please enter the last name: ");
		String lastName = scan.next();

		System.out.print(" Please enter the address: ");
		String address = scan.next();

		System.out.print(" Please enter the city: ");
		String city = scan.next();

		System.out.print(" Please enter the state: ");
		String state = scan.next();

		System.out.print(" Please enter the zip: ");
		int zip = scan.nextInt();

		System.out.print(" Please enter the phone number: ");
		Long phoneNumber = scan.nextLong();

		System.out.print(" Please enter the email: ");
		String email = scan.next();

		ContactPerson newContact = new ContactPerson(firstName, lastName, address, city, state, zip, phoneNumber,
				email);
		contacts.add(newContact);
	}
}