package br.edu.ufsj.ccomp.clp.loja;

import br.edu.ufsj.ccomp.clp.exceptions.DataException;
import br.edu.ufsj.ccomp.clp.util.Data;
import java.util.ArrayList;
import java.util.List;

public class Venda implements Totalizavel{

	private Integer number;
	private String date;
	private Cliente cliente;
	private List<ItemVenda> itens;
	
	public Venda(Integer number, String date, Cliente cliente, List<ItemVenda> itens) throws DataException {
		
		if (Data.validar(date))
			throw new DataException();
		else
			this.date = date;
		
		this.number = number;
		this.cliente = cliente;
		this.itens = new ArrayList<ItemVenda>();
	}
	
	@Override
	public Float total() {
		
	}
	
	public Integer get_number() {
		return this.number;
	}
	
	public String visualize() {
		return " Número: " + this.number + "\t Data: " + this.date + "\t Cliente: " + this.cliente.visualize() + "\n";
	}
}
