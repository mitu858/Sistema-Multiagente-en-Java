package rmi;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

public class ServidorRMI extends UnicastRemoteObject implements Protocolo {

	private Integer puerto;//número alto, se recomienda 5000 para arriba asi no molesta.
	private String ip;
	private Registry registro; //registro de direcciones
	
	
	public ServidorRMI(Integer puerto) throws RemoteException, UnknownHostException {
		super();
		
		this.setPuerto(puerto);//Cliente indica al puerto que se quiere conectar cuando instancia al servidor
		this.setIp(InetAddress.getLocalHost().getHostAddress()); //InetAddress es propia de Java, con esto se obtiene la direccion local
	    this.setRegistro(LocateRegistry.createRegistry(puerto)); //Creo registro
	    this.getRegistro().rebind("rmiServidor", this); //Se guarda el puerto en el registro, se ingresa la informacion remota con el nombre "rmiServidor"
	    System.out.println("Servidor inicializado en la IP: " + this.getIp() + " y en el púerto "+ this.getPuerto());
	}


	public Integer getPuerto() {
		return puerto;
	}


	public void setPuerto(Integer puerto) {
		this.puerto = puerto;
	}


	public String getIp() {
		return ip;
	}


	public void setIp(String ip) {
		this.ip = ip;
	}


	public Registry getRegistro() {
		return registro;
	}


	public void setRegistro(Registry registro) {
		this.registro = registro;
	}


	@Override
	public void recibirMensaje(String mensaje) throws RemoteException {
		System.out.println("El mensaje enviado es: " + mensaje);
		
	}


	@Override
	public Float sumarNumeros(Float uno, Float dos) throws RemoteException {
		
		return uno+dos;
		
		
	}

	
	
}
