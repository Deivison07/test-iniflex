package main;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import models.Funcionario;

public class App {
	
	public static void run1() {
	
		DateTimeFormatter formater =  DateTimeFormatter.ofPattern("dd/MM/yyyy");
		Uttils ferramenta = new Uttils();
		
		Funcionario marla = new Funcionario("Marla", LocalDate.parse("18/10/2000",formater), new BigDecimal(2009.44), "Operador");
		Funcionario joao = new Funcionario("joao", LocalDate.parse("12/05/1990",formater), new BigDecimal(2284.38), "Operador");
		Funcionario caio = new Funcionario("Caio", LocalDate.parse("02/05/1961",formater), new BigDecimal(9836.14), "Coordenador");
		Funcionario miguel = new Funcionario("Miguel", LocalDate.parse("14/10/1988",formater), new BigDecimal(19119.88), "Diretor");
		Funcionario alice = new Funcionario("Alice", LocalDate.parse("05/01/1995",formater), new BigDecimal(2234.68), "Recepcionista");
		Funcionario heitor = new Funcionario("Heitor", LocalDate.parse("19/11/1999",formater), new BigDecimal(1582.72), "Operador");
		Funcionario arthur = new Funcionario("Arthur", LocalDate.parse("31/03/1993",formater), new BigDecimal(4071.84), "Contador");
		Funcionario laura = new Funcionario("Laura", LocalDate.parse("31/03/1993",formater), new BigDecimal(3017.45), "Gerente");
		Funcionario heloisa = new Funcionario("Heloisa", LocalDate.parse("24/05/2003",formater), new BigDecimal(1606.85), "Eletricista");
		Funcionario lelena = new Funcionario("Laura", LocalDate.parse("02/09/1996",formater), new BigDecimal(2799.93), "Gerente");
		
	
		ferramenta.insertFuncionario(joao);
		ferramenta.insertFuncionario(marla);
		ferramenta.insertFuncionario(caio);
		ferramenta.insertFuncionario(miguel);
		ferramenta.insertFuncionario(alice);
		ferramenta.insertFuncionario(heitor);
		ferramenta.insertFuncionario(arthur);
		ferramenta.insertFuncionario(laura);
		ferramenta.insertFuncionario(heloisa);
		ferramenta.insertFuncionario(lelena);
		
		System.out.println("Lista de Funcionarios por Ordem Alfabetica".toUpperCase());
		System.out.println(ferramenta.getFuncionariosAlfabeticamenteByString());
		
		
		
		
	}
		

	public static void main(String[] args) {
		run1();
	}

}
