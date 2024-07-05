package main;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import models.Funcionario;
import models.ListaFuncionarios;
import excep.ListaVaziaException;
import excep.MesInvalidoExeption;

public class Uttils {

	private Map<String, Funcionario> listaFuncionarios;
	private Map<String, ListaFuncionarios> listaFuncionariosPorFuncao;
	private DecimalFormat decFormat;
	
	public Uttils() {
		this.listaFuncionariosPorFuncao = new HashMap<>();
		this.listaFuncionarios = new HashMap<>();
		 this.decFormat = new DecimalFormat("#,###,##0.00");
	}
	
	
	
	private void concatenaListas() {
		this.listaFuncionarios.clear();
		for(ListaFuncionarios listadefuncionarios: this.listaFuncionariosPorFuncao.values()) {
			for(Funcionario funcionario: listadefuncionarios.list.values()) {
				this.listaFuncionarios.put(funcionario.getNome(), funcionario);
			}
		}
		
	}
	
	
	public void insertFuncionario(Funcionario funcionario) {

		
		if(!this.listaFuncionariosPorFuncao.containsKey(funcionario.getFuncao())) {
			ListaFuncionarios tempList = new ListaFuncionarios();
			tempList.list.put(funcionario.getNome(), funcionario);
			this.listaFuncionariosPorFuncao.put(funcionario.getFuncao(),tempList);
		}
		else {
			this.listaFuncionariosPorFuncao.get(funcionario.getFuncao()).list.put(funcionario.getNome(), funcionario);
		}
		
	}
	
	public void removeFuncionario(Funcionario funcionario) {
		this.listaFuncionariosPorFuncao.get(funcionario.getFuncao()).list.remove(funcionario.getNome());
	}
	
	public String getAllFuncionariosByString() {
		concatenaListas();
		StringBuilder listaFuncionariosString = new StringBuilder();
		for(Funcionario funcionario : this.listaFuncionarios.values()){
			listaFuncionariosString.append(funcionario.toString()+"\n");
		}
		return listaFuncionariosString.toString();
	}
	
	public void aumentarSalarioAll(BigDecimal aumento) {
		concatenaListas();
		for(Funcionario funcionario : this.listaFuncionarios.values()){
			BigDecimal novoSalario = funcionario.getSalario().multiply(aumento);
			funcionario.setSalario(novoSalario);
		}
	}
	
	public void aumentarSalario(Funcionario funcionario, BigDecimal aumento) {
		concatenaListas();
		BigDecimal novoSalario = funcionario.getSalario().multiply(aumento);
		this.listaFuncionariosPorFuncao.get(funcionario.getFuncao()).list.get(funcionario.getNome()).setSalario(novoSalario);
	}
	
	public String getFuncionariosAniversarioByString(int mes) throws MesInvalidoExeption {

		if ((mes < 1) || (mes > 12)){
				throw new MesInvalidoExeption("mês inválido");
			}

		concatenaListas();
		StringBuilder listaFuncionariosString = new StringBuilder();
		for(Funcionario funcionario : this.listaFuncionarios.values()){
			
			if(funcionario.getNascimento().getMonthValue() == mes) {
				listaFuncionariosString.append(funcionario.toString()+"\n");
			}
		}
		return listaFuncionariosString.toString();
	}
	
	public String getFuncionarioMaisVelhoByString() {
		concatenaListas();
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
		LocalDate dataAtual = LocalDate.now();
		int idade = Period.between(funcionarioComparado.getNascimento(), dataAtual).getYears();
		
		return FuncionarioString.append("Funcionario - Nome: "+ funcionarioComparado.getNome()+", Idade: "+idade).toString();
	}
	
	
	public String getFuncionariosAlfabeticamenteByString() {
		concatenaListas();
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
	
	public String getTotalSalariosByString() {
		concatenaListas();
		BigDecimal salario = new BigDecimal(0.0);
		
		for(Funcionario funcionario : this.listaFuncionarios.values()) {
			salario = salario.add(funcionario.getSalario());
		}
		return this.decFormat.format(salario);
	}
	
	public String getSalarioComparado(BigDecimal salarioMinimo) {
		concatenaListas();
		StringBuilder listaFuncionariosString = new StringBuilder();
		BigDecimal resto;
		BigDecimal multiplicador;
		for(Funcionario funcionario : this.listaFuncionarios.values()) {
			
			multiplicador = funcionario.getSalario().divideToIntegralValue(salarioMinimo);
			resto =  funcionario.getSalario().subtract(salarioMinimo.multiply(multiplicador));
			
			listaFuncionariosString.append(funcionario.toString()
					+" ganha "+ multiplicador.intValue()
					+ " salarios Minimos mais "+ this.decFormat.format(resto)+"\n");
		}
		
		return listaFuncionariosString.toString();
		
	}
	
	
	public String getFuncionariosPorFuncao(String funcao) throws ListaVaziaException {
		StringBuilder listaFuncionariosString = new StringBuilder();
		ListaFuncionarios listaFuncionarios = this.listaFuncionariosPorFuncao.get(funcao);
		
		if(listaFuncionarios == null) {
			throw new ListaVaziaException("Lista de funcionarios não contem esta função");
		}
		
		for(Funcionario funcionarios : listaFuncionarios.list.values()) {
			listaFuncionariosString.append(funcionarios.toString()+"\n");
		}
		
		return listaFuncionariosString.toString();
			
	}



	

	
	

	
	
	
	
	
	
}
