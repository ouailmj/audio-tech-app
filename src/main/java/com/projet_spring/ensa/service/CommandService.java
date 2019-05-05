package com.projet_spring.ensa.service;

import com.projet_spring.ensa.model.Client;
import com.projet_spring.ensa.model.Command;
import com.projet_spring.ensa.model.CommandItem;
import com.projet_spring.ensa.model.Produit;
import com.projet_spring.ensa.repository.CommandRepository;
import com.projet_spring.ensa.repository.ProduitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommandService {

    @Autowired
    private ProduitRepository produitRepository;

    @Autowired
    private CommandRepository commandRepository;

    @Autowired
    private ClientService clientService;


    public void save(){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String currentUserName = authentication.getName();
        Client client = clientService.findClientByEmail(currentUserName);

        Command command = new Command();

        CommandItem commandItem = new CommandItem();

    }

    public List<Command> listAll() {
        return commandRepository.findAll();
    }



}
