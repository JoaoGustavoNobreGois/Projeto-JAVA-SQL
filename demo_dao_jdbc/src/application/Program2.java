package application;

import java.util.List;
import java.util.Scanner;

import model.dao.DepartamentoDao;
import model.dao.FabricaDao;
import model.entities.Departamento;

public class Program2 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		DepartamentoDao departamentoDao = FabricaDao.criarDepartamentoDao();
		
		System.out.println("=== TESTE 1: achar os departamentos por Id ===");
		Departamento dep = departamentoDao.acharPorId(1);
		System.out.println(dep);
		
		System.out.println("=== TESTE 2: achar todos os departamentos ===");
		List<Departamento>list = departamentoDao.acharTodos();
		for(Departamento d : list) {
			System.out.println(d);
		}
		
		System.out.println("=== TESTE 3: inserir departamento ===");
		Departamento newDep = new Departamento(null, "Musica");
		departamentoDao.inserir(newDep);
		System.out.println("Inserido! Novo Id: " + newDep.getId());
		
		System.out.println("=== TESTE 4: atualizar departamento ===");
		Departamento dep2 = departamentoDao.acharPorId(1);
		dep2.setName("Comida");
		departamentoDao.atualizar(dep2);
		System.out.println("Atualização completa");
		
		System.out.println("=== TESTE 5: deletar departamento ===");
		System.out.println("Digite um Id de departamento para ser deletado: ");
		int id = sc.nextInt();
		departamentoDao.deletarPorId(id);
		System.out.println("Deletado com sucesso!");
		
		
		sc.close();
	}

}
