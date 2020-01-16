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

import com.gestion.proforma.app.web.models.entities.Factura;
import com.gestion.proforma.app.web.models.service.IFacturaService;

@Controller
@RequestMapping(value="/factura")
public class FacturaController {

	@Autowired
	private IFacturaService service;
	
	@GetMapping(value="/create")
	public String create(Model model) {
		Factura factura = new Factura();
		model.addAttribute("title", "Registro de Facturas");
		model.addAttribute("factura", factura);
		return "factura/form";		
	}
	
	@GetMapping(value="/retrieve/{id}")
	public String retrieve(@PathVariable(value="id") Integer id, Model model) {
		Factura factura = service.findById(id);
		model.addAttribute("factura", factura);
		return "factura/card";		
	} 
	
	@GetMapping(value="/update/{id}")
	public String update(@PathVariable(value="id") Integer id, Model model) {
		Factura factura = service.findById(id);
		model.addAttribute("title", "Actualizando el registro de " 
		+ factura.getCodigo());
		model.addAttribute("factura", factura);
		return "factura/form";		
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
		return "redirect:/factura/list";		
	} 
	
	@PostMapping(value="/save")
	public String save(@Valid Factura factura,BindingResult result, Model model,
			RedirectAttributes flash) {
		try {
			if(result.hasErrors())
			{
				model.addAttribute("tittle","Error al Guardar");
				return"factura/form";
			}
			service.save(factura);
			flash.addFlashAttribute("success", "El registro fue guardado con éxito.");
		}
		catch(Exception ex) {
			flash.addFlashAttribute("error", "El registro no pudo ser guardado.");
		}
		return "redirect:/factura/list";		
	} 
	
	@GetMapping(value="/list")
	public String list(Model model) {
		List<Factura> lista = service.findAll();
		model.addAttribute("title", "Listado de Facturas");
		model.addAttribute("lista", lista);
		return "factura/list";		
	} 
	
}
