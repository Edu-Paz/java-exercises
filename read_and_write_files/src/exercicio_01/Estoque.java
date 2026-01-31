package exercicio_01;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;



public class Estoque {
	public Produto[] produto;
	
	public Estoque (Produto[] produto) {
		this.produto = produto;
	}
	
	public void preencheEstoque (String arquivo) {
		try (BufferedReader br = new BufferedReader(new FileReader(arquivo))){
			SimpleDateFormat formatador = new SimpleDateFormat("dd/MM/yyyy");
			
			String linha;
			int n = 0;
			while((linha = br.readLine()) != null) {
				String partes[] = linha.split(" \\* ");
				
				String nome = partes[0];
				String desc = partes[1];
				double preco = Double.parseDouble(partes[2]);
				String tipo = partes[3];
				String extra = partes[4];
				
				if (tipo.equals("Alimento")) {
					Date validade = formatador.parse(extra);
					this.produto[n] = new Alimento(nome, desc, preco, validade, tipo);
				}
				if (tipo.equals("Eletrodomestico")) {
					double ipi = Double.parseDouble(extra);
					this.produto[n] = new Eletrodomestico(nome, desc, preco, ipi, tipo);
				}
				if (tipo.equals("Vestuario")) {
					int tamanho = Integer.parseInt(extra);
					this.produto[n] = new Vestuario(nome, desc, preco, tamanho, tipo);
				}
				n++;
			}
		}catch(FileNotFoundException e) {
			System.out.println("Arquivo não encontrado. Erro: " + e.getMessage());
		    System.out.println("O Java procurou aqui: " + new java.io.File(".").getAbsolutePath());
		}catch(IOException e) {
			System.out.println("Falha na leitura. Erro" + e.getMessage());
		}catch(NumberFormatException e) {
			System.out.println("Falha de formato numérico. Erro: " + e.getMessage());
		}catch(java.text.ParseException e) {
			System.out.println("Erro na data.");
		}
		System.out.println("Chegou ao fim");
	}

	public Produto[] getProduto() {
		return produto;
	}

	public void setProduto(Produto[] produto) {
		this.produto = produto;
	}
}
