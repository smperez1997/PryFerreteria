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

import com.gestion.proforma.app.web.models.entities.DetalleProforma;
import com.gestion.proforma.app.web.models.service.IDetalleProformaService;
 

@Controller
@RequestMapping(value="/detalleproforma")
public class DetalleProformaController {

	@Autowired
	private IDetalleProformaService service;
	
	@GetMapping(value="/create")
	public String create(Model model) {
		DetalleProforma detalleproforma = new DetalleProforma();
		model.addAttribute("detalleproforma",detalleproforma);
		model.addAttribute("title","Registro del nuevo detalle de proforma");
		return "detalleproforma/form";
	}
	
	@GetMapping(value="/retrive/{id}")
	public String retrive(@PathVariable(value="id") Integer id, Model model) {
		DetalleProforma detalleproforma = service.findById(id);
		model.addAttribute("detalleproforma",detalleproforma);
		return "detalleproforma/card";
	}
	
	@GetMapping(value="/update/{id}")
	public String update(@PathVariable(value="id") Integer id, Model model) {
		DetalleProforma detalleproforma = service.findById(id);
		model.addAttribute("detalleproforma",detalleproforma);
		return "detalleproforma/form";
	}
	
	@GetMapping(value="/delete/{id}")
	public String delete(@PathVariable(value="id") Integer id, Model model, RedirectAttributes redirect) {
		try {
			service.delete(id);
			redirect.addFlashAttribute("success", "El registro se eliminó exitosamente");
		}catch(Exception e) {
			redirect.addFlashAttribute("error", "No se pudo eliminar");
		}
		return "redirect:/detalleproforma/list";
	}
	@GetMapping(value="/list")
	public String list(Model model) {
		List<DetalleProforma> list = service.findAll();
		model.addAttribute("list",list);
		model.addAttribute("title","Listado de tipos de detalle de proforma");
		return "/detalleproforma/list";
	}
	
	//
	@PostMapping(value="/save")
	public String save(DetalleProforma detalleproforma,Model model, RedirectAttributes redirect) {	
		try {
			service.save(detalleproforma);
			redirect.addFlashAttribute("success","Registro guardado");
			
		}catch(Exception e) {
			redirect.addFlashAttribute("error","No se pudo guardar");
		}
		
		return "/detalleproforma/list";
	}
}
