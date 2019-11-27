package com.gestion.proforma.app.web.models.dao;

import org.springframework.data.repository.CrudRepository;

import com.gestion.proforma.app.web.models.entities.Factura;

public interface IFactura extends CrudRepository<Factura, Integer> {

}
