package com.gestion.proforma.app.web.models.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
 
import com.gestion.proforma.app.web.models.dao.IProforma;
import com.gestion.proforma.app.web.models.entities.Proforma;

@Service
public class ProformaService implements IProformaService{

	@Autowired
	private IProforma dao;
	@Override
	@Transactional
	public void save(Proforma proforma) {
		dao.save(proforma);
	}

	@Override
	@Transactional
	public Proforma findById(Integer id) {
		return dao.findById(id).get();
	}

	@Override
	@Transactional
	public void delete(Integer id) {
		dao.deleteById(id);
		
	}

	@Override
	@Transactional
	public List<Proforma> findAll() {
		return (List<Proforma>)dao.findAll();
	}
	
}
