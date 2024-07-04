package main;

import java.math.BigDecimal;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import models.Funcionario;

public class Uttils {

	private Map<String, Funcionario> listaFuncionarios;
	
	public Uttils() {
		this.listaFuncionarios = new HashMap<>();
	}
	
	public void insertFuncionario(Funcionario funcionario) {
		this.listaFuncionarios.put(funcionario.getNome(), funcionario);
	}
	
	public void removeFuncionario(String nome) {
		this.listaFuncionarios.remove(nome);
	}
	
	public String getAllFuncionariosByString() {
		StringBuilder listaFuncionariosString = new StringBuilder();
		for(Funcionario funcionario : this.listaFuncionarios.values()){
			listaFuncionariosString.append(funcionario.toString()+"\n");
		}
		return listaFuncionariosString.toString();
	}
	
	public void aumentarSalarioAll(BigDecimal aumento) {
		for(Funcionario funcionario : this.listaFuncionarios.values()){
			BigDecimal novoSalario = funcionario.getSalario().multiply(aumento);
			funcionario.setSalario(novoSalario);
		}
	}
	
	public void aumentarSalario(String nome, BigDecimal aumento) {
		Funcionario funcionario =  this.listaFuncionarios.get(nome);
		BigDecimal novoSalario = funcionario.getSalario().multiply(aumento);
		funcionario.setSalario(novoSalario);
	}
	
	public String getFuncionariosAniversarioByString(int mes) {
		StringBuilder listaFuncionariosString = new StringBuilder();
		for(Funcionario funcionario : this.listaFuncionarios.values()){
			
			if(funcionario.getNascimento().getMonthValue() == mes) {
				listaFuncionariosString.append(funcionario.toString()+"\n");
			}
		}
		return listaFuncionariosString.toString();
	}
	
	public String getFuncionarioMaisVelhoByString() {
		StringBuilder FuncionarioString = new StringBuilder();
		Funcionario funcionarioComparado = null;
		
		for(Funcionario funcionario : this.listaFuncionarios.values()) {
			funcionarioComparado = funcionario;
			break;
		}
		
		for(Funcionario funcionario : this.listaFuncionarios.values()){
			
			if(funcionario.getNascimento().isBefore(funcionarioComparado.getNascimento())) {
				funcionarioComparado = funcionario;
			}
		}
		
		return FuncionarioString.append("Funcionario - Nome: "+ funcionarioComparado.getNome()+
										" Idade: "+funcionarioComparado.getNascimento().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"))).toString();
	}
	
	
	public String getFuncionariosAlfabeticamenteByString() {
		StringBuilder listaFuncionariosString = new StringBuilder();
		ArrayList<Funcionario> funcionariosList = new ArrayList<>();
		
		for(Funcionario funcionario : this.listaFuncionarios.values()) {
			funcionariosList.add(funcionario);
		}
		
		funcionariosList.sort(Comparator.comparing(Funcionario::getNome));
		
		for(Funcionario funcionario : funcionariosList) {
			listaFuncionariosString.append(funcionario.toString()+"\n");
		}
		
		return listaFuncionariosString.toString();
		
	}
	

	
	

	
	
	
	
	
	
}
