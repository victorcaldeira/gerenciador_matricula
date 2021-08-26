package Implementação;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.stream.Collectors;
import Implementação.Disciplina.Disciplina;

public class Curso {
    private int id;
    private String nome;
    private int creditos;
    private LocalDate inicioMatricula;
    private LocalDate terminoMatricula;
    private static ArrayList<Disciplina> disciplinas;

    public Curso(String nome, int creditos, int id) {
        this.setNome(nome);
        this.setCreditos(creditos);
        this.setID(id);
    }

    public Curso(int id, String nome, int creditos, ArrayList<Disciplina> disciplinas) {
        this.setNome(nome);
        this.setCreditos(creditos);
        this.setID(id);
        this.disciplinas = disciplinas;
    }

    public String getNome() {
        return nome;
    }

    public int getCreditos() {
        return creditos;
    }

    public int getId() {
        return id;
    }

    public LocalDate getInicioMatricula() {
        return inicioMatricula;
    }

    public LocalDate getFimMatricula() {
        return terminoMatricula;
    }

    public static ArrayList<Disciplina> getDisciplinas() {
        return disciplinas;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setCreditos(int creditos) {
        this.creditos = creditos;
    }

    public void setID(int id) {
        this.id = id;
    }

    protected void setDisciplina(Disciplina disciplina) {
        this.disciplinas.add(disciplina);
    }

    public boolean inserirDisciplina(Disciplina disciplina) {
        return (disciplinas.add(disciplina));
    }

    // Eu acho que essa funç~]ao simplemente resolve o nosso ponto de criar disciplina
    public void definirPeriodoMatricula(LocalDate inicio, LocalDate termino) {
        if (inicio.compareTo(termino) <= 0) {
            inicioMatricula = inicio;
            terminoMatricula = termino;
        } else {
            // erro a data de inicio não pode ser posterior ao fim.
            System.out.println("Erro, Data de inicio não pode ser posterior ao fim");
        }
    }
    
    public void listarDisciplinas() {
        System.out.println("Disciplinas do curso de " + nome + ":");
        for (Disciplina disciplina : disciplinas) {
            System.out.println("- " + disciplina.getNome() + "\n");
        }
    }
    
    public String toCsv() {
        return (this.getNome() + ";" + this.getCreditos() + ";" + this.getId() + ";" + this.getInicioMatricula() + ";"
                + this.getFimMatricula() + ";"
                + this.getDisciplinas().stream().map(String::valueOf).collect(Collectors.joining(",")) + ";");
    }
}