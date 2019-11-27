package com.gestion.proforma.app.web.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.gestion.proforma.app.web.models.entities.ElementoCatalogo;
import com.gestion.proforma.app.web.models.service.IElementoCatalogoService;

@Controller
@RequestMapping(value="/elementocatalogo")
public class ElementoCatalogoController {

	@Autowired
	private IElementoCatalogoService service;
	
	@GetMapping(value="/create")
	public String create(Model model) {
		ElementoCatalogo elementocatalogo = new ElementoCatalogo();
		model.addAttribute("elementocatalogo",elementocatalogo);
		model.addAttribute("title","Registro del nuevo elemento del catalogo");
		return "elementocatalogo/form";
	}
	
	@GetMapping(value="/retrive/{id}")
	public String retrive(@PathVariable(value="id") Integer id, Model model) {
		ElementoCatalogo elementocatalogo = service.findById(id);
		model.addAttribute("elementocatalogo",elementocatalogo);
		return "elementocatalogo/card";
	}
	
	@GetMapping(value="/update/{id}")
	public String update(@PathVariable(value="id") Integer id, Model model) {
		ElementoCatalogo elementocatalogo = service.findById(id);
		model.addAttribute("elementocatalogo",elementocatalogo);
		return "elementocatalogo/form";
	}
	
	@GetMapping(value="/delete/{id}")
	public String delete(@PathVariable(value="id") Integer id, Model model, RedirectAttributes redirect) {
		try {
			service.delete(id);
			redirect.addFlashAttribute("success", "El registro se eliminó exitosamente");
		}catch(Exception e) {
			redirect.addFlashAttribute("error", "No se pudo eliminar");
		}
		return "redirect:/elementocatalogo/list";
	}
	@GetMapping(value="/list")
	public String list(Model model) {
		List<ElementoCatalogo> list = service.findAll();
		model.addAttribute("list",list);
		model.addAttribute("title","Listado de tipos de elementos del catalogo");
		return "/elementocatalogo/list";
	}
	
	//
	@PostMapping(value="/save")
	public String save(ElementoCatalogo elementocatalogo,Model model, RedirectAttributes redirect) {	
		try {
			service.save(elementocatalogo);
			redirect.addFlashAttribute("success","Registro guardado");
			
		}catch(Exception e) {
			redirect.addFlashAttribute("error","No se pudo guardar");
		}
		
		return "/elementocatalogo/list";
	}
}
