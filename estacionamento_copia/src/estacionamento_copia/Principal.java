package estacionamento_copia;



import java.text.ParseException;
import java.util.Scanner;

public class Principal {

	public static void main(String[] args) {
		boolean continua;
		Integer escolha;
		String nome;
		String cpf;
		String cor;
		String placa;
		String modelo;
		Estacionamento estacionamento = new Estacionamento();
		
		Integer vaga;
		String guardaDataHora;
		
		
		
		estacionamento.popularListaVagas(); // PREENCHE A LISTA COM VALORES NULL ------ EXECUTA UMA UNICA VEZ!
		
		
		do {
			
			System.out.println("\n\n                       Escolha sua opcao: \n");
			
			System.out.print("        Para cadastrar ENTRADA do veiculo---------------------digite '1' \n");
			System.out.print("        Para consultar DATA e HORA de ENTRADA do veiculo----- digite '2' \n");
			System.out.print("        Para consultar VAGAS DISPONIVEIS--------------------- digite '3' \n");
			System.out.print("        Para consultar veiculos estacionados------------------digite '4' \n");
			System.out.print("        Para consultar HORARIO de SAIDA do veiculo----------- digite '5' \n");	
			System.out.print("        Buscar vaga por PLACA-------------------------------- digite '6' \n");
			System.out.print("        Buscar vaga por CPF --------------------------------- digite '7' \n");	
			System.out.print("        Buscar carro por vaga ------------------------------- digite '8' \n");
			System.out.print("        RETIRAR veiculo:--------------------------------------digite '9' \n");
			System.out.print("        Exibir HISTORICO DE ENTRADA de veiculos...............digite '10' \n");
			System.out.print("        Exibir HISTORICO DE SAIDA de veiculos.................digite '11' \n");
			System.out.print("        Exibir QUANTIDADE DE VAGAS DISPONIVEIS................digite '12' \n");
			System.out.print("        Exibir VALOR EM CAIXA.................................digite '13' \n");
			System.out.print("        Digite zero (0) para SAIR! >>>>>>>>");
			
			Scanner sc = new Scanner(System.in);
			escolha = sc.nextInt();
			
			continua = true;
			Carro carro = new Carro();// CRIAR A INSTANCIA DENTRO DO LAÇO PARA NAO SOBRESCREVER OS DADOS DOS OBJETOS! ( mesma alocação de memoria)
			Motorista motorista =new Motorista();
			
			switch(escolha) {
			
			
				case 1: {
					
					//--------------- VALORES MOTORISTA
					System.out.println("Informe seu nome ");
					nome = sc.next();
					
					
					System.out.println("Informe seu cpf: ");
					cpf = sc.next();
					
					motorista.setNome(nome);
					motorista.setCpf(cpf);
					carro.setMotorista(motorista);
					
					//---------------------VALORES CARRO
					
					
					System.out.println("Informe a placa do veiculo: ");
					placa = sc.next();
					carro.setPlaca(placa);
					
					
					System.out.println("Informe a cor do veiculo: ");
					cor = sc.next();
					
					carro.setCor(cor);
					
					System.out.println("Informe o modelo do veiculo: ");
					modelo = sc.next();
					
					carro.setModelo(modelo);
					
					
					estacionamento.setCarro(carro); 
					
					
					//----------------------------------------------------------------------------------
					
					estacionamento.vagasDisponiveis();										
					System.out.println("Informe a vaga que deseja estacionar: ");
					vaga = sc.nextInt();
					estacionamento.setMapMotoristas(placa, carro.getMotorista());
					estacionamento.estacionarCarro(vaga, carro); 
									
					
				break;
				}
				
				case 2: {
					System.out.println(" Informe a PLACA para consultar o horario: ");
					 String placaBusca =sc.next();
					 estacionamento.buscaHoraEntradaPorPlaca(placaBusca);					 
					 break;
				}
				
				case 3: {
					estacionamento.vagasDisponiveis();
					break;
				}
				
				case 4: {
					estacionamento.mostraCarroEstacionado();						
					break;
				}
				
				case 5: {
					System.out.println(" Informe a PLACA para consultar o HORARIO DE SAIDA: ");
					 String placaBuscaSaida =sc.next();
					 estacionamento.buscaHoraSaidaPorPlaca(placaBuscaSaida);				
					 break;
				}
				
				case 6: {
					System.out.println("Informe a PLACA para a busca: ");
					String placaBuscada = sc.next();
					estacionamento.buscaVagaPorPlaca(placaBuscada);
					break;
				}
				
				case 7: {
					System.out.println(" Informe o CPF do motorista: ");
					String cpfPorVaga = sc.next();
					estacionamento.buscaVagaPorCpf(cpfPorVaga);
					break;
				}
				
				case 8: {
					System.out.println("Informe o numero da VAGA: >>>>>>");
					int vagaEscolhida = sc.nextInt();					
					estacionamento.buscaCarroPorVaga(vagaEscolhida);
					break;
				}
				
				case 9: {
					System.out.println(" informa  a PLACA do veiculo a retirar: ");
					String placaRetirar = sc.next();					;
					if(estacionamento.retirarCarroDaVaga(placaRetirar)) {
						estacionamento.checkout(placaRetirar);
					}
					
					break;
				}
				
				case 10: {					
					estacionamento.exibeHistoricoEntrada();					
					break;
				}
				
				case 11: {					
					estacionamento.exibeHistoricoSaida();		
					break;
				}
				
				case 12: {					
					estacionamento.quantidadeVagasVazias();					
					break;
				}
				
				case 13: {		
					System.out.print("\n\n Valor total em caixa e: " + estacionamento.calculaValorEmCaixa() + " reais");			
					break;
				}
				
				case 0: {
					continua = false;
					sc.close();
					System.out.println("Saindo...\n");
					break;
					
				}		
				
				default: {
					System.out.println(" Digite uma operacao valida! \n");
					break;
				}			
				
			
			
			}
			

	}while(continua);
		
		
		
		
	}
}
