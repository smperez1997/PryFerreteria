package com.gestion.proforma.app.web.models.dao;

import org.springframework.data.repository.CrudRepository;

import com.gestion.proforma.app.web.models.entities.DetalleProforma;

public interface IDetalleProforma  extends CrudRepository<DetalleProforma, Integer>  {

}
