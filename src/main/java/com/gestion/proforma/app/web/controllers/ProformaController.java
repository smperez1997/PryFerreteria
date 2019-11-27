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

import com.gestion.proforma.app.web.models.entities.Proforma;
import com.gestion.proforma.app.web.models.service.IProformaService;

@Controller
@RequestMapping(value="/proforma")
public class ProformaController {

	@Autowired
	private IProformaService service;
	
	@GetMapping(value="/create")
	public String create(Model model) {
		Proforma proforma = new Proforma();
		model.addAttribute("proforma",proforma);
		model.addAttribute("title","Registro de nuevo tipo de proforma");
		return "proforma/form";
	}
	
	@GetMapping(value="/retrive/{id}")
	public String retrive(@PathVariable(value="id") Integer id, Model model) {
		Proforma proforma = service.findById(id);
		model.addAttribute("proforma",proforma);
		return "proforma/card";
	}
	
	@GetMapping(value="/update/{id}")
	public String update(@PathVariable(value="id") Integer id, Model model) {
		Proforma proforma = service.findById(id);
		model.addAttribute("proforma",proforma);
		return "proforma/form";
	}
	
	@GetMapping(value="/delete/{id}")
	public String delete(@PathVariable(value="id") Integer id, Model model, RedirectAttributes redirect) {
		try {
			service.delete(id);
			redirect.addFlashAttribute("success", "El registro se eliminó exitosamente");
		}catch(Exception e) {
			redirect.addFlashAttribute("error", "No se pudo eliminar");
		}
		return "redirect:/proforma/list";
	}
	@GetMapping(value="/list")
	public String list(Model model) {
		List<Proforma> list = service.findAll();
		model.addAttribute("list",list);
		model.addAttribute("title","Listado de tipos de proforma");
		return "/proforma/list";
	}
	
	//
	@PostMapping(value="/save")
	public String save(Proforma proforma,Model model, RedirectAttributes redirect) {	
		try {
			service.save(proforma);
			redirect.addFlashAttribute("success","Registro guardado");
			
		}catch(Exception e) {
			redirect.addFlashAttribute("error","No se pudo guardar");
		}
		
		return "/proforma/list";
	}
}
