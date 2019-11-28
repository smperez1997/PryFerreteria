package com.gestion.proforma.app.web.models.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gestion.proforma.app.web.models.dao.IVenta;
import com.gestion.proforma.app.web.models.entities.Venta;

@Service
public class VentaService  implements IVentaService {
	@Autowired 
	private IVenta dao;
		
	@Override
	@Transactional
	public void save(Venta venta) {
		dao.save(venta);		
	}

	@Override
	@Transactional(readOnly=true)
	public Venta findById(Integer id) {		
		return dao.findById(id).get();
	}

	@Override
	@Transactional
	public void delete(Integer id) {
		dao.deleteById(id);		
	}

	@Override
	@Transactional(readOnly=true)
	public List<Venta> findAll() {
		return (List<Venta>) dao.findAll();
	}
}
