package br.com.ajxtech.controllers;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.ajxtech.converters.NumberConverter;
import br.com.ajxtech.exceptions.UnsupportedMathOperationException;
import br.com.ajxtech.math.SimpleMath;

@RestController
public class MathController {
	
	private final AtomicLong counter = new AtomicLong();
	
	private SimpleMath math = new SimpleMath();
	
	@RequestMapping("/sum/{numberOne}/{numberTwo}")
	public Double sum(@PathVariable(value = "numberOne") String numberOne, 
					  @PathVariable(value = "numberTwo") String numberTwo) throws Exception{ 
		if(!NumberConverter.isNumeric(numberOne) || !NumberConverter.isNumeric(numberTwo)) { 
			throw new UnsupportedMathOperationException("Please set a numeric value!");
		}
		return math.sum(NumberConverter.convertToDouble(numberOne), NumberConverter.convertToDouble(numberTwo));
	}
	
	@RequestMapping("/sub/{numberOne}/{numberTwo}")
	public Double subtraction(@PathVariable(value="numberOne") String numberOne,
						@PathVariable(value="numberTwo") String numberTwo) throws Exception{
		
		if(!NumberConverter.isNumeric(numberOne) || !NumberConverter.isNumeric(numberTwo)) { 
			throw new UnsupportedMathOperationException("Please set a numeric value!");
		}
		return math.subtraction(NumberConverter.convertToDouble(numberOne), NumberConverter.convertToDouble(numberTwo));
		
	}
	
	@RequestMapping("/mult/{numberOne}/{numberTwo}")
	public Double multiplication(@PathVariable(value="numberOne") String numberOne,
						@PathVariable(value="numberTwo") String numberTwo) throws Exception{
		
		if(!NumberConverter.isNumeric(numberOne) || !NumberConverter.isNumeric(numberTwo)) { 
			throw new UnsupportedMathOperationException("Please set a numeric value!");
		}
		return math.multiplication(NumberConverter.convertToDouble(numberOne), NumberConverter.convertToDouble(numberTwo));
		
	}
	
	@RequestMapping("/div/{numberOne}/{numberTwo}")
	public Double division(@PathVariable(value="numberOne") String numberOne,
						@PathVariable(value="numberTwo") String numberTwo) throws Exception{
		
		if(!NumberConverter.isNumeric(numberOne) || !NumberConverter.isNumeric(numberTwo)) { 
			throw new UnsupportedMathOperationException("Please set a numeric value!");
		}
		return math.division(NumberConverter.convertToDouble(numberOne), NumberConverter.convertToDouble(numberTwo));
		
	}
	
	@RequestMapping("/squareroot/{number}")
	public Double squareRoot(@PathVariable(value="number") String number) throws Exception{
		
		if(!NumberConverter.isNumeric(number)) { 
			throw new UnsupportedMathOperationException("Please set a numeric value!");
		}
		return math.squareRoot(NumberConverter.convertToDouble(number));
		
	}
	
}
