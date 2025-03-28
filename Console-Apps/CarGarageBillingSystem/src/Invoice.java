import java.util.ArrayList;
import java.util.List;

public class Invoice {
    private Customer customer;
    private List<Service> serviceList;
    private double totalAmount;

    public Invoice(Customer customer) {
        this.customer = customer;
        this.serviceList = new ArrayList<>();
        this.totalAmount = 0;
    }

    public void addService(Service service)
    {
        serviceList.add(service);
        totalAmount += service.getPrice();
    }

    public void printInvoice()
    {
        System.out.println("----------------Invoice----------------");
        System.out.println();
        System.out.println("Customer: "+customer.getName()+ " | Phone no: " + customer.getPhone());
        System.out.println("Car: " + customer.getCar().getModel() + " | Car Plate: " + customer.getCar().getNumberPlate());
        System.out.println("Services: ");
        for (int i=0; i<serviceList.size(); i++){
            System.out.println(i+1+". " + serviceList.get(i).getName() + ": ₹" + serviceList.get(i).getPrice());
        }
        for(Service service:serviceList){

        }
        System.out.println("Total Amount: ₹"+totalAmount);
        System.out.println();
        System.out.println("-------------------Thank You! Visit Again.-------------------");
    }
}
