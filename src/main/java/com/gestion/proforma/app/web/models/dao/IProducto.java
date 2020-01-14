package com.gestion.proforma.app.web.models.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
 
import com.gestion.proforma.app.web.models.entities.Producto;

public interface IProducto  extends CrudRepository<Producto, Integer> {
 
	
}
