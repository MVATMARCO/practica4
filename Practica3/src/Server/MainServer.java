
package Server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class MainServer {

    public static void main(String[] args) {
        try {
            int a = 1;
            int b = 20;
            int numero = (int)((Math.random()*(b-a+1)+a));
            String num = String.valueOf(numero);
            ServerSocket server  = new ServerSocket(8080);           
            while(true) {
                System.out.println("Esperando cliente");
                Socket socket = server.accept();
                System.out.println("Cliente conectado");
                new ManejaCliente().run(socket, numero, num);
            }            
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
    
}

