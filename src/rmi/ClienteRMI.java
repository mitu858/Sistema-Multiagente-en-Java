package rmi;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class ClienteRMI {
	
	private Protocolo servidor;//Atributo que sirve para obtener los datos del servidor
	private Registry registro; //Para buscar el registro
	private String ipServidor; //Para que el cliente lo sepa
	private Integer puerto;
	
	public ClienteRMI(String ip, Integer puerto) {
		
		this.setIpServidor(ip);
		this.setPuerto(puerto);
		try {
		this.setRegistro(LocateRegistry.getRegistry(ip,puerto));
		this.setServidor((Protocolo) this.getRegistro().lookup("rmiServidor"));
		} catch (RemoteException e) {
			System.out.println("Problema con la dirección o puerto, por favor verifique los datos");
		} catch (NotBoundException e) {
			System.out.println("No conozco el servicio rmiServidor");
		}
		
	}
		

	public void enviarMensaje(String mensaje) {
		try {
			this.getServidor().recibirMensaje(mensaje);
			System.out.println("El mensaje fue enviado correctamente");
		} catch (RemoteException e) {
			System.out.println("Hubo un problema al enviar el mensaje");
		}
	}
	public void sumarNumero(Float nro1,Float nro2) {
		
		try {
		Float resultado= this.getServidor().sumarNumeros(nro1, nro2);
			System.out.println("La suma de los numeros es: "+ resultado);
		} catch (RemoteException e) {
			
			System.out.println("La suma no pudo ser efectuada");
		}
	}
	
	protected Protocolo getServidor() {
		return servidor;
	}

	protected void setServidor(Protocolo servidor) {
		this.servidor = servidor;
	}

	protected Registry getRegistro() {
		return registro;
	}

	protected void setRegistro(Registry registro) {
		this.registro = registro;
	}

	protected String getIpServidor() {
		return ipServidor;
	}

	protected void setIpServidor(String ipServidor) {
		this.ipServidor = ipServidor;
	}

	protected Integer getPuerto() {
		return puerto;
	}

	protected void setPuerto(Integer puerto) {
		this.puerto = puerto;
	}
	
}
