package org.exercicio.POO.Conta;

import org.exercicio.POO.Cliente.Cliente;
import org.exercicio.POO.Transacao.TipoTransancao;
import org.exercicio.POO.Transacao.Trasancao;
import java.util.ArrayList;
import java.util.List;

//Classe abstrata Conta
abstract public class Conta {

    //Atributos
    private int numero;
    private double saldo;
    private Cliente titular;
    private String senha;
    private final List<Trasancao> trasancoes;

    //Construtor
    public Conta(int numero, Cliente titular, String senha) {
        this.numero = numero;
        this.saldo = 0;
        this.titular = titular;
        this.senha = senha;
        this.trasancoes = new ArrayList<>();
    }

    //Deposita dinheiro
    public void depositar(double valor){
        //Soma o valor do saldo mais o do parametro
        setSaldo(getSaldo() + valor);
        //Registra a transação
        registrarExtrato("deposito", valor);
        System.out.println("Depositado com sucesso!");
        System.out.println(" ");
    }

    //Saca dinheiro
    abstract public void sacar(double valor);

    protected void temSaldo(double valor){
        if(valor <= getSaldo()){
            //Tira o valor da conta
            setSaldo(getSaldo() - valor);
            //Registra transação
            registrarExtrato("saque", valor);
            System.out.println("Sacado com sucesso!");
        }else {
            System.out.println("Saldo insuficiente!");
            System.exit(0);
        }
    }

    //transfere dinheiro de uma conta para outra
    public void transferir(double valor, Conta destino){
        //Checa se o saldo é > ou = ao valor recebido pelo parametro
        if(getSaldo() >= valor){
            //Checa se destino é uma conta de poupança e caso seja deve tranferir no maximo 500
            if(destino instanceof ContaPoupanca && valor <= 500){
                operacaoTransferir(valor, destino);
            }else if(destino instanceof ContaCorrente){
                operacaoTransferir(valor, destino);
            }else{
                System.out.println("Valor acima do permitido para transferir!");
            }
        }else {
            System.out.println("Saldo insuficiente!");
        }
        System.out.println(" ");
    }

    //Faz a transferencia entre conta corrente e poupança
    protected void operacaoTransferir(double valor, Conta destino){
        //Tira o valor na conta remetente
        setSaldo(getSaldo() - valor);
        //Registra a trasanção
        registrarExtrato("transferencia", valor);
        //Adiciona o valor na conta destinataria
        destino.setSaldo(destino.getSaldo() + valor);
        System.out.println("transferencia feita com sucesso!");
    }

    //Consulta saldo
    public void consultarSaldo(){
        System.out.println("Saldo atual: " + getSaldo());
    }

    //Registra transação
    public void registrarExtrato(String tipo, double valor){
        //Cria o extrato
        Trasancao t = new Trasancao(TipoTransancao.valueOf(tipo.toUpperCase()), valor);
        //Adiciona a transação na lista de transações
        trasancoes.add(t);
        System.out.println("Transação registrada com sucesso!");
    }

    //Colsulta transação
    public void consultarTransacao(){
        for(Trasancao t : trasancoes){
            System.out.println(t.toString());
        }
    }

    //Get numero
    public long getNumero() {
        return numero;
    }

    //Set numero
    public void setNumero(int numero) {
        this.numero = numero;
    }

    //Get saldo
    public double getSaldo() {
        return saldo;
    }

    //Set saldo
    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    //Get titular
    public Cliente getTitular() {
        return titular;
    }

    //Set titular
    public void setTitular(Cliente titular) {
        this.titular = titular;
    }

    //Get senha
    public String getSenha() {
        return senha;
    }

    //Set senha
    public void setSenha(String senha) {
        this.senha = senha;
    }

    //Get transacoes
    public List<Trasancao> getTrasancoes() {
        return trasancoes;
    }
}
