package co.com.cidenet.kardex.inventario.excepciones;

public class ActualizacionException extends Exception{
	
	private static final long serialVersionUID = 3498505699446390232L;

	public ActualizacionException(String mensajeError) {
		super(mensajeError);
	}
}
