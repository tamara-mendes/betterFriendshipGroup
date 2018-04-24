public class Util {

	public static void throwError(int type) {
		switch (type) {
			case 0:
				System.out.println("Arquivo invalido");
				break;
			case 1:
				System.out.println("Arquivo nao encontrado");
				break;
			case 2:
				System.out.println("Valores invalidos");
				break;
			default:
				System.out.println("Ocorreu um erro");
				break;
		}
		System.out.println(-1000);
		System.exit(0);
	}

	public static Integer stringToInt(String s) {
		try {
			return Integer.parseInt(s);
		} catch (Exception e) {
			return null;
		}
	}
	
	public static double round(double number, int places) {
		number = number * Math.pow(10, places);
		number = Math.round(number);
		number = number / Math.pow(10, places);
		return number;
	}
	
	public static boolean doubleEquals(double value1, double value2) {
		double v1 = round(value1, 4);
		double v2 = round(value2, 4);
		return (v1 == v2);
	}
	
}
