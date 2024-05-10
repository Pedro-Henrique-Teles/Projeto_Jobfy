package com.jobfy.controller;

import com.jobfy.models.entity.Colaborador;
import com.jobfy.service.ColaboradorService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/colaborador")
public class ColaboradorController {
    private ColaboradorService colaboradorService;

    public ColaboradorController(ColaboradorService colaboradorService){
        this.colaboradorService = colaboradorService;
    }
    @GetMapping()
    public ResponseEntity findAll(){
        return ResponseEntity.ok(colaboradorService.findAll());
    }
    @GetMapping("{id}")
    public ResponseEntity findById(@PathVariable("id")Integer id){
        try {
            return ResponseEntity.ok(colaboradorService.findById(id));
        }catch (Exception e){
            return new ResponseEntity(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }
    @PostMapping()
    public ResponseEntity save(@RequestBody Colaborador colaborador){
        try{
            Colaborador savedColaborador = colaboradorService.save(colaborador);
            return ResponseEntity.ok(savedColaborador);
        }catch (Exception e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
