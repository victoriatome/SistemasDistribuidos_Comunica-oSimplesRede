//O servidor mantem uma conexão aberta escutando mensagens e esperando as entradas enviadas pelo cliente.

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class CalculadoraServerSocket {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ServerSocket welcomeSocket;
		DataOutputStream socketOutput;     	
	    DataInputStream socketInput;
	    BufferedReader socketEntrada;
	    Calculadora calc = new Calculadora();
	    String result= "";
	    
		try {
			welcomeSocket = new ServerSocket(9090);
		  int i=0; //n�mero de clientes
	  
	      System.out.println ("Servidor no ar");
	      while(true) { 
	  
	           Socket connectionSocket = welcomeSocket.accept(); 
	           i++;
	           System.out.println ("Nova conex�o");
	           
	           //Interpretando dados do servidor
	           socketEntrada = new BufferedReader(new InputStreamReader(connectionSocket.getInputStream()));
               String operacao = socketEntrada.readLine();
               String oper1 = socketEntrada.readLine();
               String oper2 = socketEntrada.readLine();
               
               //Chamando a calculadora com a operação escolhida
               switch(operacao)
               {
                   case "1": //Soma
                   {
                	   result= ""+calc.soma(Double.parseDouble(oper1),Double.parseDouble(oper2));
                       break;
                   }
                      case "2": //Subtração
                   {
                	   result= ""+calc.subtracao(Double.parseDouble(oper1),Double.parseDouble(oper2));
                       break;
                   }
                      case "3": //Multiplicação
                   {
                	   result= ""+calc.multiplicacao(Double.parseDouble(oper1),Double.parseDouble(oper2));
                       break;
                   }
                      case "4": //Divisão
                   {
                	   result= ""+calc.divisao(Double.parseDouble(oper1),Double.parseDouble(oper2));
                       break;
                   }
               }
               
               
               //Enviando dados para o servidor
               socketOutput= new DataOutputStream(connectionSocket.getOutputStream());     	
	           socketOutput.writeBytes(result+ '\n');
	           System.out.println (result);	           
	           socketOutput.flush();
	           socketOutput.close();

	                    
	      }
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	    
	}

}
