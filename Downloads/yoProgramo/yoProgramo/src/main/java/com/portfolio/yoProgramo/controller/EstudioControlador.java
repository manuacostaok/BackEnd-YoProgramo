
package com.portfolio.yoProgramo.controller;

import com.portfolio.yoProgramo.entity.Estudio;
import com.portfolio.yoProgramo.service.EstudioService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
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
@RequestMapping("estudios")//localhost:8080/estudio
@CrossOrigin(origins="http://localhost:4200")//direccion del front de angular
public class EstudioControlador {
    
    @Autowired
    private EstudioService estudioServ;
    
    
    @GetMapping("/lista")
    @ResponseBody
    public List <Estudio> verEstudios(){
        return estudioServ.verEstudios();
    }
    
    @GetMapping("/ver/{id}")
    @ResponseBody
    public Estudio verEstudio(@PathVariable int id){
        return estudioServ.buscarEstudio(id);
    }
    
    @PostMapping("/crear")
    public String agregarEstudio(@RequestBody Estudio est){
        estudioServ.crearEstudio(est);
        return "El estudio fue creado correctamente!";
    }
    
    @DeleteMapping ("/borrar/{id}")
    public String eliminarEstudio(@PathVariable int id){
        estudioServ.borrarEstudio(id);
        return "El estudio fue borrado correctamente!";
    }
    
    @PutMapping("/editar")
    public String updateEstudio(@RequestBody Estudio est){
        estudioServ.editarEstudio(est);
        return "Los cambios fueron efectuados correctamente!";
    }
    
    
}
