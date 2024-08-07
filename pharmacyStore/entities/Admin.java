package pharmacyStore.entities;

public class Admin extends Employee{
    private int adminId;

    public Admin(int personId, String personName, int age, String gender, int employeeID, double salary, String workLocation, int adminId) {
        super(personId, personName, age, gender, employeeID, salary, workLocation);
        this.adminId = adminId;
    }

    public int getAdminId() {
        return adminId;
    }

    public void setAdminId(int adminId) {
        this.adminId = adminId;
    }

    @Override
    public String toString() {
        return "Admin{" +
                "adminId=" + adminId +
                '}';
    }
}
