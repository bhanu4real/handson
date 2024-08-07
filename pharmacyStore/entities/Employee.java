package pharmacyStore.entities;

public class Employee extends Person{
    private int employeeID;
    private double salary;
    private String workLocation;

    public Employee(int personId, String personName, int age, String gender, int employeeID, double salary, String workLocation) {
        super(personId, personName, age, gender);
        this.employeeID = employeeID;
        this.salary = salary;
        this.workLocation = workLocation;
    }

    public Employee() {
    }

    public int getEmployeeID() {
        return employeeID;
    }

    public void setEmployeeID(int employeeID) {
        this.employeeID = employeeID;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public String getWorkLocation() {
        return workLocation;
    }

    public void setWorkLocation(String workLocation) {
        this.workLocation = workLocation;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "employeeID=" + employeeID +
                ", salary=" + salary +
                ", workLocation='" + workLocation + '\'' +
                '}';
    }


}
