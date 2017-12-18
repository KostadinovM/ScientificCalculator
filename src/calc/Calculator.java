package calc;
/**
 * Class that handles the main logic for the calculator(all operations).
 * 
 * @author Martin Kostadinov
 *
 */
public class Calculator
{
	  private long memory = 0;
	
	 public long calculate(long number1, long number2, String operator) {
	        switch (operator) {
	            case "+":
	                return number1 + number2;
	            case "-":
	                return number1 - number2;
	            case "*":
	                return number1 * number2;
	            case "/":
	                if (number2 == 0)
	                    return 0;

	                return number1 / number2;
	        }

	        System.out.println("Unknown operator - " + operator);
	        return 0;
	    }
	 
	 public long operateMemory(String memoryFct)
	 {
		 switch(memoryFct)
		 {
		 case "MC":
			 return memory = 0;
		 case "MR":
			 return memory;
		 }
		return 0;
	 }
	 
	 public long operateMemory(String memoryFct, long number)
	 {
		 switch(memoryFct)
		 {
		 case "M+":
			 return memory += number;
		 case "M-":
			 return memory -= number;
		 case "MS":
			 return memory = number;
		 }
		return 0;
	 }
	 
	 
}
