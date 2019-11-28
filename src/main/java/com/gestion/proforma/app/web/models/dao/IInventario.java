package com.gestion.proforma.app.web.models.dao;

import org.springframework.data.repository.CrudRepository;

import com.gestion.proforma.app.web.models.entities.Inventario;

public interface IInventario  extends CrudRepository<Inventario , Integer> {

}
