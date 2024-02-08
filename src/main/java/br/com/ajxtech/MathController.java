package br.com.ajxtech;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.ajxtech.exceptions.UnsupportedMathOperationException;

@RestController
public class MathController {
	
	private final AtomicLong counter = new AtomicLong();
	
	@RequestMapping("/sum/{numberOne}/{numberTwo}")
	public Double sum(@PathVariable(value = "numberOne") String numberOne, 
					  @PathVariable(value = "numberTwo") String numberTwo) throws Exception{ 
		if(!isNumeric(numberOne) || !isNumeric(numberTwo)) { 
			throw new UnsupportedMathOperationException("Please set a numeric value!");
		}
		return convertToDouble(numberOne) + convertToDouble(numberTwo);
	}

	private Double convertToDouble(String strNumber) {
		if(strNumber == null) {
			return 0D;
			//R$ 10,25 or U$ 10.25
		}
		String number = strNumber.replaceAll(",", ".");
		if(isNumeric(number)) {
				return Double.parseDouble(number);
		}
		return null;
	}

	private boolean isNumeric(String strNumber) {
		if(strNumber == null) {
			return false;
		}
		String number = strNumber.replaceAll(",", ".");
		return number.matches("[-+]?[0-9]*\\.?[0-9]+");
	}
	
	@RequestMapping("/sub/{numberOne}/{numberTwo}")
	public Double subtraction(@PathVariable(value="numberOne") String numberOne,
						@PathVariable(value="numberTwo") String numberTwo) throws Exception{
		
		if(!isNumeric(numberOne) || !isNumeric(numberTwo)) { 
			throw new UnsupportedMathOperationException("Please set a numeric value!");
		}
		return convertToDouble(numberOne) - convertToDouble(numberTwo);
		
	}
	
	@RequestMapping("/mult/{numberOne}/{numberTwo}")
	public Double multiplication(@PathVariable(value="numberOne") String numberOne,
						@PathVariable(value="numberTwo") String numberTwo) throws Exception{
		
		if(!isNumeric(numberOne) || !isNumeric(numberTwo)) { 
			throw new UnsupportedMathOperationException("Please set a numeric value!");
		}
		return convertToDouble(numberOne) * convertToDouble(numberTwo);
		
	}
	
	@RequestMapping("/div/{numberOne}/{numberTwo}")
	public Double division(@PathVariable(value="numberOne") String numberOne,
						@PathVariable(value="numberTwo") String numberTwo) throws Exception{
		
		if(!isNumeric(numberOne) || !isNumeric(numberTwo)) { 
			throw new UnsupportedMathOperationException("Please set a numeric value!");
		}
		return convertToDouble(numberOne) / convertToDouble(numberTwo);
		
	}
	
	@RequestMapping("/squareroot/{number}")
	public Double squareRoot(@PathVariable(value="number") String number) throws Exception{
		
		if(!isNumeric(number)) { 
			throw new UnsupportedMathOperationException("Please set a numeric value!");
		}
		return Math.sqrt(convertToDouble(number));
		
	}
	
}
