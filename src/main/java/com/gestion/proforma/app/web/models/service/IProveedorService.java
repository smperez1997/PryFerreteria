package com.gestion.proforma.app.web.models.service;

import java.util.List;

import com.gestion.proforma.app.web.models.entities.Proveedor;

public interface IProveedorService {
	public void save(Proveedor proveedor);
	
	public Proveedor findById(Integer id);
	
	public void delete(Integer id);
	
	public List<Proveedor> findAll();	
}
