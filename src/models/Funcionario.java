package models;

import java.util.Locale;
import java.text.NumberFormat;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Funcionario extends Pessoa implements iFuncionario {
    
	private BigDecimal salario;
	private String funcao;
	private NumberFormat formatoMoeda = NumberFormat.getCurrencyInstance(Locale.getDefault());

	public Funcionario( String nome, LocalDate nascimento, BigDecimal salario, String funcao) {
		
		super(nome, nascimento);
		this.salario = salario;
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
                "nome='" + this.getNome() + '\'' +
                ", nascimento=" + this.getNascimento().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")) + '\'' +
                ", Salário= "+ this.formatoMoeda.format(getSalario()) +
                ", função= "+  this.getFuncao() + '\'' +
                '}';
    }
	

	
	
	
	
}
