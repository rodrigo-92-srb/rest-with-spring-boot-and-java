package br.com.ajxtech.math;

import org.springframework.web.bind.annotation.RequestMapping;

public class SimpleMath {

	@RequestMapping("/sum/{numberOne}/{numberTwo}")
	public Double sum(Double numberOne, Double numberTwo) { 
		
		return numberOne + numberTwo;
	}
	
	@RequestMapping("/sub/{numberOne}/{numberTwo}")
	public Double subtraction(Double numberOne, Double numberTwo) {
		
		
		return numberOne - numberTwo;
		
	}
	
	@RequestMapping("/mult/{numberOne}/{numberTwo}")
	public Double multiplication(Double numberOne, Double numberTwo) {
		
		
		return numberOne * numberTwo;
		
	}
	
	@RequestMapping("/div/{numberOne}/{numberTwo}")
	public Double division(Double numberOne, Double numberTwo) {
		
		return numberOne / numberTwo;
	}
	
	@RequestMapping("/squareroot/{number}")
	public Double squareRoot(Double number) {
		
		
		return Math.sqrt(number);
		
	}
}
