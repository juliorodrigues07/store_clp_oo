package br.edu.ufsj.ccomp.clp.loja;

import java.util.ArrayList;
import java.util.List;

public class ItemVenda implements Totalizavel {
	
	private Produto product;
	private Float value;
	private Integer quantity;
	
	@Override
	public Float total() {
		return this.value * this.quantity;
	}
}
