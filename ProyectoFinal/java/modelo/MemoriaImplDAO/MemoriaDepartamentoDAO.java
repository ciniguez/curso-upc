package modelo.MemoriaImplDAO;

import java.util.ArrayList;
import java.util.List;

import modelo.dao.DepartamentoDAO;
import modelo.entities.Departamento;

public class MemoriaDepartamentoDAO implements DepartamentoDAO {

	private static List<Departamento> departamentos= null;
	
	@Override
	public List<Departamento> getAll() {
		if(departamentos == null) {
			departamentos = new ArrayList<Departamento>();
			
			departamentos.add(new Departamento(1, "Contabilidad"));
			departamentos.add(new Departamento(2, "Jurídico"));
		}
		return departamentos;
	}
	@Override
	public Departamento getById(int id) {
		for( Departamento d : this.getAll()) {
			if(d.getId()== id)
				return d;
		}
		return null;
	}

}
