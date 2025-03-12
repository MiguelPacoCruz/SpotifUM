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
        User u = new User("Miguel","a108574@uminho.pt","Rua do Macaco, 235",Plan.PremiumTop);
        System.out.println(u);
        User u2 = new User("José","a1000@uminho.pt","Rua do Brazil, 239",Plan.Free);
        System.out.println(u2);
        u2.setPlan(Plan.PremiumBase);
        System.out.println(u2);

        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to SpotifUM!");
        System.out.println("Enter 1 to login, 2 to register, 3 to exit!");
        String option = scanner.nextLine();
        switch (option) {
            case "1":
                System.out.println("Please enter your email:");
                String mail = scanner.nextLine();
                // Add logic for login here
                break;
            case "2":
                System.out.println("You chose to register.");
                // Add logic for registration here
                break;
            case "3":
                System.out.println("Exiting... Goodbye!");
                System.exit(0);
                break;
            default:
                System.out.println("Invalid option. Please try again.");
                break;
        }
        scanner.close();
    }
}
