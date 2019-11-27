package com.gestion.proforma.app.web.models.service;

import java.util.List;
import com.gestion.proforma.app.web.models.entities.Empleado;

public interface IEmpleadoService {
	public void save(Empleado empleado);
	public Empleado findById(Integer id);
	public void delete(Integer id);
	public List<Empleado> findAll();
}
