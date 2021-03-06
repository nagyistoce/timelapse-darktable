package org.dttimelapse.gui;

import java.awt.BasicStroke;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;


// this class constructs a Jpanel with display of a Polyline



public class PolygonPanel extends JPanel { 
	private static final long serialVersionUID = 1L;

	   private int xScreen[], yScreen[];
	   private int n;
	
	
	   public PolygonPanel() {   //constructor

		   xScreen = new int[0];
		   yScreen = new int[0];
		   
		   
	   } // end const
		   
	   
	  protected void paintComponent(Graphics g) {
		    super.paintComponent(g);

			       
		       g.drawPolyline( xScreen, yScreen, n );     
		       
		       // Swing graphics with more functions
//		       
		       Graphics2D g2 = (Graphics2D) g;
//		       
		       g2.setStroke( new BasicStroke( 2) );   // 3 pix
		       
		       
//		       g2.drawLine( 30, 150, 200, 150 );
//		       
//		       g2.scale( 0.2500, 0.2500 );
//		       
		       g2.drawPolyline( xScreen, yScreen, n );
		       
	  }

   
		public void setCoord(double xValues[], double yValues[]) {
			
			   this.n = xValues.length; // number of coordinate pairs
			   
			   if (n != yValues.length) {
				   System.out.println("Problem with uneven koordinates!");
				   return;
			   }

			   if (n <= 1) return;
			   
			   
			   xScreen = new int[n];
			   yScreen = new int[n];
			   
			   // change the scaling of the Values to fit the panel
			   // we need global variables for dimensions

			   final double factorX = (600.0 / (n-1));
			   
			   //System.out.println("polygon n= " + n);
			   //System.out.println("factor= " + factorX);
			   
			   for (int i = 0; i < n; i++) {				      
				   
			       xScreen[i] = (int) (xValues[i] * factorX);
			       yScreen[i] = (int) (400-400 * yValues[i]);
			       
			       //y[i] = (int) (200-200 * yValues[i]);
			   
			     //System.out.println("i= " + i + " x= " + x[i]+ " y= " + y[i]);	
			       
			   }
		   
			   return;
			   
		}

	  
		public void clear() {

			this.n = 0;

			   this.xScreen = new int[0];
			   this.yScreen = new int[0];

			return;

		}
	  
	  
	  
	  
}