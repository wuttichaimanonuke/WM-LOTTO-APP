package com.example.demorestjdbc.service;

import java.util.ArrayList;

import org.springframework.stereotype.Service;

@Service("mathBasic")
public class MathBasicService implements IMathBasicService {

	@Override
	public Double PlusTwoNumber(Double num1, Double num2) {
		Double result= num1+num2;
		return result;
	}

	@Override
	public Double SumNumber(ArrayList<Double> listNumber) {
		Double sum = (double) 0;
		for (Double num : listNumber) {
			sum += num;
		}
		return sum;
	}

}
