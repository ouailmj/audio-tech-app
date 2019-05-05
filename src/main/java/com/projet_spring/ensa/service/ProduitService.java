package com.projet_spring.ensa.service;

import com.projet_spring.ensa.model.Client;
import com.projet_spring.ensa.model.Produit;
import com.projet_spring.ensa.repository.ProduitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProduitService {

    @Autowired
    private ProduitRepository produitRepository;

    public List<Produit> listAll() {
        return produitRepository.findAll();
    }

    public void save(Produit produit){
        produitRepository.save(produit);
    }

    public Produit get(Long id){
        return produitRepository.findById(id).get();
    }

    public void delete(Long id){
        produitRepository.deleteById(id);
    }

}
