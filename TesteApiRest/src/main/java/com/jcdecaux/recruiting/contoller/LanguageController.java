package com.jcdecaux.recruiting.contoller;


import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.jcdecaux.recruiting.model.LanguageProgramation;
import com.jcdecaux.recruiting.service.impl.LanguageService;





/**
* @author  Mohamed Themri
* @version 1.0
*/

@RestController
@RequestMapping("/exteam")
public class LanguageController {
	
	@Autowired
	LanguageService languageDao;
	

	 /**
	  * @api {POST}/languages: create language programming 
	  * @apiName  createLanguage
	  * @apiGroup languages
	  **/
	@PostMapping("/languages")
	public LanguageProgramation createLanguage(@Valid @RequestBody LanguageProgramation lang) {
		return languageDao.save(lang);
	}
	

}
