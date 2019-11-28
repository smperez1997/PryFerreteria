package com.gestion.proforma.app.web.models.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import com.gestion.proforma.app.web.models.dao.IProveedor;
import com.gestion.proforma.app.web.models.entities.Proveedor;


@Service
public class ProveedorService implements IProveedorService{
	@Autowired 
	private IProveedor dao;
		
	@Override
	@Transactional
	public void save(Proveedor proveedor) {
		dao.save(proveedor);		
	}

	@Override
	@Transactional(readOnly=true)
	public Proveedor findById(Integer id) {		
		return dao.findById(id).get();
	}

	@Override
	@Transactional
	public void delete(Integer id) {
		dao.deleteById(id);		
	}

	@Override
	@Transactional(readOnly=true)
	public List<Proveedor> findAll() {
		return (List<Proveedor>) dao.findAll();
	}
}
