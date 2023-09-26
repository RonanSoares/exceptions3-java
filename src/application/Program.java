package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import model.entities.Reserva;
import model.exceptions.DomainException;

public class Program {

	public static void main(String[] args) {

		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);

		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		try {
			System.out.println("Entre com os dados solicitados");
			System.out.println("------------------------------------------");
			System.out.print("Número do quarto            : ");
			int nrQuarto = sc.nextInt();
			System.out.print("Data de entrada(dd/MM/yyyy) : ");
			Date dataEnt = sdf.parse(sc.next());
			System.out.print("Data de saída(dd/MM/yyyy)   : ");
			Date dataSai = sdf.parse(sc.next());
			System.out.println("========================================");
			
			Reserva res = new Reserva(nrQuarto, dataEnt, dataSai);
			System.out.println("Reserva");
			System.out.println("-------");
			System.out.println(res.toString());
			
			System.out.println("========================================");
			System.out.println("Entre com os dados para atualizar a RESERVA:");
			System.out.print("Data de entrada (dd/MM/yyyy): ");
			dataEnt = sdf.parse(sc.next());
			System.out.print("Data de saida (dd/MM/yyyy)  : ");
			dataSai = sdf.parse(sc.next());
			
			res.attDatas(dataEnt, dataSai);
			System.out.println("Reserva");
			System.out.println("-------");
			System.out.println(res.toString());
			
		}  //Excessões do próprio java.
		/*
		catch(ParseException e) {
			System.out.println("Formato de data inválido...");
		}
		catch(IllegalArgumentException e) {
			System.out.println("Erro de Reserva: " + e.getMessage()); //Tratamento exception
		} */
		
		// Excessões personalizadas. 
		catch(ParseException e) {
			System.out.println("Formato de data inválido...");
		}
		catch(DomainException e) {
			System.out.println("------------------------------------------");
			System.out.println("Erro de Reserva: " + e.getMessage()); //Tratamento exception
		} 
		catch(RuntimeException e) {
			System.out.println("Erro inesperado...");
		}
		
	}

}
