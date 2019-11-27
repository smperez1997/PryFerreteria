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

import com.gestion.proforma.app.web.models.entities.Cliente;
import com.gestion.proforma.app.web.models.service.IClienteService;

@Controller
@RequestMapping(value="/cliente")
public class ClienteController {

	@Autowired
	private IClienteService service;
	
	@GetMapping(value="/create")
	public String create(Model model) {
		Cliente cliente = new Cliente();
		model.addAttribute("cliente",cliente);
		model.addAttribute("title","Registro del nuevo cliente");
		return "cliente/form";
	}
	
	@GetMapping(value="/retrive/{id}")
	public String retrive(@PathVariable(value="id") Integer id, Model model) {
		Cliente cliente = service.findById(id);
		model.addAttribute("cliente",cliente);
		return "cliente/card";
	}
	
	@GetMapping(value="/update/{id}")
	public String update(@PathVariable(value="id") Integer id, Model model) {
		Cliente cliente = service.findById(id);
		model.addAttribute("cliente",cliente);
		return "cliente/form";
	}
	
	@GetMapping(value="/delete/{id}")
	public String delete(@PathVariable(value="id") Integer id, Model model, RedirectAttributes redirect) {
		try {
			service.delete(id);
			redirect.addFlashAttribute("success", "El registro se eliminó exitosamente");
		}catch(Exception e) {
			redirect.addFlashAttribute("error", "No se pudo eliminar");
		}
		return "redirect:/cliente/list";
	}
	@GetMapping(value="/list")
	public String list(Model model) {
		List<Cliente> list = service.findAll();
		model.addAttribute("list",list);
		model.addAttribute("title","Listado de clientes");
		return "/cliente/list";
	}
	
	//
	@PostMapping(value="/save")
	public String save(Cliente cliente,Model model, RedirectAttributes redirect) {	
		try {
			service.save(cliente);
			redirect.addFlashAttribute("success","Registro guardado");
			
		}catch(Exception e) {
			redirect.addFlashAttribute("error","No se pudo guardar");
		}
		
		return "/cliente/list";
	}
}
