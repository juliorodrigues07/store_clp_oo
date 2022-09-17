package br.edu.ufsj.ccomp.clp.loja;

public class Pessoa {
	
	private String name;
	private String address;
	
	public Pessoa(String name, String address) {
		
		this.name = name;
		this.address = address;
	}
	
	public void set(String name, String address) {
		
		this.name = name;
		this.address = address;
	}
	
	public String visualize() {
		return "Nome: " + this.name + "\t Endereço: " + this.address;
	}
}
