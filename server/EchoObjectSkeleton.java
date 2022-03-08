
package server;
import java.net.*;
import java.io.*;
import java.text.*;
import java.util.*;
import rmi.EchoInterface;
public class EchoObjectSkeleton implements EchoInterface {
    String myURL="localhost";
    static int NoClients = 0;
    String mess = "-Conectado con Cliente";
    private String[] datos;
    static int i = 0;
    //Constructor de la clase EchoObjectSkeleton
    public EchoObjectSkeleton(){
        try {
// obtengo el nombre del equipo donde estoy ejecutando y lo guardo en la propiedad MyURL
            myURL=InetAddress.getLocalHost().getHostName();
        } catch (UnknownHostException e) 
        {
     // si no pude conocer el nombre del equipo, mantengo el nombre localhost para MyURL
            myURL="localhost";
        }
    }
// el Metodo pago que es la implementacion de la interfaz EchoInterface
    public String pago(String input) throws java.rmi.RemoteException {
        if(i == 0){
            i++;
            return input;
        }else{
            int res = transaccion(input);
            String ret = Integer.toString(res); 
            return ret;
        }
    }
    
    private int transaccion(String input){
         datos = input.split("\\s+");
         int[] valores = new int[datos.length];
         valores[0] = Integer.parseInt(datos[0]);
         valores[1] = Integer.parseInt(datos[1]);
         valores[2] = Integer.parseInt(datos[2]);
        if(0<valores[0]){
            if(10000000<=valores[1] && valores[1]<=500000000){
                if(0<valores[2] && valores[2]<1000){
                    int dinero = (int)(Math.random()*(1000+1));
                    if(dinero < valores[0]){
                        System.out.println("No hay saldo suficiente");
                        return 0;
                    }else{
                        System.out.println("La transaccion ha sido exitosa");
                        return 1;
                    }
                }else{
                    System.out.println("El cvv es incorrecto");
                    return 0;
                }
            }else{
                System.out.println("El numero de tarjeta es incorreto");
                return 0;
            }
        }else{
            System.out.println("La cantidad de pago no es aceptada");
            return 0;
        }
    }

}


