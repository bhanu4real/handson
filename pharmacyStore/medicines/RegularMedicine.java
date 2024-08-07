package pharmacyStore.medicines;

public class RegularMedicine {
    private int medicineID;
    private String medicineName;
    private int stockQuantity;
    private double price;

    public RegularMedicine(int medicineID, String medicineName, int stockQuantity, double price) {
        this.medicineID = medicineID;
        this.medicineName = medicineName;
        this.stockQuantity = stockQuantity;
        this.price = price;
    }

    public RegularMedicine() {
    }

    public int getMedicineID() {
        return medicineID;
    }

    public void setMedicineID(int medicineID) {
        this.medicineID = medicineID;
    }

    public String getMedicineName() {
        return medicineName;
    }

    public void setMedicineName(String medicineName) {
        this.medicineName = medicineName;
    }

    public int getStockQuantity() {
        return stockQuantity;
    }

    public void setStockQuantity(int stockQuantity) {
        this.stockQuantity = stockQuantity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "RegularMedicine{" +
                "medicineID=" + medicineID +
                ", medicineName='" + medicineName + '\'' +
                ", stockQuantity=" + stockQuantity +
                ", price=" + price +
                '}';
    }

    public void displayMedicine(){
        System.out.println("RegularMedicine{" +
                "medicineID=" + medicineID +
                ", medicineName='" + medicineName + '\'' +
                ", stockQuantity=" + stockQuantity +
                ", price=" + price +
                '}');
    }
}
