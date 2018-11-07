package com.jcdecaux.recruiting.service;

import java.util.List;
import com.jcdecaux.recruiting.model.Developpeur;

public interface Ideveloppeur {
	
	public Developpeur save(Developpeur dev) ;
	public List<Developpeur> findAll();
	public Developpeur findOne(Long devid) ;

}
