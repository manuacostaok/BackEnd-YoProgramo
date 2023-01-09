
package com.portfolio.yoProgramo.service;

import com.portfolio.yoProgramo.entity.Habilidad;
import com.portfolio.yoProgramo.repository.HabilidadRepository;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional//persistencia en base de datos
public class HabilidadService {
    @Autowired
    public HabilidadRepository habServ;
    
    
    public List <Habilidad> verHabilidades(){
        List<Habilidad> listaHabilidad=habServ.findAll();
        return listaHabilidad;
    }
    
    public void crearHabilidad(Habilidad h){
        habServ.save(h);
    }
    
    public void borrarHabilidad(int id){
        habServ.deleteById(id);
    }
    
    public Habilidad buscarHabilidad(int id){
        Habilidad hab=habServ.findById(id).orElse(null);
        return hab;
    }
    
    public void editarHabilidad(Habilidad hab) {
       habServ.save(hab);
    }
}
