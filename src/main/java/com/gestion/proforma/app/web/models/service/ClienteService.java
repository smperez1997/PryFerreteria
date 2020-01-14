package com.gestion.proforma.app.web.models.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.gestion.proforma.app.web.models.dao.ICliente;
import com.gestion.proforma.app.web.models.entities.Cliente;


@Service
public class ClienteService implements IClienteService{

	
	@Autowired
	private ICliente dao;
	
	@Override
	@Transactional
	public void save(Cliente cliente) {
		dao.save(cliente);
	}

	@Override
	@Transactional
	public Cliente findById(Integer id) {
		return dao.findById(id).get();
	}

	@Override
	@Transactional
	public void delete(Integer id) {
		dao.deleteById(id);
		
	}

	@Override
	@Transactional
	public List<Cliente> findAll() {
		return (List<Cliente>)dao.findAll();
	}
	
}
