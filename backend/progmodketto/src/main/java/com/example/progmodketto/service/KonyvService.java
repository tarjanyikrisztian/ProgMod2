package com.example.progmodketto.service;

import com.example.progmodketto.business.Konyv;


public interface KonyvService {
    public Konyv saveKonyv(Konyv konyv);

    public Konyv getKonyvById(Integer id);

    public void lendKonyv(Integer id, Integer vendegId);

    public void returnKonyv(Integer id);

    public void deleteKonyv(Integer id);

    public void updateKonyv(Integer id, Konyv konyv);

    public Iterable<Konyv> getAllKonyv();

    public Iterable<Konyv> getLendedKonyvByVendegId(Integer idInt);
    


}
