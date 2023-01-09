
package com.portfolio.yoProgramo.controller;

import com.portfolio.yoProgramo.entity.Habilidad;
import com.portfolio.yoProgramo.service.HabilidadService;
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
@RequestMapping("habilidad")//localhost:8080/habilidad
@CrossOrigin(origins="http://localhost:4200")//direccion del front de angular
public class HabilidadControlador {
   
    @Autowired
    private HabilidadService habServ;
    
    @GetMapping("/lista")
    @ResponseBody
    public List <Habilidad> verHabilidades(){
        return habServ.verHabilidades();
    }
    
    @GetMapping("/ver/{id}")
    @ResponseBody
    public Habilidad verHabilidad(@PathVariable int id){
        return habServ.buscarHabilidad(id);
    }
    
    @PostMapping("/crear")
    public String agregarHabilidad(@RequestBody Habilidad hab){
        habServ.crearHabilidad(hab);
        return "La habilidad fue creada correctamente!";
    }
    
    @DeleteMapping ("/borrar/{id}")
    public String eliminarHabilidad(@PathVariable int id){
            habServ.borrarHabilidad(id);
        return "La habilidad fue borrada correctamente!";
    }
    
    @PutMapping("/editar")
    public String updateHabilidad(@RequestBody Habilidad hab){
        habServ.editarHabilidad(hab);
        return "Los cambios fueron efectuados correctamente!";
    }

    


}
