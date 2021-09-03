import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JComponent;

public class MyGraphics extends JComponent {

	private Mass[] myObjects;
	public static final Color[] COLORS = {Color.red, Color.green, Color.blue, Color.orange, Color.magenta, Color.yellow, Color.cyan};
	

	public MyGraphics(Mass[] objects) {
		myObjects = objects;
	}

	public void paint(Graphics g) {
		g.translate(getSize().width/2, getSize().height/2);
		
		g.setColor(Color.lightGray);

		int rows = 20;
		int cols = 20;

		int width = getSize().width;
		int height = getSize().height;

		int rowHt = height / (rows);
		for (int i = - height/2; i < rows; i++)
			g.drawLine(-width/2, i * rowHt, width/2, i * rowHt);

		int rowWid = width / (cols);
		for (int i = - width/2; i < cols; i++)
			g.drawLine(i * rowWid, -height/2, i * rowWid, height/2);

		for (int i = 0; i < myObjects.length; i++) {
			g.setColor(COLORS[i%COLORS.length]);
			Vector3D canvasPos = Perspective.transform(myObjects[i].getPos().factor(Perspective.SCALE_FACTOR));
			int radius = (int)(Math.log(myObjects[i].getMass()+10)+3);
			g.fillOval((int)canvasPos.getX() - radius, (int)canvasPos.getY() - radius, 2*radius, 2*radius);
		}
		
		
		
	}
}

