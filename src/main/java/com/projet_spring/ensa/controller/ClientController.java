package com.projet_spring.ensa.controller;

import com.projet_spring.ensa.model.*;
import com.projet_spring.ensa.repository.ClientRepository;
import com.projet_spring.ensa.repository.PanierRepository;
import com.projet_spring.ensa.service.ClientService;
import com.projet_spring.ensa.service.CommandService;
import com.projet_spring.ensa.service.PanierService;
import com.projet_spring.ensa.service.ProduitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

@Controller
public class ClientController {

    @Autowired
    private ClientService clientService;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    ClientRepository clientRepository;

    @Autowired
    CommandService commandService;

    @Autowired
    private ProduitService produitService;

    @Autowired
    private PanierService panierService;

    @RequestMapping(value = {"/login"},method = GET)
    public ModelAndView login(){
        ModelAndView model = new ModelAndView();
        model.setViewName("auth/login");
        return model;
    }

    @RequestMapping(value = {"/signup"},method = GET)
    public ModelAndView signup(){
        ModelAndView model = new ModelAndView();
        Client client = new Client();
        model.addObject("client",client);
        model.setViewName("auth/signup");
        return model;
    }

    @RequestMapping(value = {"/signup"},method = RequestMethod.POST)
    public ModelAndView createClient(@Valid Client client, BindingResult bindingResult){
        ModelAndView model = new ModelAndView();
        Client clientExist = clientService.findClientByEmail(client.getEmail());
        if(clientExist != null) {
            bindingResult.rejectValue("email","error.auth","Email exist deja!!");
        }
        if(bindingResult.hasErrors()) {
            model.setViewName("auth/signup");
        }else {
            clientService.saveClient(client);
            model.addObject("msg","client a ete creer avec succes");
            model.addObject("client",new Client());
            model.setViewName("auth/login");
        }
        return model;
    }

    @RequestMapping(value = {"/home"},method= GET)
    public ModelAndView home() {
        List<Produit> list = produitService.listAll();

        ModelAndView model = new ModelAndView();
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        Client client = clientService.findClientByEmail(auth.getName());

        model.addObject("clientName",client.getNom());
        model.addObject("produits",list);
        model.setViewName("home/home");
        return model;
    }

    @RequestMapping(value = "/home/detail/{id}", method = GET)
    public ModelAndView detail(@PathVariable("id") long id) {
        ModelAndView model = new ModelAndView();
        Produit produit = produitService.get((long) id);
        model.addObject("produit",produit);
        model.setViewName("home/detail");
        return model;
    }

    @RequestMapping(value = "/add/panier/{id}", method = GET)
    public ModelAndView add(@PathVariable("id") long id) {
        ModelAndView model = new ModelAndView();
        Produit produit;
        produit = produitService.get((long) id);
        panierService.save(id,produit);
        model.addObject("produit",produit);
        model.setViewName("home/detail");
        return model;
    }


    @RequestMapping(value = "/admin/delete/{id}", method = GET)
    public String delete(@PathVariable("id") long id) {
        produitService.delete(id);
        return "redirect:/admin";
    }


    @RequestMapping(value = "/panier",method = GET)
    public ModelAndView panier(){
        ModelAndView model = new ModelAndView();
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String currentUserName = authentication.getName();
        Client client = clientService.findClientByEmail(currentUserName);
        Set<PanierItem> produitpanier = client.getPanier().getProduitpanier();
        List<Produit> produits = new ArrayList<>();
        double i = 0;
        for (PanierItem s : produitpanier){
            produits.add(s.getProduit());
            i += s.getQte()*s.getProduit().getPrix();
        }
        model.addObject("produits",produits);
        model.addObject("produitsPanier",produitpanier);
        model.addObject("client",client);
        model.addObject("panier",client.getPanier());
        model.addObject("total",i);
        model.setViewName("home/panier");
        return model;
    }

    @RequestMapping(value = "/panier",method = POST)
    public ModelAndView getCommande(@RequestParam("total") String total){
        ModelAndView model = new ModelAndView();
        model.addObject("total",total);
        model.setViewName("home/commande");
        return model;
    }

    @RequestMapping(value = {"/access_denied"},method= GET)
    public ModelAndView accessDenied() {
        ModelAndView model = new ModelAndView();
        model.setViewName("errors/access_denied");
        return model;
    }


    @RequestMapping(value = {"/home/profile"},method = GET)
    public ModelAndView profile(){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String currentUserName = authentication.getName();
        Client client = clientService.findClientByEmail(currentUserName);
        ModelAndView model = new ModelAndView();
        Client form = new Client();
        model.addObject("client",client);
        model.setViewName("home/profile");
        return model;
    }

    @RequestMapping(value = {"/admin"},method = GET)
    public ModelAndView admin(){
        List<Produit> list = produitService.listAll();

        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        Client client = clientService.findClientByEmail(auth.getName());
        ModelAndView model = new ModelAndView();
        model.addObject("clientName",client.getNom());
        model.addObject("allClient",clientService.listAll().size());
        model.addObject("allProducts",list.size());
        model.addObject("allCommands",commandService.listAll().size());
        model.addObject("produits",list);
        Produit form = new Produit() ;
        model.addObject("form",form);
        model.setViewName("admin/home");
        return model;
    }

    @RequestMapping(value = "/profile/submit" , method = POST)
    public String editProfile(Client client){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String currentUserName = authentication.getName();
        Client update = clientService.findClientByEmail(currentUserName);
        Address address = new Address();
        address.setPays(client.getAddress().getPays());
        address.setVille(client.getAddress().getVille());
        address.setRue(client.getAddress().getRue());
        address.setZipCode(client.getAddress().getZipCode());
        update.setAddress(address);
        update.setNom(client.getNom());
        clientRepository.save(update);
        return "redirect:/home/profile";

    }

    @RequestMapping(value = "/produit/submit" , method = POST)
    public String editProfile(Produit form){
        Produit produit = new Produit();
        produit.setNom(form.getNom());
        produit.setUrl(form.getUrl());
        produit.setDescription(form.getDescription());
        produit.setPrix(form.getPrix());
        produitService.save(produit);
        return "redirect:/admin";
    }


}
