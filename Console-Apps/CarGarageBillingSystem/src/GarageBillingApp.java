import java.util.Scanner;

public class GarageBillingApp {
    public static void main(String[] args) {
        GarageService garageService = new GarageService();
        Scanner sc = new Scanner(System.in);
        System.out.println("--------JANTA GARAGE--------");
        while (true) {

            System.out.println();
            System.out.println("1. Add Customer");
            System.out.println("2. Offered Services");
            System.out.println("3. Exit");
            System.out.println("4. Enter your choice:");

            int choice = sc.nextInt();

            switch(choice){
                case 1:
                    System.out.println("Enter  customer name:");
                    String name = sc.next();
                    System.out.println("Enter customer phone number:");
                    String phone = sc.next();
                    System.out.println("Enter customer car model");
                    String carMod = sc.next();
                    System.out.println("Enter customers cars number:");
                    String carNum = sc.next();
                    garageService.addCustomer(name,phone,carMod,carNum);
                    break;
                case 2:
                    System.out.println("Enter the car Number");
                    String carNo = sc.next();
                    garageService.createInvoice(carNo);
                    break;
                case 3:
                    System.out.println("Exiting.....Thank You!");
                    sc.close();
                    return;
                default:
                    System.out.println("Invalid Choice! Try again.");
            }
        }
    }
}
