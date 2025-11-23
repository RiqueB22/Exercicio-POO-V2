package org.exercicio.POO.Cliente;

import org.exercicio.POO.Conta.Conta;
import java.util.List;

//Classe Cliente
public class Cliente {

    //Atributos
    private String nome;
    private String cpf;
    private String email;
    private List<Conta> Contas;

    //Construtor
    public Cliente( String cpf) {
        this.nome = "João Antonio";
        this.cpf = cpf;
        this.email = "xxxxx@gggg.ccc";
    }

    //Consulta contas
    public void listarContas() {
        //Loop para mostrar todas as transações
        for (Conta c : Contas) {
            System.out.println("Numero da Conta: " + c.getNumero() +
                    " | Titular: " + c.getTitular() +
                    " | Saldo: " + c.getSaldo() +
                    " | Transações: " + c.getTrasancoes());
        }
    }

    //Get nome
    public String getNome() {
        return nome;
    }

    //Set Nome
    public void setNome(String nome) {
        this.nome = nome;
    }

    //Get CPF
    public String getCpf() {
        return cpf;
    }

    //Set CPF
    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    //Get email
    public String getEmail() {
        return email;
    }

    //Set email
    public void setEmail(String email) {
        this.email = email;
    }

    //Get contas
    public List<Conta> getContas() {
        return Contas;
    }

    //Set contas
    public void setContas(List<Conta> contas) {
        Contas = contas;
    }
}
