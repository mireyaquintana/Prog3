package practica0;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class VentanaJuego extends JFrame{
	
	public VentanaJuego(){
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setTitle("Ventana Juego");
		setSize(1000, 700);
		setLocationRelativeTo(null);
		
		JPanel pPrincipal = new JPanel();
		pPrincipal.setBackground(Color.WHITE);
		pPrincipal.setLayout(null);
		
		JPanel pBotonera = new JPanel();
		JButton bAcelera = new JButton("Acelera");
		JButton bFrena = new JButton("Frena");
		JButton bGiraIzq = new JButton("Gira Izq.");
		JButton bGiraDer = new JButton("Gira Der.");
		pBotonera.add(bAcelera);
		pBotonera.add(bFrena);
		pBotonera.add(bGiraIzq);
		pBotonera.add(bGiraDer);
		
		//pPrincipal.add(pBotonera, BorderLayout.SOUTH);
		add(pPrincipal, BorderLayout.CENTER);
		add(pBotonera, BorderLayout.SOUTH);
		
		}
	
	public static void main(String[] args) {
		VentanaJuego v = new VentanaJuego();
		v.setVisible(true);
		
		//Coche c1 = new Coche(miVelocidad, miDireccionActual, 150, 100, piloto);
		Coche coche = new Coche(100, 360, 150, 100, "piloto");
		System.out.println(coche);
	}
	
	

}
