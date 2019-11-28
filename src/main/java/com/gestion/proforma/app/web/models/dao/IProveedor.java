package com.gestion.proforma.app.web.models.dao;

import org.springframework.data.repository.CrudRepository;

import com.gestion.proforma.app.web.models.entities.Proveedor;

public interface IProveedor  extends CrudRepository<Proveedor, Integer> {

}
