package clientJava;

import java.io.*;
import java.net.*;
import java.util.Scanner;

public class client{
    public static void main(String[] args) {
        String serverAddress = "10.130.1.112"; // Indirizzo IP del server
        int serverPort = 12345; // Porta del server
        Scanner scanner1 = new Scanner(System.in);
        
        System.out.println("Vuoi connetterti al server? (sì/no)");
        System.out.print("> ");
        String userChoice = scanner1.nextLine().trim().toLowerCase();

        if (!userChoice.equals("sì") && !userChoice.equals("si")) {
            System.out.println("Connessione annullata dal client.");
            return; // Termina il programma
        }
        
        try (Socket socket = new Socket(serverAddress, serverPort)) {
            System.out.println("Connesso al server " + serverAddress + " sulla porta " + serverPort);

            // Creazione degli stream di input e output
            OutputStream output = socket.getOutputStream();
            PrintWriter writer = new PrintWriter(output, true);
            
            InputStream input = socket.getInputStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(input));

            // Scanner per leggere i messaggi dalla riga di comando
            Scanner scanner = new Scanner(System.in);
            String messageToSend;
            int x = 0;
            String serverResponse3 = reader.readLine();
        	System.out.println("Risposta dal server: " + serverResponse3);
        	
            while (true) {
            		
            	
                System.out.print("> ");
                messageToSend = scanner.nextLine();

                 //Terminare la connessione se l'utente scrive "exit"
                if ("exit".equalsIgnoreCase(messageToSend)) {
                    System.out.println("Chiusura del client.");
                    break;
                }

                //Invia il messaggio al server
                writer.println(messageToSend);

                // Legge la risposta dal server
                String serverResponse2 = reader.readLine();
            	System.out.println("Risposta dal server: " + serverResponse2);
            	
                
            }

        } catch (UnknownHostException ex) {
            System.err.println("Server non trovato: " + ex.getMessage());
        } catch (IOException ex) {
            System.err.println("Errore di I/O: " + ex.getMessage());
        }
    }
}