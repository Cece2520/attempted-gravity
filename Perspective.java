
public class Perspective {
	
	private static Vector3D viewPoint = new Vector3D(0, 0, 1);
	private static Vector3D viewPoint2 = new Vector3D(1, 0, 0);
	private static Vector3D viewPoint3 = new Vector3D(0, 1, 0);
	
	public static double SCALE_FACTOR = 2;
	
	public static Vector3D transform(Vector3D point) {
		return new Vector3D(point.dot(viewPoint2), point.dot(viewPoint3), 0);
	}

	public static void setViewPoint(Vector3D newView) {
		try {
			viewPoint = newView.factor(1.0/newView.magnitude());
			Vector3D zAxis = new Vector3D(0, 0, 1);
			Vector3D vp2 = zAxis.cross(viewPoint);
			vp2 = vp2.factor(1.0/vp2.magnitude());
			viewPoint2 = vp2;
		}
		catch (Exception e) {
			viewPoint = new Vector3D(0, 0, 1);
			viewPoint2 = new Vector3D(1, 0, 0);
			viewPoint3 = new Vector3D(0, 1, 0);
		}
		viewPoint3 = viewPoint2.cross(viewPoint);
		viewPoint3 = viewPoint3.factor(1.0/viewPoint2.magnitude());
	}
	
	public static void setViewPoint(Vector3D newView, Vector3D newView2) {
		try {
			viewPoint = newView.factor(1.0/newView.magnitude());
			viewPoint2 = newView2.factor(1.0/newView2.magnitude());
		}
		catch (Exception e) {
			
		}
	}
}
