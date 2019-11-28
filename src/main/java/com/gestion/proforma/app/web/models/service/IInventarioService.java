package com.gestion.proforma.app.web.models.service;

import java.util.List;

import com.gestion.proforma.app.web.models.entities.Inventario;

public interface IInventarioService {
	public void save(Inventario inventario);
	
	public Inventario findById(Integer id);
	
	public void delete(Integer id);
	
	public List<Inventario> findAll();
}
