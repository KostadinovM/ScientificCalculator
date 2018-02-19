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
	  private final double INCREMENT = 1E-4;
	
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
			 memory = 0;
			 return memory;
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
			 memory += number;
			 return memory;
		 case "M-":
			 memory -= number;
			 return memory;
		 case "MS":
			 memory = number;
			 return memory;
		 }
		return 0;
	 }
	 
	
		public double integral(double a, double b, Function function)
		{	
			double area = 0;
			double modifier = 1;
			if(a>b)
			{
				double tempA = a;
				a = b;
				b = tempA;
				modifier = -1;
			}
			for(double i = a + INCREMENT; i<b; i+=INCREMENT)
			{
				double dFromA = i - a;
				area += (INCREMENT / 2) * (function.f(a + dFromA) + function.f(a + dFromA - INCREMENT)); 
			}
			return (Math.round(area * 1000.0) / 1000.0) * modifier;
		}
		
	
}
