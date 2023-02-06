package com.example.tango.Tango.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.tango.Tango.model.Party;

public interface PartyRepository extends JpaRepository<Party, Long> {

}
