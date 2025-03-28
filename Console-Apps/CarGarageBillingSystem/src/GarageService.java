import java.sql.SQLOutput;
import java.util.*;

public class GarageService {
    private final Map<String, Customer> customerMap;

    private final List<Service> availableServices;

    public GarageService() {
        this.customerMap = new HashMap<>();
        this.availableServices = new ArrayList<>();
        loadServices();
    }

    public void loadServices()
    {
        availableServices.add(new Service("Car Wash", 500));
        availableServices.add(new Service("Engine Oil/Mobil Change", 700));
        availableServices.add(new Service("Wheel Alignment", 300));
        availableServices.add(new Service("Tyre Replacement", 3000));
        availableServices.add(new Service("Puncture Repair/tyre", 150));
        availableServices.add(new Service("Ac Cleaning", 600));
        System.out.println();
    }

    public void addCustomer(String name, String PhoneNo, String CarModel, String CarNumberPlate) {
        Car car = new Car(CarModel, CarNumberPlate);
        Customer customer = new Customer(name, PhoneNo, car);
        customerMap.put(CarNumberPlate, customer);
        System.out.println("Customer added successfully!");
    }


    public void createInvoice(String carNumber) {
        if (!customerMap.containsKey(carNumber)) {
            System.out.println("No customers found with car number " + carNumber + ".");
            return;
        } else {
            Scanner sc = new Scanner(System.in);
            Customer customer = customerMap.get(carNumber);
            Invoice invoice = new Invoice(customer);
            System.out.println("Available Services:");
            for (int i = 0; i < availableServices.size(); i++) {
                System.out.println(i + 1 + ". " + availableServices.get(i).getName() + "-₹" + availableServices.get(i).getPrice());
            }

            while (true) {
                System.out.println("Enter service number to add or enter 0 to finish: ");
                int choice = sc.nextInt();
                if (choice == 0) break;
                if (choice > 0 && choice <= availableServices.size()) {
                    invoice.addService(availableServices.get(choice - 1));
                    System.out.println("Service done!");
                } else {
                    System.out.println("Invalid Choice.");
                }
            }
            invoice.printInvoice();

        }
    }
}
