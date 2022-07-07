package io.newvisionsoftware.consumesoap.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.newvisionsoftware.consumesoap.SoapClient;
import io.newvisionsoftware.consumesoap.stub.DetailsType;
import io.newvisionsoftware.consumesoap.stub.GetBankResponseType;
import io.newvisionsoftware.consumesoap.stub.GetBankType;
import io.newvisionsoftware.consumesoap.stub.ObjectFactory;

@RestController
@RequestMapping("/")
public class BlzController {

	@Autowired
	private SoapClient soapClient;
	
	@GetMapping
	public DetailsType sum(@RequestParam String code ) {
		ObjectFactory objectFactory = new ObjectFactory();
		GetBankType type = new GetBankType();
		type.setBlz(code);
		
		GetBankResponseType response = soapClient.getBank("http://www.thomas-bayer.com/axis2/services/BLZService",
				objectFactory.createGetBank(type));
		return response.getDetails();
	}
}
