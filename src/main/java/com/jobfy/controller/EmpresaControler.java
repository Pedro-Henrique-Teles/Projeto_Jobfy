package com.jobfy.controller;

import com.jobfy.models.entity.Empresa;
import com.jobfy.service.EmpresaService;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/empresa")
public class EmpresaControler {
    private EmpresaService empresaService;
    public EmpresaControler(EmpresaService empresaService){
        this.empresaService = empresaService;
    }



    @GetMapping()
    public ResponseEntity findAll() {
        return ResponseEntity.ok(empresaService.findAll());
    }

    @GetMapping("{id}")
    public ResponseEntity findById(@PathVariable Integer id) {
        try {
            Empresa empresa = empresaService.findById(id);
            return ResponseEntity.ok(empresa);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PostMapping()
    public ResponseEntity save(@RequestBody Empresa empresa) {
        try {
            Empresa savedEmpresa = empresaService.save(empresa);
            return ResponseEntity.ok(savedEmpresa);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }


    @PutMapping("{id}")
    public ResponseEntity edit(@PathVariable Integer id, @RequestBody Empresa empresaAtualizada) {
        try {
            Optional<Empresa> empresa = Optional.ofNullable(empresaService.findById(id));
            if (!empresa.isPresent()){
                return ResponseEntity.notFound().build();
            }
            BeanUtils.copyProperties(empresaAtualizada, empresa.get(), "id");
            return ResponseEntity.ok(empresaService.save(empresa.get()));
        }catch (Exception e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }






    @DeleteMapping("{id}")
    public ResponseEntity delete(@PathVariable("id")Integer id){
        try {
            return ResponseEntity.ok(empresaService.delete(id));
        }catch (Exception e) {
            return new ResponseEntity(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }


    @GetMapping("/cont")
    public ResponseEntity getCont(){
        return ResponseEntity.ok(empresaService.cont());
    }



}
