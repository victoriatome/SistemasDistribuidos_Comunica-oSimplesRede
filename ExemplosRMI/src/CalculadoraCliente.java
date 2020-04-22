package javaapplication1;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Scanner;

public class CalculadoraCliente {
	
	public static void main(String[] args) {
		Registry reg = null;
		
		//Criando as variaveis 
                int x = 1;
                int y = 5;
                Scanner sc = new Scanner(System.in);
		try {
			//Conectando com a calculadora 
			reg = LocateRegistry.getRegistry(1099);
			ICalculadora calc = (ICalculadora) reg.lookup("calculadora");     
                        System.out.println("Conexão ...");
                        
                        //Escolhendo a operação da calculadora
                        System.out.println("Qual operação você deseja executar? Digite o número do índice:");
                        System.out.println("1 - Soma \n");
                        System.out.println("2 - Subtração \n");
                        System.out.println("3 - Multiplicação \n");
                        System.out.println("4 - Divisão \n");
                        int operacaoRMI  = sc.nextInt();
                        
                        //Selecionando a operação da calculadora 
                        switch(operacaoRMI)
                        {
                            case 1: //Soma
                            {
                            	System.out.println("Por favor, insira dois numeros para esta operação:");
                                System.out.println("Digite o primeiro numero");
                                x = sc.nextInt();
                                System.out.println("Digite o segundo numero");
                                y = sc.nextInt();
                                System.out.println("result:"+calc.soma(x, y));
                                break;
                            }
                               case 2: //Subtração
                            {
                            	System.out.println("Por favor, insira dois numeros para esta operação:");
                                System.out.println("Digite o primeiro numero");
                                x = sc.nextInt();
                                System.out.println("Digite o segundo numero");
                                y = sc.nextInt();
                                System.out.println("result:"+calc.subtracao(x, y));
                                break;
                            }
                               case 3: //Multiplicação
                            {
                            	System.out.println("Por favor, insira dois numeros para esta operação:");
                                System.out.println("Digite o primeiro numero");
                                x = sc.nextInt();
                                System.out.println("Digite o segundo numero");
                                y = sc.nextInt();
                                System.out.println("result:"+calc.multiplicacao(x, y));
                                break;
                            }
                               case 4: //Divisão 
                            {
                            	System.out.println("Por favor, insira dois numeros para esta operação:");
                                System.out.println("Digite o primeiro numero");
                                x = sc.nextInt();
                                System.out.println("Digite o segundo numero");
                                y = sc.nextInt();
                                System.out.println("result:"+calc.divisao(x, y));
                                break;
                            }
                        }
                       
		} catch (RemoteException | NotBoundException e) {
				System.out.println(e);
				System.exit(0);
		}
	}		

}
