package pi2tut.stunde03;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class GUI {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUI window = new GUI();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public GUI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 600, 200);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


		ColorPanel panelGradient;
		if(Farbverlauf.createColorArray2() != null)
		{
			panelGradient = new ColorPanel2(Farbverlauf.createColorArray2());
		}
		else if(Farbverlauf.createColorArray() != null)
		{
			panelGradient = new ColorPanel(Farbverlauf.createColorArray());
		} else
		{
			panelGradient = new ColorPanel(Farbverlauf.createColor());
		}
		frame.getContentPane().add(panelGradient, BorderLayout.CENTER);
	}

}

class ColorPanel extends JPanel
{
	private static final long serialVersionUID = -2333706372925095740L;
	
	private int[] colorArray;
	
	public ColorPanel(int... colorArray)
	{
		super();
		// assume colorArray is static at runtime (no time of check / time of use issues)
		if(colorArray.length == 0)
			colorArray = new int[1];
		this.colorArray = colorArray;
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;
		
		int w = this.getWidth();
		int h = this.getHeight();
		float colorbandWidth = w / (float) colorArray.length;
		
		for(int i = 0; i < colorArray.length; i++)
		{
			g2.setColor(new Color(colorArray[i]));
			g2.fill(new Rectangle2D.Float(colorbandWidth * i, 0, colorbandWidth * (i+1), h));
//			g2.fillRect((int) (colorbandWidth * i), 0, (int) (colorbandWidth * (i+1)), h);
		}
	}
}

class ColorPanel2 extends ColorPanel
{
	private static final long serialVersionUID = -2333706372925095740L;

	private int[][] colorArray;

	public ColorPanel2(int[][] colorArray)
	{
		super();
		// assume colorArray is static at runtime (no time of check / time of use issues)
		if(colorArray.length == 0)
			colorArray = new int[1][1];
		this.colorArray = colorArray;
	}

	@Override
	protected void paintComponent(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;

		int w = this.getWidth();
		int h = this.getHeight();
		float colorbandWidth = w / (float) colorArray.length;

		for(int i = 0; i < colorArray.length; i++)
		{
			float colorbandHeight = h / (float) colorArray[i].length;
			for(int j = 0; j < colorArray[i].length; j++)
			{
				g2.setColor(new Color(colorArray[i][j]));
				g2.fill(new Rectangle2D.Float(colorbandWidth * i,
						colorbandHeight * j,
						colorbandWidth * (i + 1),
						colorbandHeight * (j + 1)));
			}
		}
	}
}
