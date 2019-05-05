package com.projet_spring.ensa.service;

import com.projet_spring.ensa.model.Client;
import com.projet_spring.ensa.model.Panier;
import com.projet_spring.ensa.model.Role;
import com.projet_spring.ensa.repository.ClientRepository;
import com.projet_spring.ensa.repository.PanierRepository;
import com.projet_spring.ensa.repository.RoleRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Date;
import java.util.HashSet;
import java.util.List;


@Service("clientService")
public class ClientServiceImpl implements ClientService {

    @Qualifier("clientRepository")
    @Autowired
    private ClientRepository clientRepository;

    @Autowired
    private RoleRespository roleRespository;

    @Autowired
    private PanierRepository panierRepository;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public Client findClientByEmail(String email) {
        return clientRepository.findByEmail(email) ;
    }

    @Override
    public void saveClient(Client client) {
        client.setPassword(bCryptPasswordEncoder.encode(client.getPassword()));
        client.setActive(1);
        Role userRole = roleRespository.findByRole("USER");
        client.setRoles(new HashSet<Role>(Arrays.asList(userRole)));
        client.setAdmin(false);
        Panier panier = new Panier();
        panier.setDate(new Date());
        client.setPanier(panier);
        panierRepository.save(panier);
        clientRepository.save(client);
    }

    @Override
    public List<Client> listAll() {
        return clientRepository.findAll();
    }


}
