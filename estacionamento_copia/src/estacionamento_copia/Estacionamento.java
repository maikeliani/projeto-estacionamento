package estacionamento_copia;



import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;



public class Estacionamento {
	
	
	private String dataEntradaFormatada;
	private String horaEntradaFormatada;
	private String dataSaidaFormatada;
	private String horaSaidaFormatada;
	private Double valorPorHora = 5.00;
	private int quantidadeTotalVagas = 50;
	private int quantidadeVagaOcupada =0;
	
	private Date horaEntrada;
	private Date horaSaida ;
	private String dataHora;
	private String dataHoraSaida;
	
	private   Carro carro;
	private int contadorVagas = 0;	
	private Date horaParaCalculo;
	 
	List <Carro>vagas = new ArrayList<>();	 
	private  Map<Carro,String> mapHoraEntrada = new HashMap<Carro,String>(); 
	private  Map<Carro,String> mapEntradaFormatada = new HashMap<Carro,String>(); 
	private  Map<String,String> mapHoraSaida = new HashMap<String,String>(); 
	private  Map<String,String> mapSaidaFormatada = new HashMap<String,String>(); 
	private  Map<String,Motorista> mapMotoristas = new HashMap<String,Motorista>(); 
	private  Map<String,Double> mapValorEmCaixa = new HashMap<String,Double>(); 
	  
	  
	
	//------------------getters e setters--------------------------------------
	  
	
	
	
	
	public Map<Carro, String> getMapHoraEntrada() { 
		return mapHoraEntrada;
	}	
	public void setMapMotoristas(String placa, Motorista motorista) {
		this.mapMotoristas.put(placa, motorista);
	}
	public void setMapHoraEntrada(Carro carro, String hora) {
		this.mapHoraEntrada.put(carro, hora); 
	}
	
	
	
	public Map<String, String> getMapHoraSaida() {
		return mapHoraSaida;
	}	
	public void setMapHoraSaida(String placa, String hora) { 
		this.mapHoraSaida.put(placa, hora); // 
	}
	
	
	

	
	public String getHoraEntrada() {
		DateTimeFormatter formatter = DateTimeFormatter.ofLocalizedDate(FormatStyle.SHORT);
		//formatter.
    	horaEntrada = new Date(); 
    	dataEntradaFormatada = new SimpleDateFormat("dd/MM/yyyy").format(horaEntrada); 
    	horaEntradaFormatada = new SimpleDateFormat("HH:mm:ss").format(horaEntrada);
     	this.dataHora = dataEntradaFormatada + " " + horaEntradaFormatada ;  
    	return this.dataHora;
    }		
	
	public String getHoraSaida() {
		horaSaida = new Date();
		dataSaidaFormatada = new SimpleDateFormat("dd/MM/yyyy").format(horaSaida); 
    	 horaSaidaFormatada = new SimpleDateFormat("HH:mm:ss").format(horaSaida);    	
     	this.dataHoraSaida = dataSaidaFormatada + " " + horaSaidaFormatada ;  
    	return this.dataHoraSaida;
	}
	
	
	public Carro getCarro() {
		return carro;
	}
	public void setCarro(Carro carro) {
		this.carro = carro;
	}
	
	
	
	
	
	
	//---------------------------------------METODOS---------------------------------
	
	
	
	
	public void estacionarCarro(Integer vaga, Carro carro){ 
		
		
		if(vaga > 50) {
			System.out.println("Vaga nao existe. Sao 50 vagas no total");
			return;
		}
		
					
		if(vagas.get((vaga-1)) == null) {
			vagas.remove((vaga-1)); 
			vagas.add((vaga-1), carro);  
			
			getHoraEntrada(); 
			setMapHoraEntrada(carro, this.dataHora);  
			mapEntradaFormatada.put(carro, this.horaEntradaFormatada); 
			quantidadeVagaOcupada++;
			
			System.out.println(" Vaga " + (vaga)+ " liberado para estacionar.");	
			System.out.println(" Carro a ser estacionado na vaga " + ((vaga)));   
			
		}else {
			System.out.println("Vaga ja esta ocupada");
		}
	System.out.println(vagas.get((vaga-1))); // 
	}
	
	
	
	
	
	public  void vagasDisponiveis() {
		
		System.out.println("\n\n VAGAS DISPONIVEIS: \n");
			
			boolean contador = false;
			for(int i=0; i < vagas.size(); i++) {
				if(vagas.get(i) == null) {
					System.out.println("Vaga " + (i+1) + " esta disponivel");
					contador =true;;
				}else {
					continue;
				}
			}
			if(contador == false) {
				System.out.println("Sem vagas disponiveis no momento");
			}
		}
	
	
    	


