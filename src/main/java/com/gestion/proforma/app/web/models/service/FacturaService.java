package com.gestion.proforma.app.web.models.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
 
import com.gestion.proforma.app.web.models.dao.IFactura;
import com.gestion.proforma.app.web.models.entities.Factura;

@Service
public class FacturaService implements IFacturaService{

	@Autowired
	private IFactura dao;
	@Override
	@Transactional
	public void save(Factura factura) {
		dao.save(factura);
	}

	@Override
	@Transactional
	public Factura findById(Integer id) {
		return dao.findById(id).get();
	}

	@Override
	@Transactional
	public void delete(Integer id) {
		dao.deleteById(id);
		
	}

	@Override
	@Transactional
	public List<Factura> findAll() {
		return (List<Factura>)dao.findAll();
	}
	
}
