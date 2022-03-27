package com.java;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AddressBook {
	public static void main(String[] args) {
		System.out.println("**Welcome to Address Book**");
		Scanner sc = new Scanner(System.in);

		/* Arraylist is used to store data/contacts */
		List<ContactPerson> contacts = new ArrayList<ContactPerson>();
		AddressBookNew ab = new AddressBookNew();
		// ab.addContact();

		while (true) {

			System.out.println("Enter your Choice: \n 1.Add Contact\n 2. Edit Contact\n 3.Display Contact\n 4.Exit ");
			int choice = sc.nextInt();
			switch (choice) {
			case 1:
				System.out.println("Enter the contact detais to add in the Address Book: ");
				ab.addContact();

				break;
			case 2:
				System.out.println("Enter the detais to edit: ");
				ab.editContact();

				break;

			case 3:
				System.out.println("The contacts in the Address Book are ");
				ab.displayContact();
				break;

			case 4:
				System.out.println("Exit : ");
				sc.close();
				return;

			}
		}
	}
}
