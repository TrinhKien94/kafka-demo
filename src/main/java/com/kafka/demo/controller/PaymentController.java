package com.kafka.demo.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.kafka.demo.dto.PaymentDTO;
import com.kafka.demo.service.PaymentService;

@RestController
public class PaymentController {
	@Autowired
	private PaymentService paymentService;
	private static final Logger logger = LogManager.getLogger(PaymentController.class);
	@RequestMapping(value = "/payments", method = RequestMethod.PATCH, consumes=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Void> changePaymentStatus(@RequestBody PaymentDTO paymentDTO) {
		logger.info("changePaymentStatus");
		paymentService.changePaymentStatus(paymentDTO);
		return ResponseEntity.ok().build();
	}

}