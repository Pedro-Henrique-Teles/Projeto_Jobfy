package com.jobfy.controller;

import com.jobfy.models.entity.Colaborador;
import com.jobfy.service.ColaboradorService;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
@RestController
@RequestMapping("/api/colaborador")
public class ColaboradorController {
    private ColaboradorService colaboradorService;
    public ColaboradorController(ColaboradorService colaboradorService) {
        this.colaboradorService = colaboradorService;
    }



    @GetMapping()
    public ResponseEntity findAll() {
        return ResponseEntity.ok(colaboradorService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity findById(@PathVariable Integer id) {
        try {
            Colaborador colaborador = colaboradorService.findById(id);
            return ResponseEntity.ok(colaborador);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }


    @PostMapping()
    public ResponseEntity create(@RequestBody Colaborador colaborador) {
        try {
            Colaborador savedColaborador = colaboradorService.create(colaborador);
            return ResponseEntity.ok(savedColaborador);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }



    @PutMapping("{id}")
    public ResponseEntity edit(@PathVariable Integer id, @RequestBody Colaborador colaboradorAtualizado) {
        try {
            Optional<Colaborador> colaborador = Optional.ofNullable(colaboradorService.findById(id));
            if (!colaborador.isPresent()){
                return ResponseEntity.notFound().build();
            }
            BeanUtils.copyProperties(colaboradorAtualizado, colaborador.get(), "id");
            return ResponseEntity.ok(colaboradorService.save(colaborador.get()));
        }catch (Exception e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }




    @DeleteMapping("{id}")
    public ResponseEntity delete(@PathVariable("id")Integer id){
        try {
            return ResponseEntity.ok(colaboradorService.delete(id));
        }catch (Exception e){
            return new ResponseEntity(e.getMessage(),HttpStatus.NOT_FOUND);
        }
    }




    @GetMapping("/cont")
    public ResponseEntity getCont(){
        return ResponseEntity.ok(colaboradorService.cont());
    }
}


