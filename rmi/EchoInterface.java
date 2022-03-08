
package rmi;
//Interfaz de tipo remota, cabe resaltar que
// solo tiene el metodo echo ( no hya instrucciones) 
public interface EchoInterface extends java.rmi.Remote 
{
    public String pago(String input)throws java.rmi.RemoteException;
}
