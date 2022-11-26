package estacionamento_copia;





public class Carro {
	private String placa;
	private String modelo;
	private String cor;
	private Motorista motorista;
	
	
	
	
	
	public Motorista getMotorista() {
			return motorista;
	}
	public void setMotorista(Motorista motorista) {
			this.motorista = motorista;
	}
 
	 
	public String getModelo() {
		return modelo;
	}
	public void setModelo(String modelo) {
		this.modelo = modelo;
	}
	public String getCor() {
		return cor;
	}
	public void setCor(String cor) {
		this.cor = cor;
	}
	public String getPlaca() {
		return placa;
	}
	public void setPlaca(String placa) {
		this.placa = placa;
	}
	
	@Override
    public String toString() {
        return " veiculo: placa: " + this.placa 
        		+ " cor: " + this.cor
        		+ " modelo: " + this.modelo
        		+ "  ";
        		}
	
	
	
	
	
	
	
}
