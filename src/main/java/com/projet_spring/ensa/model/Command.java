package com.projet_spring.ensa.model;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Command {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "command_id")
    private long id;

    @OneToMany(mappedBy = "command")
    Set<CommandItem> commandItem;

}
