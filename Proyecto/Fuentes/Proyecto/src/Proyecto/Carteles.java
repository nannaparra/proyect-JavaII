package Proyecto;

import javax.swing.JOptionPane;

public class Carteles {
	
	public Carteles(){
		
	}
	
	public void cartelAdivino(){
		JOptionPane.showMessageDialog(null, "EL JUEGO HA ADIVINADO", "Fin del Juego", JOptionPane.PLAIN_MESSAGE);
	}
	
	public void cartelNoAdivino(){
		JOptionPane.showMessageDialog(null, "EL JUEGO NO HA ADIVINADO", "Fin del Juego", JOptionPane.PLAIN_MESSAGE);
	}

}
