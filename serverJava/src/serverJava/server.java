package serverJava;

import java.io.*;
import java.net.*;

public class server {
	public static void main(String[] args) {
        int porta = 31112; // La porta su cui il server ascolta

        try (ServerSocket serverSocket = new ServerSocket(porta)) {
            System.out.println("Server avviato. In attesa di connessioni...");

            // Il server entra in un ciclo per accettare connessioni in ingresso
            while (true) {
                // Attende una connessione da un client
                Socket clientSocket = serverSocket.accept();
                System.out.println("Client connesso: " + clientSocket.getInetAddress().getHostAddress());

                
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
