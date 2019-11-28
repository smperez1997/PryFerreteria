package com.gestion.proforma.app.web.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.gestion.proforma.app.web.models.entities.Inventario;
import com.gestion.proforma.app.web.models.service.IInventarioService;


@Controller
@RequestMapping(value="/inventario")
public class InventarioController {
	@Autowired
	private IInventarioService service;
	
	@GetMapping(value="/create")
	public String create(Model model) {
		Inventario inventario = new Inventario();
		model.addAttribute("title", "Registro de un nuevo inventario");
		model.addAttribute("inventario", inventario);
		return "inventario/form";		
	}
	
	@GetMapping(value="/retrieve/{id}")
	public String retrieve(@PathVariable(value="id") Integer id, Model model) {
		Inventario inventario = service.findById(id);
		model.addAttribute("inventario", inventario);
		return "inventario/card";		
	} 
	
	@GetMapping(value="/update/{id}")
	public String update(@PathVariable(value="id") Integer id, Model model) {
		Inventario inventario = service.findById(id);
		model.addAttribute("title", "Actualizando el registro de inventario");
		model.addAttribute("inventario", inventario);
		return "inventario/form";		
	} 
	
	@GetMapping(value="/delete/{id}")
	public String delete(@PathVariable(value="id") Integer id, Model model, 
			RedirectAttributes flash) {
		try {
			service.delete(id);
			flash.addFlashAttribute("success", "El registro fue eliminado con éxito.");
		}	
		catch(Exception ex) {
			flash.addFlashAttribute("error", "El registro no pudo ser eliminado.");
		}
		return "redirect:/inventario/list";		
	} 
	
	@PostMapping(value="/save")
	public String save(@Valid Inventario inventario, BindingResult result, Model model,
			RedirectAttributes flash) {
		try {
			if(result.hasErrors())
			{
				if(inventario.getIdinventario() == null) {
					model.addAttribute("tittle","Registro de un nuevo inventario");					
				}
				else {
					model.addAttribute("tittle","Actualizando el registro de inventario");
				}
				
				return"inventario/form";
			}
			service.save(inventario);
			flash.addFlashAttribute("success", "El registro fue guardado con éxito.");
		}
		catch(Exception ex) {
			flash.addFlashAttribute("error", "El registro no pudo ser guardado.");
		}
		return "redirect:/inventario/list";		
	} 
	
	@GetMapping(value="/list")
	public String list(Model model) {
		List<Inventario> lista = service.findAll();
		model.addAttribute("title", "Listado de inventarios");
		model.addAttribute("lista", lista);
		return "inventario/list";		
	}
}
