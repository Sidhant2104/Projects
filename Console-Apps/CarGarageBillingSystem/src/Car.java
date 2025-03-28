public class Car {
    private String numberPlate;
    private String model;

    public Car(String model, String numberPlate) {
        this.model = model;
        this.numberPlate = numberPlate;
    }

    public String getNumberPlate() {
        return numberPlate;
    }

    public String getModel() {
        return model;
    }
}
