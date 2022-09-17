package br.edu.ufsj.ccomp.clp.loja;


public class ItemVenda implements Totalizavel {
	
	private Produto product;
	private Float value;
	private Integer quantity;
	
	public ItemVenda(Produto product, Float value, Integer quantity) {
		
		this.product = product;
		this.value = value;
		this.quantity = quantity;
	}
	
	@Override
	public Float total() {
		return this.value * this.quantity;
	}
	
	public String visualize() {
		return " Produto: " + this.product.visualize() + "\t Valor: " + this.value + "\t Quantidade: " + this.quantity; 
	}
}
