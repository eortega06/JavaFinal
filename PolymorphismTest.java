/** CSE 292 Fall 2018
 * PolymorphismTest.java
 * Purpose: The main file. Will inheirit all classes and create new array of employees
 * 
 * @author Edwin Ortega
 * @version 1.0 12/05/18
 */



import java.util.List;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Formatter;


/**
 * PolymorphismTest.java
 * 
 * @author
 * @version 1.0  
 *
 */
public class PolymorphismTest {
   public static void main(String[] args) {
	   
	   ArrayList<Employee> employees =  new ArrayList<Employee>();
	   
	   employees.add(new Employee("Sue", "Jones", "111-11-1111", 10000, .06, 3));
	   employees.add(new BasePlusEmployee("Bob", "Lewis", "333-33-3333", 5000, .04,  3000, 4));
	   employees.add(new Employee("Michael", "Hughes", "234-22-2232", 20000, 0.05, 4));
	   employees.add(new BasePlusEmployee("Sandra", "Stanley", "343-43-3432", 15000, 0.04, 4000, 20));
	   employees.add(new BasePlusEmployee("Robert", "Rich", "343-434-222", 23000, 0.04, 5000, 30));
	   employees.add(new BasePlusEmployee("Susan", "Millers"));
	   // test case
      
      
      
	   double sumSales = 0;
	      double sumEarming = 0;
	      int numEmployee = 0;
	      try (Formatter output = new Formatter("earnings.txt") ) {
	    	  for ( Employee employee : employees) {
	    		  numEmployee++;
	    		  employee.setCommissionRate(employee.getCommissionRate() +  0.01);
	    		  System.out.printf("%3d. %s %s $%,.2f%n", numEmployee, 
	    				  employee.toString(), "Earning:", employee.earnings());
	    		  output.format("%s %s %s %.2f %.2f %2d %.2f%n", employee.getFirstName(),
	    				  employee.getLastName(), employee.getSocialSecurityNumber(),
	    				  employee.getGrossSales(), employee.getCommissionRate(), employee.getYears(),
	    				  employee.earnings());
	    		  sumSales += employee.getGrossSales();
	    		  sumEarming += employee.earnings();
	    	  }
	      } catch ( SecurityException | FileNotFoundException e ) {
	    	  System.err.println(e.getMessage());
	      }
	      
	      

	      System.out.printf("Total employees: %3d%n", employees.size());
		  System.out.printf("Total Sales: %,12.2f%n", sumSales);
		  System.out.printf("Total Earning: %,10.2f%n", sumEarming);
      
 
  
      
	} 
} 
