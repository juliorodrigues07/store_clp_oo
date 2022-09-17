package br.edu.ufsj.ccomp.clp.loja;

import br.edu.ufsj.ccomp.clp.exceptions.DataException;
import br.edu.ufsj.ccomp.clp.util.Leitura;
import br.edu.ufsj.ccomp.clp.util.Data;
import java.util.ArrayList;
import java.util.List;

public class Programa {
	
	private static List<Cliente> clients = new ArrayList<Cliente>();
	private static List<Produto> products = new ArrayList<Produto>();
	private static List<Venda> sales = new ArrayList<Venda>();
	
	public static void main(String[] args) {
		
		int choice = 0;
		int operation = 0;
		System.out.println("STORE CRUD");
		
		do {
			
			System.out.println("\n1 -> Cliente");
			System.out.println("2 -> Produto");
			System.out.println("3 -> Venda");
			System.out.println("0 -> Sair\n");
			System.out.print("Informe a entidade para manipular: ");
			
			choice = Integer.parseInt(Leitura.readLine());
			System.out.println("");
			
			switch (choice) {
			
				case 1:
					
					System.out.println("1 -> Inserção");
					System.out.println("2 -> Alteração");
					System.out.println("3 -> Remoção");
					System.out.println("4 -> Visualização\n");
					System.out.print("Informe a operação: ");
					
					operation = Integer.parseInt(Leitura.readLine());
					System.out.println("");
					
					switch (operation) {
						
						case 1:
							System.out.println("INSERÇÃO DE CLIENTE");
							client_insertion();
							break;
							
						case 2:
							System.out.println("ALTERAÇÃO DE CLIENTE");
							client_modification();
							break;
							
						case 3:
							System.out.println("REMOÇÃO DE CLIENTE");
							client_exclusion();
							break;
						
						case 4:
							System.out.println("VISUALIZAÇÃO DE CLIENTE");
							client_visualization();
							break;
						
						default:
							System.err.println("Operação inválida!");
					}
					
					break;
			
				case 2:
					
					System.out.println("1 -> Inserção");
					System.out.println("2 -> Alteração");
					System.out.println("3 -> Remoção");
					System.out.println("4 -> Visualização\n");
					System.out.print("Informe a operação: ");
					
					operation = Integer.parseInt(Leitura.readLine());
					System.out.println("");
					
					switch (operation) {
						
						case 1:
							System.out.println("INSERÇÃO DE PRODUTO");
							product_insertion();
							break;
							
						case 2:
							System.out.println("ALTERAÇÃO DE PRODUTO");
							product_modification();
							break;
							
						case 3:
							System.out.println("REMOÇÃO DE PRODUTO");
							product_exclusion();
							break;
						
						case 4:
							System.out.println("VISUALIZAÇÃO DE PRODUTO");
							product_visualization();
							break;
						
						default:
							System.err.println("Operação inválida!");
					}
					
					break;
				
				case 3:
					
					System.out.println("1 -> Inserção");
					System.out.println("2 -> Remoção");
					System.out.println("3 -> Visualização\n");
					System.out.print("Informe a operação: ");
					
					operation = Integer.parseInt(Leitura.readLine());
					System.out.println("");
					
					switch (operation) {
						
						case 1:
							System.out.println("INSERÇÃO DE VENDA");
							sale_insertion();
							break;
							
						case 2:
							System.out.println("REMOÇÃO DE VENDA");
							sale_exclusion();
							break;
							
						case 3:
							System.out.println("VISUALIZAÇÃO DE VENDA");
							sale_visualization();
							break;
						
						default:
							System.err.println("Operação inválida!");
					}
					
					break;
				
				default:
					
					if (choice != 0) 
						System.err.println("Entidade inválida!");
			}
			
		} while (choice != 0);
		
		System.out.println("FIM DO PROGRAMA!");
	}
	
	/* -----------xxxxxx--------------xxxxxxxxxx------- CLIENTES --------xxxxxxxxxxxx---------------xxxxxxxxxxx----------- */
	
	public static void client_insertion() {
		
		System.out.print("Nome: ");
		String name = Leitura.readLine();
		
		System.out.print("Endereço: ");
		String address = Leitura.readLine();
		
		System.out.print("RG: ");
		String rg = Leitura.readLine();
		
		System.out.print("Data de Nascimento (dd/MM/yyyy): ");
		String birth_date = Data.LeituraData();
		
		try {
			Cliente client = new Cliente(name, address, rg, birth_date);
			clients.add(client);
		} catch (DataException e) {
			System.err.println("\nA data informada ainda não ocorreu ---> " + birth_date);
		} catch (NullPointerException e) {
			System.err.println("\nTipo incorreto encontrado nos dados! \t String - String - String - Date(dd/MM/yyyy)");
		}
	}
	
