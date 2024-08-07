package pharmacyStore.medicines;

public class EmergencyMedicine extends RegularMedicine{
    private int EmergencyMedicineID;

    public EmergencyMedicine(int medicineID, String medicineName, int stockQuantity, double price, int emergencyMedicineID) {
        super(medicineID, medicineName, stockQuantity, price);
        EmergencyMedicineID = emergencyMedicineID;
    }

    public int getEmergencyMedicineID() {
        return EmergencyMedicineID;
    }

    public void setEmergencyMedicineID(int emergencyMedicineID) {
        EmergencyMedicineID = emergencyMedicineID;
    }

    @Override
    public String toString() {
        return "EmergencyMedicine{" +
                "EmergencyMedicineID=" + EmergencyMedicineID +
                '}';
    }

    @Override
    public void displayMedicine() {
        super.displayMedicine();
        System.out.println("EmergencyMedicine ID: " + getMedicineID());
    }
}
