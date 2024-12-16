package com.projeto.projeto.Controller;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.projeto.projeto.Service.CategoriaService;
import com.projeto.projeto.model.Categoria;
import com.projeto.projeto.model.MensagemDTO;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;




@RestController
@RequestMapping(value = "/categoria")
public class CategoriaController {

    @Autowired
    CategoriaService categoriaService;

    @GetMapping
    public ResponseEntity<List<Categoria>> findAll() {
        return ResponseEntity.ok().body(categoriaService.findAll());
    }
    
    @GetMapping("/{pIdCategoria}")
    public ResponseEntity<Categoria> findById(@PathVariable Integer pIdCategoria) {
        return ResponseEntity.ok().body(categoriaService.findById(pIdCategoria));
    }

    @PostMapping
    public ResponseEntity<Categoria> insCategoria(@RequestBody Categoria pCategoria) {
        Categoria vNovCategoria = categoriaService.insCategoria(pCategoria);
        
        URI vURI = ServletUriComponentsBuilder.fromCurrentRequest().path("/categoria/{pIdCategoria}").buildAndExpand(vNovCategoria.getIdCategoria()).toUri();
        return ResponseEntity.created(vURI).body(vNovCategoria);
    }

    @PutMapping("{pIdCategoria}")
    public ResponseEntity<Categoria> updCategoria(@PathVariable Integer pIdCategoria, @RequestBody Categoria pCategoria) {
        Categoria vCategoria = categoriaService.updCategoria(pIdCategoria, pCategoria);

        return ResponseEntity.ok().body(vCategoria);
    }
    
    @DeleteMapping(value = "/{pIdCategoria}")
    public ResponseEntity<MensagemDTO> delCategoria(@PathVariable Integer pIdCategoria){
        return categoriaService.delCategoria(pIdCategoria);
    }
    
}