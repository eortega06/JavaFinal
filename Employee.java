



/** CSE 292 Fall 2018
 * Employee.java
 * Purpose: Create a class that gets inheireted
 * 
 * @author Edwin Ortega
 * @version 1.0 12/05/18
 */


public class Employee {
   private final String firstName;                        
   private final String lastName;                         
   private final String socialSecurityNumber;             
   private double grossSales; // gross weekly sales       
   private double commissionRate; // commission percentage
   private double allowance;
   private int yearsWorked;

   // five-argument constructor
   public Employee(String firstName, String lastName, 
      String socialSecurityNumber, double grossSales, 
      double commissionRate, int yearsWorked) {
      // implicit call to Object constructor occurs here

      // if grossSales is invalid throw exception
      if (grossSales < 0.0) {
         throw new IllegalArgumentException("Gross sales must be >= 0.0");
      }      

      // if commissionRate is invalid throw exception
      if (commissionRate < 0.0 || commissionRate >= 1.0) {
         throw new IllegalArgumentException(
            "Commission rate must be > 0.0 and < 1.0");
      }      

      this.firstName = firstName;                                    
      this.lastName = lastName;                                    
      this.socialSecurityNumber = socialSecurityNumber;         
      this.grossSales = grossSales;
      this.commissionRate = commissionRate;
      this.yearsWorked = yearsWorked;
   }
   
   public Employee() {
       throw new IllegalArgumentException("Must have first name and last name");
   }
   
   public Employee(String firstName, String lastName, String socialSecurityNumber){
	   this(firstName, lastName, socialSecurityNumber, 0, 0, 0);
   }
   
   public Employee(String firstName, String lastName) {
	   this(firstName, lastName, "999-99-9999", 0, 0, 0);
   }
   
   
   
   

   // return first name
   public String getFirstName() {return firstName;}

   // return last name
   public String getLastName() {return lastName;}

   // return social security number 
   public String getSocialSecurityNumber() {return socialSecurityNumber;}

   // set gross sales amount
   public void setGrossSales(double grossSales) {
      if (grossSales < 0.0) {
         throw new IllegalArgumentException("Gross sales must be >= 0.0");
      }      

      this.grossSales = grossSales;
   } 

   // return gross sales amount
   public double getGrossSales() {return grossSales;}
   
   public void setAllowance(double allowance) {
	   this.allowance = allowance;
   }
   
   public double getAllowance() {
	   return allowance;
   }

   // set commission rate
   public void setCommissionRate(double commissionRate) {
      if (commissionRate <= 0.0 || commissionRate >= 1.0) {
         throw new IllegalArgumentException(
            "Commission rate must be > 0.0 and < 1.0");
      } 

      this.commissionRate = commissionRate;
   } 
   
   public void setYears(int yearsWorked) {
	   if(yearsWorked < 0) {
		   throw new IllegalArgumentException("Years worked cannot be less that 0");
	   }
	   this.yearsWorked = yearsWorked;
   }
   
   public int getYears() {
	   return yearsWorked;
   }


   // return commission rate
   public double getCommissionRate() {return commissionRate;}

   // calculate earnings
   public double earnings() {
	   double yearFactor = 1.00;
	   int yearsEmployed = getYears();
	   if( yearsEmployed <= 20 ) {
		   yearFactor = 1.2;
	   } else if ( yearsEmployed <= 15) {
		   yearFactor = 1.15;
	   } else if( yearsEmployed <= 10 ) {
		   yearFactor = 1.10;
	   } else if( yearsEmployed <= 5  ) {
		   yearFactor = 1.05;
	   } else if ( yearsEmployed > 5 ) {
		   yearFactor = 1.00;
	   } 
      return getCommissionRate() * getGrossSales() * yearFactor;
   } 
   
  

   // return String representation of CommissionEmployee object
   @Override 
   public String toString() {
	      return String.format("%s: %-7s %-10s %s: %s %s: %,10.2f %s: %,5.2f", 
	         "Employee", getFirstName(), getLastName(), 
	         "SSN", getSocialSecurityNumber(), 
	         "gross sales", getGrossSales(), 
	         "commission rate", getCommissionRate());
	   } 
} 
