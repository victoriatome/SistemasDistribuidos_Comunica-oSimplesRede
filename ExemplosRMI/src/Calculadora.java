package javaapplication1;

import java.rmi.AccessException;
import java.rmi.AlreadyBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

public class Calculadora  implements ICalculadora {

	private static final long serialVersionUID = 1L;
	
	//Variaveis das chamadas
	private static int chamadasSoma = 0;
    private static int chamadasSob = 0;
    private static int chamadasMul = 0;
    private static int chamadasDiv = 0;
        
    //Função soma
	public int soma(int a, int b) throws RemoteException {
		System.out.println("Método soma chamado " + chamadasSoma++);
		return a + b;
	}
	
    //Função subtração
    public int subtracao(int a, int b) throws RemoteException {
		System.out.println("Método subtracao chamado " + chamadasSob++);
		return a - b;
	}
    
    //Função multiplicação
    public int multiplicacao(int a, int b) throws RemoteException {
		System.out.println("Método multiplicacao chamado " + chamadasMul++);
		return a * b;
	}
        
    //Função divisao
    public int divisao(int a, int b) throws RemoteException {
		System.out.println("Método divisao chamado " + chamadasDiv++);
		return a / b;
	}
        
  //A classe da calculadora adiciona ao registro com a tag "calculadora".
  //Quando executa ele procura pela tag no registro e abre a conexão, instanciando a classe e executando a função escolhida.    
	public static void main(String[] args) throws AccessException, RemoteException, AlreadyBoundException  {
               
		Calculadora calculadora = new Calculadora();		
		Registry reg = null;
		ICalculadora stub = (ICalculadora) UnicastRemoteObject.
				exportObject(calculadora, 1100);
		try {
			System.out.println("Creating registry...");
			reg = LocateRegistry.createRegistry(1099);
		} catch (Exception e) {
			try {
				reg = LocateRegistry.getRegistry(1099);
			} catch (Exception e1) {
				System.exit(0);
			}
		}
		reg.rebind("calculadora", stub);
	}
}
