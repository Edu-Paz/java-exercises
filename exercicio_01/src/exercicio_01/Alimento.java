package exercicio_01;

import java.util.Date;

public class Alimento extends Produto {
	public Date validade;
	public String tipo;
	
	public Alimento (String nome, String descricao, double preco, Date validade, String tipo) {
		super(nome, descricao, preco);
		this.validade = validade;
		this.tipo = tipo;
	}

	public Date getValidade() {
		return validade;
	}

	public void setValidade(Date validade) {
		this.validade = validade;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
}
