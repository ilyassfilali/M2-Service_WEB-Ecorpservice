package fr.uge.service_web.Ecorp.notShared;

import java.rmi.RemoteException;
import java.util.Set;

import fr.uge.service_web.ifshare.shared.IOffer;
import fr.uge.service_web.ifshare.shared.IProduct;

public class EProduct {

	private String id;
	private String name;
	private String description;
	
	
	public EProduct(String id, String nom, String description) {
		super();
		this.id = id;
		this.name = nom;
		this.description = description;
	}
	
	public String getId(){
		// TODO Auto-generated method stub
		return id;
	}

	public String getName(){
		// TODO Auto-generated method stub
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}


	public String getDescription() {
		
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}
