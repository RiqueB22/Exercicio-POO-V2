package org.exercicio.POO;

/*
* Sistema bancario simplificado
*
* author: Henrique Bernardo
* */

import org.exercicio.POO.Cliente.Cliente;
import org.exercicio.POO.Conta.Conta;
import org.exercicio.POO.Conta.ContaCorrente;
import org.exercicio.POO.Conta.ContaPoupanca;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        //input Login
        Scanner inputT = new Scanner(System.in);
        System.out.println("***************************************");
        System.out.println("Banco POO - Login");
        System.out.println("***************************************");
        System.out.println("Digite seu CPF(000.000.000-00): ");
        String identificador = inputT.nextLine();
        Scanner inputS = new Scanner(System.in);
        System.out.println("Digite sua senha(minimo 8 caracteres): ");
        String senha = inputS.nextLine();

        //instanciando conta corrente, conta poupança e titular
        Conta contaP;
        Conta contaC;
        Cliente titular;

        //Checa se cpf e senha foi informado corretamente
        if (identificador.matches(".*[0-9\\\\.-].*") &&
                identificador.matches("(\\d{3}\\.\\d{3}\\.\\d{3}-\\d{2})") &&
                senha.matches(".*[A-z0-9].*") &&
                senha.length() >= 8) {
            //inicializando os objetos
            titular = new Cliente(identificador);
            contaC = new ContaCorrente(123, titular, senha);
            contaP = new ContaPoupanca(456, titular, senha);

            //Input de Conta
            Scanner inputC = new Scanner(System.in);
            System.out.println("***************************************");
            System.out.println("Banco POO - Conta");
            System.out.println("***************************************");
            System.out.println("1 - Conta Corrente");
            System.out.println("2 - Conta Poupança");
            System.out.println("Digite uma das opções acima: ");
            String conta = inputC.nextLine();

            //Variaveis
            String opcao = "";

            //Checa se tem só numero inteiro
            if(conta.matches(".*[0-9].*")){
                //Loop do menu principal, se for 0 ele sai do loop e finaliza o programa
                while(!opcao.equals("0")){
                    //Checa se as opções são correspondentes ao do menu
                    switch (conta){
                        case "1":
                            opcao = opcaoConta(contaC, contaP, opcao);
                            break;
                        case "2":
                            opcao = opcaoConta(contaP, contaC, opcao);
                            break;
                        default:
                            System.out.println("Digite uma opção valida!");
                            System.exit(0);
                    }
                }
            }else{
                System.out.println("Digite apenas numeros inteiros!");
                System.exit(0);
            }
        }else{
            System.out.println("Erro no usuario ou senha!");
            System.exit(0);
        }
    }

    protected static String opcaoConta(Conta remetente, Conta destinataria, String opcao){
        //Input do menu principal
        Scanner input = new Scanner(System.in);
        System.out.println("***************************************");
        System.out.println("Banco POO - Menu principal");
        System.out.println("***************************************");
        System.out.println("Conta: " + remetente.getNumero());
        System.out.println("Titular: " + remetente.getTitular().getNome());
        System.out.println(" ");
        System.out.println("1 - Depositar");
        System.out.println("2 - Sacar");
        System.out.println("3 - Transferir");
        System.out.println("4 - Consultar Transações");
        System.out.println("5 - Consultar Saldo");
        System.out.println("0 - Sair");
        System.out.println("Digite uma das opções: ");
        opcao = input.nextLine();

        //Checa se é numero inteiro
        if(opcao.matches(".*[0-9].*")){
            //Checa se é uma das opções do menu
            switch(opcao){
                case "1":
                    //Input do deposito
                    Scanner inputDP = new Scanner(System.in);
                    System.out.println("***************************************");
                    System.out.println("Banco POO - Deposito");
                    System.out.println("***************************************");
                    System.out.println("Digite seu valor para depositar:");
                    String valor = inputDP.nextLine();

                    //Checa se é numero decimal
                    if(valor.matches(".*[0-9\\\\.].*")){
                        remetente.depositar(Double.parseDouble(valor));
                    }else{
                        System.out.println("Coloque apenas numeros!");
                    }
                    break;
                case "2":
                    //Input de saque
                    Scanner inputSC = new Scanner(System.in);
                    System.out.println("***************************************");
                    System.out.println("Banco POO - Saque");
                    System.out.println("***************************************");
                    System.out.println("Digite seu valor para sacar:");
                    String quantia = inputSC.nextLine();

                    //Checa se é numero decimal
                    if(quantia.matches(".*[0-9\\\\.].*")){
                        remetente.sacar(Double.parseDouble(quantia));
                    }else{
                        System.out.println("Coloque apenas numeros!");
                    }
                    break;
                case "3":
                    //Input de transferencia
                    Scanner inputTF = new Scanner(System.in);
                    System.out.println("***************************************");
                    System.out.println("Banco POO - Transferencia");
                    System.out.println("***************************************");
                    System.out.println("Digite o valor para transferir:");
                    String valorTF = inputTF.nextLine();
                    if(valorTF.matches(".*[0-9\\\\.].*")){
                        remetente.transferir(Double.parseDouble(valorTF), destinataria);
                    }
                    break;
                case "4":
                    System.out.println("***************************************");
                    System.out.println("Banco POO - Consulta de transações");
                    System.out.println("***************************************");
                    //Consulta as transações
                    remetente.consultarTransacao();
                    System.out.println("Consulta de extratos feita com sucesso!");
                    System.out.println(" ");
                    break;
                case "5":
                    System.out.println("***************************************");
                    System.out.println("Banco POO - Consulta de saldo");
                    System.out.println("***************************************");
                    //Consulta saldo
                    remetente.consultarSaldo();
                    System.out.println("Consulta de saldo feita com sucesso!");
                    System.out.println(" ");
                case "0":
                    //Sai do programa
                    System.out.println("Obrigado por acessar nosso sistema!");
                    System.out.println("Finalizando o programa!");
                    break;
                default:
                    System.out.println("Coloque um numero vindo do menu");
            }
        }else{
            System.out.println("Coloque apenas numeros!");
        }

        return opcao;
    }
}