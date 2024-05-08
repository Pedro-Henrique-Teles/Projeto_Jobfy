    package com.jobfy.controller;

    import com.jobfy.models.entity.Colaborador;
    import com.jobfy.models.repository.ColaboradorRepository;
    import org.springframework.beans.factory.annotation.Autowired;
    import org.springframework.web.bind.annotation.GetMapping;
    import org.springframework.web.bind.annotation.RequestMapping;
    import org.springframework.web.bind.annotation.RestController;

    import java.util.List;

    @RestController
    @RequestMapping (path = "api/colaborador")
    public class ColaboradorController {

        private final ColaboradorRepository colaboradorRepository;

        @Autowired
        public ColaboradorController(ColaboradorRepository colaboradorRepository){
            this.colaboradorRepository = colaboradorRepository;
        }

        @GetMapping
        public List<Colaborador> getAll(){
            return colaboradorRepository.findAll();
        }
    }
    
