package calculator;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

public class SaveManager {

	private List<String> results;
	private String filename;
	
	public SaveManager(String filename){
		results = new ArrayList<String>();
		this.filename = filename;
	}
	
	/**
	 * Läs sparad data från fil.
	 */
	public List<String> readFromDisk()
	{
		try 
		{
			ObjectInputStream in = new ObjectInputStream(new FileInputStream(filename));
			results = (List<String>) in.readObject();
		    in.close();
		    return results;
		}
	    catch (Exception ex) 
	    {
			System.out.println("Error: " + ex.toString());
		}
		return results;
	}
	
	/**
	 * Spara listan med information till fil.
	 */
	public void saveToDisk()
	{
		try 
		{
			ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(filename));
		    out.writeObject(results);
		    out.close();
		} 
		catch (Exception ex) 
		{
			System.out.println("Error: " + ex.toString());
		}
	}
	
}
