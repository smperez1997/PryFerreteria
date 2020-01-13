package com.gestion.proforma.app.web.models.service;

import java.util.List;

import  com.gestion.proforma.app.web.models.entities.Pais;

public interface IPaisService {

	public void save(Pais pais);
	public Pais findById(Integer id);
	public void delete(Integer id);
	public List<Pais> findAll();
}
