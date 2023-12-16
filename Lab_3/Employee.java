package Lab_3;

// Employee Payroll System
// Base class

class Employee {

    int employeeId;
    String employeeName;
    String designation;

    // Constructor

    public Employee(int employeeId, String employeeName, String designation){
        this.employeeId = employeeId;
        this.employeeName = employeeName;
        this.designation = designation;
    }

    // Implementing appropriate methods for setting and retrieving these attributes

    // Methods for setting and retrieving employeeId

    public int getEmployeeId(){
        return employeeId;
    }

    public void setEmployeeId(int employeeId){
        this.employeeId = employeeId;
    }

    // Methods for setting and retrieving employeeName

    public String getEmployeeName(){
        return employeeName;
    }

    public void setEmployeeName(String employeeName){
        this.employeeName = employeeName;
    }

    // Methods for setting and retrieving employeeDesignation

    public String getDesignation(){
        return designation;
    }

    public void setDesignation(String designation){
        this.designation = designation;
    }

    // Method to calculate bonus (This will be overriden by subclass)

    public double calculateBonus(){

        return 0.0;

    }

    // This method is to display detailed employee information

    public void displayInfo(){
        System.out.println("Employee ID: " + employeeId);
        System.out.println("Employee Name: " + employeeName);
        System.out.println("Designation: " + designation);
    }

}

// Derived Class 

class HourlyEmployee extends Employee{

    // Additional attributes in the derived class

    double hourlyRate;
    int hoursWorked;

    // Constructor

    public HourlyEmployee(int employeeId, String employeeName, String designation, double hourlyRate, int hoursWorked){

        super(employeeId, employeeName, designation);
        // By calling super() in a subclass constructor for ensuring that the superclass's constructor is executed before initializing the specific attributes of the subclass. 
        // It is used to call the immediate parent class within the constructor of child class

        // Additional attributes in the derived class

        this.hourlyRate = hourlyRate; 
        this.hoursWorked = hoursWorked;
    }

    // Implementing appropriate methods for setting and retrieving these attributes

    // Method for setting and retrieving hourly rate 

    public double getHourlyRate(){
        return hourlyRate;
    }

    public void setHourlyRate(double hourlyRate){
        this.hourlyRate = hourlyRate;
    }

    // Methods for setting and retrieving hours worked

    public int getHoursWorked(){
        return hoursWorked;
    }

    public void setHoursWorked(int hoursWorked){
        this.hoursWorked = hoursWorked;
    }

    // Implementing methods in derived class to calculate weekly salary

    public double calculateWeeklyEarnings(){

        return hourlyRate * hoursWorked;

    }

    // Overriding base class method to calculate bonus for HourlyEmployee

    @Override // Indication of overriding the method from it's parent class
    public double calculateBonus(){

        // Defining bonus calculatino specific to HourlyEmployee

        return calculateWeeklyEarnings() * 0.1; 
        // Assuming 10% of bonus per week

    }
    // Overriding displayInfo method to include specific details for HourlyEmployee
    @Override
    public void displayInfo(){
        super.displayInfo();
        System.out.println("Hourly Rate: " + hourlyRate);
        System.out.println("Hours Worked: " + hoursWorked);
        System.out.println("Weekly Earnings: " + calculateWeeklyEarnings());
    }
}

// Derived Class

class SalariedEmployee extends Employee{

    // Additional attributes in the derived class
    double monthlySalary;

    // Constructor

    public SalariedEmployee(int employeeId, String employeeName, String designation, double monthlySalary){
        super(employeeId, employeeName, designation); // It is used to call the immediate parent class within the constructor of child class
        this.monthlySalary = monthlySalary;
    }

    // Implementing appropriate methods for setting and retrieving these attributes
    // Method for setting and retrieving monthlySalary
    public double getMonthlySalary(){
        return monthlySalary;
    }

    public void setMonthlySalary(double monthlySalary){
        this.monthlySalary =  monthlySalary;
    }

    // Method to calculate weekly earnings

    public double calculateWeeklyEarnings(){
        return monthlySalary / 4; // 4 Weeks in a month
    }

    // Overriding base class method to calculate bonues for SalariedEmployee
    @Override
    public double calculateBonus(){
        // Defining bonus calculation
        return monthlySalary * 0.06; // Assuming 6% of bonus for monthly salary
    }

    // Overriding displayInfo method to include specific details for HourlyEmployee

    @Override
    public void displayInfo(){
        super.displayInfo();
        System.out.println("Monthly Salary: " + monthlySalary);
        System.out.println("Weekly Earnings:" + calculateWeeklyEarnings());
    }

}

// Derived Class

class ExecutiveEmployee extends SalariedEmployee{

    // Additional attributes 
    double bonusPercentage; // Percentage of annual salary allocated as bonus

    public ExecutiveEmployee(int employeeId, String employeeName, String designation, double monthlySalary, double bonusPercentage){

        super(employeeId, employeeName, designation, monthlySalary);
        // Invoking the immediate parent class constructor
        this.bonusPercentage = bonusPercentage;
    }

    // Implementing appropriate methods for setting and retrieving these attributes

    // Method for setting and retrieving bonusPercentage

    public double getBonusPercentage(){
        return bonusPercentage;
    }

    public void setBonusPercentage(double bonusPercentage){
        this.bonusPercentage =  bonusPercentage;
    }

    // Overriding base class method to calculate bonus for ExecutiveEmployee
    @Override
    public double calculateBonus(){

        // Defining bonus calculation specific to this class

        double annualSalary = getMonthlySalary() * 12; // Percentage of annualSalary allocated as bonus
        return annualSalary * (bonusPercentage/100);

    }

    // Overriding displayInfo method to include specific details for ExecutiveEmployee

    @Override
    public void displayInfo(){
        super.displayInfo();
        System.out.println("Bonus Percentage: " + bonusPercentage + "%");
        System.out.println("Annual Salary:" + getMonthlySalary() * 12);
        System.out.println("Bonus Amount:" + calculateBonus());
    }

}
