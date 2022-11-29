package com.example.progmodketto.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.progmodketto.business.Konyv;
import com.example.progmodketto.business.KonyvRepo;
import com.example.progmodketto.business.Vendeg;
import com.example.progmodketto.business.VendegRepo;

@Service
public class KonyvServiceImpl implements KonyvService {

    @Autowired
    private KonyvRepo konyvRepo;

    @Autowired
    private VendegRepo vendegRepo;

    @Override
    public Konyv saveKonyv(Konyv konyv) {
        return konyvRepo.save(konyv);
    }

    @Override
    public Konyv getKonyvById(Integer id) {
        return konyvRepo.findById(id).get();
    }

    @Override
    public void lendKonyv(Integer id, Integer vendegId) {
        Konyv konyv = konyvRepo.findById(id).get();
        Vendeg vendeg = vendegRepo.findById(vendegId).get();
        //if konyv is not available, send error message
        if (konyv.getVendeg() != null) {
            throw new RuntimeException("Konyv is not available");
        }
        else {
            konyv.setVendeg(vendeg);
            konyvRepo.save(konyv);
        }
    }

    @Override
    public void returnKonyv(Integer id) {
        Konyv konyv = konyvRepo.findById(id).get();
        if (konyv.getVendeg() == null) {
            throw new RuntimeException("Konyv is not lent");
        }
        else {
            konyv.setVendeg(null);
            konyvRepo.save(konyv);
        }
    }

    @Override
    public void deleteKonyv(Integer id) {
        konyvRepo.deleteById(id);
    }

    @Override
    public void updateKonyv(Integer id, Konyv konyv) {
        Konyv konyvToUpdate = konyvRepo.findById(id).get();
        konyvToUpdate.setCim(konyv.getCim());
        konyvToUpdate.setSzerzo(konyv.getSzerzo());
        konyvToUpdate.setKiadasEve(konyv.getKiadasEve());
        konyvToUpdate.setVendeg(konyv.getVendeg());
        konyvRepo.save(konyvToUpdate);
    }
    
    @Override
    public Iterable<Konyv> getAllKonyv() {
        return konyvRepo.findAll();
    }

    @Override
    public Iterable<Konyv> getLendedKonyvByVendegId(Integer idInt) {
        //find all books where vendeg is idInt  
        return konyvRepo.findAllByVendegId(idInt);
    }
}
