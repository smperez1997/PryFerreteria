package com.gestion.proforma.app.web.models.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.gestion.proforma.app.web.models.dao.IElementoCatalogo;
import com.gestion.proforma.app.web.models.entities.ElementoCatalogo;

@Service
public class ElementoCatalogoService implements IElementoCatalogoService{

	@Autowired
	private IElementoCatalogo dao;
	
	@Override
	@Transactional
	public void save(ElementoCatalogo elementoCatalogo) {
		dao.save(elementoCatalogo);
	}

	@Override
	@Transactional
	public ElementoCatalogo findById(Integer id) {
		return dao.findById(id).get();
	}

	@Override
	@Transactional
	public void delete(Integer id) {
		dao.deleteById(id);
		
	}

	@Override
	@Transactional
	public List<ElementoCatalogo> findAll() {
		return (List<ElementoCatalogo>)dao.findAll();
	}
	
}
