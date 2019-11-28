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

import com.gestion.proforma.app.web.models.entities.Venta;
import com.gestion.proforma.app.web.models.service.IVentaService;

@Controller
@RequestMapping(value="/venta")
public class VentaController {
	@Autowired
	private IVentaService service;
	
	@GetMapping(value="/create")
	public String create(Model model) {
		Venta venta = new Venta();
		model.addAttribute("title", "Registro de venta");
		model.addAttribute("venta", venta);
		return "venta/form";		
	}
	
	@GetMapping(value="/retrieve/{id}")
	public String retrieve(@PathVariable(value="id") Integer id, Model model) {
		Venta venta = service.findById(id);
		model.addAttribute("venta", venta);
		return "venta/card";		
	} 
	
	@GetMapping(value="/update/{id}")
	public String update(@PathVariable(value="id") Integer id, Model model) {
		Venta venta = service.findById(id);
		model.addAttribute("title", "Actualizando el registro de " 
		+ venta.getFecha_venta());
		model.addAttribute("venta", venta);
		return "venta/form";		
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
		return "redirect:/venta/list";		
	} 
	
	@PostMapping(value="/save")
	public String save(@Valid Venta venta, BindingResult result, Model model,
			RedirectAttributes flash) {
		try {
			if(result.hasErrors())
			{
				if(venta.getIdventa() == null) {
					model.addAttribute("tittle","Registro de una venta");					
				}
				else {
					model.addAttribute("tittle","Actualizando el registro de " 
							+ venta.getFecha_venta());
				}
				
				return"venta/form";
			}
			service.save(venta);
			flash.addFlashAttribute("success", "El registro fue guardado con éxito.");
		}
		catch(Exception ex) {
			flash.addFlashAttribute("error", "El registro no pudo ser guardado.");
		}
		return "redirect:/venta/list";		
	} 
	
	@GetMapping(value="/list")
	public String list(Model model) {
		List<Venta> lista = service.findAll();
		model.addAttribute("title", "Listado de tipos de enfermedades");
		model.addAttribute("lista", lista);
		return "venta/list";		
	}
}
