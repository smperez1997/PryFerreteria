package com.gestion.proforma.app.web.models.service;

import java.util.List;
import com.gestion.proforma.app.web.models.entities.ElementoCatalogo;

public interface IElementoCatalogoService {
	public void save(ElementoCatalogo elementoCatalogo);
	public ElementoCatalogo findById(Integer id);
	public void delete(Integer id);
	public List<ElementoCatalogo> findAll();
}
