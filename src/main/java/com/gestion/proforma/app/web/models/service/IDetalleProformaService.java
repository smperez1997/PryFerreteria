package com.gestion.proforma.app.web.models.service;

import java.util.List;
import com.gestion.proforma.app.web.models.entities.DetalleProforma;

public interface IDetalleProformaService {
	public void save(DetalleProforma detalleProforma);
	public DetalleProforma findById(Integer id);
	public void delete(Integer id);
	public List<DetalleProforma> findAll();

}