	public static void client_modification() {
		
		boolean check = true;
		
		System.out.print("Informe o RG do cliente que deseja-se alterar: ");
		String old_rg = Leitura.readLine();
		
		for (Cliente client : clients) {
			
			if (client.get_rg().equals(old_rg)) {
				
				System.out.println("Informe os novos dados:\n");
				
				System.out.print("Nome: ");
				String name = Leitura.readLine();
				
				System.out.print("Endereço: ");
				String address = Leitura.readLine();
				
				System.out.print("RG: ");
				String rg = Leitura.readLine();
				
				System.out.print("Data de Nascimento (dd/MM/yyyy): ");
				String birth_date = Data.LeituraData();
				
				try {
					client.set(name, address, rg, birth_date);
					check = false;
				} catch (DataException e) {
					System.err.println("\nA data informada ainda não ocorreu ---> " + birth_date);
				} catch (NullPointerException e) {
					System.err.println("\nTipo incorreto encontrado nos dados! \t String - String - String - Date(dd/MM/yyyy)");
				}
				
				break;
			}
		}
		
		if (check) 
			System.err.println("\nNão existe cliente que possui tal RG!");
	}
	
	public static void client_exclusion() {
		
		int i = 0;
		boolean check = true;
		
		System.out.print("Informe o RG do cliente que deseja remover: ");
		String rg = Leitura.readLine();
		
		for (Cliente client : clients) {
			
			if (client.get_rg().equals(rg)) {
				
				i = clients.indexOf(client);
				clients.remove(i);

				check = false;
				break;
			}
		}
		
		if (check) 
			System.err.println("\nNão existe cliente que possui tal RG!");
	}
	
	public static void client_visualization() {
		
		boolean check = true;
		
		System.out.print("Informe o RG do cliente que deseja visualizar: ");
		String rg = Leitura.readLine();
		
		for (Cliente client : clients) {
			
			if (client.get_rg().equals(rg)) {
				
				System.out.println(client.visualize());
				check = false;
				break;
			}
		}
		
		if (check)
			System.err.println("\nNão existe cliente que possui tal RG!");
	}
	
	/* -----------xxxxxx--------------xxxxxxxxxx------- PRODUTOS --------xxxxxxxxxxxx---------------xxxxxxxxxxx----------- */
	
	public static void product_insertion() {
		
		System.out.print("Código: ");
		String code = Leitura.readLine();
		
		System.out.print("Nome: ");
		String name = Leitura.readLine();
		
		System.out.print("Valor: ");
		String value = Leitura.readLine();
		
		try {
			Produto product = new Produto(Integer.parseInt(code), name, Float.parseFloat(value));
			products.add(product);
		} catch (NumberFormatException e) {
			System.err.println("\nTipo incorreto encontrado nos dados! \t Integer - String - Float");
		}
	}
	
	public static void product_modification() {
		
		boolean check = true;
		
		System.out.print("Informe o código do produto que deseja alterar: ");
		String old_code = Leitura.readLine();
		
		for (Produto product : products) {
			
			if (product.get_code() == Integer.parseInt(old_code)) {
				
				System.out.println("Informe os novos dados:\n");
				
				System.out.print("Código: ");
				String code = Leitura.readLine();
				
				System.out.print("Nome: ");
				String name = Leitura.readLine();
				
				System.out.print("Valor: ");
				String value = Leitura.readLine();
				
				try {
					product.set(Integer.parseInt(code), name, Float.parseFloat(value));
					check = false;
				} catch (NumberFormatException e) {
					System.err.println("\nTipo incorreto encontrado nos dados! \t Integer - String - Float");
				}
				
				break;
			}
		}
		
		if (check) 
			System.err.println("\nNão existe produto que possui tal código!");
	}
	
	public static void product_exclusion() {
		
		int i = 0;
		boolean check = true;
		
		System.out.print("Informe o código do produto que deseja remover: ");
		String code = Leitura.readLine();
		
		for (Produto product : products) {
			
			if (product.get_code() == Integer.parseInt(code)) {
				
				i = products.indexOf(product);
				products.remove(i);

				check = false;
				break;
			}
		}
		
		if (check) 
			System.err.println("\nNão existe produto que possui tal código!");
	}
	
	public static void product_visualization() {
		
		boolean check = true;
		
		System.out.print("Informe o código do produto que deseja visualizar: ");
		String code = Leitura.readLine();
		
		for (Produto product : products) {
			
			if (product.get_code() == Integer.parseInt(code)) {
				
				System.out.println(product.visualize());
				check = false;
				break;
			}
		}
		
		if (check)
			System.err.println("\nNão existe produto que possui tal código!");
	}
	
