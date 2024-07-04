package models;

import java.text.DecimalFormat;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Funcionario extends Pessoa implements iFuncionario {
    
	private BigDecimal salario;
	private String funcao;
	private DecimalFormat decFormat = new DecimalFormat("#,###,##0.00");

	public Funcionario( String nome, LocalDate nascimento, BigDecimal d, String funcao) {
		
		super(nome, nascimento);
		this.salario = d;
		this.funcao = funcao;
	}

	public BigDecimal getSalario() {
		return salario;
	}

	public void setSalario(BigDecimal salario) {
		this.salario = salario;
	}

	public String getFuncao() {
		return funcao;
	}

	public void setFuncao(String funcao) {
		this.funcao = funcao;
	}
	
    @Override
    public String toString() {
        return "Funcionario{" +
                "Nome='" + this.getNome() +
                ", Nascimento=" + this.getNascimento().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")) +
                ", Salário= "+ this.decFormat.format(this.getSalario()) +
                ", Função= "+  this.getFuncao() +
                '}';
    }
	

	
	
	
	
}
