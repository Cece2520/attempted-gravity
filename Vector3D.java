
public class Vector3D {

	private double myX;
	private double myY;
	private double myZ;

	public Vector3D(double x, double y, double z) {
		myX = x;
		myY = y;
		myZ = z;
	}

	public double getX() {
		return myX;
	}

	public double getY() {
		return myY;
	}

	public double getZ() {
		return myZ;
	}

	public Vector3D plus(Vector3D other) {
		return new Vector3D(myX + other.getX(), myY + other.getY(), myZ + other.getZ());
	}

	public Vector3D minus(Vector3D other) {
		return new Vector3D(myX - other.getX(), myY - other.getY(), myZ - other.getZ());
	}

	public double dot(Vector3D other) {
		return myX*other.getX() + myY*other.getY() + myZ*other.getZ();
	}
	
	public Vector3D factor(double cons) {
		return new Vector3D(myX * cons, myY * cons, myZ * cons);
	}
	
	public double magnitude() {
		return Math.sqrt(Math.pow(myX,2) + Math.pow(myY,2) + Math.pow(myZ,2));
	}
	
	public Vector3D cross(Vector3D other) { 
		double newX = myY * other.getZ() - myZ * other.getY();
		double newY = myZ * other.getX() - myX * other.getZ();
		double newZ = myX * other.getY() - myY * other.getX();
		return new Vector3D(newX, newY, newZ);
	}
	
	public Vector3D push(Vector3D other) {
		return other.factor(this.dot(other));
	}
	
	public static Vector3D average(Vector3D[] list) {
		Vector3D sum = new Vector3D(0,0,0);
		for (int i = 0; i < list.length; i++) {
			sum = sum.plus(list[i]);
		}
		return sum.factor(1.0/list.length);
	}
	
	public String toString() {
		return ("<" + myX + ", " + myY + ", " + myZ + ">");
	}

}
