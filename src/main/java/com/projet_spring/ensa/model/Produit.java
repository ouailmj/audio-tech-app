package com.projet_spring.ensa.model;

import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Set;

@Entity
public class Produit {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "produit_id")
    private long id;

    @NotNull
    @Size(max = 100)
    private String nom;

    @Lob
    @Column(name="url", length=1024)
    private String url;

    @NotNull
    @Size(max = 255)
    private String description;

    @NotNull
    private double prix;

    @OneToMany(mappedBy = "produit")
    Set<PanierItem> produitpanier;

    @OneToMany(mappedBy = "produit")
    Set<ProduitPartenaire> produitPartenaire;

    @OneToMany(mappedBy = "produit")
    Set<CommandItem> commandItem;

    public Produit(@NotNull @Size(max = 100) String nom, @NotNull @Size(max = 255) String description, @NotNull double prix) {
        this.nom = nom;
        this.description = description;
        this.prix = prix;
    }

    public Produit(@NotNull @Size(max = 100) String nom, @NotNull @Size(max = 255) String description, @NotNull double prix, Set<PanierItem> produitpanier, Set<ProduitPartenaire> produitPartenaire, Set<CommandItem> commandItem) {
        this.nom = nom;
        this.description = description;
        this.prix = prix;
        this.produitpanier = produitpanier;
        this.produitPartenaire = produitPartenaire;
        this.commandItem = commandItem;
    }

    public Produit() {
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrix() {
        return prix;
    }

    public void setPrix(double prix) {
        this.prix = prix;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Set<PanierItem> getProduitpanier() {
        return produitpanier;
    }

    public void setProduitpanier(Set<PanierItem> produitpanier) {
        this.produitpanier = produitpanier;
    }

    public Set<ProduitPartenaire> getProduitPartenaire() {
        return produitPartenaire;
    }

    public void setProduitPartenaire(Set<ProduitPartenaire> produitPartenaire) {
        this.produitPartenaire = produitPartenaire;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Set<CommandItem> getCommandItem() {
        return commandItem;
    }

    public void setCommandItem(Set<CommandItem> commandItem) {
        this.commandItem = commandItem;
    }
}
