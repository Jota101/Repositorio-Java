package Cibertec;

import javax.swing.JPanel;
import javax.swing.ImageIcon;

import java.awt.Graphics;
import java.awt.Image;

public class Panel extends JPanel {
	private Image Fondo;

	/**
	 * Create the panel.
	 */
	public Panel() {
		preInit();
		initComponents();
	}

	private void initComponents() {
		
	}

	private void preInit() {
		Fondo = new ImageIcon("sebastian-svenson-d2w-_1LJioQ-unsplash.jpg").getImage();
		
	}
	
	public void paint(Graphics g){
		g.drawImage(Fondo,0,0,getWidth(),getHeight(),this);
	}
}
