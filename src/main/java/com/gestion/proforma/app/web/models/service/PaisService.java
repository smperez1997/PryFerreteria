package com.gestion.proforma.app.web.models.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gestion.proforma.app.web.models.dao.IPais;
import com.gestion.proforma.app.web.models.entities.Pais;

@Service
public class PaisService implements IPaisService {

	@Autowired 
	private  IPais dao;
	
	@Override
	@Transactional
	public void save(Pais pais) {
		dao.save(pais);	
	}
	
	@Override
	//@Transactional(readOnly=true)
	@Transactional(readOnly=true)
	public Pais findById(Integer id) {
		return dao.findById(id).get();
	}
	
	@Override
	@Transactional
	public void delete(Integer id) {
		dao.deleteById(id);
	}

	@Override
	@Transactional(readOnly=true)
	public List<Pais> findAll() {
		return (List<Pais>)dao.findAll();
	}
	
	
}
