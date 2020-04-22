package javaapplication1;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface ICalculadora extends Remote{
	
	//Soma
    public int soma(int a, int b) throws RemoteException;
    
    //Subtração
    public int subtracao(int a, int b) throws RemoteException;

    //Multiplicação
    public int multiplicacao(int a, int b) throws RemoteException;
    
    //Divisão
    public int divisao(int a, int b) throws RemoteException;
}
