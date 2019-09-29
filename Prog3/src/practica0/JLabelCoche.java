package practica0;

import java.awt.AlphaComposite;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class JLabelCoche extends JLabel{
	
	private int ancho = 100; // 100 píxeles de ancho
	private int alto = 100; // 100 píxeles de alto
	private Image imagenObjeto;
	protected float opacity = 1.0f;
	private static final long serialVersionUID = 1L;
	
	public JLabelCoche(){
		try {
			setIcon(new ImageIcon(JLabelCoche.class.getResource("coche.png").toURI().toURL()));
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	private double miGiro = Math.PI/2;
	
	public void setGiro( double gradosGiro ) {
		// De grados a radianes...
		miGiro = gradosGiro/180*Math.PI;
		// El giro en la pantalla es en sentido horario (inverso):
		miGiro = -miGiro;  // Cambio el sentido del giro
		// Y el gráfico del coche apunta hacia arriba (en lugar de derecha OX)
		miGiro = miGiro + Math.PI/2; // Sumo 90º para que corresponda al origen OX
	}

	@Override
	protected void paintComponent(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;
		g2.setRenderingHint(RenderingHints.KEY_INTERPOLATION,RenderingHints.VALUE_INTERPOLATION_BILINEAR);
		g2.setRenderingHint(RenderingHints.KEY_RENDERING,RenderingHints.VALUE_RENDER_QUALITY);
		g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,RenderingHints.VALUE_ANTIALIAS_ON);	
		g2.rotate(miGiro, 50, 50);
		g2.setComposite(AlphaComposite.getInstance( AlphaComposite.SRC_OVER, opacity));
		g2.drawImage(imagenObjeto, 0, 0, ancho, alto, null);
	}
	
	
}
