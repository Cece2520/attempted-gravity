
import java.util.*;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import javax.swing.JComponent;
import javax.swing.JFrame;

//Main method here, runs program
public class Command {

	final static double time = 0.0005;

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		System.out.print("Number of objects: ");
		int numObjects = sc.nextInt();
		System.out.println();

		Mass[] objects = new Mass[numObjects];

		//Query number and data of mass objects
		for (int i = 0; i < numObjects; i++) {
			System.out.print("Mass: ");
			double mass = sc.nextDouble();
			System.out.println();

			System.out.print("Position X: ");
			double posX = sc.nextDouble();
			System.out.println();

			System.out.print("Position Y: ");
			double posY = sc.nextDouble();
			System.out.println();

			System.out.print("Position Z: ");
			double posZ = sc.nextDouble();
			System.out.println();

			Vector3D posVector = new Vector3D(posX, posY, posZ);

			System.out.print("Velocity X: ");
			double velX = sc.nextDouble();
			System.out.println();

			System.out.print("Velocity Y: ");
			double velY = sc.nextDouble();
			System.out.println();

			System.out.print("Velocity Z: ");
			double velZ = sc.nextDouble();
			System.out.println();

			Vector3D velVector = new Vector3D(velX, velY, velZ);

			objects[i] = new Mass(posVector, velVector, mass);

			System.out.println("-------------------------------\n");

		}
		sc.close();


		//Set graphics window
		JFrame window = new JFrame();
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setBounds(0, 0, 1200, 1200);
		window.setSize(new Dimension(600, 600));
		window.getContentPane().add(new MyGraphics(objects));
		window.setVisible(true);
		
		JFrame window2 = new JFrame();
		window2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window2.setBounds(0, 0, 1200, 1200);
		window2.setSize(new Dimension(300, 300));
		window2.getContentPane().add(new CentroidGraph(objects));
		window2.setVisible(true);
		
		//Draw and update graphics
		while(true) {
			try {
				window.getContentPane().add(new MyGraphics(objects));
				window.setVisible(true);
				window.getContentPane().remove(0);
				Thread.sleep(1);
				
				for (int i = 0; i < objects.length; i++) {
					for (int j = 0; j < objects.length; j++) {
						if (i == j) 
							continue;
						objects[i].addAccel(objects[j]);
					}
				}
				
				//Occasionally output to console position/velocity vectors for debugging
				double rand = Math.random();
				for (Mass object: objects) {
					object.applyMvmt(time);
					if (rand > 0.997)
						System.out.println(object);
				}
				
			}
			catch (Exception e) {
				
			}

		}

	}

}
