package estacionamento_copia;


public class Motorista {
	
	private String nome;
	private String cpf;
	
	
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	
	@Override
	public String toString() {
		return ("NOME: " + this.nome
				+ "  CPF: " + this.cpf);
	}

}
