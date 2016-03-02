package se.mah.lisa_b;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

import se.mah.k3.klara.PixelController;
import se.mah.k3.klara.PixelController.Screen;

public class A7 {
	
	public static void main(String[] args) {
		BufferedImage img = null;
		Color color;
		
		//Läs in bild från disk
		try {
			img = ImageIO.read(A7.class.getResource("bild.jpg"));
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		//Skriver ut bildens bredd och höjd
		System.out.println("img w:" + img.getWidth() + " h:" + img.getHeight());

		//Upprättar anslutning till en skärm
		PixelController c = PixelController.getInstance(Screen.MEDEA_2);
		
		//Väntar på att anslutningen ska upprättas
		while(!c.isConnected()) {
			try {
				System.out.println("Waiting for connection...");
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		if (c.isConnected()) {
			//Sriver ut bredd och höjd från skärmen
			System.out.println(c.getNumberPixelsWidestSide() + " x " + c.getNumberPixelsShortestSide());
			
			//Loopar igen rad för rad på bilden
			for (int row = 0; row < img.getHeight(); row++) {
				//Lopar igenom kolumn för kolumn på bilden
				for (int col = 0; col < img.getWidth(); col++) {
					//Hämtar ut färg på pixlarna
					color = new Color(img.getRGB(col, row));
					System.out.println("img x:" + col + " y:" + row + " - " + color.toString() + " ->  screen x:" + row + " y:" + col);
					//Sätter pixlarna på skärmen
					c.setPixel(row, col, color);
				}
			}
		}
		
		//c.clearConnection();
		//System.exit(0);
	}
}