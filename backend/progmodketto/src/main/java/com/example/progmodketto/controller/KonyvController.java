package com.example.progmodketto.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.progmodketto.business.Konyv;
import com.example.progmodketto.service.KonyvService;

@RestController
@RequestMapping("/konyv")
public class KonyvController {

    @Autowired
    private KonyvService konyvService;

    @PostMapping("/add")
    public String addKonyv(@RequestBody Konyv konyv) {

        konyvService.saveKonyv(konyv);
        return "Könyv hozzáadva";
    }


    @PutMapping("/lend")
    public Konyv lendKonyv(@RequestParam String id, @RequestParam String vendegId) {
        Integer IdInt = Integer.parseInt(id);
        Integer vendegIdInt = Integer.parseInt(vendegId);

        konyvService.lendKonyv(IdInt, vendegIdInt);
        Konyv konyvNew = konyvService.getKonyvById(IdInt);
        return konyvNew;
    }

    @PutMapping("/return")
    public Konyv returnKonyv(@RequestParam String id) {
        Integer IdInt = Integer.parseInt(id);

        konyvService.returnKonyv(IdInt);
        Konyv konyvNew = konyvService.getKonyvById(IdInt);
        return konyvNew;
    }

    @DeleteMapping("/delete")
    public String deleteKonyv(@RequestParam String id) {
        Integer IdInt = Integer.parseInt(id);

        konyvService.deleteKonyv(IdInt);
        return "Konyv törölve: " + id;
    }

    @PutMapping("/update")
    public Konyv updateKonyv(@RequestParam String id, @RequestBody Konyv konyv) {
        Integer IdInt = Integer.parseInt(id);

        konyvService.updateKonyv(IdInt, konyv);

        Konyv konyvNew = konyvService.getKonyvById(IdInt);
        return konyvNew;
    }

    @GetMapping("/getall")
    public Iterable<Konyv> getAllKonyv() {
        Iterable<Konyv> konyvek = konyvService.getAllKonyv();
        return konyvek;
    }

    @GetMapping("/get")
    public Konyv getKonyvById(@RequestParam String id) {
        Integer IdInt = Integer.parseInt(id);

        Konyv konyv = konyvService.getKonyvById(IdInt);
        return konyv;
    }

    @GetMapping("/lendedbyvendeg")
    public Iterable<Konyv> getLendedKonyvByVendegId(@RequestParam String id) {
        Integer IdInt = Integer.parseInt(id);

        Iterable<Konyv> konyvek = konyvService.getLendedKonyvByVendegId(IdInt);
        return konyvek;
    }

     
    
}
