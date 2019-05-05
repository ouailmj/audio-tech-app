package com.projet_spring.ensa.model;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class PanierItemKey implements Serializable {
    @Column(name = "panier_id")
    private Long panierId;

    @Column(name = "produit_id")
    private Long produitId;

    public Long getPanierId() {
        return panierId;
    }

    public void setPanierId(Long panierId) {
        this.panierId = panierId;
    }

    public Long getProduitId() {
        return produitId;
    }

    public void setProduitId(Long produitId) {
        this.produitId = produitId;
    }
}
