package com.java;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class MultipleAddressBook {

	Scanner scanner = new Scanner(System.in);
	/* use of hashMap to save the addressBook */
	Map<String, AddressBookNew> addressBookMap = new HashMap<>();

	public void addAddressBook() { // to add address book
		System.out.println("Enter Name of new Address Book: ");

		String bookName = scanner.next();
		/* we use containsKey to check if the book name exists */

		if (addressBookMap.containsKey(bookName)) {
			System.out.println("Address book with this name exists, Enter new name.");
			addAddressBook();
		} else {
			AddressBookNew addressBook = new AddressBookNew();

			/* adding address book and contacts to HashMap */
			addressBookMap.put(bookName, addressBook);
			System.out.println("Address Book " + bookName + " successfully added!!");
		}
	}

	public void addContact() { // to add contact in Address book
		System.out.println("Enter the name of Address book to add the contact.");
		Scanner scanner = new Scanner(System.in);
		String newContact = scanner.nextLine();
		AddressBookNew addressBook = addressBookMap.get(newContact); // to check if the addressbook is present
		if (addressBook == null) {
			System.out.println("No book found");

		} else {
			addressBookMap.get(newContact).addContact();
		}
	}

	public void editContactInBook() {
		System.out.println("Enter Name of Address Book you want to edit: ");
		Scanner scanner = new Scanner(System.in);
		String editBookName = scanner.next();
		if (addressBookMap.containsKey(editBookName)) {
			/* calling the edit contact method to edit contact */
			addressBookMap.get(editBookName).editContact();
		} else {
			System.out.println("AddressBook doesn't exist, Please enter correct name.");
			editContactInBook();
		}
	}

	public void deleteAddressBook() {
		System.out.println("Enter Name of Address Book you want to delete: ");
		Scanner scanner = new Scanner(System.in);
		String bookName = scanner.next();
		/* we use containsKey to check if addressBook present */
		if (addressBookMap.containsKey(bookName)) {
			/* using remove fun to remove the book */
			addressBookMap.remove(bookName);
		} else {
			System.out.println("AddressBook doesn't exist, Please enter correct name.");
			deleteAddressBook();
		}
	}

	public void deleteContactInBook() {
		System.out.println("Enter Name of Address Book you want to delete the contacts in it: ");
		Scanner scanner = new Scanner(System.in);
		String bookName = scanner.next();
		if (addressBookMap.containsKey(bookName)) {
			/* we call the deleteContact function to delete the contact */
			addressBookMap.get(bookName).deleteContact();
		} else {
			System.out.println("AddressBook doesn't exist, Please enter correct name.");
			deleteContactInBook();
		}
	}

	public void printBook() {
		System.out.println("These are AddressBooks in program.");
		for (String i : addressBookMap.keySet()) { // we use keySet to get all the keys and display it
			System.out.println(i);
		}
	}

	public void printContactsInBook() {
		for (String i : addressBookMap.keySet()) {
			System.out.println(i);
			/* we print the values of the key */
			System.out.println(addressBookMap.get(i).contacts);
			System.out.println(" ");
		}
	}

	public void searchByState() {
		// TODO Auto-generated method stub
		System.out.println("Enter the name of the State to the get persons : ");
		String stateName = scanner.next();
		for (String i : addressBookMap.keySet()) {
			List<ContactPerson> arr = addressBookMap.get(i).contacts;
			arr.stream().filter(person -> person.getState().equals(stateName))
					.forEach(person -> System.out.println(person.getFirstName()));
		}
	}

	public void searchByCity() {
		// TODO Auto-generated method stub

		System.out.println("Enter the name of the City to get the persons : ");
		String cityName = scanner.next();
		for (String i : addressBookMap.keySet()) {
			List<ContactPerson> arr = addressBookMap.get(i).contacts;
			arr.stream().filter(person -> person.getCity().equals(cityName))
					.forEach(person -> System.out.println(person.getFirstName()));
		}
	}

}
