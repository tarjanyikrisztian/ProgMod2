package com.example.progmodketto.business;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface KonyvRepo extends JpaRepository<Konyv, Integer> {

    Iterable<Konyv> findAllByVendegId(Integer idInt);
    
}

