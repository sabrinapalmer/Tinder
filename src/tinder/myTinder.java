package tinder;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;


public class myTinder {
	
	public static void main(String[] args) {
		Tinder tinder = new Tinder();
		JSONParser parser = new JSONParser();	
		try {
			Object obj = parser.parse(new FileReader("users2.json"));
			//System.out.println("File exists.");
			JSONArray jsonArray = (JSONArray) obj;
            
            for (int i = 0; i < jsonArray.size(); i++) {
                JSONObject jsonObject = (JSONObject) jsonArray.get(i);
                //System.out.println(jsonObject);
                
                int id = i;
    			String fn = (String) jsonObject.get("first_name");
    			String ln = (String) jsonObject.get("last_name");
    			String em = (String) jsonObject.get("email");
    			String gen = (String) jsonObject.get("gender");
    			String in = (String) jsonObject.get("interesed");

    			Object ong = jsonObject.get("longitude");
    			double lo = ((Number) ong).doubleValue();

    			Object ati = jsonObject.get("latitude");
    			double la = ((Number)ati).doubleValue();

    			double ra = 25;
    			
    			User newone = new User(id, fn, ln, em, gen, in, lo, la, ra);
    			tinder.addUser(newone);
                
            }
            
            
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	Scanner sc = new Scanner(System.in);
	System.out.println("Enter first and last name to return matches:");
	String searchname = new String(sc.nextLine());
	
	
	
	sc.close();

	System.out.println("There are " + tinder.links.size() + " matches among " + tinder.users.size() + " different tinder users...");
	for(int i = 0; i < tinder.links.size(); i++) {
		System.out.println(tinder.links.get(i).u1.getName() + " matched with " + tinder.links.get(i).u2.getName());
	}


}
}