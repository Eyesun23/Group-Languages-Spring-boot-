package com.aysun.group.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.aysun.group.models.Language;
import com.aysun.group.services.LanguageService;

@Controller
public class languagesGroup {
	
	private final LanguageService languageService;
	public languagesGroup(LanguageService languageService) {
		this.languageService = languageService;
	}
	
	@RequestMapping(value="/")
	public String index(Model model, @ModelAttribute("newLanguage") Language newLanguage) {
		List<Language> languages = languageService.allLanguages();
		model.addAttribute("languages", languages);
		return "NewFile.jsp";
	}
	
	@PostMapping(value="/language/new")
	public String createLanguage(@Valid @ModelAttribute("newLanguage") Language newLanguage, BindingResult result) {
		if(result.hasErrors()) {
			return "NewFile.jsp";
		}else {
			languageService.addLanguage(newLanguage);
			return "redirect:/";
		}
		
	}
	
	@RequestMapping(value="/language/{index}")
	public String findLanguageByIndex(Model model, @PathVariable("index") int index) {
		Language language = languageService.findLanguageByIndex(index);
		model.addAttribute("language", language);
		return "language1.jsp";
	}
	
	@RequestMapping(value="/language/update/{index}", method=RequestMethod.GET)
	public String editLanguage(Model model, @PathVariable("index") int index) {
		Language language = languageService.findLanguageByIndex(index);
		if(language != null) {
			model.addAttribute("language", language);
			model.addAttribute("index", index);
			return "revision.jsp";
		}else {
			return "redirect:/";
		}
	}
	
	@PostMapping(value="/language/update/{index}")
	public String updateLanguage(@PathVariable("index") int index, @Valid @ModelAttribute("language") Language language, BindingResult result) {
		if(result.hasErrors()) {
			return "revision.jsp";
		}else {
			languageService.updateLanguage(index, language);
			return "redirect:/language/{index}";
		}
	}
	
	@RequestMapping(value="/language/delete/{index}")
	public String deleteLanguage(@PathVariable("index") int index) {
		languageService.deleteLanguage(index);
		return "redirect:/";
	}

}