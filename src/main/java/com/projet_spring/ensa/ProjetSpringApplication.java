package com.projet_spring.ensa;

import com.projet_spring.ensa.model.Client;
import com.projet_spring.ensa.model.Produit;
import com.projet_spring.ensa.model.Role;
import com.projet_spring.ensa.repository.*;
import com.projet_spring.ensa.service.ClientService;
import com.projet_spring.ensa.service.ProduitService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

@SpringBootApplication
@EnableJpaAuditing
public class ProjetSpringApplication {

    public static void main(String[] args) {
        ApplicationContext ctx =  SpringApplication.run(ProjetSpringApplication.class, args);
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        ProduitRepository produitRepository= ctx.getBean(ProduitRepository.class);
        ClientRepository clientRepository= ctx.getBean(ClientRepository.class);
        CommandRepository commandRepository= ctx.getBean(CommandRepository.class);
        PanierRepository panierRepository = ctx.getBean(PanierRepository.class);
        RoleRespository roleRespository = ctx.getBean(RoleRespository.class);
        ClientService clientService = ctx.getBean(ClientService.class);
        ProduitService produitService = ctx.getBean(ProduitService.class);
        Role role1 = new Role();
        Role role2 = new Role();
        role1.setRole("ADMIN");
        role2.setRole("USER");
        roleRespository.save(role1);
        roleRespository.save(role2);
        Client admin = new Client();
        Client user = new Client();
        admin.setNom("ouail");
        admin.setEmail("ouail@gmail.com");
        admin.setPassword("password"); // ******************* MOT DE PASSE EST password
        user.setEmail("ouailmjahed@gmail.com");
        user.setNom("mjahed");
        user.setPassword("password");
        clientService.saveClient(user);
        clientService.saveAdmin(admin);
        Produit produit1 = new Produit();
        produit1.setNom("produit1");
        produit1.setUrl("https://images-na.ssl-images-amazon.com/images/I/71RYhD1uzpL._SX569_.jpg");
        produit1.setDescription("ceci est une description");
        produit1.setPrix(100);
        Produit produit2 = new Produit();
        produit2.setNom("produit2");
        produit2.setUrl("https://store.storeimages.cdn-apple.com/4982/as-images.apple.com/is/image/AppleInc/aos/published/images/i/ph/iphone/xr/iphone-xr-white-select-201809?wid=940&hei=1112&fmt=png-alpha&qlt=80&.v=1551226036668");
        produit2.setDescription("ceci est une description");
        produit2.setPrix(200);
        produitService.save(produit2);
        produitService.save(produit1);
    }

}
