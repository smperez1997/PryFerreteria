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
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.gestion.proforma.app.web.models.service.IPaisService;
import com.gestion.proforma.app.web.models.entities.Pais;
import com.gestion.proforma.app.web.models.entities.Empleado;
import com.gestion.proforma.app.web.models.service.IEmpleadoService;

@Controller
@RequestMapping(value="/empleado")
public class EmpleadoController {

	@Autowired
	private IEmpleadoService service;
	
	@Autowired
	private IPaisService srvPais;
	
	@GetMapping(value="/create")
	public String create(Model model) {
		Empleado empleado = new Empleado();
		model.addAttribute("title", "Registro de Empleado");
		model.addAttribute("empleado", empleado);
		List<Pais> paises = srvPais.findAll();
		model.addAttribute("paises", paises);
		return "empleado/form";		
	}
	
	@GetMapping(value="/retrieve/{id}")
	public String retrieve(@PathVariable(value="id") Integer id, Model model) {
		Empleado empleado = service.findById(id);
		model.addAttribute("title", "Admisión");
		model.addAttribute("empleado", empleado);
		return "empleado/card";		
	} 
	
	@GetMapping(value="/update/{id}")
	public String update(@PathVariable(value="id") Integer id, Model model) {
		Empleado empleado = service.findById(id);
		model.addAttribute("title", "Actualizando el registro de " 
		+ empleado.getNombres()+" "+empleado.getApellidos());
		model.addAttribute("empleado", empleado);
		return "empleado/form";		
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
		return "redirect:/empleado/list";		
	} 
	
	@PostMapping(value="/save")
	public String save(@Valid Empleado empleado,BindingResult result, Model model,
			RedirectAttributes flash) {
		try {
			if(result.hasErrors())
			{
				List<Pais> paises = srvPais.findAll();
				model.addAttribute("paises", paises);	
				if(empleado.getIdpersona() == null) {
					model.addAttribute("title","Nuevo registro");					
				}
				else {
					model.addAttribute("title","Actualización de registro");
				}	
				 return"empleado/form";
			}
			service.save(empleado);
			flash.addFlashAttribute("success", "El registro fue guardado con éxito.");
		}
		catch(Exception ex) {
			flash.addFlashAttribute("error", "El registro no pudo ser guardado.");
		}
		return "redirect:/";		
	} 
	
	@GetMapping(value="/list")
	public String list(Model model) {
		List<Empleado> lista = service.findAll();
		model.addAttribute("title", "Listado de Empleados");
		model.addAttribute("lista", lista);
		return "empleado/list";		
	} 
	@GetMapping(value="/search")
	public String search(Model model) {
		model.addAttribute("title", "Búsqueda por apellidos");		
		return "empleado/search";		
	}
	@GetMapping(value="/findByApellido/{filtro}", produces="application/json")
	public @ResponseBody List<Empleado> findByApellido(@PathVariable(value="filtro") String filtro, Model model) {
		List<Empleado> lista = service.findByApellido(filtro.toLowerCase());		
		return lista;		
	} 
	@GetMapping(value="/findByCedula/{cedula}")
	public String findByCedula(@PathVariable(value="cedula") String cedula, Model model) {
		Empleado encontrado = service.findByCedula(cedula);
		model.addAttribute("paciente", encontrado);
		return "paciente/card";				
	}
	
}
