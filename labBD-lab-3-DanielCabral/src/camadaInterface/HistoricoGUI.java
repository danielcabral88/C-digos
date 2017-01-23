package camadaInterface;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.*;
import java.util.List;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import camadaNegocios.*;
import camadaDTO.*;

@SuppressWarnings("serial")
public class HistoricoGUI extends JFrame {
	
	JTable tabela;
	JScrollPane tabPainel;
	JPanel painelNorte;
	JPanel painelCentral;
	JPanel painelSul;
	JButton btnBuscar;
	JTextField txtBuscar;
	DefaultTableModel tabelaModelo;
	
	public HistoricoGUI(){
		super.setTitle("Consulta");
		super.setResizable(true);
		
		painelNorte = new JPanel();
		painelCentral = new JPanel();
		painelSul = new JPanel();
		
		GridLayout gLayoutNorte = new GridLayout();
		painelNorte.setLayout(gLayoutNorte);
		
		//GridBagLayout gLayoutCentro = new GridBagLayout();
		//painelCentral.setLayout(gLayoutCentro);
		
		GridLayout gLayoutSul = new GridLayout();
		painelSul.setLayout(gLayoutSul);
		
		btnBuscar = new JButton("Buscar");
		txtBuscar = new JTextField();
		
		tabelaModelo = new DefaultTableModel(null,
				new String[]{"Operacao","Valor","Cliente_ID","Nome","Conta","Saldo"});
		tabela = new JTable(tabelaModelo);
		tabPainel = new JScrollPane(tabela);
		GridLayout gLayoutCentral = new GridLayout(1,1);
		painelCentral.setLayout(gLayoutCentral);
		painelCentral.add(tabPainel);
		

		/*DefaultTableModel modelo = new DefaultTableModel(null,
				new String[]{"Codigo","Operacao","Valor","Cliente_ID","Numero Conta"});
		tabela = new JTable(modelo);
		tabPainel = new JScrollPane(tabela);
		
		painelCentral.add(tabPainel);*/
		
		/*GridBagConstraints gbC1 = new GridBagConstraints();
		gbC1.fill = GridBagConstraints.HORIZONTAL;
		gbC1.gridx = 0;
		gbC1.gridy = 0;*/
		painelNorte.add(txtBuscar);
		
		/*GridBagConstraints gbC2 = new GridBagConstraints();
		gbC2.fill = GridBagConstraints.BOTH;
		gbC2.gridx = 1;
		gbC2.gridy = 1;*/
		painelNorte.add(btnBuscar);
			
		getContentPane().add(painelCentral, BorderLayout.CENTER);
		getContentPane().add(painelNorte, BorderLayout.NORTH);
		getContentPane().add(painelSul, BorderLayout.SOUTH);
		
		listenerBtBuscar listenerBuscar = new listenerBtBuscar();
		btnBuscar.addActionListener(listenerBuscar);
	}
	
	
	
	
	class listenerBtBuscar implements ActionListener{
		public void actionPerformed(ActionEvent e){
			if(e.getActionCommand().equals(btnBuscar.getText())) {
				tabelaModelo.setNumRows(0);
				//HistoricoDAO objHistoricoDAO = new HistoricoDAO(); // tive problema na ordem de abertura da conexão, pois a mesma é feita quando o objeto é instanciado
				//ClienteDAO objClienteDAO = new ClienteDAO(); //
				Cliente objCliente = new Cliente();
				
				List<Historico> lista = new ArrayList<Historico>();
				
				NGCliente objNGCliente = new NGCliente();
				objCliente = objNGCliente.consultaPorNome(txtBuscar.getText());
				
				NGHistorico objNGHistorico = new NGHistorico();
				lista = objNGHistorico.consultaPorID(objCliente.getID());
				
				//lista = objHistoricoDAO.consultaPorID(objCliente.getID());
				/*List<Cliente> clienteList = new ArrayList<Cliente>();
				clienteList = objClienteDAO.Consultar(); */
				float valor = 0;
				String[] dados = new String[7];
				for (Historico hs : lista){
					boolean op = hs.isOperacao();
					if (op == true){
						dados[0] = "DEPOSITO";
						valor = valor + hs.getValor();
					}
					else{
						dados[0] = "SAQUE";
						valor = valor - hs.getValor();
					}
					
					dados[1] = String.valueOf(hs.getValor());
					dados[2] = String.valueOf(hs.getClienteID());
					dados[3] = objCliente.getNome();
					dados[4] = String.valueOf(hs.getContaNumero());
					dados[5] = String.valueOf(valor);
					tabelaModelo.addRow(dados);
				}
			}
		}
				
	}
}
