package com.projet_spring.ensa.service;

import com.projet_spring.ensa.model.Client;
import com.projet_spring.ensa.model.Panier;
import com.projet_spring.ensa.model.PanierItem;
import com.projet_spring.ensa.model.Produit;
import com.projet_spring.ensa.repository.PanierRepository;
import com.projet_spring.ensa.repository.ProduitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PanierService {
    @Autowired
    private PanierRepository panierRepository;

    @Autowired
    private ProduitService produitService;

    @Autowired
    private ClientService clientService;

    @Autowired
    private ProduitRepository produitRepository;


    public List<Panier> listAll(){
        return panierRepository.findAll();
    }

}
