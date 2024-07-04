package models;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Pessoa {

    private String nome;
    private LocalDate nascimento;

    public Pessoa(String nome, LocalDate nascimento) {
        this.nome = nome;
        this.nascimento = nascimento;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public LocalDate getNascimento() {
        return nascimento;
    }

    public void setNascimento(LocalDate nascimento) {
        this.nascimento = nascimento;
    }
    
    @Override
    public String toString() {
        return "Pessoa{" +
                "nome='" + this.getNome() +
                ", nascimento=" + this.getNascimento().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")) +
                '}';
    }
    
}
