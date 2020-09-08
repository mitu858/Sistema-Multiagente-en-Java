package rmi;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Protocolo extends Remote {

	void recibirMensaje(String mensaje) throws RemoteException;
	Float sumarNumeros(Float uno, Float dos) throws RemoteException;
	
	
}
