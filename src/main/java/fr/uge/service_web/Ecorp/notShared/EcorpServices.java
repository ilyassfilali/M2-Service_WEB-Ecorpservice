package fr.uge.service_web.Ecorp.notShared;

import java.rmi.RemoteException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.Vector;

import fr.uge.service_web.Ecorp.Shared.Ecommand;
import fr.uge.service_web.Ecorp.Shared.EcorpInterface;
import fr.uge.service_web.Ecorp.Shared.IOffer;
import fr.uge.service_web.Ecorp.Shared.IPerson;
import fr.uge.service_web.Ecorp.Shared.IProduct;
import fr.uge.service_web.Ecorp.Shared.IfShareInterface;
import fr.uge.service_web.Ecorp.Shared.ProductState;

public class EcorpServices implements EcorpInterface{
	
	IfShareInterface ifshare;
	private HashMap<String, IPerson> employes = new HashMap<String, IPerson>();
	private HashMap<IPerson, String> employespassword = new HashMap<IPerson, String>();
	private List<Ecommand> commands = new Vector<>();
	
	public EcorpServices(IfShareInterface ifshare) {
		this.ifshare = ifshare;
	}

	@Override
	public IProduct addProduct(String productID, String productName, String description) throws RemoteException {
		
		return ifshare.addProduct(productID, productName, description);
	}

	@Override
	public Set<IProduct> getProducts() throws RemoteException {
		// TODO Auto-generated method stub
		return ifshare.getProducts();
	}

	@Override
	public void addOffer(IPerson seller, IProduct product, ProductState productState, float price, int stock)
			throws RemoteException {
		ifshare.addOffer(seller, product, productState, price, stock);
		
	}

	@Override
	public Optional<List<IOffer>> getOffers(IProduct product) throws RemoteException {
		// TODO Auto-generated method stub
		return ifshare.getOffers(product);
	}

	@Override
	public void addPersonne(String id,String fistname, String lastname, String adress, String mail,String passwd) throws RemoteException{
		IPerson emp = new Employe(fistname, lastname, adress, mail);
		
		synchronized (employes) {
			employes.put(id, emp);
		}
		synchronized (employespassword) {
			employespassword.put(emp, passwd);
		}
		
	}

	@Override
	public Set<IPerson> getallPersonnel() throws RemoteException{
		synchronized (employes) {
			return new HashSet<IPerson>(employes.values());
		}
	}

	@Override
	public IPerson getPersonnel(String id) throws RemoteException{
		synchronized (employes) {
			return employes.get(id);
		}
	}
	
	@Override
	public IPerson getPersonnelbyname(String fistname,String lastname) throws RemoteException{
		synchronized (employes) {
			for (IPerson p : employes.values()) {
				if(p.getFirstName().equals(fistname) && p.getLastName().equals(lastname)) {
					return p;
				}
			}
			return null;
		}
	}
	
	@Override
	public boolean connect(String email,String passwd) throws RemoteException{
		
		IPerson e =null;
		synchronized (employes) {
			for (IPerson p : employes.values()) {
				if(p.getMail().equals(email)) {
					e = p;
				}
			}
		}
		if(e == null) {
			return false;
		}
		
		synchronized (employespassword) {
			if(employespassword.get(e).equals(passwd)) {
				return true;
			}else {
				return false;
			}
		}
	}

	@Override
	public void addcommand(String idbyer,String idproduct, String idoffer) throws RemoteException {
		IPerson emp = getPersonnel(idoffer);
		//besoin de .......
	}

	@Override
	public List<Ecommand> getcommands() throws RemoteException {
		// TODO Auto-generated method stub
		return commands;
	}

	@Override
	public Ecommand getcommandbyEmploye(String id) throws RemoteException {
		for (Ecommand ecommand : commands) {
			if(ecommand.getbyer() == getPersonnel(id)) {
				return ecommand;
			}
		}
		return null;
	}

}
