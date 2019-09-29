package practica0;

public class CocheJuego extends Coche{
	
	private JLabelCoche imgCoche;
	
	public CocheJuego(){
		//imgCoche = new JLabelCoche();
	}
	
	public JLabelCoche getGrafico(){
		return imgCoche;
	}
	
	@Override
	public void setPosX(double posX){
		super.setPosX(posX);
		imgCoche.setLocation((int)posX, (int)posY);
	}
	
	@Override
	public void setPosY(double posY){
		super.setPosY(posY);
		imgCoche.setLocation((int)posX, (int)posY);
	}
	
	@Override
	public void setMiDireccionActual(double miDireccionActual){
		super.setMiDireccionActual(miDireccionActual);
		imgCoche.setGiro(miDireccionActual);
	}
}
