package com.realestate.repositories;

import com.realestate.entities.ClientReg;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRegRepository extends JpaRepository<ClientReg,Long> {
}
