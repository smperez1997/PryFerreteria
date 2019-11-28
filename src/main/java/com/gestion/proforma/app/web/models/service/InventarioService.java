package com.gestion.proforma.app.web.models.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gestion.proforma.app.web.models.dao.IInventario;
import com.gestion.proforma.app.web.models.entities.Inventario;

@Service
public class InventarioService implements IInventarioService{
	@Autowired 
	private IInventario dao;
		
	@Override
	@Transactional
	public void save(Inventario inventario) {
		dao.save(inventario);		
	}

	@Override
	@Transactional(readOnly=true)
	public Inventario findById(Integer id) {		
		return dao.findById(id).get();
	}

	@Override
	@Transactional
	public void delete(Integer id) {
		dao.deleteById(id);		
	}

	@Override
	@Transactional(readOnly=true)
	public List<Inventario> findAll() {
		return (List<Inventario>) dao.findAll();
	}
}
