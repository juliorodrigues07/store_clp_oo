package br.edu.ufsj.ccomp.clp.util;

import java.text.SimpleDateFormat;
import java.text.ParseException;
import java.text.DateFormat;
import java.util.Calendar;
import java.util.Scanner;
import java.util.Date;

public class Data {
	
	// Método para a leitura das datas
	public static String LeituraData() {
		
		String date = null;
		
		try {
			Scanner s = new Scanner(System.in);
			String dataRecebida = s.nextLine();
			DateFormat dfs = new SimpleDateFormat("dd/MM/yyyy");
			Date dt = dfs.parse(dataRecebida);
			date = dfs.format(dt);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		
		return date;
	}

	// Método para retornar a data atual
	public static String dataAtual() {
		
		Calendar c = Calendar.getInstance();
		Date atual = c.getTime();
		DateFormat dfs = new SimpleDateFormat("dd/MM/yyyy");
		return dfs.format(atual);
	}
	
	public static boolean validar(String date) {
	
		DateFormat dfs1 = new SimpleDateFormat("dd/MM/yyyy");
		Date begin = null;
		DateFormat dfs2 = new SimpleDateFormat("dd/MM/yyyy");
		Date end = null;
		
		String actual_date = dataAtual();

		try {
			begin = dfs1.parse(date);
			end = dfs2.parse(actual_date);
		} catch (ParseException e) {
			e.printStackTrace();
		}

		if (begin.after(end)) 
			return true;
		else 
			return false;
	}
}
