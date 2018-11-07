package com.jcdecaux.recruiting.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jcdecaux.recruiting.model.Developpeur;
import com.jcdecaux.recruiting.repository.DeveloppeurRepository;
import com.jcdecaux.recruiting.service.Ideveloppeur;

@Service
public class DeveloppeurService implements Ideveloppeur  {
	
	@Autowired
	DeveloppeurRepository developpeurRepository ;
	
	
	/**
	 * This method is used to create developper
	 * @param dev
	 * @return Developpeur
	 */
	
	public Developpeur save(Developpeur dev) {
		return developpeurRepository.save(dev);
	}
	
	

	/**
	 * This method is used to find all developper
	 * @param 
	 * @return List<Developpeur>
	 */
	public List<Developpeur> findAll(){
		return developpeurRepository.findAll();
	}
	

	
	/**
	 * This method is used to find developper
	 * @param devid
	 * @return Developpeur
	 */
	public Developpeur findOne(Long devid) {
		return developpeurRepository.findOne(devid);
	}
	
	
}
