//O cliente inicia uma comunicação com o servidor e envia a mensagem com os parametros.
//O servidor executa a operação e responde com uma mensagem. 


import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.util.Scanner;

public class CalculadoraClientSocket {

	public static void main(String[] args) {
		
		//Criação de variaveis 
		int x = 0;
        int y = 0;
        Scanner sc = new Scanner(System.in);
		
        //Escolhendo a operação para ser executada na calculadora
		System.out.println("Conexão ...");
        System.out.println("Qual operação você deseja executar? Digite o número do índice:");
        System.out.println("1 - Soma \n");
        System.out.println("2 - Subtração \n");
        System.out.println("3 - Multiplicação \n");
        System.out.println("4 - Divisão \n");
        int operacaoSocket  = sc.nextInt();
        Calculadora calc = new Calculadora();
        
        //Selecionando a operação desejada
        switch(operacaoSocket)
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
        
        //Criação de variaveis 
		int operacao = operacaoSocket; //1-somar 2-subtrair 3-multiplicar 4-dividir
		int oper1 = x;
		int oper2 = y;
		String result="";
		
        try {

        	//Conexao com o Servidor
            Socket clientSocket = new Socket("192.168.0.11", 9090);
            DataOutputStream socketSaidaServer = new DataOutputStream(clientSocket.getOutputStream());
            
            //Enviando os dados
            socketSaidaServer.writeBytes(operacao+"\n");
            socketSaidaServer.writeBytes(oper1+ "\n");
            socketSaidaServer.writeBytes(oper2+ "\n");
            socketSaidaServer.flush();

            //Recebendo a resposta
            BufferedReader messageFromServer = new BufferedReader
                    (new InputStreamReader(clientSocket.getInputStream()));
            result=messageFromServer.readLine();
            
            System.out.println("resultado="+result);
            clientSocket.close();
            sc.close();

        } catch (IOException e) {
            e.printStackTrace();
            sc.close();
        }


	}

}
