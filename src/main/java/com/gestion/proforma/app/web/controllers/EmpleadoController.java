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

import com.gestion.proforma.app.web.models.entities.Empleado;
import com.gestion.proforma.app.web.models.service.IEmpleadoService; 

@Controller
@RequestMapping(value="/empleado")
public class EmpleadoController {

	@Autowired
	private IEmpleadoService service;
	
	@GetMapping(value="/create")
	public String create(Model model) {
		Empleado empleado = new Empleado();
		model.addAttribute("empleado",empleado);
		model.addAttribute("title","Registro de nuevo empleado");
		return "empleado/form";
	}
	
	@GetMapping(value="/retrive/{id}")
	public String retrive(@PathVariable(value="id") Integer id, Model model) {
		Empleado empleado = service.findById(id);
		model.addAttribute("empleado",empleado);
		return "empleado/card";
	}
	
	@GetMapping(value="/update/{id}")
	public String update(@PathVariable(value="id") Integer id, Model model) {
		Empleado empleado = service.findById(id);
		model.addAttribute("empleado",empleado);
		return "empleado/form";
	}
	
	@GetMapping(value="/delete/{id}")
	public String delete(@PathVariable(value="id") Integer id, Model model, RedirectAttributes redirect) {
		try {
			service.delete(id);
			redirect.addFlashAttribute("success", "El registro se eliminó exitosamente");
		}catch(Exception e) {
			redirect.addFlashAttribute("error", "No se pudo eliminar");
		}
		return "redirect:/empleado/list";
	}
	@GetMapping(value="/list")
	public String list(Model model) {
		List<Empleado> list = service.findAll();
		model.addAttribute("list",list);
		model.addAttribute("title","Listado de empleados");
		return "/empleado/list";
	}
	
	//
	@PostMapping(value="/save")
	public String save(Empleado empleado,Model model, RedirectAttributes redirect) {	
		try {
			service.save(empleado);
			redirect.addFlashAttribute("success","Registro guardado");
			
		}catch(Exception e) {
			redirect.addFlashAttribute("error","No se pudo guardar");
		}
		
		return "/empleado/list";
	}
}
