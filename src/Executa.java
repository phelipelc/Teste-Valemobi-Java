import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Random;

public class Executa {
	
	public static void main (String args[]) throws SQLException {
		ClienteDao cli = new ClienteDao();
		
		double mfinal=0;
		
		for (int i=1;i<5000;i++) {
			long num = (long) (10000000000L + Math.random() * 89999999999L);
			Random aleatorio = new Random();
			
			Cliente cliente = new Cliente();
			cliente.setNome("Teste"+i);
			cliente.setCpf_cnpj(String.valueOf(num));
			cliente.setSaldo(500+ (10000 - 500) * aleatorio.nextDouble());
			cliente.setStatus(false);
			
			cli.geraClientes(cliente);
		}
		
		for (int i=1;i<5000;i++) {
			long num = (long) (10000000000L + Math.random() * 89999999999L);
			Random aleatorio = new Random();
			
			Cliente cliente = new Cliente();
			cliente.setNome("Teste"+i);
			cliente.setCpf_cnpj(String.valueOf(num));
			cliente.setSaldo(500+ (10000 - 500) * aleatorio.nextDouble());
			cliente.setStatus(false);
			
			cli.geraClientes(cliente);
		}
		
		
	    for(Cliente c :  Cliente.orderList(cli.getClientes())) {
			System.out.println("Nome: " + c.getNome() + 
							" - CPF: " + c.getCpf_cnpj() + 
						    " - Saldo: " + c.getSaldo() + 
						    " - Status: " + c.isStatus() );
	     
			mfinal = mfinal+c.getSaldo();
			
		}
	  
	   mfinal = (mfinal)/cli.getClientes().size();
	   System.out.println("A média final é: "+ mfinal);
	
	}

}








	
	
	
	