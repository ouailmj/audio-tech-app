package com.projet_spring.ensa.model;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class ProduitPartenaireKey implements Serializable {

    @Column(name = "partenaire_id")
    private Long partenaireId;

    @Column(name = "produit_id")
    private Long produitId;

    public Long getPartenaireId() {
        return partenaireId;
    }

    public void setPartenaireId(Long partenaireId) {
        this.partenaireId = partenaireId;
    }

    public Long getProduitId() {
        return produitId;
    }

    public void setProduitId(Long produitId) {
        this.produitId = produitId;
    }
}
