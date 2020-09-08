package rmi;

import java.net.UnknownHostException;
import java.rmi.RemoteException;

public class ApliServidor {

	public static void main(String[] args) throws RemoteException, UnknownHostException { //No se hace try catch por que es local
		// TODO Auto-generated method stub

	 ServidorRMI server=new ServidorRMI(5560);
	
	}

}
