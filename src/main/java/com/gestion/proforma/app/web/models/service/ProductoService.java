package com.gestion.proforma.app.web.models.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.gestion.proforma.app.web.models.dao.IProducto;
import com.gestion.proforma.app.web.models.entities.Producto;

@Service
public class ProductoService implements IProductoService{

	@Autowired
	private IProducto dao;
	
	@Override
	@Transactional
	public void save(Producto producto) {
		dao.save(producto);
	}

	@Override
	@Transactional
	public Producto findById(Integer id) {
		return dao.findById(id).get();
	}

	@Override
	@Transactional
	public void delete(Integer id) {
		dao.deleteById(id);
		
	}

	@Override
	@Transactional
	public List<Producto> findAll() {
		return (List<Producto>)dao.findAll();
	}
	
}
