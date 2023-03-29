import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.OptionalDouble;
import java.util.stream.Collectors;

public class ExemploCursos {
	public static void main(String[] args) {

		List<Curso> cursos = new ArrayList<Curso>();
		cursos.add(new Curso("Python", 45));
		cursos.add(new Curso("JavaScript", 150));
		cursos.add(new Curso("Java 8", 113));
		cursos.add(new Curso("C", 55));
		
		cursos.sort(Comparator.comparing(Curso::getAlunos));
//		cursos.forEach(c -> System.out.println(c.getNome()));
		
		//Quero imprimir todos cursos que tem mais de 100alunos
//		cursos.stream().filter(c -> c.getAlunos() >=100)
//		.map(c -> c.getAlunos())
//		.forEach(t -> System.out.println(t));
		
		//Comentei o código acima para fazer agr com o method reference
//		int sum =cursos.stream().filter(c -> c.getAlunos() >=100)
//		.mapToInt(Curso::getAlunos)
//		.sum();
		
//		System.out.println(sum);
		
//		Optional<Curso> optionalCurso = cursos.stream().filter(c -> c.getAlunos() >= 100).findAny();
//		
//		optionalCurso.ifPresent(c -> System.out.println(c.getNome())); //Se existir faça
		
		//forma mais adequada de escrever o cód acima, optional importante para não tomarmos exception caso não encontre nenhum curso
		cursos.stream()
		.filter(c -> c.getAlunos() >= 100)
		.findAny()
		.ifPresent(c -> System.out.println(c.getNome()));; //ifPresente da api optional
		
		 OptionalDouble average = cursos.stream().filter(c -> c.getAlunos() >=100)
		.mapToInt(Curso::getAlunos)
		.average(); //ao invés da soma colocarmos a média de dermos um ctrl1 da OptionalDouble average pq se der zero pode dar erro optional te ajuda a evitar
		 
		 
		 cursos = cursos.stream() // ou List<Curso> resultado = cursos.stream()
		 .filter(c -> c.getAlunos() >= 100)
		 .collect(Collectors.toList()); //forma de tranformar o result de uma stream em uma collection
		 
		 cursos.stream()
		 	.filter(c -> c.getAlunos() >= 100)
		 	.collect(Collectors.toMap(
		 			c -> c.getNome(),
		 			c -> c.getAlunos()))
		 	.forEach((nome, alunos) -> System.out.println(nome + " tem " + alunos + " alunos"));
	}
}
