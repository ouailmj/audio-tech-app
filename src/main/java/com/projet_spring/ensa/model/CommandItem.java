package com.projet_spring.ensa.model;

import javax.persistence.*;

@Entity
public class CommandItem {

    @EmbeddedId
    CommandItemKey id;

    @ManyToOne
    @MapsId("produit_id")
    @JoinColumn(name = "produit_id")
    Produit produit;

    @ManyToOne
    @MapsId("command_id")
    @JoinColumn(name = "command_id")
    Command command;

    private int qte;

}
