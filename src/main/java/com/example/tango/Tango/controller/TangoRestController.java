package com.example.tango.Tango.controller;

import java.time.LocalDateTime;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.example.tango.Tango.model.Business;
import com.example.tango.Tango.model.Party;
import com.example.tango.Tango.service.MyThread;
import com.example.tango.Tango.service.PartyService;

@RestController
public class TangoRestController {

	@Autowired
	private PartyService partyService;
	
    @GetMapping("/tango")
    public String homePage() {
        return "Time on the tango server is "+ LocalDateTime.now();
    }
    
    @GetMapping("/tango2/party/{id}")
    ResponseEntity<Party> findParty(@PathVariable Long id) throws Exception {
    	Party p = partyService.findParty(id);
    	return ResponseEntity.ok(p);
    }
    
    @GetMapping("/tango/business/map")
    Map<String,Business> getBusinessMap() {
  
    	return partyService.getBusinessMap();
    }
}
