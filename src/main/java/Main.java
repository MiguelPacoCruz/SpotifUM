import java.util.Scanner;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author miguel
 */



public class Main {
    public static void main(String[] args) {
//        Music m = new Music("Für Elise","Ludwig van Beethoven","", new String[]{}, new String[]{}, Genre.Classic, 173, 0);
//        System.out.println(m);
//        Playlist p = new Playlist();
//        System.out.println(p);
//        p.addMusic(m);
//        System.out.println(p);
//
        menu();
    }

    private static void menu(){
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to SpotifUM!");
        System.out.println("Enter 1 to login, 2 to register, 3 to exit!");

        String option = scanner.nextLine();
        switch (option) {
            case "1":
                login(scanner);
                break;
            case "2":
                register(scanner);
                break;
            case "3":
                System.out.println("Exiting... Goodbye!");
                System.exit(0);
                break;
            default:
                System.out.println("Invalid option. Please try again.");
                menu();
                break;
        }
        scanner.close();
    }

    private static void login(Scanner scanner){
        System.out.println("Please enter your email:");
        String mail = scanner.nextLine();
        if (DataManager.getUserId(mail) == -1) {
            System.out.println("User not found. Please try again.");
            menu();
        }
        else {
            System.out.println("Welcome back, " + mail + "!");
        }
    }

    private static void register(Scanner scanner){
        System.out.println("You chose to register.");
        System.out.println("Please enter your email:");
        String mail = scanner.nextLine();
        if (DataManager.getUserId(mail) != -1) {
            System.out.println("User already exists. Please try again.");
            menu();
        }
        System.out.println("Please enter your name:");
        String name = scanner.nextLine();
        System.out.println("Please enter your address:");
        String address = scanner.nextLine();
        choosePlan(scanner, name, mail, address);
        menu();
    }

    private static void choosePlan(Scanner scanner, String name, String mail, String address){
        System.out.println("Please choose your plan. Enter 1 for Free, 2 for Premium Base and 3 for Premium Top");
        String plan = scanner.nextLine();
        if (plan.equals("1")) {
            DataManager.addUser(new User(name, mail, address, Plan.Free));
        }
        else if (plan.equals("2")) {
            DataManager.addUser(new User(name, mail, address, Plan.PremiumBase));
        }
        else if (plan.equals("3")) {
            DataManager.addUser(new User(name, mail, address, Plan.PremiumTop));
        }
        else {
            System.out.println("Invalid plan. Please try again.");
            choosePlan(scanner, name, mail, address);
        }
    }
}
