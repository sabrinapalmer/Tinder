package tinder;
import java.util.ArrayList;


public class Tinder {
	
	ArrayList<User> users;
	ArrayList<Link> links;
	
	public Tinder() {
		this.users = new ArrayList<User>();
		this.links = new ArrayList<Link>();
	}
	
	public void addUser(User v1) {
		if(this.users.contains(v1)) {
			return;
		}
		else {
			this.users.add(v1);
			int sz = this.users.size();
			for(int i = 0; i < sz; i++) {
				User v2 = users.get(i);
				if(v1.gender.equals(v2.interested)) {
					if(v2.gender.equals(v1.interested)) {
						double dm = distance(v1.latit, v2.latit, v1.longit, v2.longit, 0, 0);
						//THIS IS THE DEFAULT RADIUS OF 10 MILES
						if(dm <= Math.min(v1.radius, v2.radius)) {
							addLink(v1, v2);
						}
					}}
			}}}
				
	
	
	public boolean hasUser(User v1) {
		return users.contains(v1);
	}
	
	public void addLink(User v1, User v2) {
		if(v1.equals(v2)) {
			return;
		}
		else {
			Link link = new Link(v1, v2);
			if(links.contains(link)) {
				return;
			}
			else {
				links.add(link);
			}
		}
	}
	
	public static double distance(double lat1, double lat2, double lon1,
	        double lon2, double el1, double el2) {

	    final int R = 6371; // Radius of the earth

	    double latDistance = Math.toRadians(lat2 - lat1);
	    double lonDistance = Math.toRadians(lon2 - lon1);
	    double a = Math.sin(latDistance / 2) * Math.sin(latDistance / 2)
	            + Math.cos(Math.toRadians(lat1)) * Math.cos(Math.toRadians(lat2))
	            * Math.sin(lonDistance / 2) * Math.sin(lonDistance / 2);
	    double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));
	    double distance = R * c * 1000; // convert to meters
	    
	    double height = el1 - el2;

	    distance = Math.pow(distance, 2) + Math.pow(height, 2);
	    
	    return Math.sqrt(distance)*0.000621371;
	}
	
	

}