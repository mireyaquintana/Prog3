package cap00;

import java.awt.BorderLayout;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JTextPane;

/** Ejercicio de hilos con ventanas. Programa esta clase para que se cree una ventana
 * que pida un dato de texto al usuario y un botón de confirmar para que se confirme.
 * Haz que al pulsar el botón de confirmación se llame al procesoConfirmar()
 * que simula un proceso de almacenamiento externo que tarda unos segundos.
 * Observa que hasta que ocurre esta confirmación la ventana no responde.
 * 1. Arréglalo para que la ventana no se quede "frita" hasta que se acabe de confirmar.
 * 2. Haz que el botón de "confirmar" no se pueda pulsar dos veces mientras el proceso
 * de confirmación se esté realizando
 * @author andoni.eguiluz @ ingenieria.deusto.es
 */
public class VentanaConfirmacionLenta extends JFrame{
	
	private JTextField texto;
	private JButton bConfirmar;
	private JPanel panel;
	
	//NUEVO
	public VentanaConfirmacionLenta(){
		
			setTitle("VENTANA");
			setSize(600, 400);
			setLocation(100, 100);
			setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		
			bConfirmar = new JButton("Confirmar");
			texto = new JTextField();
			
			add(texto, BorderLayout.NORTH);
			add(bConfirmar, BorderLayout.SOUTH);
			
			bConfirmar.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent arg0) {
					Thread hilo = new Thread(){
						public void run(){
							System.out.println("Empiezo");
							procesoConfirmar(); // aqui lo ejecuta el hilo
							System.out.println("Acabao");
						}
					};
					//procesoConfirmar(); // aqui lo ejecuta swing
					hilo.start();
				}
			});
			
	}
	//NUEVO
	
	

		private static Random r = new Random();
	// Este método simula un proceso que tarda un tiempo en hacerse (entre 5 y 10 segundos)
	private static void procesoConfirmar() {
		try {
			Thread.sleep( 5000 + 1000*r.nextInt(6) );
		} catch (InterruptedException e) {}
	}
	
	public static void main(String[] args) {
		//NUEVO
		VentanaConfirmacionLenta v = new VentanaConfirmacionLenta();
		v.setVisible(true);
		//NUEVO
	}

}
