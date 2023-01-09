
package com.portfolio.yoProgramo.service;

import com.portfolio.yoProgramo.entity.Experiencia;
import com.portfolio.yoProgramo.repository.ExperienciaRepository;
import java.util.List;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional//persistencia en base de datos
public class ExperienciaService {
    
    @Autowired
    ExperienciaRepository expServ;
    
    
    public List <Experiencia> verExperiencias(){
        List<Experiencia> listaExperiencia=expServ.findAll();
        return listaExperiencia;
    }
    
    public void crearExperiencia(Experiencia p){
        expServ.save(p);
    }
    
    public void borrarExperiencia(int id){
        expServ.deleteById(id);
    }
    
    public Experiencia buscarExperiencia(int id){
        Experiencia exp=expServ.findById(id).orElse(null);
        return exp;
    }
    
    public void editarExperiencia(Experiencia exp) {
       expServ.save(exp);
    }
}
