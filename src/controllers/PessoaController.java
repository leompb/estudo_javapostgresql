package controllers;

import java.util.List;
import java.util.Scanner;

import entities.Pessoa;
import repositories.PessoaRepository;

public class PessoaController {

	private Scanner scanner = new Scanner(System.in);

	// Método para realizar o cadastro de pessoa no sistema:
	public void cadastrarPessoa() {

		try {

			System.out.println("\n *** CADASTRO DE PESSOA *** \n");

			Pessoa pessoa = new Pessoa();

			System.out.println("Informe o nome da pessoa....:");
			pessoa.setNome(scanner.nextLine());

			System.out.println("Informe o CPF da pessoa.....:");
			pessoa.setCpf(scanner.nextLine());

			System.out.println("Informe o e-mail da pessoa..:");
			pessoa.setEmail(scanner.nextLine());

			// Gravar no banco de dados:
			PessoaRepository pessoaRepository = new PessoaRepository();
			pessoa.setIdPessoa(pessoaRepository.create(pessoa));

			System.out.println("\nPessoa cadastrada com sucesso.");
			System.out.println("IdPessoa = " + pessoa.getIdPessoa());

		} catch (Exception e) {
			System.out.println("\nErro: " + e.getMessage());
		} finally {
			//scanner.close();
		}
	}

	// Método para atualizar o cadastro de uma pessoa:
	public void atualizarPessoa() {

		try {

			System.out.println("\n *** ATUALIZAÇÃO DE PESSOA *** \n");

			System.out.print("Informe o id da pessoa.......: ");
			Integer id = Integer.parseInt(scanner.nextLine());

			// consultando no banco de dados a pessoa através do id
			PessoaRepository pessoaRepository = new PessoaRepository();
			Pessoa pessoa = pessoaRepository.findById(id);

			// verificar se pessoa foi encontrado
			if (pessoa != null) {

				System.out.print("Informe o nome da pessoa.....: ");
				pessoa.setNome(scanner.nextLine());

				System.out.print("Informe o cpf da pessoa......: ");
				pessoa.setCpf(scanner.nextLine());

				System.out.print("Informe o email da pessoa....: ");
				pessoa.setEmail(scanner.nextLine());

				// atualizando no banco de dados
				pessoaRepository.update(pessoa);

				System.out.println("\nPessoa atualizada com sucesso.");
				
			} 
			
			else {
				System.out.println("\nPessoa não encontrada. ID inválido.");
			}
			
		} catch (IllegalArgumentException e) {
			System.out.println("\nErro de validação: " + e.getMessage());
		} catch (Exception e) {
			System.out.println("\nErro: " + e.getMessage());
		}

	}
	
	public void excluirPessoa() {
		
		try {
			
			System.out.println("\n *** EXCLUSÃO DE PESSOA *** \n");

			System.out.print("Informe o id da pessoa.......: ");
			Integer id = Integer.parseInt(scanner.nextLine());

			// consultando no banco de dados a pessoa através do id
			PessoaRepository pessoaRepository = new PessoaRepository();
			Pessoa pessoa = pessoaRepository.findById(id);

			//Verificar se a pessoa foi encontrada:
			if(pessoa != null) {
				
				// Excluindo pessoa do banco de dados:
				pessoaRepository.delete(pessoa.getIdPessoa());
				
				System.out.println("\nPessoa excluída com sucesso.");
			}
			else {
				System.out.println("\nPessoa não encontrada. Id inválido!");
			}
			
		} catch(Exception e) {
			System.out.println("\nErro: " + e.getMessage());
		}
	}
	
	public void consultarPessoas() {
		
		try {
			
			System.out.println("\n *** CONSULTA DE PESSOAS *** \n");
			
			PessoaRepository pessoaRepository = new PessoaRepository();
			List<Pessoa> lista = pessoaRepository.findAll();
			
			// Percorrendo e imprimindo os dados:
			for(Pessoa pessoa : lista) {
				
				System.out.println("ID da pessoa......: " + pessoa.getIdPessoa());
				System.out.println("Nome da pessoa....: " + pessoa.getNome());
				System.out.println("CPF da pessoa.....: " + pessoa.getCpf());
				System.out.println("E-mail da pessoa..: " + pessoa.getEmail());
				System.out.println("...");
							
			}			
			
		} catch(Exception e) {
			System.out.println("\nErro: " + e.getMessage());
		}
	}
}
