
package com.portfolio.yoProgramo.controller;

import com.portfolio.yoProgramo.entity.Persona;
import com.portfolio.yoProgramo.service.ImpPersonaService;
import java.util.List;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@RestController
@RequestMapping("persona")//localhost:8080/experiencia
@CrossOrigin(origins ="http://localhost:4200")
public class PersonaControlador {
    @Autowired ImpPersonaService  IPersonaService;
    
    @GetMapping ("/lista")
    public ResponseEntity<List<Persona>> list(){
        List<Persona> list = IPersonaService.getPersona();
        return new ResponseEntity(list, HttpStatus.OK);
    }
    
    @GetMapping("/ver/{id}")
    public ResponseEntity<Persona> detail(@PathVariable("id") Long id){
        Persona perso = IPersonaService.findPersona(id);
        return new ResponseEntity(perso, HttpStatus.OK);
    }       
    
    
    @PostMapping("/crear")
    public void save(@RequestBody Persona persona){
        IPersonaService.savePersona(persona);
    }
    
   
    @DeleteMapping("/borrar/{id}")
    public void delete(@PathVariable Long id){
        IPersonaService.deletePersona(id);
    }
    
    @PutMapping("/editar")
    public void edit(@RequestBody Persona persona){
        IPersonaService.savePersona(persona);
    }
   
       
}
