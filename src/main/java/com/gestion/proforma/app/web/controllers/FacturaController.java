package com.gestion.proforma.app.web.controllers; 

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
 
import com.gestion.proforma.app.web.models.service.UsuarioService;
 
import com.gestion.proforma.app.web.models.entities.DetalleFactura;
import com.gestion.proforma.app.web.models.entities.Empleado;
import com.gestion.proforma.app.web.models.entities.Factura; 
import com.gestion.proforma.app.web.models.entities.Usuario; 
import com.gestion.proforma.app.web.models.service.DetalleFacturaService;
import com.gestion.proforma.app.web.models.service.EmpleadoService;
import com.gestion.proforma.app.web.models.service.IFacturaService;

@Controller
@RequestMapping(value="/factura")
@SessionAttributes({"facturafinal"})
public class FacturaController {

	@Autowired
	private IFacturaService service;
	@Autowired
	private EmpleadoService srvCliente;	
	@Autowired
	private UsuarioService srvEmpleado;
	
	@GetMapping(value="/create")
	public String create(Model model) {
		Factura factura = new Factura();
		model.addAttribute("title", "Registro de Facturas");
		model.addAttribute("factura", factura);
		return "factura/form";		
	}
	@GetMapping(value="/create/{id}")
	public String create(Model model, @PathVariable(value="id") Integer id) {
		Factura facturafinal = new Factura();
		facturafinal.setPersonaid(id);	
		Empleado empleado = srvCliente.findById(id);
		List<Usuario> empleados = srvEmpleado.findAll();
		model.addAttribute("title", "Nuevo registro para " + empleado);
		model.addAttribute("facturafinal", facturafinal);
		model.addAttribute("medicos", empleados);		
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
	public String save(@Valid Factura facturafinal, 
			BindingResult result, Model model,
			RedirectAttributes mensaje, SessionStatus session){
		
		if(result.hasErrors()) {
			return "factura/form";
		}
		
		service.save(facturafinal);
		session.setComplete();		
		
		return "redirect:/";
	}
	
	
	
	@GetMapping(value="/list")
	public String list(Model model) {
		List<Factura> lista = service.findAll();
		model.addAttribute("title", "Listado de Facturas");
		model.addAttribute("lista", lista);
		return "factura/list";		
	} 
	
	@PostMapping(value="/addDetail", produces="application/json")
	public void addDetail(@RequestBody DetalleFactura detail, 
			@SessionAttribute(value="factura") Factura factura ) 
	{
		if(factura.getDetalles()== null)
		{
			List<DetalleFactura> lista = new ArrayList<DetalleFactura>();
			factura.setDetalles(lista);
		}
		//Factura tipo = srv
	}
	
}
