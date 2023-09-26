package model.exceptions;

public class DomainException extends Exception{

	private static final long serialVersionUID = 1L; // Versão da classe serializable
	
	// Construtor recebe uma String msg como argumento
	public DomainException(String msg) {
		super(msg); // Passa a msg para a super classe.
	}
	

}
