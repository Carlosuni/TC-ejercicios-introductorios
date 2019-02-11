package auxClasses;
import java.math.BigInteger;

public class DivisorAlgo1 {
	private BigInteger valor;
	private boolean usado;

	
	public DivisorAlgo1() {
		super();
		this.valor = new BigInteger("1");
		this.usado = false;
	}
	
	public DivisorAlgo1(BigInteger valor, boolean usado) {
		super();
		this.valor = valor;
		this.usado = usado;
	}
		
	public BigInteger getValor() {
		return valor;
	}
	public void setValor(BigInteger valor) {
		this.valor = valor;
	}
	public boolean isUsado() {
		return usado;
	}
	public void setUsado(boolean usado) {
		this.usado = usado;
	}	
	
}
