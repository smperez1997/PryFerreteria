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

import com.gestion.proforma.app.web.models.entities.DetalleFactura;
import com.gestion.proforma.app.web.models.service.IDetalleFacturaService;

@Controller
@RequestMapping(value="/detallefactura")
public class DetalleFacturaController {

	@Autowired
	private IDetalleFacturaService service;
	
	@GetMapping(value="/create")
	public String create(Model model) {
		DetalleFactura detallefactura = new DetalleFactura();
		model.addAttribute("title", "Registro de Detalle de Factura");
		model.addAttribute("detallefactura", detallefactura);
		return "detallefactura/form";		
	}
	
	@GetMapping(value="/retrieve/{id}")
	public String retrieve(@PathVariable(value="id") Integer id, Model model) {
		DetalleFactura detallefactura = service.findById(id);
		model.addAttribute("detallefactura", detallefactura);
		return "detallefactura/card";		
	} 
	
	@GetMapping(value="/update/{id}")
	public String update(@PathVariable(value="id") Integer id, Model model) {
		DetalleFactura detallefactura = service.findById(id);
		model.addAttribute("title", "Actualizando el registro de " 
		+ detallefactura.getIddetallefactura());
		model.addAttribute("detallefactura", detallefactura);
		return "detallefactura/form";		
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
		return "redirect:/detallefactura/list";		
	} 
	
	@PostMapping(value="/save")
	public String save(@Valid DetalleFactura detallefactura,BindingResult result, Model model,
			RedirectAttributes flash) {
		try {
			if(result.hasErrors())
			{
				model.addAttribute("tittle","Error al Guardar");
				return"detallefactura/form";
			}
			service.save(detallefactura);
			flash.addFlashAttribute("success", "El registro fue guardado con éxito.");
		}
		catch(Exception ex) {
			flash.addFlashAttribute("error", "El registro no pudo ser guardado.");
		}
		return "redirect:/detallefactura/list";		
	} 
	
	@GetMapping(value="/list")
	public String list(Model model) {
		List<DetalleFactura> lista = service.findAll();
		model.addAttribute("title", "Listado de Detalles de Facturas");
		model.addAttribute("lista", lista);
		return "detallefactura/list";		
	} 
	
}
