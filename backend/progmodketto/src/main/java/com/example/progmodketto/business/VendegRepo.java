package com.example.progmodketto.business;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VendegRepo extends JpaRepository<Vendeg, Integer> {

}
