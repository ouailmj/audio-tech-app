package com.projet_spring.ensa.service;

import com.projet_spring.ensa.model.Client;

import java.util.List;

public interface ClientService {

    public Client findClientByEmail(String email);

    public void saveClient(Client client);

    List<Client> listAll();

}
