package com.example.progmodketto.service;

import com.example.progmodketto.business.Vendeg;

public interface VendegService {
    public Vendeg saveVendeg(Vendeg vendeg);

    public Vendeg getVendegById(Integer id);

    public void deleteVendeg(Integer id);

    public void updateVendeg(Integer id, Vendeg vendeg);

    public Iterable<Vendeg> getAllVendeg();

}
