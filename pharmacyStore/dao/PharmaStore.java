package pharmacyStore.dao;

import pharmacyStore.exceptions.MedicineNotExistsException;
import pharmacyStore.medicines.EmergencyMedicine;
import pharmacyStore.medicines.RegularMedicine;

import java.util.Date;

public interface PharmaStore {
    public void purchaseEmergencyMedicine(String MedicineName, int quantity) throws MedicineNotExistsException; //customers
    public void purchaseMedicine(String MedicineName, int quantity) throws MedicineNotExistsException; //customers
    public void addMedicine(RegularMedicine Medicine); //Only admins can add
    public void addEmergencyMedicine(EmergencyMedicine Medicine); //Only admins can add
    public RegularMedicine getMedicine(String MedicineName) throws MedicineNotExistsException; //Anyone can view the medicines
    public EmergencyMedicine getEmergencyMedicine(String MedicineName) throws MedicineNotExistsException;
    public void getStockDetails(); //Stock access to Employees
    public void getOrderDetails();
    public void getOderByDate(Date d1, Date d2);
    public void viewRegularMedicines();
    public void viewEmergencyMedicines();


}
