package rmi;

public class ApliCliente {

	public static void main(String[] args) {
		
		ClienteRMI cliente1= new ClienteRMI("192.168.0.104",5560);
		cliente1.enviarMensaje("Hola soy el cliente 1");
		cliente1.sumarNumero(30.0f, 5.0f);
		
		ClienteRMI cliente2= new ClienteRMI("192.168.0.104",5560);
		cliente2.enviarMensaje("Hola soy el cliente 2");
		cliente2.sumarNumero(75.0f, 5.0f);

	}

}
