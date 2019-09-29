package donQuijote;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.*;

/** Ejercicio de hilos  con ventanas. Esta clase carga el texto del Quijote en un área de texto,
 * y permite navegar por el área con la scrollbar y con botones de página arriba y página abajo.
 * 1. Modificarlo para que al pulsar los botones el scroll se haga con una animación 
 * a lo largo de un segundo, en lugar de en forma inmediata.
 * 2. Prueba a pulsar muy rápido varias páginas abajo. ¿Cómo lo arreglarías para que el scroll
 * en ese caso funcione bien y vaya bajando una página tras otra pero las baje *completas*?
 * @author andoni.eguiluz @ ingenieria.deusto.es
 */
public class VentanaQuijote extends JFrame {

	private JTextArea taTexto;
	private JScrollPane spTexto;
	
	public VentanaQuijote() {
		setDefaultCloseOperation( JFrame.DISPOSE_ON_CLOSE );
		setTitle( "Don Quijote de la Mancha" );
		setSize( 800, 600 );
		setLocationRelativeTo( null );  // Pone la ventana relativa a la pantalla
		taTexto = new JTextArea();
		spTexto = new JScrollPane( taTexto );
		add( spTexto, BorderLayout.CENTER );
		JPanel pBotonera = new JPanel();
		JButton bPagArriba = new JButton( "^" );
		JButton bPagAbajo = new JButton( "v" );
		pBotonera.add( bPagArriba );
		pBotonera.add( bPagAbajo );
		add( pBotonera, BorderLayout.SOUTH );
		bPagArriba.addActionListener( new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				muevePagina( -(spTexto.getHeight()-20) );
			}
		});
		bPagAbajo.addActionListener( new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				muevePagina( (spTexto.getHeight()-20) );
			}
		});
	}
	
	// NUEVO
	// ESTRUCTURA DE DATOS
	private ArrayList<Thread> hilosActivos = new ArrayList<>();
	
	private void muevePagina( final int pixelsVertical ) {
		// TODO Cambiar este comportamiento de acuerdo a los comentarios de la cabecera de clase
		Thread hilo = new Thread(new Runnable(){
			public void run(){
				
				JScrollBar bVertical = spTexto.getVerticalScrollBar();
				System.out.println( "Moviendo texto de " + bVertical.getValue() + " a " + (bVertical.getValue()+pixelsVertical) );
				// bVertical.setValue( bVertical.getValue() + pixelsVertical );
				// NUEVO
				if(pixelsVertical>0){
					for (int i=0; i<pixelsVertical; i++){
						bVertical.setValue( bVertical.getValue() + 1 ); // 512 veces sumo 1
						try {
							Thread.sleep(10);
						} catch (InterruptedException e) {
							// TODO: handle exception
						}
					}
				}else{
					for (int i=0; i<Math.abs(pixelsVertical); i--){
					//for (int i=0; i>pixelsVertical; i--){
						bVertical.setValue( bVertical.getValue() - 1 ); // 512 veces sumo 1
						try {
							Thread.sleep(10);
						} catch (InterruptedException e) {
							// TODO: handle exception
						}
					}
				}
		// hacemos un hilo porque no queremos que el hilo principal swing lo ejecute para que una de las acciones no deje de ejecutarse.
		// po ejemplo si se esta pintando la pnatlalla no queremos que a su vez este pendiente de najar el texto.
		
			}
			
		});
		hilo.start();
				
		// NUEVO
	}
	
	private void cargaQuijote() {
		try {
			Scanner scanner = new Scanner( VentanaQuijote.class.getResourceAsStream( "DonQuijote.txt" ), "UTF-8" );
			while (scanner.hasNextLine()) {
				String linea = scanner.nextLine();
				taTexto.append( linea + "\n" );
			}
			scanner.close();
		} catch (Exception e) {
			JOptionPane.showMessageDialog( this, "No se ha podido cargar el texto" );
		}
	}

	public static void main(String[] args) {
		VentanaQuijote v = new VentanaQuijote();
		v.setVisible( true );
		v.cargaQuijote();
	}

}
