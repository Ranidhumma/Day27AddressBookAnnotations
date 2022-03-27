package com.java;

import java.util.Scanner;

public class AddressBook {
	public static void main(String[] args) {
		System.out.println("**Welcome to Address Book**");
		Scanner sc = new Scanner(System.in);

		AddressBookNew ab = new AddressBookNew();
		MultipleAddressBook mab = new MultipleAddressBook();
		while (true) {
			System.out.println("Enter \n 1. To add the new AddressBook\n 2. To add contact in AddressBook\n "
					+ "3. To edit the contact in AddressBook\n 4. To delete the contact in AddressBook\n 5. To delete the AddressBook\n "
					+ "6. To Print the AddressBook\n 7. To Print the contacts in AddressBook\n 8. Search Person By City.\n 9. Search Person by State\n 10. View Person by City \n 11. View Person by State\n 12. Count People \n 0. To exit");
			Scanner scanner = new Scanner(System.in);
			int choice = scanner.nextInt();
			switch (choice) {
			case 1:
				mab.addAddressBook();
				break;
			case 2:
				mab.addContact();
				break;
			case 3:
				mab.editContactInBook();
				break;
			case 4:
				mab.deleteContactInBook();
				break;
			case 5:
				mab.deleteAddressBook();
				break;
			case 6:
				mab.printBook();
				break;
			case 7:
				mab.printContactsInBook();
				break;
			case 8:
				mab.searchByCity();
				break;
			case 9:
				mab.searchByState();
				break;
			case 10:
				mab.displayPeopleByRegion(AddressBookNew.personByCity);
				break;
			case 11:
				mab.displayPeopleByRegion(AddressBookNew.personByState);
				break;
			case 12:
				System.out.println("Enter \n1.Display By City\n2.Display By State");
				int countChoice = sc.nextInt();
				if (countChoice == 1)
					mab.countPeopleByRegion(AddressBookNew.personByCity);
				else
					mab.countPeopleByRegion(AddressBookNew.personByState);
				break;

			case 0:
				System.exit(0);
				break;
			default:
				System.out.println("Enter the wrong input");
			}
		}

	}
}