package com.gestion.proforma.app.web.models.dao;

import org.springframework.data.repository.CrudRepository;
 

import com.gestion.proforma.app.web.models.entities.ElementoCatalogo;

public interface IElementoCatalogo  extends CrudRepository<ElementoCatalogo, Integer> {

}
