package br.edu.ufsj.ccomp.clp.loja;

public class Produto {
	
	private Integer code;
	private String name;
	private Float value;
	
	public Produto(Integer code, String name, Float value) {
		
		this.code = code;
		this.name = name;
		this.value = value;
	}
	
	public void set(Integer code, String name, Float value) {
		
		this.code = code;
		this.name = name;
		this.value = value;
	}
	
	public String visualize() {
		return " Código: " + this.code + "\t Nome: " + this.name + "\t Valor: " + this.value + "\n";
	}
	
	public Integer get_code() {
		return this.code;
	}
	
	public Float get_value() {
		return this.value;
	}
}
