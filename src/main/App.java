package main;

import java.util.HashMap;
import java.util.Map;
import models.Funcionario;

public class App {

	private Map<String, Funcionario> listaFuncionarios;
	
	public App() {
		this.listaFuncionarios = new HashMap<>();
	}
	
	public void insertFuncionario(Funcionario funcionario) {
		this.listaFuncionarios.put(funcionario.getNome(), funcionario);
	}
	
	public void removeFuncionario(String nome) {
		this.listaFuncionarios.remove(nome);
	}
	
	public String getAllFuncionarios() {
		StringBuilder listaFuncionariosString = new StringBuilder();
		for(Funcionario funcionario : this.listaFuncionarios.values()){
			listaFuncionariosString.append(funcionario.toString());
		}
		return listaFuncionariosString.toString();
	}
	
	
	
}
