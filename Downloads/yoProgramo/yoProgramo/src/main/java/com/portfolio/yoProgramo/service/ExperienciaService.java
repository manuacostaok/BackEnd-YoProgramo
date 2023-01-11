
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
     ExperienciaRepository rExperiencia;
    
    public List<Experiencia> list(){
        return rExperiencia.findAll();
    }
    
    public Experiencia getOne(int id){
        Experiencia expe = rExperiencia.findById(id).orElse(null);
        return expe;
    }
       
    
    public void save(Experiencia expe){
        rExperiencia.save(expe);
    }
    
     public void delete(int id){
        rExperiencia.deleteById(id);
    }
    
    public void edit(Experiencia expe){
        rExperiencia.save(expe);
    }
    
    //busca lista de relojes por la id de la persona
    public List<Experiencia> findByPersonaId(Long personaId) {
        return rExperiencia.findByPersonaId(personaId);
    }

    
}
