package com.projet_spring.ensa.repository;

import com.projet_spring.ensa.model.Command;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommandRepository extends JpaRepository<Command,Long> {

}
