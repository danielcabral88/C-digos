package camadaInterface;

import java.awt.EventQueue;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

import javax.swing.JFrame;

import camadaDTO.*;
import camadaNegocios.*;

public class Main {

	JFrame meuFrame;
	/**
	 * @param args
	 * @throws Exception 
	 * @throws SQLException 
	 * @throws ClassNotFoundException 
	 */
	public static void main(String[] args){
		/*HistoricoGUI meuFrame = new HistoricoGUI();
		//MetaDadosSort meuFrame = new MetaDadosSort();
		TransferenciaBancaria meuFrame = new TransferenciaBancaria();
		meuFrame.setSize(500, 400);
		meuFrame.setVisible(true);
		meuFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);*/
		Date hoje = new Date();
		SimpleDateFormat simp = new SimpleDateFormat ("dd/MM/yyyy");	
		
		Cliente objCliente = new Cliente();
		ArrayList<Cliente> listaCliente = new ArrayList<Cliente>();
		NGCliente objNGCliente = new NGCliente();
		
		Historico objHistorico = new Historico();
		ArrayList<Historico> listaHistorico = new ArrayList<Historico>();
		NGHistorico objNGHistorico = new NGHistorico();
		
		Conta objConta = new Conta();
		ArrayList<Conta> listaConta = new ArrayList<Conta>();
		NGConta objNGConta = new NGConta();
		
		Scanner scanner = new Scanner( System.in );  
		int i = 0;
		
		do{
			
			System.out.println("Digite um numero de 6 digitos para o ID do Cliente :");
			objCliente.setID(scanner.nextLine());
			objHistorico.setClienteID(scanner.nextLine());
			System.out.println("Digite o nome do Cliente :");
			objCliente.setNome(scanner.nextLine());
			System.out.println("Digite o Endereço do Cliente :");
			objCliente.setEndereco(scanner.nextLine());
			System.out.println("Digite o Telefone do Cliente:");
			objCliente.setTelefone(scanner.nextLine());
			
			System.out.println("Digite um numero de 6 digitos para a conta :");
			objConta.setNumero(scanner.nextLine());
			objHistorico.setContaNumero(scanner.nextLine());
			
			System.out.println("Digite o valor do deposito inicial: ");
			objConta.setSaldo(Float.parseFloat(scanner.nextLine()));
			objHistorico.setValor(Float.parseFloat(scanner.nextLine()));
			
			//objConta.setDataAbertura (simp.format(hoje));
			
			System.out.println("Digite o Numero da Agencia :");
			objConta.setAgenciaNumero(Integer.parseInt(scanner.nextLine()));
			
			objHistorico.setOperacao(true);
			objHistorico.setCodigo(12 + i);
			
			listaCliente.add(objCliente);
			listaConta.add(objConta);
			listaHistorico.add(objHistorico);
			
			
		} while (i == 0);
		
		objNGConta.inserirBath(listaConta);
		objNGCliente.inserirBath(listaCliente);
		objNGHistorico.inserirBath(listaHistorico);		
		
	}
}