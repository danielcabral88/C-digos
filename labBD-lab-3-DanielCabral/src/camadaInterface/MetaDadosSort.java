package camadaInterface;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

import camadaDTO.*;
import camadaNegocios.*;

public class MetaDadosSort extends JFrame{
	JTable tabela;
	JScrollPane tabPainel;
	JPanel painelNorte;
	JPanel painelCentral;
	JPanel painelSul;
	JButton btnBuscar;
	JTextField txtBuscar;
	DefaultTableModel tabelaModelo;
	List<Historico> listaHistorico;
	ArrayList<String> nomeTabela;
	
	public MetaDadosSort(){
		super.setTitle("Consulta Meta Dados");
		super.setResizable(true);
		
		painelNorte = new JPanel();
		painelCentral = new JPanel();
		painelSul = new JPanel();
		
		GridLayout gLayoutNorte = new GridLayout();
		painelNorte.setLayout(gLayoutNorte);
	
		GridLayout gLayoutSul = new GridLayout();
		painelSul.setLayout(gLayoutSul);
		
		btnBuscar = new JButton("Buscar");
		txtBuscar = new JTextField();
		painelNorte.add(txtBuscar);
		painelNorte.add(btnBuscar);
		
		
		tabelaModelo = new DefaultTableModel();
		tabela = new JTable(tabelaModelo);
		
		TableRowSorter<TableModel> sorter = new TableRowSorter<TableModel>(tabela.getModel()); // Cria-se um objetor sorte para a tabela
		tabela.setRowSorter(sorter); // aplica-se a propriedade sorte a tabela
		
		tabPainel = new JScrollPane(tabela);
		GridLayout gLayoutCentral = new GridLayout(1,1);
		painelCentral.setLayout(gLayoutCentral);
		painelCentral.add(tabPainel);
			
		getContentPane().add(painelCentral, BorderLayout.CENTER);
		getContentPane().add(painelNorte, BorderLayout.NORTH);
		getContentPane().add(painelSul, BorderLayout.SOUTH);
		
		listenerBtBuscar listenerBuscar = new listenerBtBuscar();
		btnBuscar.addActionListener(listenerBuscar);
	}
	
	class listenerBtBuscar implements ActionListener{
		public void actionPerformed(ActionEvent e){
			//if(e.getActionCommand().equals(btnBuscar.getText())) {
				tabelaModelo.setNumRows(0);
				tabelaModelo.setColumnCount(0);
				NGHistorico objNGHistorico = new NGHistorico();
				//Historico objHistorico = new Historico();
				List<Historico> listaHistorico = new ArrayList<Historico>();
				List<String> nomeTabela = new ArrayList<String>();
				
				listaHistorico = objNGHistorico.consultaDistinct();
				nomeTabela = objNGHistorico.getNomeMetaDados();
					
				//if(listaHistorico.isEmpty() != true){
				NGCliente objNGCliente = new NGCliente();
				ArrayList<Cliente> listaCliente = new ArrayList<Cliente>();
				NGConta objNGConta = new NGConta();
				ArrayList<Conta> listaConta = new ArrayList<Conta>();
				for (Historico hs : listaHistorico){
						listaCliente.add(objNGCliente.consultaPorID(hs.getClienteID()));
						listaConta.add(objNGConta.consultaPorID(hs.getContaNumero()));
				}
				//}
				int i = nomeTabela.size();
				Object row[] = new Object[i+1];
				for(String n : nomeTabela){
					tabelaModelo.addColumn(n.toString());
				}
				for(int j=0;j<i+1;j++){
						row[0] = listaCliente.get(j).getNome();
						row[1] = listaConta.get(j).getNumero();
						row[2] = String.valueOf(listaConta.get(j).getSaldo());
						tabelaModelo.addRow(row);
				}
				
				
			//}
		}
				
	}

}
