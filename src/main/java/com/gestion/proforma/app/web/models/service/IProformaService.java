package com.gestion.proforma.app.web.models.service;

import java.util.List;
import com.gestion.proforma.app.web.models.entities.Proforma;

public interface IProformaService {
	public void save(Proforma proforma);
	public Proforma findById(Integer id);
	public void delete(Integer id);
	public List<Proforma> findAll();
}
