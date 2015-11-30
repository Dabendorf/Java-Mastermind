package mastermind;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JPanel;

/**
 * Dies sind die kleinen farbigen Felder, in welchen der Spieler die zu erratenden Farben durchprobieren kann.
 * @author Lukas Schramm
 */
public class Farbfeld extends JPanel {
	
	private int farbe = -1;
	private boolean aktiviert = false;
	
	public Farbfeld() {
		this.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent evt) {
				if(evt.getButton() == MouseEvent.BUTTON1) {
					aufMausReagierenLinks();
				} else if(evt.getButton() == MouseEvent.BUTTON3){
					aufMausReagierenRechts();
				}
			}
		});
	}
	
	/**
	 * Dies ist die paint-Methode, in welcher je nach Farbwert die das Feld gefaerbt wird.
	 */
	public void paintComponent(Graphics stift) {
		super.paintComponent(stift);
		switch (farbe) {
		case 0:
			stift.setColor(Color.yellow);
			break;
		case 1: 
			stift.setColor(Color.blue);
			break;
		case 2:
			stift.setColor(Color.red);
			break;
		case 3:
			stift.setColor(Color.green);
			break;
		case 4:
			stift.setColor(Color.pink);
			break;
		case 5:
			stift.setColor(Color.cyan);
			break;
		default:
			stift.setColor(Color.gray);
			break;
		}
		stift.fillRect(0,0,this.getWidth(),this.getHeight());
	}
	
	/**
	 * Diese Methode schaltet die Farbe um eins weiter.
	 */
	public void nextColor() {
		if(farbe<5) {
			farbe++;
		} else {
			farbe=0;
		}
		this.repaint();
	}
	
	/**
	 * Diese Methode schaltet die Farbe um eins zurueck.
	 */
	public void beforeColor() {
		if(farbe>0) {
			farbe--;
		} else {
			farbe=5;
		}
		this.repaint();
	}

	public int getFarbe() {
		return farbe;
	}
	
	public void setFarbe(int farbe) {
		this.farbe = farbe;
	}
	
	/**
	 * Diese Methode reagiert bei einem Linksklick auf der Maus.
	 */
	public void aufMausReagierenLinks() {
		if(aktiviert == true) {
			nextColor();
			repaint();
		}
	}
	
	/**
	 * Diese Methode reagiert bei einem Rechtsklick auf der Maus.
	 */
	public void aufMausReagierenRechts() {
		if(aktiviert == true) {
			beforeColor();
			repaint();
		}
	}
	
	public void setAktiviert(boolean neuerwert) {
		aktiviert = neuerwert;
	}

}