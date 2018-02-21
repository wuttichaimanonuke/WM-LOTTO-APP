package com.example.demorestjdbc.controller;

import java.util.ArrayList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demorestjdbc.entity.ResultPlusTwoNumber;
import com.example.demorestjdbc.entity.ResultSumNumber;
import com.example.demorestjdbc.entity.TwoNumber;
import com.example.demorestjdbc.service.IMathBasicService;

@RestController
public class MathController {

	private static final Logger log = LoggerFactory.getLogger(MathController.class);
	
	@Autowired
	private IMathBasicService mathBasicService;
	
	@RequestMapping(value = "/api/math/plusTwoNumber", method = RequestMethod.POST)
	public ResponseEntity<?> PlusTwoNumber(@RequestBody TwoNumber twoNumber) {
		log.info("(POST) mapping to PlusTwoNumber : Begin.");
		log.info("@RequestBody : num1 = {}, num2 = {}",twoNumber.getNum1(),twoNumber.getNum2());
		ResultPlusTwoNumber result = new ResultPlusTwoNumber();
		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.add("HeaderResponse", "api/math/plusTwoNumber/num1 = "+twoNumber.getNum1()+", num2 = "+twoNumber.getNum2());
		if ( (twoNumber.getNum1().equals(null)) || (twoNumber.getNum1().equals("")) || !(twoNumber.getNum1() instanceof Double) 
			|| (twoNumber.getNum2().equals(null)) || (twoNumber.getNum2().equals("")) || !(twoNumber.getNum2() instanceof Double) ) {
			return new ResponseEntity<ResultPlusTwoNumber>(result, responseHeaders, HttpStatus.BAD_REQUEST);
		} else {
			result.setResult(mathBasicService.PlusTwoNumber(twoNumber.getNum1(), twoNumber.getNum2()));
			return new ResponseEntity<ResultPlusTwoNumber>(result, responseHeaders, HttpStatus.OK);
		}
	}
	
	@RequestMapping(value = "/api/math/sumNumber", method = RequestMethod.POST)
	public ResponseEntity<?> SumNumber(@RequestBody ArrayList<Double> listNumber) {
		log.info("(POST) mapping to SumNumber : Begin.");
		log.info("@RequestBody : listNumber = {}", listNumber);
		ResultSumNumber result = new ResultSumNumber();
		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.add("HeaderResponse", "api/math/sumNumber/");
		for (Double num : listNumber) {
			if ( (num.equals(null)) || (num.equals("")) ) {
				return new ResponseEntity<ResultSumNumber>(result, responseHeaders, HttpStatus.BAD_REQUEST);
			}
		}
		result.setResult(mathBasicService.SumNumber(listNumber));
		return new ResponseEntity<ResultSumNumber>(result, responseHeaders, HttpStatus.OK);
	}
}
