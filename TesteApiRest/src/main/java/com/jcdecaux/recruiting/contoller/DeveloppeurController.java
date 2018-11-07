package com.jcdecaux.recruiting.contoller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jcdecaux.recruiting.model.Developpeur;
import com.jcdecaux.recruiting.service.impl.DeveloppeurService;

@RestController
@RequestMapping("/exteam")
public class DeveloppeurController {

	@Autowired
	DeveloppeurService developpeurDao;



	/**
	 * @api {POST} /developpeurs: create Developper
	 * @apiName createDevloppeur
	 * @apiGroup Developpeurs
	 **/
	@PostMapping("/developpeurs")
	public Developpeur createDevloppeur(@Valid @RequestBody Developpeur dev) {
		return developpeurDao.save(dev);
	}



	/**
	 * @api {GET} /developpeurs/{id}: find developper
	 * @apiName getDeveloppeurById
	 * @apiGroup Developpeurs
	 **/
	@GetMapping("/developpeurs/{id}")
	public ResponseEntity<Developpeur> getDeveloppeurById(@PathVariable(value="id") Long devid){

		Developpeur dev=developpeurDao.findOne(devid);

		if(dev==null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok().body(dev);

	}



	/**
	 * @api {PUT} /developpeurs/{id}: update developper
	 * @apiName updateDeveloppeur
	 * @apiGroup Developpeurs
	 **/

	@PutMapping("/developpeurs/{id}")
	public ResponseEntity<Developpeur> updateDeveloppeur(@PathVariable(value="id") Long devid,@Valid @RequestBody Developpeur devUpdate){

		Developpeur dev=developpeurDao.findOne(devid);
		if(dev==null) {
			return ResponseEntity.notFound().build();
		}

		dev.setNom(devUpdate.getNom());
		dev.setPrenom(devUpdate.getPrenom());
		dev.setEntreprise(devUpdate.getEntreprise());
		Developpeur updateDeveloppeur=developpeurDao.save(dev);
		return ResponseEntity.ok().body(devUpdate);

	}	


	/**
	 * @api {GET} /developpeurs/{id}: find all developpers
	 * @apiName getAllDeveloppeur
	 * @apiGroup Developpeurs
	 **/

	@GetMapping("/developpeurs")
	public List<Developpeur> getAllDeveloppeurs(){	
		return developpeurDao.findAll();
	}
	
	/**
	 * @api {GET} /languages/{id}/developpeurs: find all developper has language
	 * @apiName getAllDeveloppeursLangProg
	 * @apiGroup Developpeurs
	 **/

	@GetMapping("/languages/{id}/developpeurs")
	public List<Developpeur> getAllDeveloppeursLangProg(@PathVariable String devId){	
		return developpeurDao.findAll();
	}
	




}
