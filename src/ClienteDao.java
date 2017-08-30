
import java.util.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Random;

public class ClienteDao {
	
	private Object connection;

  public ClienteDao() {
		this.connection = new ConnectionFactory().getConnection();      
  }
  
		public void geraClientes(Cliente cliente) {
			String sql = "insert into tb_customer_account " + 
		"(nm_customer,cpf_cnpj,vl_total,is_active)" + "values(?,?,?,?)";
	               
			
			try {
							
				
				PreparedStatement stmt = ((Connection) this.connection).prepareStatement(sql);
				

				stmt.setString(1,cliente.getNome());
				stmt.setString(2,cliente.getCpf_cnpj());
				stmt.setDouble(3,cliente.getSaldo());
				stmt.setBoolean(4,cliente.isStatus());

				stmt.execute();
				stmt.close();
				
				} catch (SQLException e) {
				throw new RuntimeException(e);
				}
	                
	          
	                          	
	                      
	        
		}
		
		
		
		public List<Cliente>  getClientes(){
		
			try {
				List<Cliente> contatos= new ArrayList<Cliente>();
			PreparedStatement stmt = ((Connection) this.connection) .prepareStatement(
					"select * from tb_customer_account where id_customer > 1500 and id_customer < 2700 and vl_total > 560");
					ResultSet rs = stmt.executeQuery();
					
					

					while (rs.next()) {
					Cliente client = new Cliente();
					client.setNome(rs.getString("nm_customer"));
					client.setCpf_cnpj(rs.getString("cpf_cnpj"));
					client.setSaldo(rs.getDouble("vl_total"));
					client.setStatus(rs.getBoolean("is_active"));
					
				    contatos.add(client);
				   
					
					}
					
					return contatos;
					
			}catch(SQLException e){
				throw new RuntimeException(e) ;
			}	
		}
}



