package com.gestion.proforma.app.web.models.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
 
import com.gestion.proforma.app.web.models.dao.IDetalleFactura;
import com.gestion.proforma.app.web.models.entities.DetalleFactura;

@Service
public class DetalleFacturaService implements IDetalleFacturaService{

	@Autowired
	private IDetalleFactura dao;
	
	@Override
	@Transactional
	public void save(DetalleFactura detallefactura) {
		dao.save(detallefactura);
	}

	@Override
	@Transactional
	public DetalleFactura findById(Integer id) {
		return dao.findById(id).get();
	}

	@Override
	@Transactional
	public void delete(Integer id) {
		dao.deleteById(id);
		
	}

	@Override
	@Transactional
	public List<DetalleFactura> findAll() {
		return (List<DetalleFactura>)dao.findAll();
	}
	
}
