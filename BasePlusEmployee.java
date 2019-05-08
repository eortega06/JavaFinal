


/** CSE 292 Fall 2018
 * BasePlusEmployee.java
 * Purpose: Create a class that gets inheirited
 * 
 * @author Edwin Ortega
 * @version 1.0 12/05/18
 */


public class BasePlusEmployee extends Employee {
   private double baseSalary; // base salary per week

   // six-argument constructor
   public BasePlusEmployee(String firstName, String lastName, 
      String socialSecurityNumber, double grossSales, 
      double commissionRate, double baseSalary, int yearsWorked) {
      super(firstName, lastName, socialSecurityNumber, 
         grossSales, commissionRate, yearsWorked);                      

      
      if( ! firstName.matches("[A-Z][a-zA-Z]*")) {
	         throw new IllegalArgumentException("First Name must be letters, the first letter must be a capital");
	   }
	   
	   if( ! lastName.matches("[A-Z][a-zA-Z]*")) {
	         throw new IllegalArgumentException("Last Name must be letters, the first letter must be a capital");
	   }


	   /*if( ! socialSecurityNumber.matches("\\d{3}-\\d{2}-\\d{4}")) {
	         throw new IllegalArgumentException("SSN must be digit");
	   }*/
      // if baseSalary is invalid throw exception
      if (baseSalary < 0.0) {                  
         throw new IllegalArgumentException("Base salary must be >= 0.0");
      }
      
      

      this.baseSalary = baseSalary;
      
   }
   
   public BasePlusEmployee(String firstName, String lastName, String socialSecurityNumber) {
	   super(firstName, lastName, socialSecurityNumber);
       this.baseSalary = 0;
   }
   
   public BasePlusEmployee(String firstName, String lastName) {
	   super(firstName, lastName);
       this.baseSalary = 0;
   }
   
   public BasePlusEmployee() {
	   super();
       this.baseSalary = 0;
   }
   
   // set base salary
   public void setBaseSalary(double baseSalary) {
      if (baseSalary < 0.0) {                  
         throw new IllegalArgumentException("Base salary must be >= 0.0");
      }       

      this.baseSalary = baseSalary;                
   } 

   // return base salary
   public double getBaseSalary() {return baseSalary;}
   


   
   // calculate earnings
   @Override 
   public double earnings() {return getBaseSalary() + super.earnings();}

   // return String representation of BasePlusEmployee
   @Override
   public String toString() {
      return String.format("%s %s: %,.2f",
         super.toString(), "base salary", getBaseSalary());   
   } 
} 

