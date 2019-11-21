package ejerCap03;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class Main extends JFrame {
	
	private JTextArea taDatos;
	private ArrayList<Producto> listaProds;
	
	
	public Main() {
		// Punto 7
		setDefaultCloseOperation( JFrame.DISPOSE_ON_CLOSE);
		setSize(530, 300);
		setTitle( "Ejercicio 3.6 de base de datos" );
		taDatos = new JTextArea();
		taDatos.setFont( new Font( "Arial", Font.PLAIN, 18));
		JPanel pBotonera = new JPanel();		
		getContentPane().add( new JScrollPane(taDatos), BorderLayout.CENTER );
		getContentPane().add( pBotonera, BorderLayout.SOUTH );
		
		// Punto 8
		addWindowListener( new WindowAdapter() {
			
			@Override
			public void windowOpened(WindowEvent e) {
				BaseDatos.abrirConexion("miniamazon.db");
				
			}
			
			@Override
			public void windowClosed(WindowEvent e) {
				BaseDatos.cerrarConexion();
			}
			
		});
		
		// Punto 9
		JButton bVerProductos = new JButton("Ver productos");
		pBotonera.add(bVerProductos);
		
	}
	
	public static void main(String[] args) {
		Main v = new Main();
		v.setVisible(true);
	}

}
