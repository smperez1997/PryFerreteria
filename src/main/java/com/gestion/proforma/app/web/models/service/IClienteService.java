package com.gestion.proforma.app.web.models.service;

import java.util.List;
import com.gestion.proforma.app.web.models.entities.Cliente;


public interface IClienteService {
	public void save(Cliente cliente);
	public Cliente findById(Integer id);
	public void delete(Integer id);
	public List<Cliente> findAll();
	
}
