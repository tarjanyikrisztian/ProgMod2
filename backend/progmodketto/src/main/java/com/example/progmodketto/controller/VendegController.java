package com.example.progmodketto.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.progmodketto.business.Vendeg;
import com.example.progmodketto.service.VendegService;

@RestController
@RequestMapping("/vendeg")
public class VendegController {

    @Autowired
    private VendegService vendegService;

    @PostMapping("/add")
    public String addVendeg(@RequestBody Vendeg vendeg) {
        vendegService.saveVendeg(vendeg);
        
        return vendeg.getNev();
    }

    @PutMapping("/update")
    public Vendeg updateVendeg(@RequestParam String id, @RequestBody Vendeg vendeg) {
        Integer IdInt = Integer.parseInt(id);
        vendegService.updateVendeg(IdInt, vendeg);
        Vendeg vendegNew = vendegService.getVendegById(IdInt);
        return vendegNew;
    }

    @PutMapping("/delete")
    public String deleteVendeg(@RequestParam String id) {
        Integer IdInt = Integer.parseInt(id);
        vendegService.deleteVendeg(IdInt);
        return "Vendég törölve: " + id;
    }

    @GetMapping("/get")
    public Vendeg getVendeg(@RequestParam String id) {
        Integer IdInt = Integer.parseInt(id);
        Vendeg vendeg = vendegService.getVendegById(IdInt);
        return vendeg;
    }

    @GetMapping("/getall")
    public Iterable<Vendeg> getAllVendeg() {
        Iterable<Vendeg> vendegek = vendegService.getAllVendeg();
        return vendegek;
    }
    
}
