package clientJava;

import java.io.*;
import java.net.*;

public class client {
    public static void main(String[] args) {
        String serverAddress = "10.130.1.112"; // Indirizzo IP del server
        int serverPort = 31112; // Porta del server

        try (Socket socket = new Socket(serverAddress, serverPort)) {
            System.out.println("Connessione al server " + serverAddress + " sulla porta " + serverPort);

            // Creazione degli stream di input e output
            OutputStream output = socket.getOutputStream();
            PrintWriter writer = new PrintWriter(output, true);

            InputStream input = socket.getInputStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(input));

            // Invio del messaggio al server
            String messageToSend = "Ciao, server!";
            writer.println(messageToSend);
            System.out.println("Messaggio inviato: " + messageToSend);

            // Lettura della risposta dal server
            String serverResponse = reader.readLine();
            System.out.println("Risposta dal server: " + serverResponse);

        } catch (UnknownHostException ex) {
            System.err.println("Server non trovato: " + ex.getMessage());
        } catch (IOException ex) {
            System.err.println("Errore di I/O: " + ex.getMessage());
        }
    }
}
