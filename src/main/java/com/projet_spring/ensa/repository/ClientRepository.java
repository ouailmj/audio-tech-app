package com.projet_spring.ensa.repository;

import com.projet_spring.ensa.model.Client;
import com.projet_spring.ensa.model.Panier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("clientRepository")
public interface ClientRepository  extends JpaRepository<Client,Long> {

    Client findByEmail(String email);


}
