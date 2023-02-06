package com.example.tango.Tango.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.tango.Tango.model.Business;
import com.example.tango.Tango.model.Company;
import com.example.tango.Tango.model.Party;
import com.example.tango.Tango.model.repository.PartyRepository;

@Service
public class PartyService {

	@Autowired
	private PartyRepository partyRepository;
	
	public Party findParty(Long id) throws Exception {
		//test1();
		
		 return partyRepository.findById(id)
			        .orElseThrow(() -> new Exception("party with idnot found: "+id));
	}
	
	private void test1() {
		Map<String,Integer> marksMap = new HashMap<>();
		marksMap.put("A", 50);
		marksMap.put("B", 10);
		marksMap.put("C", 30);
		marksMap.put("D", 20);
		marksMap.put("E", 40);
		marksMap.put("F", 51);
		marksMap.put("G", 55);
		List<String> resp = marksMap.entrySet().stream()
		.sorted((i1, i2) -> i2.getValue().compareTo(i1.getValue()))
		.map(e -> e.getKey())
		.toList();
		
		Map<Integer, String> collect = resp.stream()
				.collect(Collectors.toMap(k -> marksMap.get(k), Function.identity()));
	}

	public Map<String, Business> getBusinessMap() {
		List<Company> companies = getCompanies();
		Map<String, Business> businessMap = Map.of();
		businessMap = companies.stream()
				.map(Company::getBusinesses).flatMap(List::stream)
				.collect(Collectors.toMap(Business::getName, Function.identity(), 
						(b1,b2) -> b1));
		return businessMap;
	}

	private List<Company> getCompanies() {
		List<Company> companies = new ArrayList<>();
		Business b1 = new Business("B1", "B1 desc");
		Business b2 = new Business("B2", "B2 desc");
		Business b3 = new Business("B3", "B3 desc");
		Business b4 = new Business("B4", "B4 desc");
		Business b5 = new Business("B5", "B5 desc");
		Business b6 = new Business("B2", "B6 desc");
		companies.add(new Company(List.of(b1,b2)));
		companies.add(new Company(List.of(b3,b4)));
		companies.add(new Company(List.of(b6,b5)));
		return companies;
	}
}
