
package game.pkg2;

import java.util.Random;
import java.util.Scanner;

public class Game2 {

    public static void main(String[] args) {

// Imports
        Scanner ler = new Scanner(System.in);
        Random aleatorio = new Random();

// Variaveis
        int tentou = 0, tentativas = 0, acertos = 0;
        boolean jogo = false, iniciar = true, acertou = true;
        String inicio, nome, repetir, respostaFinal;
        double aposta, valor;
        aposta = 0;
        valor = 0;

// Boas-vindas
        System.out.println("Bem-vindo ao jogo de adivinhação!");

// Entradas
        System.out.println("Qual o seu nome?");
        nome = ler.nextLine();

// Looping caso o cliente erra se quer começar ou não
        while (!jogo) {
            System.out.println("Você deseja iniciar o jogo? sim ou nao?");
            inicio = ler.next();

// If Iniciar
            if (inicio.equals("sim")) {
                iniciar = false;
                acertou = false;
                respostaFinal = "Volte sempre, até a próxima Xiruuu! :)";
                System.out.println("Quanto quer apostar?");
                aposta = ler.nextDouble();
            } else if (inicio.equals("nao")) {
                jogo = true;
                iniciar = true;
                respostaFinal = "Que pena que não queira jogar, mas até a próxima Xiruuu! :(";
            } else {
                respostaFinal = "Digite apenas sim ou nao";
            }

// Looping do game
            while (!iniciar) {
                jogo = true;
                int numeroSecreto = aleatorio.nextInt(100) + 1;

// Looping das tentativas
                while (!acertou) {
                    System.out.println(numeroSecreto);
                    System.out.println("Estou pensando em um número entre 1 e 100...");
                    System.out.print("Digite sua tentativa: ");
                    int palpite = ler.nextInt();
                    tentativas++;
                    if (palpite < numeroSecreto) {
                        System.out.println("O número é maior!");
                    } else if (palpite > numeroSecreto) {
                        System.out.println("O número é menor!");
                    } else {
                        aposta *= 2;
                        valor += aposta;
                        acertos++;
                        acertou = true;
                        iniciar = true;
                        System.out.println("Parabéns! Você acertou em " + tentativas + " tentativas.");
                    }
                }
                tentou += tentativas;
                tentativas = 0;

// Entrada do continuar
                System.out.println("Você deseja continuar o jogo e aumentar suas recompensas? sim ou nao?");
                repetir = ler.next();

// If do continuar
                if (repetir.equals("sim")) {
                    iniciar = false;
                    acertou = false;
                } else if (repetir.equals("nao")) {
                    iniciar = true;
                    respostaFinal = nome + " você tentou acertar " + tentou + " vezes, e com isso acertou " + acertos + " vezes e ganhou incríveis R$" + valor + ". Volte sempre e até a próxima Xiruuu! :)";
                } else {
                    System.out.println("Escreva apenas sim ou nao");
                    iniciar = false;
                    acertou = true;
                }
            }

// Saída geral
            System.out.println(respostaFinal);
        }
        ler.close();
    }
}
