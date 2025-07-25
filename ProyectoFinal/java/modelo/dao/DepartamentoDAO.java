package modelo.dao;

import java.util.List;

import modelo.entities.Departamento;

public interface DepartamentoDAO {

	public List<Departamento> getAll();
	public Departamento getById(int id);
}
