package Lab_3;

 // Now, we need to create objects for each and every class to showcase the functionalities


    class EmployeePayrollTest {
    public static void main(String[] args) {

        // Creating objects of each employee type

        HourlyEmployee hourlyEmployee = new HourlyEmployee(101, "Harish K", "Developer", 15.5, 40);
        SalariedEmployee salariedEmployee = new SalariedEmployee(102, "Surendran M", "Manager", 5000);
        ExecutiveEmployee executiveEmployee = new ExecutiveEmployee(103, "Nithila S", "Executive", 10000, 15);

        // Displaying detailed information for each employee

        System.out.println("Employee Information:");
        System.out.println("---------------------");
        System.out.println("Hourly Employee Details:");
        hourlyEmployee.displayInfo();
        System.out.println("\nSalaried Employee Details:");
        salariedEmployee.displayInfo();
        System.out.println("\nExecutive Employee Details:");
        executiveEmployee.displayInfo();
        System.out.println("----------------------");

        // Calculating and display bonus for each employee

        System.out.println("\nBonus Calculation:");
        System.out.println("--------------------");
        System.out.println("Hourly Employee Bonus: $" + hourlyEmployee.calculateBonus());
        System.out.println("Salaried Employee Bonus: $" + salariedEmployee.calculateBonus());
        System.out.println("Executive Employee Bonus: $" + executiveEmployee.calculateBonus());
        System.out.println("---------------------");

        // Calculating and display annual earnings for each employee

        System.out.println("\nAnnual Earnings:");
        System.out.println("------------------");
        System.out.println("Hourly Employee Annual Earnings: $" + hourlyEmployee.calculateWeeklyEarnings() * 52); // 52 weeks in a year
        System.out.println("Salaried Employee Annual Earnings: $" + salariedEmployee.getMonthlySalary() * 12);
        System.out.println("Executive Employee Annual Earnings: $" + executiveEmployee.getMonthlySalary() * 12);
        System.out.println("-------------------");

        // Calculating and displaying total payroll

        double totalPayroll = hourlyEmployee.calculateWeeklyEarnings() * 52 +
                salariedEmployee.getMonthlySalary() * 12 +
                executiveEmployee.getMonthlySalary() * 12;
        System.out.println("\nTotal Payroll: $" + totalPayroll);
    }
}

    
