package tinder;

class Link {
	
	User u1;
	User u2;
	
	public Link(User u1, User u2) {
		this.u1 = u1;
		this.u2 = u2;
		
		u1.addMatch(u2);
		u2.addMatch(u1);
	}
	

}
