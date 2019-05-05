package com.projet_spring.ensa.repository;


import com.projet_spring.ensa.model.Panier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("panierRepository")
public interface PanierRepository extends JpaRepository<Panier,Long> {

}
