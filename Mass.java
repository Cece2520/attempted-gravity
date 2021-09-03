

public class Mass {

	private Vector3D myPosition;
	private Vector3D myVelocity;
	private Vector3D myAcceleration;
	private double myMass;
	
	private final double G = 6.67428 * Math.pow(10, 3);
	
	public Mass(Vector3D pos, Vector3D vel, double mass) {
		myPosition = pos;
		myVelocity = vel;
		myMass = mass;
		myAcceleration = new Vector3D(0,0,0);
	}
	
	public Vector3D getPos() {
		return myPosition;
	}
	
	public Vector3D getVel() {
		return myVelocity;
	}
	
	public double getMass() {
		return myMass;
	}
	
	public void addAccel(Mass other) {
		try {
			Vector3D distVec = other.getPos().minus(myPosition);
			double distScalar = distVec.magnitude();
			double gm = G * other.getMass() / Math.pow(distScalar, 3);
			myAcceleration = myAcceleration.plus(distVec.factor(gm));
		}
		catch (Exception e) {
			
		}
	}
	
	public Vector3D applyMvmt(double time) {
		myPosition = myPosition.plus(myVelocity.factor(time));
		myVelocity = myVelocity.plus(myAcceleration.factor(time));
		myAcceleration = new Vector3D(0,0,0);
		return myPosition;
	}
	
	public String toString() {
		return (myMass + ", " + myPosition.toString());
	}

}
