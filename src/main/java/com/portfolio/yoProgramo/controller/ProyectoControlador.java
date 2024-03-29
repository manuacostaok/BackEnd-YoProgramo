
package com.portfolio.yoProgramo.controller;

import com.portfolio.yoProgramo.entity.Proyecto;
import com.portfolio.yoProgramo.service.ProyectoService;
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
@RequestMapping("proyecto")//localhost:8080/proyilidad
@CrossOrigin(origins={"https://portfoliomanuacosta.web.app","http://localhost:4200"})//direccion del front de angular
public class ProyectoControlador {
    
    @Autowired
    ProyectoService sProyecto;
    
    @GetMapping ("/lista")
    public ResponseEntity<List<Proyecto>> lista(){
        List<Proyecto> list = sProyecto.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }
    
     
    @GetMapping("/detail/{id}")
    public ResponseEntity<Proyecto> detail(@PathVariable("id") int id){
        Proyecto proye = sProyecto.getOne(id);
        return new ResponseEntity(proye, HttpStatus.OK);
    }
    
    @PostMapping("/create")
    public void create(@RequestBody Proyecto proye) {
        sProyecto.save(proye);
    }
    
    
    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable ("id") int id){
        sProyecto.delete(id);
    }
    
    @PutMapping("/update")
    public void edit(@RequestBody Proyecto proye) {
        sProyecto.edit(proye);
    }
    
}
