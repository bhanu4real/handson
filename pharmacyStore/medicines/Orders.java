package pharmacyStore.medicines;

import java.util.Date;

public class Orders extends EmergencyMedicine{
    private Date date;

    public Orders(int medicineID, String medicineName, int stockQuantity, double price, int emergencyMedicineID, Date date) {
        super(medicineID, medicineName, stockQuantity, price, emergencyMedicineID);
        this.date = date;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Orders{" +
                "date=" + date +
                '}';
    }

    @Override
    public void displayMedicine() {
        super.displayMedicine();
        System.out.println("Order Date :" + date);
    }
}
