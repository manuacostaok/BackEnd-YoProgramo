
package com.portfolio.yoProgramo.service;

import com.portfolio.yoProgramo.entity.Estudio;
import com.portfolio.yoProgramo.repository.EstudioRepository;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional//persistencia en base de datos
public class EstudioService {
    
    @Autowired
    public EstudioRepository estudioRepo;
    
    
    public List <Estudio> verEstudios(){
        List<Estudio> listaEstudios=estudioRepo.findAll();
        return listaEstudios;
    }
    
    public void crearEstudio(Estudio e){
        estudioRepo.save(e);
    }
    
    public void borrarEstudio(int id){
        estudioRepo.deleteById(id);
    }
    
    public Estudio buscarEstudio(int id){
        Estudio estudio=estudioRepo.findById(id).orElse(null);
        return estudio;
    }
    
    public void editarEstudio(Estudio estudio) {
       estudioRepo.save(estudio);
    }

   
   
    
}
