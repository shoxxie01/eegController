package com.shoxxie.eegcontroller.repository;

import com.shoxxie.eegcontroller.model.ModelEeg;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EegRepository extends JpaRepository<ModelEeg, Integer> {

    ModelEeg findByUsernameAndElectrodeNumber(String username, Integer electrodeNumber);
}
