package client;
import java.io.*;
import java.net.*;

public class Echo {
    //definimos el Stub del cliente
    private static EchoObjectStub ss;
    
    public static void main(String[] args) 
    {
        String cadena="";
        String mes = "Cliente conectado con Servidor";
        // revisamos que los argumentos para ejecutar el programa son correctos
        if (args.length<2) {
            System.out.println("Para ejecutar , hazlo en este formato: Echo <nombre o IP del Equipo> <numero de puerto>");
            System.exit(1);
        }
        //creamos el STUB
        ss = new EchoObjectStub();
        ss.setHostAndPort(args[0],Integer.parseInt(args[1]));
       // leemos de teclado 
        BufferedReader stdIn = new BufferedReader( new InputStreamReader(System.in));
        //escribimos en pantalla
        PrintWriter stdOut = new PrintWriter(System.out);
        
        String input, output;
        
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        
        try {  
            
            System.out.println(ss.pago(mes));
            do{
                cadena = in.readLine();
                output = ss.pago(cadena);
                if(output.equals("1"))
                    System.out.println("Transaccion exitosa. Su pedido esta en camino");
                else if(output.equals("0"))
                    System.out.println("Transaccion no exitosa. Intente con otro medio de pago");
            }while(!cadena.equals("adios"));
        } 
        catch (IOException e) {
            System.err.println("Falla conexion de E/S con el host:"+args[0]);
        }
        System.out.println ("Finalizada conexion con el servidor");
    }
}