	public void buscaVagaPorPlaca(String placaBuscada) {  
		boolean buscada = false;
		for(int i = 0; i < vagas.size(); i++) {
			if((vagas.get(i) != null ) && (vagas.get(i).getPlaca().equals(placaBuscada)) )  {
				System.out.println("A vaga buscada e a vaga " + (i+1));
				buscada = true;
				break;
			}else 
				continue;
			}
		
		if(buscada ==false) {
			System.out.println("Nao foi encontrado nenhum veiculo com a placa informada");
		}
	}
	

	
	  
	    public void mostraCarroEstacionado() { 
	    	boolean contadorCarros = false;
	    	for(int i=0; i < vagas.size(); i++) {
	    		if(vagas.get(i) != null) {
	    			System.out.println("Vaga: " + (i+1) + " modelo: " + vagas.get(i).getModelo()+ " "
	    		+" " +" cor: " + vagas.get(i).getCor()+ " " + " placa: " +  vagas.get(i).getPlaca());
	    			contadorCarros =true;
	    			
	    		}else {
	    			continue;
	    		}
	    	}
	    	
	    	if(contadorCarros == false) {
	    		System.out.println("Sem carros estacionados no momento");
	    	}
	    }
	    
	    
	    
	    
	    
	    public void buscaVagaPorCpf(String cpfInformado) {   
	    	
	    	boolean encontrada = false;
	    	for(int i = 0; i < vagas.size(); i++) {
				if(( vagas.get(i) == null ) ) {
					continue;
				}else if(( vagas.get(i).getMotorista().getCpf().equals(cpfInformado))){
						System.out.println("A vaga procurada e: " + (i+1));
						encontrada = true;
						break;
					}else {
						continue;
					}
	    	
				}
	    		if(encontrada==false) {
	    			System.out.println("Nao foi encontrado veiculo no cpf informado");
	    		}
	    	}
	    
	    
	    
	    
	    
	    
	    
	    public void buscaCarroPorVaga(int vaga) { 
	    	if(vagas.get((vaga-1)) != null) {    		
	    		  System.out.println("veiculo --> modelo: " + vagas.get((vaga-1)).getModelo()
	    				+ "  cor: " + vagas.get((vaga-1)).getCor()
	    				+ "  placa: " + vagas.get((vaga-1)).getPlaca());    		 
	    	} else {
	    		System.out.println(" A vaga " + (vaga) + " esta vazia!");
	    	}
	    }
	    
	    
	    
	    
	    
	    public String buscaHoraEntradaPorPlaca(String placaDesejada) { 
	    	String horaDeEntradaVeiculo ="";
    		for (Entry<Carro, String> mapa :  mapHoraEntrada.entrySet()) {
    			if(mapa.getKey().getPlaca().equals(placaDesejada)) {
    				System.out.println(" HORARIO DE ENTRADA --> "+ mapa.getValue());  
    				horaDeEntradaVeiculo =  mapa.getValue();
    				break;
    			}else {
    				System.out.println("");
    			}
    		} 
    		return horaDeEntradaVeiculo;
	    }
	    
	          
	 
		public boolean retirarCarroDaVaga(String placaParaRetirar) { 
	    	
			boolean encontrada = false;
	    	for(int i = 0; i < vagas.size(); i++) {    		
	    		
	    		if(vagas.get(i) == null) {
	    			continue;
	    		}else if(vagas.get(i).getPlaca().equals(placaParaRetirar) ) {
	    			encontrada = true;	 
	    			
					setMapHoraSaida(placaParaRetirar, getHoraSaida());
					mapSaidaFormatada.put(placaParaRetirar,horaSaidaFormatada ) ;  
					
					vagas.remove(vagas.get(i));
					quantidadeVagaOcupada--;					
					System.out.println(" A vaga agora esta disponivel.");					
					
	    		}else {
	    			continue;
	    		}				
			}
	    	if(encontrada ==false) {
    			System.out.println("Nenhuma veiculo encontrado com a placa fornecida.");
    		}
			return encontrada;
	    	
	    	
	    }
	    	
	    
	    
	    
	
		public String buscaHoraSaidaPorPlaca(String placaDesejada) { 
			String horarioDaSaidaPorPlaca = "";
    		for (Entry<String, String> mapa :  mapHoraSaida.entrySet()) {
    			if(mapa.getKey().equals(placaDesejada)) {
    				horarioDaSaidaPorPlaca = mapa.getValue();
    				System.out.println(" HORARIO DE SAIDA --> "+ mapa.getValue()); 
    				break;
    			} else if(mapa.getKey() != null) {
    				System.out.println(" ");
    			}
    		} 
    		return horarioDaSaidaPorPlaca;
	    }
	    
	    
	    
