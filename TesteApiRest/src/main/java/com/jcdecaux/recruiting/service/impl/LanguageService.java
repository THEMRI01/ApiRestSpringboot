package com.jcdecaux.recruiting.service.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.jcdecaux.recruiting.model.LanguageProgramation;
import com.jcdecaux.recruiting.repository.LanguageRepository;
import com.jcdecaux.recruiting.service.Ilanguage;

@Service
public class LanguageService  implements Ilanguage{
	
	@Autowired
	LanguageRepository languageRepository ;
	
 
	/**
	   * This method is used to create language programming
	   * @param lang 
	   * @return LanguageProgramation
	   */

	public LanguageProgramation save(LanguageProgramation lang) {
		return languageRepository.save(lang);
	}
		
	
}
