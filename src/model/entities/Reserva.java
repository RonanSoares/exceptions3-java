package model.entities;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import model.exceptions.DomainException;

public class Reserva {
	private Integer nrQuarto;
	private Date entrada;
	private Date saida;
	
	SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	
	Reserva(){		
	}

	public Reserva(Integer nrQuarto, Date entrada, Date saida) throws DomainException {
		// Excessão ja lançada no construtor
		if(!saida.after(entrada)) {
			throw new DomainException("Data de saida não pode ser menor que entrada"); 
		}
		this.nrQuarto = nrQuarto;
		this.entrada = entrada;
		this.saida = saida;
	}

	public Integer getNrQuarto() {
		return nrQuarto;
	}

	public void setNrQuarto(Integer nrQuarto) {
		this.nrQuarto = nrQuarto;
	}

	public Date getEntrada() {
		return entrada;
	}

	public void setEntrada(Date entrada) {
		this.entrada = entrada;
	}

	public Date getSaida() {
		return saida;
	}

	public void setSaida(Date saida) {
		this.saida = saida;
	}
	
	public long duracao() {
		long diff = saida.getTime() - entrada.getTime();
		return TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);
	}
	
	public void attDatas(Date entrada, Date saida) throws DomainException {
		Date now = new Date();
		if(entrada.before(now) || saida.before(now)) {
			throw new DomainException( "Datas tem que ser futuras.");
		}if(!saida.after(entrada)) {
			throw new DomainException("Data de saida não pode ser menor que entrada"); 
		}
		this.entrada = entrada;
		this.saida = saida;
	}
	
	public String toString() {
		return "Nr Quarto      : " 
				+ nrQuarto + "\n" 
				+ "Data de entrada: " + sdf.format(entrada) + "\n"
				+ "Data de saída  : " + sdf.format(saida) + "\n" + "Nr de diárias  : "
				+ duracao() + " noites.";
	}

}
