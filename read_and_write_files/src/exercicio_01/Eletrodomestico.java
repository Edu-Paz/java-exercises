package exercicio_01;

public class Eletrodomestico extends Produto {
	public double ipi;
	public String tipo;
	
	public Eletrodomestico(String nome, String descricao, double preco, double ipi, String tipo) {
		super(nome, descricao, preco);
		this.ipi = ipi;
		this.tipo = tipo;
	}

	public double getIpi() {
		return ipi;
	}

	public void setIpi(double ipi) {
		this.ipi = ipi;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
}
