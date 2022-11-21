import java.io.FileNotFoundException;
import java.io.IOException;

public class SelectionSort {
	Leitor list = new Leitor();
	int[] Lista = list.getLista();

	public SelectionSort() throws FileNotFoundException, IOException {
		list.LerArq();
		long tempo_inicial = System.nanoTime();
		selectionSort(Lista);
		long tempo_final = System.nanoTime();
		System.out.print("SelectionSort: ");
		list.Mostrar();
		double seconds = (tempo_final - tempo_inicial) * 1e-9;
		System.out.printf("Tempo: %.9f segundos\n\n", seconds);
	}

	public void selectionSort(int[] vetor) {
		int posicaoMenor, aux;
		for (int i = 0; i < vetor.length; i++) {
			posicaoMenor = i;
			for (int j = i + 1; j < vetor.length; j++) {
				if (vetor[j] < vetor[posicaoMenor]) {
					posicaoMenor = j;
				}
			}
			aux = vetor[posicaoMenor];
			vetor[posicaoMenor] = vetor[i];
			vetor[i] = aux;
		}
	}
}
