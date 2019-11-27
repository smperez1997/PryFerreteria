package com.gestion.proforma.app.web.models.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

 
import com.gestion.proforma.app.web.models.dao.IEmpleado;
import com.gestion.proforma.app.web.models.entities.Empleado;

@Service
public class EmpleadoService implements IEmpleadoService{

	@Autowired
	private IEmpleado dao;
	
	@Override
	@Transactional
	public void save(Empleado empleado) {
		dao.save(empleado);
	}

	@Override
	@Transactional
	public Empleado findById(Integer id) {
		return dao.findById(id).get();
	}

	@Override
	@Transactional
	public void delete(Integer id) {
		dao.deleteById(id);
		
	}

	@Override
	@Transactional
	public List<Empleado> findAll() {
		return (List<Empleado>)dao.findAll();
	}
}
