package com.appmobile.Controller.Api;

import com.appmobile.Dto.ProduitDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.appmobile.Util.Constants.APP_ROOT;

@RequestMapping(APP_ROOT+"/api/Produits")
public interface ProduitApi {
    @PostMapping("/creer")
    ResponseEntity<ProduitDto> save(@RequestBody ProduitDto produitDto);
    @GetMapping("/nom/{nom}")
    ResponseEntity<List<ProduitDto>> getProduitsByNom(@PathVariable String nom);
    @GetMapping("/categorie/{categorie}")
    ResponseEntity<List<ProduitDto>> getProduitsByCategorie(@PathVariable String categorie);
    @GetMapping("/All")
    public ResponseEntity<List<ProduitDto>> getAllProduits();
    @GetMapping("/status/{statu}")
    ResponseEntity<List<ProduitDto>> getProduitsByStatus(@PathVariable String statu);
}
