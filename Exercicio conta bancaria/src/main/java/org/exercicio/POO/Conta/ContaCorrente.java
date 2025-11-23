package org.exercicio.POO.Conta;

import org.exercicio.POO.Cliente.Cliente;

//Classe filha da Conta
public class ContaCorrente extends Conta {

    //Construtor Herdado pela herança
    public ContaCorrente(int numero, Cliente titular, String senha) {
        super(numero, titular, senha);
    }

    //Saca dinheiro
    @Override
    public void sacar(double valor) {
        //variavel
        double desconto = valor + (valor * 0.1);
        //Checa se desconto é < ou igual ao saldo da conta
        temSaldo(desconto);
        System.out.println(" ");
    }
}
