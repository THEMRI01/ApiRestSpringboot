package com.jcdecaux.recruiting.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jcdecaux.recruiting.model.Developpeur;


public interface DeveloppeurRepository  extends JpaRepository<Developpeur, Long>  {

}