	/* -----------xxxxxx--------------xxxxxxxxxx------- VENDAS --------xxxxxxxxxxxx---------------xxxxxxxxxxx----------- */
	
	public static Cliente check_client() {
		
		int i = -1;
		boolean check = true;
		
		System.out.print("Informe o RG do cliente: ");
		String rg = Leitura.readLine();
		
		for (Cliente client : clients) {
					
			if (client.get_rg().equals(rg)) {
				i = clients.indexOf(client);
				check = false;
				break;
			}
		}
				
		if (check) {
			System.err.println("\nNão existe cadastro com este RG! É necessário efetuá-lo.\n");
			client_insertion();
			
			System.out.print("Informe o RG novamente: ");
			String new_rg = Leitura.readLine();
					
			for (Cliente client : clients) {
				if (client.get_rg().equals(new_rg)) {
					i = clients.indexOf(client);
					break;
				}
			}
		}
			
		if (i != -1)
			return clients.get(i);
		 else 
			return null;
	}
	
	public static Produto check_product() {
		
		int i = 0;
		boolean check = true;
		
		System.out.print("Informe o código do produto: ");
		String code = Leitura.readLine();
		
		for (Produto product: products) {
							
			if (product.get_code() == Integer.parseInt(code)) {
				i = products.indexOf(product);
				check = false;
				break;
			}
		}
						
		if (check) {
			System.err.println("\nNão existe produto com este código!\n");
			return null;
		}
		
		return products.get(i);
					
	}
	
	public static void sale_insertion() {
		
		int finalize = 0;
		boolean check = false;
		List<ItemVenda> itens = new ArrayList<ItemVenda>();

		System.out.print("Número: ");
		String number = Leitura.readLine();
		
		System.out.print("Data: ");
		String date = Data.LeituraData();
		
		Cliente client = check_client();
		
		if (client != null) {
			
			do {
				
				System.out.println("\nADICIONE SEUS ITENS");
				
				String quantity = "0";
				Produto product = check_product();
				
				if (product != null) {
					System.out.print("Informe a quantidade: ");
					quantity = Leitura.readLine();
				} else {
					
					if (!check) {
						System.out.println("\nDeseja finalizar? Digite 0! \nContinuar? Qualquer outra tecla!");
						finalize = Integer.parseInt(Leitura.readLine());
						continue;
					}
				}
				
				if (!quantity.equals("0")) {
					
					try {
						ItemVenda item = new ItemVenda(product, product.get_value(), Integer.parseInt(quantity));
						itens.add(item);
						check = true;
					} catch (NumberFormatException e) {
						System.err.println("\nTipo incorreto encontrado nos dados! \t Integer - Integer");
					}
				}
				
				System.out.println("\nDeseja finalizar? Digite 0! \nContinuar? Qualquer outra tecla!");
				finalize = Integer.parseInt(Leitura.readLine());
				
			} while (finalize != 0);
			
			if (check) {
				
				try {
					Venda sale = new Venda(Integer.parseInt(number), date, client, itens);
					sales.add(sale);
				} catch (DataException e) {
					System.err.println("\nA data informada ainda não ocorreu ---> " + date);
				} catch (NumberFormatException e) {
					System.err.println("\nTipo incorreto encontrado nos dados! \t Integer - Date (dd/MM/yyyy)- Cliente - ItemVenda");
				}
			} else {
				System.err.println("\nNão existem itens no carrinho!\n");
			}
		} else {
			System.err.println("\nCliente não encontrado!\n");
		}
	}
	
	public static void sale_exclusion() {
		
		int i = 0;
		boolean check = true;
		
		System.out.print("Informe o número da venda que deseja remover: ");
		String number = Leitura.readLine();
		
		for (Venda sale : sales) {
			
			if (sale.get_number() == Integer.parseInt(number)) {
				
				i = sales.indexOf(sale);
				sales.remove(i);

				check = false;
				break;
			}
		}
		
		if (check) 
			System.err.println("\nNão existe venda que possui tal número!");
	}
	
	public static void sale_visualization() {
		
		boolean check = true;
		
		System.out.print("Informe o número da venda que deseja visualizar: ");
		String number = Leitura.readLine();
		
		for (Venda sale : sales) {
			
			if (sale.get_number() == Integer.parseInt(number)) {
				
				System.out.println(sale.visualize());
				check = false;
				break;
			}
		}
		
		if (check)
			System.err.println("\nNão existe venda que possui tal número!");
	}
}
