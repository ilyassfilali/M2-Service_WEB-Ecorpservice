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

public class Employe extends UnicastRemoteObject implements IUser {
	private String id;
	private String firstname;
	private String lastname;
	private String address;
	private String mail;
	private Set<IOffer> offers = new HashSet<IOffer>();
	private List<IPurchase> purchases = new Vector<IPurchase>();	
	

	public Employe(String id,String firstname, String lastname, String address, String mail) throws RemoteException {
		super();
		this.id = id;
		this.firstname = firstname;
		this.lastname = lastname;
		this.address = address;
		this.mail = mail;
	}



	@Override
	public String getId() throws RemoteException {
		// TODO Auto-generated method stub
		return id;
	}



	@Override
	public String getFirstName() throws RemoteException {
		// TODO Auto-generated method stub
		return firstname;
	}



	@Override
	public void setFirstName(String firstName) throws RemoteException {
		this.firstname = firstName;
	}



	@Override
	public String getLastName() throws RemoteException {
		return lastname;
	}



	@Override
	public void setLastName(String lastName) throws RemoteException {
		this.lastname = lastName;
	}



	@Override
	public String getAddress() throws RemoteException {
		// TODO Auto-generated method stub
		return address;
	}



	@Override
	public void setAddress(String address) throws RemoteException {
		this.address = address;
	}



	@Override
	public String getMail() throws RemoteException {
		return mail;
	}



	@Override
	public void setMail(String mail) throws RemoteException {
		this.mail = mail;
	}



	@Override
	public IOffer offer(IProduct product, ProductState productState, float price, int stock) throws RemoteException {
		IOffer offer  = new Offer(0,this,product,productState,price,stock);
		this.offers.add(offer);
		return offer;
	}



	@Override
	public IPurchase purchase(IOffer offer,int quantity) throws RemoteException {
		
		return null;
	}



	@Override
	public Set<? extends IOffer> getOffers() throws RemoteException {
		return offers;
	}



	@Override
	public List<? extends IPurchase> getPurchases() throws RemoteException {
		return purchases;
	}

}
