package main;

import java.io.IOException;
import java.util.ArrayList;

import arquivo.Arquivo;
import comparacao.Calculo;
import escalonamento.*;
import node.Cliente;
import teclado.Teclado;

public class Main {

	public static void main(String[] args) throws Exception{
		Arquivo arq = new Arquivo();
		FilaPrioridade fp = new FilaPrioridade();
		Fila fila = new Fila();
		SJF sjf = new SJF();
		RoundRobin rr = new RoundRobin();
		
		Calculo calculo = new Calculo();
		try {
			long inicio;
			long fim;
			long tempo;
			arq.lerArquivo("dados14.txt");
			System.out.println(arq.getQuantidadeCli());
			ArrayList<Cliente> clientes;
			int quantCli = arq.getQuantidadeCli();
			
			System.out.println("-----------------Lavanderia--------------------");
			System.out.println("Escolha o método de escalonamento: ");
			System.out.println("1-Fila\n2-Fila de Prioridade\n3-SJF\n4-RoundRobin");
			
			int opcao = Teclado.readInt();
			while(opcao < 1 || opcao > 4) {
				System.out.println("Opção inválida!\nDigite novamente:");
				opcao = Teclado.readInt();
			}
			
			switch(opcao) {
			
			case 1:
				
				clientes = arq.retornarClientes();
				inicio = System.currentTimeMillis();
				fila.calculaTempo(clientes,quantCli);
				fim = System.currentTimeMillis();
				 tempo = (fim - inicio);
				System.out.println("Tempo Media: "+ tempo);
				break;
			case 2:
				clientes = arq.retornarClientes();
				inicio = System.currentTimeMillis();
				fp.calculaTempo(clientes,quantCli);
				fim = System.currentTimeMillis();
				 tempo = (fim - inicio);
				System.out.println("Tempo Media: "+ tempo);
				break;
			case 3:
				clientes = arq.retornarClientes();
				inicio = System.currentTimeMillis();
				sjf.calculaTempo(clientes,quantCli);
				fim = System.currentTimeMillis();
				 tempo = (fim - inicio);
				System.out.println("Tempo Media: "+ tempo);
				break;
			case 4:
				clientes = arq.retornarClientes();
				inicio = System.currentTimeMillis();
				rr.calculaTempo(clientes,quantCli);
				fim = System.currentTimeMillis();
				 tempo = (fim - inicio);
				System.out.println("Tempo Media: "+ tempo);
				break;
			}
			
			
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
