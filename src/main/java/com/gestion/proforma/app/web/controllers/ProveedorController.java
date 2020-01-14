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

import com.gestion.proforma.app.web.models.entities.Proveedor;
import com.gestion.proforma.app.web.models.service.IProveedorService;


@Controller
@RequestMapping(value="/proveedor")
public class ProveedorController {
	@Autowired
	private IProveedorService service;
	
	@GetMapping(value="/create")
	public String create(Model model) {
		Proveedor proveedor = new Proveedor();
		model.addAttribute("title", "Registro de un nuevo proveedor");
		model.addAttribute("proveedor", proveedor);
		return "proveedor/form";		
	}
	
	@GetMapping(value="/retrieve/{id}")
	public String retrieve(@PathVariable(value="id") Integer id, Model model) {
		Proveedor proveedor = service.findById(id);
		model.addAttribute("proveedor", proveedor);
		return "proveedor/card";		
	} 
	
	@GetMapping(value="/update/{id}")
	public String update(@PathVariable(value="id") Integer id, Model model) {
		Proveedor proveedor = service.findById(id);
		model.addAttribute("title", "Actualizando el registro de " 
		+ proveedor.getNombre());
		model.addAttribute("proveedor", proveedor);
		return "proveedor/form";		
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
		return "redirect:/proveedor/list";		
	} 
	
	@PostMapping(value="/save")
	public String save(@Valid Proveedor proveedor, BindingResult result, Model model,
			RedirectAttributes flash) {
		try {
			if(result.hasErrors())
			{
				if(proveedor.getIdproveedor() == null) {
					model.addAttribute("tittle","Registro de un nuevo proveedor");					
				}
				else {
					model.addAttribute("tittle","Actualizando el registro de " 
							+ proveedor.getNombre());
				}
				
				return"proveedor/form";
			}
			service.save(proveedor);
			flash.addFlashAttribute("success", "El registro fue guardado con éxito.");
		}
		catch(Exception ex) {
			flash.addFlashAttribute("error", "El registro no pudo ser guardado.");
		}
		return "redirect:/proveedor/list";		
	} 
	
	@GetMapping(value="/list")
	public String list(Model model) {
		List<Proveedor> lista = service.findAll();
		model.addAttribute("title", "Listado de proveedores");
		model.addAttribute("lista", lista);
		return "proveedor/list";		
	}
}
