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

import com.gestion.proforma.app.web.models.entities.Producto;
import com.gestion.proforma.app.web.models.entities.Proveedor;
import com.gestion.proforma.app.web.models.service.IProductoService;
import com.gestion.proforma.app.web.models.service.IProveedorService;

@Controller
@RequestMapping(value="/producto")
public class ProductoController {

	@Autowired
	private IProductoService service;
	
	@Autowired
    private IProveedorService srvProveedor;
	@GetMapping(value="/create")
	public String create(Model model) {
		Producto producto = new Producto();
		model.addAttribute("title", "Registro de Producto");
		model.addAttribute("producto", producto);
		List<Proveedor> proveedores = srvProveedor.findAll();
        model.addAttribute("proveedores", proveedores);  
		return "producto/form";		
	}
	
	@GetMapping(value="/retrieve/{id}")
	public String retrieve(@PathVariable(value="id") Integer id, Model model) {
		Producto producto = service.findById(id);
		model.addAttribute("producto", producto);
		return "producto/card";		
	} 
	
	@GetMapping(value="/update/{id}")
	public String update(@PathVariable(value="id") Integer id, Model model) {
		Producto producto = service.findById(id);
		model.addAttribute("title", "Actualizando el registro de " 
		+ producto.getNombre());
		model.addAttribute("producto", producto);
		List<Proveedor> proveedores = srvProveedor.findAll();
        model.addAttribute("proveedores", proveedores); 
		return "producto/form";		
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
		return "redirect:/producto/list";		
	} 
	
	@PostMapping(value="/save")
	public String save(@Valid Producto producto,BindingResult result, Model model,
			RedirectAttributes flash) {
		try {
			if(result.hasErrors())
			{
				model.addAttribute("tittle","Error al Guardar");
				return"producto/form";
			}
			service.save(producto);
			flash.addFlashAttribute("success", "El registro fue guardado con éxito.");
		}
		catch(Exception ex) {
			flash.addFlashAttribute("error", "El registro no pudo ser guardado.");
		}
		return "redirect:/producto/list";		
	} 
	
	@GetMapping(value="/list")
	public String list(Model model) {
		List<Producto> lista = service.findAll();
		model.addAttribute("title", "Listado de Clientes");
		model.addAttribute("lista", lista);
		return "producto/list";		
	} 
	
}
