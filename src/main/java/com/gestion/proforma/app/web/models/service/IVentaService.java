package com.gestion.proforma.app.web.models.service;

import java.util.List;

import com.gestion.proforma.app.web.models.entities.Venta;

public interface IVentaService {
	public void save(Venta venta);
	
	public Venta findById(Integer id);
	
	public void delete(Integer id);
	
	public List<Venta> findAll();
}
