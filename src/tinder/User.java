package tinder;
import java.util.ArrayList;


public class User {
	
	int id;
	String fname;
	String lname;
	String email;
	String gender;
	String interested;
	double longit;
	double latit;
	double radius;
	
	boolean visited;
	ArrayList<User> matches;
	
	
	public User(int id, String fname, String lname, String email, String gender, String interested, double longit, double latit, double radius) {
		this.id = id;
		this.fname = fname;
		this.lname = lname;
		this.email = email;
		this.gender = gender;
		this.interested = interested;
		this.longit = longit;
		this.latit = latit;
		this.radius = radius;
		

		this.matches = new ArrayList<User>();
		
	}
	
	
	public void addMatch(User u) {
		if(!this.matches.contains(u)) {
			matches.add(u);
		}
	}
	
	public boolean findMatch(User u) {
		return this.matches.contains(u);
	}
	
	public int getID() {
		return this.id;
	}
	
	public String getName() {
		String name = "";
		name += this.fname + " " + this.lname;
		return name;
	}
	
	public boolean hasVisited() {
		return visited;
	}
	
	public User getMatch(int index) {
		return this.matches.get(index);
	}
	
	public ArrayList<User> getMatches(){
		return this.matches;
	}
	
	public void deleteMatch(User v) {
		matches.remove(v);
	}
}
