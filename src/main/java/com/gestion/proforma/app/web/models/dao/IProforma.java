package com.gestion.proforma.app.web.models.dao;

import org.springframework.data.repository.CrudRepository;

import com.gestion.proforma.app.web.models.entities.Proforma;

public interface IProforma extends CrudRepository<Proforma, Integer> {

}
