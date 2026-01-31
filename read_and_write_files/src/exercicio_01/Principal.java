package exercicio_01;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Principal {

	public static void main(String[] args) {				
		Produto[] listaDeProdutos = new Produto[21];
		Estoque estoque = new Estoque(listaDeProdutos);
		
		String arquivo = Teclado.leString("Digite o nome do arquivo: ");
		
		estoque.preencheEstoque(arquivo);
		
		double alimentoMaisCaro = 0;
		String nomeDoAlimento = null;
		
		double eletroBarato = 100000;
		String nomeDoEletro = null;
		
		String[] nomes = new String[estoque.produto.length];
		int iVest = 0;
		int[] quant = new int[estoque.produto.length];
	
		for (int i = 0; i < estoque.produto.length ; i++) {
		    if (estoque.produto[i] == null) continue; 
			if (estoque.produto[i] instanceof Alimento) {
				if(estoque.produto[i].getPreco() > alimentoMaisCaro) {
					alimentoMaisCaro = estoque.produto[i].getPreco();
					nomeDoAlimento = estoque.produto[i].getNome();
				}
			}
			if (estoque.produto[i] instanceof Eletrodomestico) {
				if(estoque.produto[i].getPreco() < eletroBarato) {
					eletroBarato = estoque.produto[i].getPreco();
					nomeDoEletro = estoque.produto[i].getNome();
				}
			}
			if (estoque.produto[i] instanceof Vestuario) {
			    Vestuario v = (Vestuario) estoque.produto[i]; 
				
				nomes[iVest] = v.getNome();
				quant[iVest] = v.getQuantidade();
				iVest++;
			}
		}
		System.out.println("O alimento mais caro é " + nomeDoAlimento + " custando R$" + alimentoMaisCaro);
		System.out.println("O eletrodoméstico mais barato é " + nomeDoEletro + " custando R$" + eletroBarato);
		for(int i = 0; i < nomes.length; i++) {
			if(nomes[i] != null) {
				System.out.println(nomes[i]);
			}
		}

		try(BufferedWriter bw = new BufferedWriter(new FileWriter("info.txt"))){
			bw.write("a) Alimento mais caro: " + nomeDoAlimento);
			bw.newLine();
			bw.write("b) ELetrodoméstico mais caro: " + nomeDoEletro);
			bw.newLine();
			for(int i = 0; i < nomes.length; i++) {
				if(nomes[i] != null) {
					bw.write("- " + nomes[i] + " Quantidade: " + quant[i] );
					bw.newLine();
				}
			}		
			System.out.println("Relatório gerado!");
		}catch(IOException e) {
			System.err.println("Erro ao salvar o arquivo: " + e.getMessage());
		}
	}

}
