import java.io.FileNotFoundException;
import java.io.IOException;

public class BinaryInsertionSort {

	Leitor list = new Leitor();
	int[] Lista = list.getLista();

	public BinaryInsertionSort() throws FileNotFoundException, IOException {
		list.LerArq();
		long tempo_inicial = System.nanoTime();
		binarySort(Lista);
		long tempo_final = System.nanoTime();
		System.out.print("BinaryInsertinoSort: ");
		list.Mostrar();
		double seconds = (tempo_final - tempo_inicial) * 1e-9;
		System.out.printf("Tempo: %.9f segundos\n\n", seconds);
	}

	public void binarySort(int[] list) { 
		int i, loc, j, selected;

		for (i = 1; i < list.length; ++i) {
			j = i - 1;
			selected = list[i];

			loc = buscaBinaria(list, selected, 0, j);

			while (j >= loc) {
				list[j + 1] = list[j];
				j--;
			}
			list[j + 1] = selected;
		}
	}

	public int buscaBinaria(int list[], int elem, int inicio, int fim) {
		while (inicio <= fim) {
			int mid = inicio + (fim - inicio) / 2;
			if (elem == list[mid])
				return mid + 1;
			else if (elem > list[mid])
				inicio = mid + 1;
			else
				fim = mid - 1;
		}

		return inicio;
	}

}
