package com.projet_spring.ensa.repository;

import com.projet_spring.ensa.model.Produit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("produitRepository")
public interface ProduitRepository extends JpaRepository<Produit,Long> {

}
