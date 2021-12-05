package fr.uge.service_web.Ecorp.notShared;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Vector;

import fr.uge.service_web.ifshare.shared.IOffer;
import fr.uge.service_web.ifshare.shared.IProduct;
import fr.uge.service_web.ifshare.shared.IPurchase;
import fr.uge.service_web.ifshare.shared.IUser;
import fr.uge.service_web.ifshare.shared.ProductState;

public class Employe {
	private String id;
	private String firstname;
	private String lastname;
	private String address;
	private String mail;
	private Set<IOffer> offers = new HashSet<IOffer>();
	private List<IPurchase> purchases = new Vector<IPurchase>();	
	

	public Employe(String firstname, String lastname, String address, String mail) throws RemoteException {
		super();
		this.firstname = firstname;
		this.lastname = lastname;
		this.address = address;
		this.mail = mail;
	}


	public void setId(String id) {
		this.id = id;
	}
	
	public String getId() throws RemoteException {
		// TODO Auto-generated method stub
		return id;
	}



	public String getFirstName() throws RemoteException {
		// TODO Auto-generated method stub
		return firstname;
	}



	public void setFirstName(String firstName) throws RemoteException {
		this.firstname = firstName;
	}



	public String getLastName() throws RemoteException {
		return lastname;
	}



	public void setLastName(String lastName) throws RemoteException {
		this.lastname = lastName;
	}



	public String getAddress() throws RemoteException {
		// TODO Auto-generated method stub
		return address;
	}


	public void setAddress(String address) throws RemoteException {
		this.address = address;
	}



	public String getMail() throws RemoteException {
		return mail;
	}



	public void setMail(String mail) throws RemoteException {
		this.mail = mail;
	}





	public Set<? extends IOffer> getOffers() throws RemoteException {
		return null;
	}



	public List<? extends IPurchase> getPurchases() throws RemoteException {
		return null;
	}

}
