
package com.portfolio.yoProgramo.repository;

import com.portfolio.yoProgramo.entity.Habilidad;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface HabilidadRepository extends JpaRepository<Habilidad, Integer> {
    
}
