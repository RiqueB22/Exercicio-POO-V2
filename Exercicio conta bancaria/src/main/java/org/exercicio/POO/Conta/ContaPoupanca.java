package org.exercicio.POO.Conta;

import org.exercicio.POO.Cliente.Cliente;

//Classe filha da Conta
public class ContaPoupanca extends Conta {

    //Construtor Herdado pela herança
    public ContaPoupanca(int numero, Cliente titular, String senha) {
        super(numero, titular, senha);
    }

    //Saca dinheiro
    @Override
    public void sacar(double valor) {
        //Checa se valor do parametro é < ou = ao saldo da conta
        temSaldo(valor);
        System.out.println(" ");
    }
}
