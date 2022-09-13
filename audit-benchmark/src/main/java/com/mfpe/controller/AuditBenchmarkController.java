package com.mfpe.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mfpe.exception.FailedJwtValidation;
import com.mfpe.model.AuditBenchmark;
import com.mfpe.service.AuditBenchmarkService;
import com.mfpe.service.AuthorizationService;

@RestController
@RequestMapping("/benchmark")
@CrossOrigin(origins = "*")
public class AuditBenchmarkController {
	
	@Autowired
	private AuthorizationService authorizationService;
	
	@Autowired
	private AuditBenchmarkService auditBenchmarkService;
	
	Logger logger = LoggerFactory.getLogger("Benchmark-Controller-Logger");

	
	// Endpoint to retrieve the Audit Benchmark details
	@GetMapping("/AuditBenchmark")
	public ResponseEntity<List<AuditBenchmark>> getAuditBenchmark(@RequestHeader("Authorization") String jwt) throws FailedJwtValidation {
		List<AuditBenchmark> auditBenchmarks = new ArrayList<>();
		
		// checking if the jwt is valid or not
		logger.info("from header JWT :: " + jwt);
		if(jwt.length()>0 && authorizationService.validateJwt(jwt)) {			
			auditBenchmarks = auditBenchmarkService.getAuditBenchmarkList();
		}
		else {
			logger.error("Failed to validate the JWT :: " + jwt);
			throw new FailedJwtValidation();
		}
		return new ResponseEntity<List<AuditBenchmark>>(auditBenchmarks,HttpStatus.OK);
	}
	
	// Endpoint to check if the microservice is live
	@GetMapping("/health-check")
	public ResponseEntity<Map<String,String>> healthCheck() {
		Map<String, String> map = new HashMap<String,String>();
		map.put("message","Audit Benchmark Microservice is Active");
		return new ResponseEntity<Map<String,String>>(map,HttpStatus.OK);
	}
	
}
