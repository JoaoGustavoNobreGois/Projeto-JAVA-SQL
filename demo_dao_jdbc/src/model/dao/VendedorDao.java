package model.dao;

import java.util.List;

import model.entities.Departamento;
import model.entities.Vendedor;

public interface VendedorDao {
	
	void inserir(Vendedor obj);
	void atualizar(Vendedor obj);
	void deletarPorId(Integer id);
	Vendedor acharPorId(Integer id);
	List<Vendedor> acharTodos();
	List<Vendedor> acharPorDepartamento(Departamento departamento);
}
