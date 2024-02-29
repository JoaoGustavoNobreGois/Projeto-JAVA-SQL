package application;

import java.util.Date;
import java.util.List;
import java.util.Scanner;

import model.dao.FabricaDao;
import model.dao.VendedorDao;
import model.entities.Departamento;
import model.entities.Vendedor;

public class Program {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		VendedorDao vendedorDao = FabricaDao.criarVendedorDao();
		
		System.out.println("=== TESTE 1: achar os vendedores por Id ===");
		Vendedor vendedor = vendedorDao.acharPorId(3);
		System.out.println(vendedor);
		
		System.out.println("=== TESTE 2: achar os vendedores por departamento ===");
		Departamento departamento = new Departamento(2, null);
		List<Vendedor> list = vendedorDao.acharPorDepartamento(departamento);
		for(Vendedor obj : list) {
			System.out.println(obj);
		}
		
		System.out.println("=== TESTE 3: achar todos os vendedores ===");
		list = vendedorDao.acharTodos();
		for(Vendedor obj : list) {
			System.out.println(obj);
		}
		
		System.out.println("=== TESTE 4: inserir vendedor ===");
		Vendedor newVendedor = new Vendedor(null, "Greg", "greg@gmail.com", new Date(), 4000.0, departamento);
		vendedorDao.inserir(newVendedor);
		System.out.println("Inserido! Novo Id = " + newVendedor.getId());
		
		System.out.println("=== TESTE 5: atualizar vendedor ===");
		vendedor = vendedorDao.acharPorId(1);
		vendedor.setNome("Martha Waine");
		vendedorDao.atualizar(vendedor);
		System.out.println("Atualização completa!");
		
		System.out.println("=== TESTE 6: deletar vendedor ===");
		System.out.println("Digite um Id para ser deletado: ");
		int id = sc.nextInt();
		vendedorDao.deletarPorId(id);
		System.out.println("Deletado com sucesso!");
		
		
		sc.close();
	}

}
