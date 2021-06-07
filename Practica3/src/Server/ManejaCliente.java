package Server;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ManejaCliente extends Thread {   
    public void run(Socket clienten, int numero, String num) {
        String msg;
        int intento;
        try {
            String m1= "";
            ObjectInputStream entrada = new ObjectInputStream(clienten.getInputStream());
            do{
                msg = (String) entrada.readObject();
                intento = Integer.parseInt(msg);
                System.out.println("Numero ingresado: " + msg);
                if(msg.contains(num)) {
                    m1=("Adivino el numero");
                    System.out.println("Adivino el numero: " + msg);
                    break;
                } else if(intento>numero){
                    m1=("Numero Muy Alto");
                }else {
                    m1=("Numero Muy Bajo");
                }
            }while(m1.equals("Adivino el numero"));
            ObjectOutputStream men=new ObjectOutputStream(clienten.getOutputStream());
            men.writeObject(m1);
        } catch (IOException | ClassNotFoundException ex) {
            Logger.getLogger(ManejaCliente.class.getName()).log(Level.SEVERE, null, ex);
        }
    }    
    
}