package entities;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Pessoa {

	// Atributos (dados):
	private Integer idPessoa;
	private String nome;
	private String cpf;
	private String email;

	public Integer getIdPessoa() {
		return idPessoa;
	}

	public void setIdPessoa(Integer idPessoa) {

		if (idPessoa <= 0)
			throw new IllegalArgumentException("O id deve ser maior que zero.");

		this.idPessoa = idPessoa;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {

		if (nome == null)
			throw new IllegalArgumentException("O nome é obrigatório.");
		
		else if (nome.trim().length() < 6)
			throw new IllegalArgumentException("O nome deve conter no mínimo 6 caracteres.");
		
		else if (nome.trim().length() > 150)
			throw new IllegalArgumentException("O nome deve conter no máximo 150 caracteres.");

		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {

		Pattern pattern = Pattern.compile("^[0-9]{11}$");
		Matcher matcher = pattern.matcher(cpf);

		if (!matcher.matches())
			throw new IllegalArgumentException("O CPF deve conter 11 dígitos numéricos.");

		this.cpf = cpf;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {

		if (email == null)
			throw new IllegalArgumentException("O e-mail é obrigatório.");
		
		else if (email.trim().length() < 10)
			throw new IllegalArgumentException("O e-mail deve conter no mínimo 6 caracteres.");
		
		else if (email.trim().length() > 100)
			throw new IllegalArgumentException("O e-mail deve conter no máximo 100 caracteres.");

		this.email = email;
	}

}
