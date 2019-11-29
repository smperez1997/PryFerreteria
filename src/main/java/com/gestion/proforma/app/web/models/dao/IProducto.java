package com.gestion.proforma.app.web.models.dao;

import org.springframework.data.repository.CrudRepository;
 

import com.gestion.proforma.app.web.models.entities.Producto;

public interface IProducto  extends CrudRepository<Producto, Integer> {

}
