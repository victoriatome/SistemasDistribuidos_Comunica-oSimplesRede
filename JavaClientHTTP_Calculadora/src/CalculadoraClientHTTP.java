import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;

import java.util.Scanner;

//O código do servidor esta online.
//O cliente abre uma conexão com o servidor, o servidor responde com os textos perguntando a operação.
//O cliente envia os parametros, quando recebe a resposta do servidor a conexão é encerrada.

public class CalculadoraClientHTTP {

	public static void main(String[] args) {
		
	String result="";
        Scanner sc = new Scanner(System.in);
    try {
       
    	//Conexão com o servidor 
       URL url = new URL("https://double-nirvana-273602.appspot.com/?hl=pt-BR");
       HttpsURLConnection conn = (HttpsURLConnection) url.openConnection();
        conn.setReadTimeout(10000);
        conn.setConnectTimeout(15000);
        conn.setRequestMethod("POST");
        conn.setDoInput(true);
        conn.setDoOutput(true);

        //Envio de parametros
        OutputStream os = conn.getOutputStream();
        BufferedWriter writer = new BufferedWriter(
                new OutputStreamWriter(os, "UTF-8"));
        
        //Escolha da operação 
        System.out.println("Qual operação você deseja executar? Digite o número do índice:");
        System.out.println("1 - Soma \n");
        System.out.println("2 - Subtração \n");
        System.out.println("3 - Multiplicação \n");
        System.out.println("4 - Divisão \n");
        int operacaoHTTP  = sc.nextInt();
        
        //Numeros para a operação 
        System.out.println("Por favor, insira dois numeros para esta operação:");
        System.out.println("Digite o primeiro numero");
        int x = sc.nextInt();
        System.out.println("Digite o segundo numero");
        int y = sc.nextInt();
        
        //Envio dos parametros 
        String str ="oper1="+x+"&oper2="+y+"&operacao="+operacaoHTTP;
        
        writer.write(str); //1-somar 2-subtrair 3-dividir 4-multiplicar
        writer.flush();
        writer.close();
        os.close();
        
        //Conexão HTTP
        int responseCode=conn.getResponseCode();
        if (responseCode == HttpsURLConnection.HTTP_OK) {
        	

         //Recebimentos dos parametros
            BufferedReader br = new BufferedReader(
                    new InputStreamReader(conn.getInputStream(), "utf-8"));
            StringBuilder response = new StringBuilder();
            String responseLine = null;
            while ((responseLine = br.readLine()) != null) {
                response.append(responseLine.trim());
            }
            result = response.toString();
            System.out.println("Resposta do Servidor PHP="+result);
        }
    } catch (IOException e) {
        e.printStackTrace();
    }
	}
}
