import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class UtilFile {

	/**
	 * Entrada esperada:
	 * 
	 * Arquivo onde cada linha representa uma aresta do grafo
	 * A primeira linha determina o número de usuários da rede social
	 * As linhas seguintes determinam uma relação de amizade entre dois usuários:
	 * 	os dois primeiros valores são os vértices, 
	 * 	o terceiro, o valor de friendship
	 *  e o quarto, a distância. 
	 * Todos os números devem ser inteiros, positivos e diferentes de zero
	 * O programa resolve várias instâncias do problema, então, cada rede deve ser separada por uma linha em branco
	 * 
	 * nuR1
	 * v1 v2 f1 d1
	 * v3 v4 f2 d2
	 * v5 v6 f3 d3
	 * v7 v8 f4 d4
	 * 
	 * nuR2
	 * v1 v2 f1 d1
	 * v3 v4 f2 d2
	 * v5 v6 f3 d3
	 * .
	 * .
	 * .
	 */
	public static boolean read(Control control, String fileName) {

		try {
			BufferedReader input = new BufferedReader(new FileReader(fileName));

			String line = input.readLine();
			List<String> lines = new ArrayList<>();
			Integer n = null;

			n = validateLength(line);
			if (n == null) {
				input.close();
				return false;
			}
			try {
				line = input.readLine();
				while (line != null) {
					if (isWhiteLine(line)) {
						control.newInstance(lines, n);
						lines = new ArrayList<>();
						
						n = validateLength(input.readLine());
						if (n == null) {//fim do arquivo
							input.close();
							return true;
						}
					} else {
						lines.add(line);
					}
					line = input.readLine();
				}

			} catch (Exception e) {
				input.close();
			}
			input.close();
			if (!lines.isEmpty() && n != null) {
				control.newInstance(lines, n);
			}
		} catch (Exception e) {
			Util.throwError(1);
			return false;
		}
		return true;
	}
	
	public static boolean readWithScanner(Control control) {

		try {
			Scanner scanner = new Scanner(new InputStreamReader(System.in));

			String line = scanner.nextLine();
			List<String> lines = new ArrayList<String>();
			Integer n = null;

			n = validateLength(line);
			if (n == null) {
				scanner.close();
				return false;
			}
			try {
				line = scanner.nextLine();
				while (scanner.hasNextLine()) {
					if (isWhiteLine(line)) {
						control.newInstance(lines, n);
						lines = new ArrayList<String>();
						
						n = validateLength(scanner.nextLine());
						if (n == null) {//fim do arquivo
							scanner.close();
							return true;
						}
					} else {
						lines.add(line);
					}
					line = scanner.nextLine();
				}
			} catch (Exception e) {
				scanner.close();
			}
			if (!lines.isEmpty() && n != null) {
				control.newInstance(lines, n);
			}
			scanner.close();
		} catch (Exception e) {
			Util.throwError(1);
			return false;
		}
		return true;
	}

	public static Integer[] readLine(String line, int n) {
		Integer[] result = new Integer[4];
		String[] values = line.split("\\s+");

		if (values.length < 4) {
			Util.throwError(0);
			return null;
		}

		result[0] = validateNode(values[0], n);
		result[1] = validateNode(values[1], n);
		result[2] = validateWeight(values[2]);
		result[3] = validateWeight(values[3]);

		if (result[0] == null || result[1] == null || result[2] == null
				|| result[3] == null) {
			return null;
		}

		return result;
	}

	private static Integer validateNode(String s, int n) {
		Integer i = Util.stringToInt(s);
		if (i == null) {
			Util.throwError(0);
			return null;
		}

		if (i < 1 || i > n) {
			Util.throwError(2);
			return null;
		}

		return i - 1;
	}

	private static Integer validateWeight(String s) {
		Integer i = Util.stringToInt(s);
		if (i == null) {
			Util.throwError(0);
			return null;
		}

		if (i < 1) {
			Util.throwError(2);
			return null;
		}

		return i;
	}

	private static Integer validateLength(String s) {
		if (s != null) {
			Integer i = Util.stringToInt(s);
			if (i != null && i > 1) {
				return i;
			}
		}
		Util.throwError(0);
		return null;
	}

	private static boolean isWhiteLine(String line) {
		return line.trim().isEmpty();
	}
}
