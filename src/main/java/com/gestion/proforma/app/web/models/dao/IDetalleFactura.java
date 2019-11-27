package com.gestion.proforma.app.web.models.dao;

import org.springframework.data.repository.CrudRepository;

import com.gestion.proforma.app.web.models.entities.DetalleFactura;

public interface IDetalleFactura  extends CrudRepository<DetalleFactura, Integer>  {

}
