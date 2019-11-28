package com.gestion.proforma.app.web.models.dao;

import org.springframework.data.repository.CrudRepository;

import com.gestion.proforma.app.web.models.entities.Venta;

public interface IVenta extends CrudRepository<Venta, Integer> {

}
