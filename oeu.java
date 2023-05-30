package uei;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.time.LocalDate;
import java.time.LocalTime;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class oeu {
	public static void main(String [] args) throws InterruptedException {
		
			JFrame frame = new JFrame("Mordern Clock");
			frame.setBounds(10,10,500,500);
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frame.setUndecorated(true); // border of frame are not visible 
			
			JPanel panel = new JPanel() {
				@Override
				public void paint(Graphics g2) {
					Graphics2D g = (Graphics2D)g2.create();
					g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
					g.setColor(new Color (160,0,196));
					g.fillRect(0,0,500,500);
					g.setColor(Color.white);
					String time = String.format("%02d", LocalTime.now().getHour())+  ":"+ String.format("%02d", LocalTime.now().getMinute()) + ":" + String.format("%02d", LocalTime.now().getSecond());	
					g.setFont(new Font("TimesRoman",Font.PLAIN ,110));
					g.drawString(time, 250-g.getFontMetrics().stringWidth(time)/2, 150);
					
							String date = LocalDate.now().getMonth().toString()	+ " " + String.format("%02d", LocalDate.now().getDayOfMonth()) + " " + LocalDate.now().getYear() ;
					g.setFont(new Font("Fira san" , 0 , 40));
					g.drawString(date, 250-g.getFontMetrics().stringWidth(date)/2, 220);
				
				}
			};
			frame.add(panel);
			frame.setVisible(true);
			while(true) {
				frame.repaint();
				Thread.sleep(1000);
			}
		
	}
		
	
}
