package com.projet_spring.ensa.model;

import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Embeddable
public class Address {
    @NotNull
    @Size(max = 100)
    private String rue;

    @NotNull
    @Size(max = 100)
    private String ville;

    @NotNull
    @Size(max = 100)
    private String pays;

    @NotNull
    @Size(max = 6)
    private String zipCode;

    public Address(@NotNull @Size(max = 100) String rue, @NotNull @Size(max = 100) String ville, @NotNull @Size(max = 100) String pays, @NotNull @Size(max = 6) String zipCode) {
        this.rue = rue;
        this.ville = ville;
        this.pays = pays;
        this.zipCode = zipCode;
    }

    public Address() {
    }

    public String getRue() {
        return rue;
    }

    public void setRue(String rue) {
        this.rue = rue;
    }

    public String getVille() {
        return ville;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }

    public String getPays() {
        return pays;
    }

    public void setPays(String pays) {
        this.pays = pays;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }
}
