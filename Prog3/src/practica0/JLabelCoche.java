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
	
	public JLabelCoche(ImageIcon objetoGrafico, int ancho, int alto){
		super( objetoGrafico );
		this.ancho = ancho;
		this.alto = alto;
		imagenObjeto = objetoGrafico.getImage();
		setBounds( 0, 0, ancho, alto );
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;
		g2.setRenderingHint(RenderingHints.KEY_INTERPOLATION,RenderingHints.VALUE_INTERPOLATION_BILINEAR);
		g2.setRenderingHint(RenderingHints.KEY_RENDERING,RenderingHints.VALUE_RENDER_QUALITY);
		g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,RenderingHints.VALUE_ANTIALIAS_ON);	
		g2.rotate();
		g2.setComposite(AlphaComposite.getInstance( AlphaComposite.SRC_OVER, opacity));
		g2.drawImage(imagenObjeto, 0, 0, ancho, alto, null);
	}
}
