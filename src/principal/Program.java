package principal;

import controllers.PessoaController;

public class Program {

	public static void main(String[] args) {

		// Instanciar o controlador:
		PessoaController pessoaController = new PessoaController();
		pessoaController.cadastrarPessoa();

	}

}
