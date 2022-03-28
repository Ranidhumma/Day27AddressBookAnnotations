package com.java;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

public class MultipleAddressBook {

	Scanner scanner = new Scanner(System.in);
	/* use of hashMap to save the addressBook */
	Map<String, AddressBookNew> addressBookMap = new HashMap<>();
	public Map<String, ContactPerson> contacts = new HashMap<String, ContactPerson>();
	ContactPerson person = new ContactPerson();

	public void addAddressBook() {
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
		System.out.println("Enter the name of the City to get the persons : ");
		String cityName = scanner.next();
		for (String i : addressBookMap.keySet()) {
			List<ContactPerson> arr = (List<ContactPerson>) addressBookMap.get(i).contacts;
			arr.stream().filter(person -> person.getCity().equals(cityName))
					.forEach(person -> System.out.println(person.getFirstName()));
		}
	}

	public void searchByCity() {
		// TODO Auto-generated method stub

		System.out.println("Enter the name of the City to get the persons : ");
		String cityName = scanner.next();
		for (String i : addressBookMap.keySet()) {
			List<ContactPerson> arr = (List<ContactPerson>) addressBookMap.get(i).contacts;
			arr.stream().filter(person -> person.getCity().equals(cityName))
					.forEach(person -> System.out.println(person.getFirstName()));
		}
	}

	public void displayPeopleByRegion(HashMap<String, ArrayList<ContactPerson>> addressBookMap) {
		System.out.println("Enter the name of the region :");
		String regionName = scanner.next();

		addressBookMap.values().stream()
				.map(region -> region.stream()
						.filter(person -> person.getState().equals(regionName) || person.getCity().equals(regionName)))
				.forEach(person -> person.forEach(personDetails -> System.out.println(personDetails)));
	}

	/**
	 * In this method we are displaying the number of person in the city or state.
	 * 
	 * @param listToDisplay - we are passing the list of city or state
	 */
	public void countPeopleByRegion(HashMap<String, ArrayList<ContactPerson>> listToDisplay) {
		System.out.println("Enter the name of the region :");
		String regionName = scanner.next();
		long countPeople = listToDisplay.values().stream()
				.map(region -> region.stream()
						.filter(person -> person.getState().equals(regionName) || person.getCity().equals(regionName)))
				.count();

		System.out.println("Number of People residing in " + regionName + " are: " + countPeople + "\n");

	}

	public void sortAddressBook() {
		// TODO Auto-generated method stub
		/**
		 * Method to sort the address book by name In this method we are sorting the
		 * address book by the person first name we have used the sorted method and
		 * compared 2 contacts and arranged them. In this way it will compare and
		 * arrange it.
		 */
		for (String i : addressBookMap.keySet()) {
			Map<String, ContactPerson> con = addressBookMap.get(i).contacts;

			List<ContactPerson> sorted = con.values().stream().sorted(
					(firstperson, secondperson) -> firstperson.getFirstName().compareTo(secondperson.getFirstName()))
					.collect(Collectors.toList());

			System.out.println("------ Sorted Address Book ------");
			Iterator iterator = sorted.iterator();
			while (iterator.hasNext()) {
				System.out.println(iterator.next());
				System.out.println();
			}
		}
	}
}
