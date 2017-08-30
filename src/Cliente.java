import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Cliente{

	private String cpf_cnpj;
	private String nome ;
	private boolean status;
	private Double saldo;
	
	public String getCpf_cnpj() {
		return cpf_cnpj;
	}
	public void setCpf_cnpj(String cpf_cnpj) {
		this.cpf_cnpj = cpf_cnpj;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getNome() {
		
		return nome;
	}
	
	public boolean isStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}
	public Double getSaldo() {
		return saldo;
	}
	public void setSaldo(Double saldo) {
		this.saldo = saldo;
	}
	
	//Ordena lista de objeto cliente
	public static List<Cliente> orderList(List<Cliente> clientes){
		Collections.sort(clientes, new Comparator<Cliente>() {
		    @Override
		    public int compare(Cliente c1, Cliente c2) {
		        return Double.compare(c1.getSaldo(), c2.getSaldo());
		    }
		});
		return clientes;
	}
	
}
