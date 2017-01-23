package camadaInterface;

import java.awt.BorderLayout;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;


public class TransferenciaBancaria extends JFrame {
	JPanel painelSul;
	JPanel painelPrincipal;
	JPanel painelNorte;
	JButton btnTransf;
	JTextField txtValor;
	JTextField txtConta1;
	JTextField txtConta2;
			
	public TransferenciaBancaria(){
		super.setTitle("Transferencia");
		super.setResizable(false);
		
		painelPrincipal = new JPanel();
		painelSul = new JPanel();
				
		GridLayout gLayoutP = new GridLayout(1,3);
		painelPrincipal.setLayout(gLayoutP);
		
		GridBagLayout gLayoutSul = new GridBagLayout();
		painelSul.setLayout(gLayoutSul);
		
		//GridLayout gLayoutN = new GridLayout(1,3);
		//painelNorte.setLayout(gLayoutN);
		
		btnTransf = new JButton("Transferir");
		txtValor = new JTextField();
		txtConta1 = new JTextField();
		txtConta2 = new JTextField();
		
		painelPrincipal.add(txtValor);
		painelPrincipal.add(txtConta1);
		painelPrincipal.add(txtConta2);
		painelSul.add(btnTransf);
			
		getContentPane().add(painelPrincipal, BorderLayout.CENTER);
		getContentPane().add(painelSul, BorderLayout.SOUTH);
				
		listenerBtTransf listenerTransf = new listenerBtTransf();
		btnTransf.addActionListener(listenerTransf);
	}
	
	
	
	
	class listenerBtTransf implements ActionListener{
		public void actionPerformed(ActionEvent e){
			if(e.getActionCommand().equals(btnTransf.getText())) {
				
			}
		}


	}
}
