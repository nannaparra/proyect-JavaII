package Proyecto;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;

import java.awt.Font;
import java.awt.Color;

import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.border.TitledBorder;

import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JTextPane;
import javax.swing.JComboBox;
import javax.swing.border.EtchedBorder;

import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

import javax.swing.SwingConstants;

import java.awt.ComponentOrientation;
import java.awt.Insets;
import java.awt.Dimension;
import javax.swing.ImageIcon;





@SuppressWarnings("serial")
public class GUI extends JFrame {
	
    private Logica logica=new Logica();
    private Carteles carteles=new Carteles();
	private JPanel contentPane;
	private JTextField txtObjeto;
	private JTextField txtDiferencia;
	
	private JTextArea txtrPreguntas = new JTextArea();
	private JPanel panel = new JPanel();
	private JPanel panel_1 = new JPanel();
	private JLabel lblbienvenidosAlAdivinador = new JLabel("\u00A1Bienvenidos al Adivinador ");
	private JButton btnNewButton = new JButton("Nuevo Juego");
	private JButton btnNewButton_1 = new JButton("Continuar");
	private JPanel panel_2 = new JPanel();
	private JButton btnSi = new JButton("SI");
	private JButton btnNo = new JButton("NO");
	private JLabel lblNewLabel_4 = new JLabel("\u00BF");
	private JLabel label = new JLabel("?");
	private JPanel panel_3 = new JPanel();
	private JTextArea txtrDescripcionDeLos = new JTextArea();
	private JPanel panel_4 = new JPanel();
	private JLabel lblNewLabel = new JLabel("\u00BFEn qu\u00E9 transporte est\u00E1s pensando?");
	private JPanel panel_5 = new JPanel();
	private JLabel lblquDiferenciaHay= new JLabel("\u00BFQu\u00E9 diferencia hay entre un auto y ?");
	private JPanel panel_6 = new JPanel();
	private JLabel lblNewLabel_1 = new JLabel("Altura:");
	private JLabel lblNewLabel_2 = new JLabel("Cantidad de Objetos:");
	private JLabel lblNewLabel_3 = new JLabel("Cantidad de Preguntas:");
	private JTextPane textPane_1 = new JTextPane();
	private JTextPane textPane_2 = new JTextPane();
	private JTextPane textPane = new JTextPane();
	private JPanel panel_7 = new JPanel();
	private JTextPane textPane_3 = new JTextPane();
	private JPanel panel_8 = new JPanel();
	private JComboBox<String> comboBox=new JComboBox<String>();
	private JButton btnNewButton_2 = new JButton("Eliminar");
	private String obj;
	private final JLabel lblDeTransportes = new JLabel("de Transportes!");
	private JLabel lblEstasPensandoEn = new JLabel("La pregunta es..");
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUI frame = new GUI();
					frame.setVisible(true);
					frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public GUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 478, 572);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		//Panel 1
		panel_1.setBounds(0, 0, 474, 555);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		panel.setBackground(Color.WHITE);
		
		//Panel
		panel.setBorder(null);
		panel.setBounds(10, 8, 444, 86);
		panel.setOpaque(false);
		panel_1.add(panel);
		panel.setLayout(null);
		lblbienvenidosAlAdivinador.setBackground(Color.WHITE);
		lblbienvenidosAlAdivinador.setToolTipText("\u00A1Bienvenidos al Adivinador");
		lblbienvenidosAlAdivinador.setVerticalAlignment(SwingConstants.TOP);
		
		
		lblbienvenidosAlAdivinador.setBounds(10, 11, 292, 36);
		lblbienvenidosAlAdivinador.setForeground(Color.BLUE);
		lblbienvenidosAlAdivinador.setFont(new Font("Comic Sans MS", Font.BOLD, 20));
		panel.add(lblbienvenidosAlAdivinador);
		btnNewButton_1.setEnabled(false);
		
		//Boton NuevoJuego
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				logica.borrarArchivo();
				logica.resetArbol();
				logica.crearArbol();
				String objeto="ArbolVacio";
				btnNewButton_1.setEnabled(false);
				lblEstasPensandoEn.setText("La pregunta es: ");
			    objeto = logica.mostrarObjeto();
				txtrPreguntas.setEnabled(true);
				txtrPreguntas.setText(objeto);
				panel_2.setEnabled(true);
				panel_8.setEnabled(true);
				btnSi.setEnabled(true);
				btnNo.setEnabled(true);
				comboBox.removeAllItems();
				comboBox.setEnabled(false);
				txtDiferencia.setText("Diferencia");
				txtrDescripcionDeLos.setText("");
				textPane_3.setText(logica.mostrarPreguntas());
				textPane.setText(logica.obtenerAltura()+"");
				textPane_1.setText(logica.cantObjetosAlm()+"");
				textPane_2.setText(logica.cantPregAlm()+"");
				panel_4.setVisible(false);
				panel_4.setEnabled(false);
				lblNewLabel.setVisible(false);
				txtObjeto.setVisible(false);
				txtObjeto.setEnabled(false);
				panel_5.setVisible(false);
				panel_5.setEnabled(false);
				lblquDiferenciaHay.setVisible(false);
				txtDiferencia.setVisible(false);
				txtDiferencia.setEnabled(false);
				
			
			}
		});
		btnNewButton.setBounds(326, 11, 108, 30);
		panel.add(btnNewButton);
		
		//Boton Continuar
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				logica.armarArbol();
				txtrPreguntas.setText(logica.mostrarObjeto());
				btnNewButton_1.setEnabled(false);
				btnNewButton.setEnabled(true);
				panel_2.setEnabled(true);
				txtrPreguntas.setEnabled(true);
				panel_8.setEnabled(true);
				btnSi.setEnabled(true);
				btnNo.setEnabled(true);
				txtDiferencia.setText("Diferencia");
				comboBox.removeAllItems();
				comboBox.setEnabled(false);
				
			}
		});
		btnNewButton_1.setBounds(326, 45, 108, 30);
		panel.add(btnNewButton_1);
		lblDeTransportes.setForeground(Color.BLUE);
		lblDeTransportes.setFont(new Font("Comic Sans MS", Font.BOLD, 20));
		lblDeTransportes.setBounds(137, 36, 170, 41);
		
		panel.add(lblDeTransportes);
		panel_2.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		
		//Panel 2
		panel_2.setBounds(10, 105, 444, 104);
		panel_1.add(panel_2);
		panel_2.setEnabled(false);
		panel_2.setLayout(null);
		btnSi.setBounds(335, 23, 99, 33);
			
		//Boton SI
		btnSi.setEnabled(false);
		btnSi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				lblEstasPensandoEn.setText("La pregunta es:");
				String sig=logica.respuestaSi(txtrPreguntas.getText());
				if(sig.equals("Adivino")){
					carteles.cartelAdivino();
					panel_2.setEnabled(false);
					txtrPreguntas.setEnabled(false);
					txtrPreguntas.setText("Preguntas");
					btnNo.setEnabled(false);
					btnSi.setEnabled(false);
				    logica.guardarDatosEnArchivo();
				    btnNewButton_1.setEnabled(true);
				}
				else{
					txtrPreguntas.setText(sig);
				}
			}
		});
		panel_2.add(btnSi);
		btnNo.setBounds(335, 60, 99, 33);
		
		//Boton NO
		btnNo.setEnabled(false);
		btnNo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				lblEstasPensandoEn.setText("La pregunta es:");
				String sig=(logica.respuestaNo(txtrPreguntas.getText()));
				if (sig.equals("No Adivino")){
					panel_2.setEnabled(false);
					panel_4.setVisible(true);
					panel_4.setEnabled(true);
					lblNewLabel.setVisible(true);
					txtObjeto.setVisible(true);
					txtObjeto.setEnabled(true);
					btnNo.setEnabled(false);
					btnSi.setEnabled(false);
					
				}
				else{
					txtrPreguntas.setText(sig);
				}
			}
		});
		panel_2.add(btnNo);
		txtrPreguntas.setMargin(new Insets(10, 2, 2, 10));
		txtrPreguntas.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		txtrPreguntas.setMaximumSize(new Dimension(243, 47));
		txtrPreguntas.setBounds(41, 37, 243, 54);
		txtrPreguntas.setEditable(false);
		txtrPreguntas.setEnabled(false);
		txtrPreguntas.setFont(new Font("Comic Sans MS", Font.PLAIN, 18));
		txtrPreguntas.setForeground(Color.BLACK);
		txtrPreguntas.setText("Preguntas");		
		panel_2.add(txtrPreguntas);
		lblNewLabel_4.setBounds(20, 33, 23, 54);
		lblEstasPensandoEn.setForeground(Color.RED);
		lblEstasPensandoEn.setFont(new Font("Comic Sans MS", Font.PLAIN, 17));
		
		lblEstasPensandoEn.setBounds(10, 11, 315, 24);
		panel_2.add(lblEstasPensandoEn);
		
		
		//¿
		lblNewLabel_4.setFont(new Font("Comic Sans MS", Font.PLAIN, 30));
		lblNewLabel_4.setForeground(Color.RED);
		panel_2.add(lblNewLabel_4);
		label.setBounds(289, 23, 23, 54);
		
		//?
		label.setForeground(Color.RED);
		label.setFont(new Font("Comic Sans MS", Font.PLAIN, 30));
		panel_2.add(label);
		
		
		//Panel 3
		panel_3.setBorder(new TitledBorder(null, "Descripci\u00F3n de los Objetos", TitledBorder.LEADING, TitledBorder.TOP, null, Color.RED));
		panel_3.setBounds(10, 333, 444, 92);
		panel_1.add(panel_3);
		panel_3.setLayout(null);
		panel_3.setEnabled(true);
		txtrDescripcionDeLos.setEditable(false);
		
		//Descripcion
		txtrDescripcionDeLos.setForeground(Color.BLACK);
		txtrDescripcionDeLos.setText("Descripcion de los Objetos");
		txtrDescripcionDeLos.setBounds(10, 21, 424, 60);
		txtrDescripcionDeLos.setText(logica.mostrarDescripcion());
		
		panel_3.add(txtrDescripcionDeLos);
		panel_4.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		
		
		//Panel 4
		panel_4.setBounds(10, 220, 264, 49);
		panel_1.add(panel_4);
		panel_4.setLayout(null);
		panel_4.setEnabled(false);
		panel_4.setVisible(false);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 9));
		panel_4.add(lblNewLabel);
		
		//En que instrumento estas pensando?
		lblNewLabel.setVisible(false);
		lblNewLabel.setBounds(10, 0, 200, 28);
		
		//Objeto
		txtObjeto = new JTextField();
		txtObjeto.setEnabled(false);
		txtObjeto.setForeground(Color.BLACK);
		txtObjeto.setVisible(false);
		txtObjeto.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent arg0) {
				txtObjeto.setText("");
			}
		});
		txtObjeto.addActionListener(new ActionListener() {		
			public void actionPerformed(ActionEvent arg0) {		
				obj=txtObjeto.getText();
				txtObjeto.setEnabled(false);
				panel_5.setVisible(true);
				panel_5.setEnabled(true);
				lblquDiferenciaHay.setText("\u00BFQu\u00E9 diferencia hay entre "+txtrPreguntas.getText()+" y "+obj+"?");
				lblquDiferenciaHay.setVisible(true);
				txtDiferencia.setVisible(true);
				txtDiferencia.setEnabled(true);
				

			}
		});
		txtObjeto.setText("Objeto");
		txtObjeto.setBounds(10, 21, 244, 20);
		panel_4.add(txtObjeto);
		txtObjeto.setColumns(10);
		panel_5.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		
		//Panel 5
		panel_5.setBounds(10, 280, 264, 49);
		panel_1.add(panel_5);
		panel_5.setLayout(null);
		panel_5.setEnabled(false);
		panel_5.setVisible(false);
		lblquDiferenciaHay.setFont(new Font("Tahoma", Font.PLAIN, 9));
		
		lblquDiferenciaHay.setBounds(10, 0, 244, 20);
		panel_5.add(lblquDiferenciaHay);
		//Que diferencia hay entre auto y obj
		
		//Diferencia
		txtDiferencia = new JTextField();
		txtDiferencia.setEnabled(false);
		txtDiferencia.setForeground(Color.BLACK);
		txtDiferencia.setVisible(false);
		txtDiferencia.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent arg0) {
				txtDiferencia.setText("");
			}
		});
		txtDiferencia.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			    logica.agregarNodo((txtDiferencia.getText()), obj,(txtrPreguntas.getText()));
				logica.guardarDatosEnArchivo();
				logica.guardarPreguntas();
				//AGREGAR PREGUNTAS AL COMBO BOX;
				comboBox.setEnabled(true);
				btnNewButton_2.setEnabled(true);
				carteles.cartelNoAdivino();
				textPane_3.setText(logica.mostrarPreguntas());
				panel_4.setVisible(false);
				panel_5.setVisible(false);
				panel_2.setEnabled(false);
				txtrPreguntas.setEnabled(false);
				txtrPreguntas.setText("Preguntas");
				txtrDescripcionDeLos.setText(logica.mostrarDescripcion());
				textPane.setText(logica.obtenerAltura()+"");
				textPane_1.setText(logica.cantObjetosAlm()+"");
				textPane_2.setText(logica.cantPregAlm()+"");
				btnNewButton_1.setEnabled(true);
				for(String subArbol : logica.crearString()) {
				    comboBox.addItem(subArbol);
					
						
				}
				
				
			}
		
		});
		txtDiferencia.setText("Diferencia");
		txtDiferencia.setBounds(10, 18, 244, 20);
		panel_5.add(txtDiferencia);
		txtDiferencia.setColumns(10);
		
		//panel 6
		panel_6.setBorder(new TitledBorder(null, "Informaci\u00F3n del \u00C1rbol", TitledBorder.LEADING, TitledBorder.TOP, null, Color.RED));
		panel_6.setBounds(284, 220, 170, 109);
		panel_1.add(panel_6);
		panel_6.setLayout(null);
		panel_6.setEnabled(true);
		
		//Altura
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblNewLabel_1.setBounds(10, 23, 47, 22);
		panel_6.add(lblNewLabel_1);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 11));
		
		//cant obj
		lblNewLabel_2.setBounds(10, 46, 106, 29);
		panel_6.add(lblNewLabel_2);
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 11));
		
		//cant preg
		lblNewLabel_3.setBounds(10, 73, 124, 25);
		panel_6.add(lblNewLabel_3);
		textPane_1.setText("");
		textPane_1.setEditable(false);
		
		
		
		//altura
		textPane_1.setBounds(126, 45, 34, 22);
		panel_6.add(textPane_1);
		textPane_2.setEditable(false);

	
		//cant obj
		textPane_2.setBounds(126, 78, 34, 20);
		panel_6.add(textPane_2);
		textPane.setEditable(false);
		
		
		//cant preg
		textPane.setBounds(126, 13, 34, 20);
		panel_6.add(textPane);
		
		
		//panel 7
		panel_7.setBorder(new TitledBorder(null, "Preguntas", TitledBorder.LEADING, TitledBorder.TOP, null, Color.RED));
		panel_7.setBounds(10, 433, 223, 95);
		panel_1.add(panel_7);
		panel_7.setLayout(null);
		panel_7.setEnabled(true);
		textPane_3.setEditable(false);
		
		//preguntas
		textPane_3.setBounds(10, 21, 203, 63);
		panel_7.add(textPane_3);
		
		
		//panel 8
		panel_8.setBorder(new TitledBorder(null, "Eliminar pregunta", TitledBorder.LEADING, TitledBorder.TOP, null, Color.RED));
		panel_8.setBounds(236, 433, 218, 95);
		panel_1.add(panel_8);
		panel_8.setLayout(null);
		panel_8.setEnabled(false);
		
		//combo box
		//Cargar preguntas en el combo box
		//Como le pongo el tipo de elemento de los item?
		comboBox.setBounds(10, 21, 198, 20);
		panel_8.add(comboBox);
		comboBox.setEnabled(false);
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				logica.eliminarSubarbol(comboBox.getSelectedItem().toString());
				comboBox.removeItem(comboBox.getSelectedItem().toString());
				logica.guardarDatosEnArchivo();
				logica.armarArbol();
				txtrDescripcionDeLos.setText(logica.mostrarDescripcion());
				textPane.setText(logica.obtenerAltura()+"");
				textPane_1.setText(logica.cantObjetosAlm()+"");
				textPane_2.setText(logica.cantPregAlm()+"");
				textPane_3.setText(logica.mostrarPreguntas());
			}
		});
		
		
		//boton Eliminar
		btnNewButton_2.setEnabled(false);
		btnNewButton_2.setBounds(92, 61, 116, 23);
		panel_8.add(btnNewButton_2);
		
		JLabel lblNewLabel_5 = new JLabel("New label");
		lblNewLabel_5.setIcon(new ImageIcon("C:\\Users\\Alumno\\Desktop\\Proyecto\\Fuentes\\csm_ord_om_transport._Anna_Frajtova._shutterstock_271698923_502fa06b06.jpg"));
		lblNewLabel_5.setBounds(0, 0, 464, 533);
		panel_1.add(lblNewLabel_5);
	
	}
}
