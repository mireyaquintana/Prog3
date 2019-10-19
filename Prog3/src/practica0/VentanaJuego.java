package practica0;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class VentanaJuego extends JFrame{
	
	CocheJuego coche;
	JPanel pPrincipal;
	
	public VentanaJuego(){
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setTitle("Ventana Juego");
		setSize(1000, 700);
		setLocationRelativeTo(null);
		
		pPrincipal = new JPanel();
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
		
		// EVENTOS 
		// Botones
		bAcelera.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				coche.acelera(+5);
				System.out.println(coche.getMiVelocidad());
			}
		});
		
		bFrena.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				coche.acelera(-5);
				System.out.println(coche.getMiVelocidad());
			}
		});
		
		bGiraIzq.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				coche.gira(+10);
				System.out.println(coche.getMiDireccionActual());	
			}
		});
		
		bGiraDer.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				coche.gira(-10);
				System.out.println(coche.getMiDireccionActual());
			}
		});
		
		}
	
	public void crearCoche(int posX, int posY){
		coche = new CocheJuego();
		coche.setPosicion(posX, posY);
		pPrincipal.add(coche.getGrafico());
	}
	
	public static void main(String[] args) {
		VentanaJuego v = new VentanaJuego();
		//Coche c1 = new Coche(miVelocidad, miDireccionActual, 150, 100, piloto);
		//Coche coche = new Coche(100, 360, 150, 100, "piloto");
		v.crearCoche(100, 100);
		v.setVisible(true);
		
	}
	
	

}
