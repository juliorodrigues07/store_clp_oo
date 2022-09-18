package br.edu.ufsj.ccomp.clp.loja;

import br.edu.ufsj.ccomp.clp.exceptions.DataException;
import br.edu.ufsj.ccomp.clp.util.Data;
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
		this.itens = itens;
	}
	
	@Override
	public Float total() {
		
		float sum = 0;
		
		for (ItemVenda item : this.itens) {
			sum += item.total();
		}
		
		return sum;
	}
	
	public Integer get_number() {
		return this.number;
	}
	
	public String visualize() {
		
		System.out.println("\nITENS\n");
		
		for (ItemVenda item : this.itens) 
			System.out.println(item.visualize());
		
		return "Número da venda: " + this.number + "\t Total: " + this.total() + "\t Data: " + this.date + "\n\nCLIENTE" + this.cliente.visualize();
	}
}