	    public void popularListaVagas() { 
	    	int x=0;
	    	while(x < 50) {
	    		vagas.add(null);
	    		x++;
	    	}
	    	
	    }
	    
	    	
	    public void quantidadeVagasVazias() {
	    	
	    	int vagasVazias = (quantidadeTotalVagas - quantidadeVagaOcupada); 
	    	System.out.println(" No momento temos " + vagasVazias + " vagas disponiveis.");
	    	
	    }
	    
	    
	    public void exibeHistoricoEntrada() {	    		    	

	    	for (Entry<Carro, String> mapa :  mapHoraEntrada.entrySet()) {
	    		
	    		System.out.println(mapa.getKey().toString()+ " Motorista: " +
	    		mapa.getKey().getMotorista().toString() + "  HORARIO DE ENTRADA:  " + mapa.getValue() +"\n");
	    	}
	    		    	
	    }
	        	  
	    
	    
	    
	    public void exibeHistoricoSaida(){ 	  
	    	List <Motorista>copiaMotoristas = new ArrayList<>();
	    	List <String>copiaPlacas = new ArrayList<>();
	    	
	    	for (Entry<String, Motorista> mapa :  mapMotoristas.entrySet()) {	    		 
	    		copiaPlacas.add(mapa.getKey()); 
	    		copiaMotoristas.add(mapa.getValue()); 	    		
	    	}
	    	
	    
		    for (Entry<String, String> mapa :  mapHoraSaida.entrySet()) {
		    		
		    	for( int i=0; i < copiaPlacas.size(); i++) {
		    		if(mapa.getKey().equals(copiaPlacas.get(i))) {
		    			System.out.println("Veiculo:  placa:  " + copiaPlacas.get(i)
		    			+"  Motorista: " + copiaMotoristas.get(i).toString()
		    			+ " Horario de saida:  " + mapa.getValue());
		    		}else {
		    				continue;
		    		}
		    	}
		    }
	    			
	    }
	    		
	    		    	
	    
	    
	    
	    public String buscaEntradaFormatadaPorPlaca(String placaDesejada) {
	    	String horaDeEntradaVeiculo ="";
    		for (Entry<Carro, String> mapa :  mapEntradaFormatada.entrySet()) {
    			if(mapa.getKey().getPlaca().equals(placaDesejada)) {
    				  
    				horaDeEntradaVeiculo =  mapa.getValue();
    				break;
    			}else {
    				System.out.println("");
    			}
    		} 
    		return horaDeEntradaVeiculo;
	    }
	    
		public String buscaSaidaFormatadaPorPlaca(String placaDesejada) {  
			String horarioDaSaidaPorPlaca = "";
    		for (Entry<String, String> mapa :  mapSaidaFormatada.entrySet()) {
    			if(mapa.getKey().equals(placaDesejada)) {
    				horarioDaSaidaPorPlaca = mapa.getValue(); 
    				
    				break;
    			} else if(mapa.getKey() != null) {
    				System.out.println(" ");
    			}
    		} 
    		return horarioDaSaidaPorPlaca;
	    }
	    
	    
	    
	    
	    public void checkout(String placa)  {
	    	
		    	String horaDeEntradaVeiculo = buscaEntradaFormatadaPorPlaca(placa); 
		    	String horaDeSaidaVeiculo =  buscaSaidaFormatadaPorPlaca(placa); 
		    	 Double valor;
	
		    	
		    	
		    	SimpleDateFormat conversor = new SimpleDateFormat("HH:mm:ss");
		    	
		        Date entrada = null;
		        Date saida = null;
		        try {
		           entrada = conversor.parse(horaDeEntradaVeiculo);
		           saida = conversor.parse(horaDeSaidaVeiculo);
		           long diferencaMS = saida.getTime() - entrada.getTime();

		          
		           long diferencaSegundos = diferencaMS / 1000;
		           long diferencaMinutos = diferencaSegundos / 60;
		           long diferencaHoras = diferencaMinutos / 60;
		           long diferencaDias = diferencaHoras / 24;
			       
		           
		           
		           System.out.println("Tempo na vaga: " + diferencaMinutos + "minuto(s)" );
		           
		           
		           if(diferencaHoras < 1) {
		        	    valor = valorPorHora;
		        	   System.out.println("Veiculo permaneceu pr menos de 1 hora. Sera cobrado valor minimo.");
		           }else  {
		        	   int horaCompleta =  (int) (diferencaMinutos/60);
		        	  Double horaIncompleta =   (double) (diferencaMinutos- ( horaCompleta*60));
		        		valor = ( horaCompleta * valorPorHora )	+ ((horaIncompleta/60) * valorPorHora);    
		           }
		           
		           
		           System.out.println("O valor total é: " + valor);
			     
		        } catch (java.text.ParseException e) { return; }

		          	 mapValorEmCaixa.put(placa, valor);   	
		    	
	    }
	    
	    
	    
	    public Double calculaValorEmCaixa() {  
			Double total =0.0;
			if(mapValorEmCaixa.isEmpty()) {
				return 0.0;
			}
    		for (Entry<String, Double> calc :  mapValorEmCaixa.entrySet()) {
    			total+= calc.getValue();
    		} 
    		return total;
	    }
	    
	  
	   
}
