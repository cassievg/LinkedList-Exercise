import java.util.Objects;
import java.util.Scanner;
import java.util.LinkedList;
import java.util.HashMap;

class ContactBook {
    LinkedList<HashMap<String, String>> contacts;

    public ContactBook() {
        contacts = new LinkedList<HashMap<String, String>>();
    }

    public void add(String name, String email, String phone) {
        HashMap<String, String> contact = new HashMap<String, String>();
        contact.put("name", name);
        contact.put("email", email);
        contact.put("phone", phone);

        contacts.add(contact);
    }

    public void delete(String name) {
        boolean get = false;

        for (int i = 0; i < contacts.size(); i++){
            if(Objects.equals(contacts.get(i).get("name"), name)) {
                contacts.remove(i);
                get = true;
            }
        }

        if (!get) {
            System.out.println("This person is not in your contacts.");
        }
        else {
            System.out.println("Contact deleted.");
        }
    }

    public HashMap<String, String> emailSearch(String email) {
        boolean get = false;

        HashMap<String, String> emailSearch = new HashMap<String, String>();
        for (int i = 0; i < contacts.size(); i++){
            if(Objects.equals(contacts.get(i).get("email"), email)) {
                emailSearch = contacts.get(i);
                get = true;
            }
        }

        if (!get) {
            System.out.println("This person is not in your contacts.");
        }

        return emailSearch;
    }

    public void printList() {
        System.out.println(contacts);
    }

    public HashMap<String, String> search(String name) {
        boolean get = false;

        HashMap<String, String> search = new HashMap<String, String>();
        for (int i = 0; i < contacts.size(); i++){
            if(Objects.equals(contacts.get(i).get("name"), name)) {
                search = contacts.get(i);
                get = true;
            }
        }

        if (!get) {
            System.out.println("This person is not in your contacts.");
        }

        return search;
    }
}

public class Main {
    public static void main(String[] args) {
        System.out.print("*******************************\n (A)dd\n (D)elete\n (E)mail search\n (P)rint list\n (S)earch\n (Q)uit\n *******************************\n");

        ContactBook conts = new ContactBook();

        boolean run = true;
        while (run) {
            System.out.println("Please enter a command:");

            Scanner scanner = new Scanner(System.in);
            String menu = scanner.next();

            menu = menu.toLowerCase();

            switch (menu) {
                case "a":
                    System.out.println("Enter name: ");

                    Scanner addNameIn = new Scanner(System.in);
                    String addName = addNameIn.next();

                    System.out.println("Enter email: ");

                    Scanner addEmailIn = new Scanner(System.in);
                    String addEmail = addEmailIn.next();

                    System.out.println("Enter phone number: ");

                    Scanner addNumIn = new Scanner(System.in);
                    String addNum = addNumIn.next();

                    conts.add(addName, addEmail, addNum);
                    System.out.println("Contact successfully added.");
                    break;
                case "d":
                    System.out.println("Enter name: ");

                    Scanner delNameIn = new Scanner(System.in);
                    String delName = delNameIn.next();

                    conts.delete(delName);
                    break;
                case "e":
                    System.out.println("Enter email: ");

                    Scanner sEmailIn = new Scanner(System.in);
                    String sEmail = sEmailIn.next();

                    System.out.println(conts.emailSearch(sEmail));
                    break;
                case "p":
                    conts.printList();
                    break;
                case "s":
                    System.out.println("Enter name: ");

                    Scanner sNameIn = new Scanner(System.in);
                    String sName = sNameIn.next();

                    System.out.println(conts.search(sName));
                    break;
                case "q":
                    run = false;
                    break;
                default:
                    System.out.println("Please enter a valid input.");
                    break;
            }
        }
    }
}