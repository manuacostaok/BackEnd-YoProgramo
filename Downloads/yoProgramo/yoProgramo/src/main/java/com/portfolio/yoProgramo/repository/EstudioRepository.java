
package com.portfolio.yoProgramo.repository;

import com.portfolio.yoProgramo.entity.Estudio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface EstudioRepository extends JpaRepository<Estudio, Integer> {
    
}
