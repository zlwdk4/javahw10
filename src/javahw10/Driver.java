package javahw10;


import java.lang.reflect.Field;
import java.lang.reflect.Method;

import acme.NetworkService;


public class Driver {

	public static void main(String[] args) {
        NetworkService ns = new NetworkService();
        ns.connect();
        
        System.out.println("after");
        Class reflectClass = NetworkService.class;
        
        /*
        Method[] theMethods = reflectClass.getMethods();
        for(Method m : theMethods)
        {
        	System.out.println(m.getName());
        }
  		*/
        
        
        Field[] theFields = reflectClass.getDeclaredFields();
        String theName = null;
        for(Field f: theFields){
        	theName = f.getName();
        	System.out.println(f.getName());
        }
        
        try {
			Field mn = ns.getClass().getDeclaredField(theName);
			mn.setAccessible(true);
			mn.set(ns, "aws.com");
		} 
        catch (NoSuchFieldException | SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        ns.connect();
    }
	
}
