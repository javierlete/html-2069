package basico;

public class ConversionesEntrePrimitivos {
	public static void main(String[] args) {
		int i = 5;

		double d = i;

		System.out.println(d);

		d = 5.5;

		i = (int) d;

		System.out.println(i);

		i = (int) Math.round(d);

		System.out.println(i);
	}
}
