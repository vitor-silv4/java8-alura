import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class OrdenaStrings {

	public static void main(String[] args) {

		List<String> palavras = new ArrayList<>();
		palavras.add("Alura online");
		palavras.add("Editora casa do codigo");
		palavras.add("Caelum");

//		Collections.sort(palavras, comparador);
//		palavras.sort((s1, s2) -> {
//				if (s1.length() < s2.length())
//					return -1;
//				if (s1.length() > s2.length())
//					return 1;
//				return 0;
//			});
		// Mesma coisa da implementação acima agr em lambda
//		palavras.sort((s1, s2) -> Integer.compare(s1.length(), s2.length()));
		
		//Mesma implementação de cima agr com a método da Comparator
//		palavras.sort(Comparator.comparing(s -> s.length()));
		palavras.sort(Comparator.comparing(String::length)); //compara com método length de string
//		System.out.println(palavras);

//		for (String p : palavras) {
//			System.out.println(p);
//		}

		palavras.forEach(p -> System.out.println(p));
		palavras.forEach(System.out::println); //Mesma coisa que acima
	}
}
