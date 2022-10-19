import java.util.Scanner;

public class AddressBookOperations {
    Scanner input = new Scanner(System.in);
    AddressBook addressBook = new AddressBook();

    public void performOperationsOnAddressBook() {

        int choice = 1;
        //Store contacts to addressBook1

        while (choice != 0) {
            switch (choice) {
                case 0:
                    return;
                case 1:
                    addressBook.addToAddressBook();
                    break;
                case 2:
                    addressBook.editPersonName();
                    break;
                case 3:
                    addressBook.displayAddressBook();
                    break;
                case 4:
                    addressBook.deleteContact();
                    break;
                case 5:
                    System.out.println("Enter state to search for persons");
                    String state = input.next();
                    addressBook.displayPersonInState(state);
                    break;
                case 6:
                    System.out.println("Enter city to search for persons");
                    String city = input.next();
                    addressBook.displayPersonInCity(city);
                    break;
                case 7:
                    addressBook.sortAddressBookByFirstName();
                    break;
                case 8:
                    System.out.println("Enter choice to sort Address Book upon");
                    String option = input.next();
                    addressBook.sortAddressBookByCityOrStateOrZip(option);
                    break;
                case 9:
                    addressBook.writeAddressBookToCSV();
                    break;
                case 10:
                    addressBook.readAddressBookFromCSV();
                    break;
            }

            System.out.println("Enter\n0- exit \n1- Add more contact \n2- edit contact \n3- display\n4- delete contact\n5- Search for person within state\n6- Search for person within city \n7- Sort using first name \n8- sort using city/state/zip \n9- Write data using CSV \n10- Read data");
            choice = input.nextInt();
        }
    }
}
