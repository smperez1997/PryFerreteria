package com.gestion.proforma.app.web.models.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
 
import com.gestion.proforma.app.web.models.dao.IDetalleProforma;
import com.gestion.proforma.app.web.models.entities.DetalleProforma;

@Service
public class DetalleProformaService implements IDetalleProformaService{

	@Autowired
	private IDetalleProforma dao;
	
	@Override
	@Transactional
	public void save(DetalleProforma detalleProforma) {
		dao.save(detalleProforma);
	}

	@Override
	@Transactional
	public DetalleProforma findById(Integer id) {
		return dao.findById(id).get();
	}

	@Override
	@Transactional
	public void delete(Integer id) {
		dao.deleteById(id);
		
	}

	@Override
	@Transactional
	public List<DetalleProforma> findAll() {
		return (List<DetalleProforma>)dao.findAll();
	}
	
}
