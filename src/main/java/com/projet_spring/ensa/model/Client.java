package com.projet_spring.ensa.model;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "clients")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private long id;

    private String email;
    private String nom;
    private boolean isAdmin;
    private String password;
    @Column(name = "active")
    private int active;

    @OneToOne
    @JoinColumn(name = "panier_id",referencedColumnName = "id")
    private Panier panier;

    @ManyToMany
    @JoinTable(name="user_role", joinColumns=@JoinColumn(name="user_id"), inverseJoinColumns=@JoinColumn(name="role_id"))
    private Set<Role> roles;

    @Embedded
    private Address address;

    public Client(String email, String nom, Address address) {
        this.email = email;
        this.nom = nom;
        this.address = address;
        this.isAdmin = false;
    }

    public Client() {
    }

    public Client(String email) {
        this.email = email;
    }

    public Client(String email, String nom, boolean isAdmin, String password) {
        this.email = email;
        this.nom = nom;
        this.isAdmin = isAdmin;
        this.password = password;
    }

    public Client(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public Panier getPanier() {
        return panier;
    }

    public void setPanier(Panier panier) {
        this.panier = panier;
    }

    public boolean isAdmin() {
        return isAdmin;
    }

    public void setAdmin(boolean admin) {
        isAdmin = admin;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getActive() {
        return active;
    }

    public void setActive(int active) {
        this.active = active;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }
}
