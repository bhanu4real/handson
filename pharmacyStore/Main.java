package pharmacyStore;

import pharmacyStore.dao.PharmaStoreImpl;
import pharmacyStore.exceptions.MedicineNotExistsException;
import pharmacyStore.medicines.RegularMedicine;

import java.sql.Time;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        PharmaStoreImpl pharmStore = new PharmaStoreImpl();

        //Stock report - Gives report about the stock available in the pharmacy.
        pharmStore.getStockDetails();

        //Orders list - Gives list of all the orders
        pharmStore.getOrderDetails();

        //Orders based on Date range
        pharmStore.getOderByDate(new Date(2024,03,4), new Date(2024,8,8));

        //Purchase a Medicine using Medicine name and quantity
        //This adds the purchased item into orders list as well as reduces the stockquantity by the quantity purchased by customer
        System.out.println("PURCHASE MEDICINE: for Regular Medicine enter 1, for emergency medicine enter 2:");
        Scanner sc = new Scanner(System.in);
        int type = sc.nextInt();
        if (type == 1) {
            pharmStore.viewRegularMedicines();
            try {
                pharmStore.purchaseMedicine("Dolo",3);
            } catch (MedicineNotExistsException e) {
                e.getMessage();
            }
        }
        else if (type == 2) {
            pharmStore.viewEmergencyMedicines();
            try {
                pharmStore.purchaseEmergencyMedicine("Dettol",3);
            } catch (MedicineNotExistsException e) {
                e.getMessage();
            }
        }
        else System.out.println("Enter valid choice");


        //addMedicine methods adds the new medicine to the medicine list if the medicine does not exist
        // if the medicine already exists it increases the stock quantity of the already existing medicine.
        RegularMedicine medicine= new RegularMedicine(108, "Citeregine", 23, 8);
        pharmStore.addMedicine(medicine);



    }

}
