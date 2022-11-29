package com.example.progmodketto.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.progmodketto.business.Vendeg;
import com.example.progmodketto.business.VendegRepo;

@Service
public class VendegServiceImpl implements VendegService {

    @Autowired
    private VendegRepo vendegRepo;

    @Override
    public Vendeg saveVendeg(Vendeg vendeg) {
        return vendegRepo.save(vendeg);
    }

    @Override
    public Vendeg getVendegById(Integer id) {
        return vendegRepo.findById(id).get();
    }

    @Override
    public void deleteVendeg(Integer id) {
        vendegRepo.deleteById(id);
    }

    @Override
    public void updateVendeg(Integer id, Vendeg vendeg) {
        Vendeg vendegToUpdate = vendegRepo.findById(id).get();
        vendegToUpdate.setNev(vendeg.getNev());
        vendegToUpdate.setTelefonszam(vendeg.getTelefonszam());
        vendegRepo.save(vendegToUpdate);
    }

    @Override
    public Iterable<Vendeg> getAllVendeg() {
        return vendegRepo.findAll();
    }

    
    
}
