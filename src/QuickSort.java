import java.io.FileNotFoundException;
import java.io.IOException;

public class QuickSort {
	Leitor list = new Leitor();
	int[] Lista = list.getLista();

	public QuickSort() throws FileNotFoundException, IOException {
		list.LerArq();
		long tempo_inicial = System.nanoTime();
		quickSort(0, list.getTamanho() - 1);
		long tempo_final = System.nanoTime();
		System.out.print("QuickSort: ");
		list.Mostrar();
		double seconds = (tempo_final - tempo_inicial) * 1e-9;
		System.out.printf("Tempo: %.9f segundos\n\n", seconds);
	}

	public void quickSort(int esq, int dir) {
		if (esq < dir) {
			int p = particao(Lista, esq, dir);
			quickSort(esq, p);
			quickSort(p + 1, dir);
		}
	}

	public int particao(int[] lista, int esq, int dir) {
		int meio = (int) (esq + dir) / 2;
		int pivot = lista[meio];
		int i = esq - 1;
		int j = dir + 1;
		while (true) {
			do {
				i++;
			} while (lista[i] < pivot);
			do {
				j--;
			} while (lista[j] > pivot);
			if (i >= j) {
				return j;
			}
			int aux = lista[i];
			lista[i] = lista[j];
			lista[j] = aux;
		}
	}

}
