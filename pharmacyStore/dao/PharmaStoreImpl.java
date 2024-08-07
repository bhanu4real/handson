package pharmacyStore.dao;

import pharmacyStore.entities.Admin;
import pharmacyStore.entities.Employee;
import pharmacyStore.entities.Person;
import pharmacyStore.exceptions.MedicineNotExistsException;
import pharmacyStore.medicines.EmergencyMedicine;
import pharmacyStore.medicines.Orders;
import pharmacyStore.medicines.RegularMedicine;

import java.util.*;

public class PharmaStoreImpl implements PharmaStore {

    List<Person> persons = new ArrayList<Person>();
    List<Employee> employees = new ArrayList<>();
    List<Admin> admins = new ArrayList<>();


    Set<RegularMedicine> regularMedicines = new HashSet<>();
    Set<EmergencyMedicine> emergencyMedicines = new HashSet<>();

    List<Orders> ordersList = new ArrayList<>();


    public PharmaStoreImpl() {
        persons.add(new Person(101,"James",24,"Male"));
        persons.add(new Person(102,"Bob",25,"Female"));
        persons.add(new Person(103,"Jack",26,"Male"));
        persons.add(new Person(104,"Jane",27,"Female"));
        persons.add(new Person(105,"John",28,"Male"));


        employees.add(new Employee(106,"Clark",45,"Male",301,26000,"Pune"));
        employees.add(new Employee(107, "John", 35, "Female", 301,26000,"Pune" ));
        employees.add(new Employee(102, "Bob", 25, "Male", 301,26000,"Pune" ));

        admins.add(new Admin(106,"Clark",45,"Male",301,26000,"Pune",1));

        regularMedicines.add(new RegularMedicine(501, "Dolo",25, 10));
        regularMedicines.add(new RegularMedicine(502, "Paracetamol",12, 15));
        regularMedicines.add(new RegularMedicine(503, "Dart",10, 15));

        emergencyMedicines.add(new EmergencyMedicine(504,"Crocin", 30, 14, 1001));
        emergencyMedicines.add(new EmergencyMedicine(505, "Dettol", 10, 100, 1002));

        ordersList.add(new Orders(501,"Dolo",2, 10, 00, new Date(2024,6,24)));
        ordersList.add(new Orders(504,"Crocin", 30, 14, 1001, new Date(2024,3,20)));
        ordersList.add(new Orders(501,"Dolo",3, 10, 00, new Date(2024,6,3)));
    }

    @Override
    public void purchaseEmergencyMedicine(String MedicineName,int quantity) throws MedicineNotExistsException {
        int count=0;
        for (EmergencyMedicine em : emergencyMedicines) {
            if (em.getMedicineName().equals(MedicineName)) {
                em.setStockQuantity(em.getStockQuantity()-1);
                System.out.println("Medicine added successfully, Total Amount is: " + em.getPrice()*quantity);
                count++;
            }
        }
        if(count==0){
            throw new MedicineNotExistsException("Medicine Not Exists");
        }

    }

    @Override
    public void purchaseMedicine(String MedicineName, int quantity) throws MedicineNotExistsException {
        int count=0;
        for (RegularMedicine rm : regularMedicines) {
            if (rm.getMedicineName().equals(MedicineName)) {
                rm.setStockQuantity(rm.getStockQuantity()-quantity);
                System.out.println("Medicine added successfully, Total Amount is: " + rm.getPrice()*quantity);
                count++;
                ordersList.add(
                        new Orders(rm.getMedicineID(), rm.getMedicineName(), rm.getStockQuantity(), rm.getPrice(), 0, new Date()));
            }
        }
        if(count==0){
            throw new MedicineNotExistsException("Medicine Not Exists");
        }

    }

    @Override
    public void addMedicine(RegularMedicine Medicine) {
        int count=0;
        for(RegularMedicine rm : regularMedicines){
            if(rm.getMedicineName().equals(Medicine.getMedicineName())){
                rm.setStockQuantity(rm.getStockQuantity()+1);
                System.out.println("Medicine stock quantity increased successfully, new stock count is:" + rm.getStockQuantity());
                count++;
            }

        }
        if (count==0) {
            regularMedicines.add(Medicine);
            System.out.println("New Medicine added successfully.");
        }

    }

    @Override
    public void addEmergencyMedicine(EmergencyMedicine Medicine) {
        int count=0;
        for(EmergencyMedicine em : emergencyMedicines){
            if(em.getMedicineName().equals(Medicine.getMedicineName())){
                em.setStockQuantity(em.getStockQuantity()+ Medicine.getStockQuantity());
                System.out.println("Medicine stock quantity increased successfully, new stock count is:" + em.getStockQuantity());
                count++;
            }

        }
        if (count==0) {
            emergencyMedicines.add(Medicine);
            System.out.println("New Medicine added successfully.");
        }

    }

    @Override
    public RegularMedicine getMedicine(String MedicineName) throws MedicineNotExistsException{
        for(RegularMedicine rm : regularMedicines){
            if(rm.getMedicineName().equals(MedicineName)){
                return rm;
            }
        }
        throw new MedicineNotExistsException("Medicine Not Exists");
    }

    @Override
    public EmergencyMedicine getEmergencyMedicine(String MedicineName) throws MedicineNotExistsException {
        for(EmergencyMedicine em: emergencyMedicines){
            if(em.getMedicineName().equals(MedicineName)){
                return em;
            }
        }
        throw new MedicineNotExistsException("Medicine Not Exists");
    }


    @Override
    public void getStockDetails() {
        for(RegularMedicine rm : regularMedicines){
            rm.displayMedicine();
        }
        for(EmergencyMedicine em : emergencyMedicines){
            em.displayMedicine();
        }
    }

    @Override
    public void getOrderDetails() {
        System.out.println("ORDERS RECEIVED AS OF TODAY :");
        for(Orders order: ordersList){

            System.out.println("----------------------------------------");
            order.displayMedicine();
        }
    }

    @Override
    public void getOderByDate(Date d1, Date d2) {
        System.out.println("---------------------------------------------");
        System.out.println("Orders in given date range: ");
        System.out.println("---------------------------------------------");
        for(Orders order: ordersList){
            //Print order details only of order.date lies between Date d1 and Date d2;
            if (order.getDate().after(d1) && order.getDate().before(d2)) {
                order.displayMedicine();
                System.out.println("-----------------------------------------");
            }
        }
    }

    @Override
    public void viewRegularMedicines() {
        regularMedicines.forEach(medicine -> System.out.println(medicine.getMedicineName()));
    }

    @Override
    public void viewEmergencyMedicines() {
        emergencyMedicines.forEach(medicine -> System.out.println(medicine.getMedicineName()));
    }
}
