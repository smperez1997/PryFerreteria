package com.gestion.proforma.app.web.models.service;

import java.util.List;
import com.gestion.proforma.app.web.models.entities.Producto;

public interface IProductoService {
	public void save(Producto producto);
	public Producto findById(Integer id);
	public void delete(Integer id);
	public List<Producto> findAll();
}
