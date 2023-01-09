
package com.portfolio.yoProgramo.controller;

import com.portfolio.yoProgramo.entity.Experiencia;
import com.portfolio.yoProgramo.service.ExperienciaService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("experiencia")//localhost:8080/experiencia
@CrossOrigin(origins="http://localhost:4200")//direccion del front de angular
public class ExperienciaControlador {
   
    @Autowired
    ExperienciaService expServ;
    
    @GetMapping("/lista")
    @ResponseBody
    public ResponseEntity<List<Experiencia>> lista(){
        List<Experiencia> lista=expServ.verExperiencias();
        return new ResponseEntity(lista, HttpStatus.OK);
    }
    
    @GetMapping("/ver/{id}")
    @ResponseBody
    public ResponseEntity <Experiencia> getById(@PathVariable("id") int id){
        Experiencia expe =expServ.buscarExperiencia(id);
        return new ResponseEntity(expe,HttpStatus.OK);
    }
    
    @PostMapping("/crear")
    @ResponseBody
    public String crearExperiencia(@RequestBody Experiencia exp){
        expServ.crearExperiencia(exp);
        return "La experiencia fue creada correctamente!";
    }
    
    @DeleteMapping ("/borrar/{id}")
    public String eliminarExperiencia(@PathVariable int id){
            expServ.borrarExperiencia(id);
        return "La experiencia fue borrada correctamente!";
    }
    
    @PutMapping("/editar")
    public String updateExperiencia(@RequestBody Experiencia exp){
        expServ.editarExperiencia(exp);
        return "La edicion fue efectuada correctamente!";
    }
    
    @PutMapping("/editar/{id}")
    public String editarExperiencia(@PathVariable ("id") int id, Experiencia exp){
        expServ.editarExperiencia(exp);
        return "La actualizacion por ID fue efectuada correctamente!";   }

    
}
