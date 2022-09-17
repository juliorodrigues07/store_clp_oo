package br.edu.ufsj.ccomp.clp.loja;

import br.edu.ufsj.ccomp.clp.exceptions.DataException;
import br.edu.ufsj.ccomp.clp.util.Data;

public class Cliente extends Pessoa{
	
	private String rg;
	private String birth_date;
	
	public Cliente(String name, String address, String rg, String birth_date) throws DataException {
		
		super(name, address);
		
		if (Data.validar(birth_date))
			throw new DataException();
		else
			this.birth_date = birth_date;
		
		this.rg = rg;
	}
	
	public void set(String name, String address, String rg, String birth_date) throws DataException {
		
		super.set(name, address);
		
		if (Data.validar(birth_date))
			throw new DataException();
		else
			this.birth_date = birth_date;
		
		this.rg = rg;
	}
	
	@Override
	public String visualize() {
		return super.visualize() + "\t RG: " + this.rg + "\t Data de Nascimento: " + this.birth_date;
	}
	
	public String get_rg() {
		return this.rg;
	}
}
