import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Leitor {
	int tamanho = 10000;
	int Lista[] = new int[tamanho];

	public void LerArq() throws FileNotFoundException, IOException {
		FileReader arq = new FileReader(getTamanho() + "_numbers.txt");
		BufferedReader lerArq = new BufferedReader(arq);
		String linha = lerArq.readLine();

		int lin = 0;

		while (linha != null) {
			linha = linha.trim();

			linha = linha.replace(" ", ";");
			linha = linha.replace(";;", ";");

			String[] a = linha.split(";");

			for (int coluna = 0; coluna < a.length; coluna++) {
				Lista[lin] = Integer.parseInt(a[coluna]);
			}

			lin = lin + 1;
			linha = lerArq.readLine();
		}

		arq.close();
	}
	
	public int getTamanho() {
		return tamanho;
	}

	public void setTamanho(int tamanho) {
		this.tamanho = tamanho;
	}

	public int[] getLista() {
		return Lista;
	}

	public void setLista(int[] lista) {
		Lista = lista;
	}
	
	public void Mostrar() {
		for (int i = 0; i < getTamanho(); i++)
			System.out.print(Lista[i] + " ");
		System.out.println();
	}
}

