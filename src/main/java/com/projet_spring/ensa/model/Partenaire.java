package com.projet_spring.ensa.model;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.Set;

@Entity
public class Partenaire extends Client {

    private String compte_bancaire;

    @OneToMany(mappedBy = "partenaire")
    Set<ProduitPartenaire> produitPartenaire;

    public Partenaire() {
    }

    public Partenaire(String email, String nom, Panier panier, Address address, String compte_bancaire) {
        super(email, nom, address);
        this.compte_bancaire = compte_bancaire;
    }

    public String getCompte_bancaire() {
        return compte_bancaire;
    }

    public void setCompte_bancaire(String compte_bancaire) {
        this.compte_bancaire = compte_bancaire;
    }

    public Set<ProduitPartenaire> getProduitPartenaire() {
        return produitPartenaire;
    }

    public void setProduitPartenaire(Set<ProduitPartenaire> produitPartenaire) {
        this.produitPartenaire = produitPartenaire;
    }
}
