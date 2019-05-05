package com.projet_spring.ensa.model;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "paniers")
public class Panier {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private long id;

    @Temporal(TemporalType.TIMESTAMP)
    private Date date;

    @OneToOne(mappedBy = "panier")
    private Client client;

    @OneToMany(mappedBy = "panier", cascade = CascadeType.ALL,orphanRemoval = true)
    Set<PanierItem> produitpanier;

    public Panier() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Set<PanierItem> getProduitpanier() {
        return produitpanier;
    }

    public void setProduitpanier(Set<PanierItem> produitpanier) {
        this.produitpanier = produitpanier;
    }
}
