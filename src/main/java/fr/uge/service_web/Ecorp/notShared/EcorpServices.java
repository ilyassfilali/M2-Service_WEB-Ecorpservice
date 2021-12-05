package fr.uge.service_web.Ecorp.notShared;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.Vector;

import fr.uge.service_web.ifshare.shared.EcorpInterface;
import fr.uge.service_web.ifshare.shared.IOffer;
import fr.uge.service_web.ifshare.shared.IProduct;
import fr.uge.service_web.ifshare.shared.IPurchase;
import fr.uge.service_web.ifshare.shared.IUser;
import fr.uge.service_web.ifshare.shared.IfShareInterface;
import fr.uge.service_web.ifshare.shared.ProductState;
import fr.uge.service_web.ifshare.shared.PurchaseStatus;

public class EcorpServices extends UnicastRemoteObject implements EcorpInterface{
	
	private IfShareInterface ifshare;
	private HashMap<String, String> passwds = new HashMap<String, String>();	
	
	public EcorpServices(IfShareInterface ifShare) throws RemoteException {
		super();
		this.ifshare = ifShare;
	}

	@Override
	public IProduct addProduct(String productID, String productName, String description) throws RemoteException {
		
		return ifshare.addProduct(productID, productName, description);
	}

	@Override
	public Set<? extends IProduct> getProducts() throws RemoteException {
		
		return ifshare.getProducts();
	}

	@Override
	public Map<? extends IProduct, ? extends IOffer> getOffers() throws RemoteException {
		// TODO Auto-generated method stub
		return ifshare.getOffers();
	}

	@Override
	public IUser addUser(String id, String firstName, String lastName, String address, String mail)
			throws RemoteException {
		return ifshare.addUser(id, firstName, lastName, address, mail);
	}

	@Override
	public IUser getUser(String id) throws RemoteException {
		// TODO Auto-generated method stub
		return ifshare.getUser(id);
	}

	@Override
	public Set<? extends IUser> getUsers() throws RemoteException {
		// TODO Auto-generated method stub
		return ifshare.getUsers();
	}

	@Override
	public void addoffer(String idpoduit, String iduser,ProductState state,int price,int stock) throws RemoteException {
		IProduct product = null;
		for (IProduct pro : getProducts()) {
			if(pro.getId().equals(idpoduit)) {
				product = pro;
			}
		}
		IUser user = getUser(iduser);
		user.offer(product, state, price,stock);
	}

	@Override
	public List<IOffer> getoffersbyuser(String iduser) throws RemoteException {
		IUser user = getUser(iduser);
		
		return new Vector<IOffer>(user.getOffers());
	}

	@Override
	public List<IOffer> getoffersbyproduct(String idproduct) throws RemoteException {
		for (IProduct pr : ifshare.getProducts()) {
			if(pr.getId().equals(idproduct)) {
				return (List<IOffer>) ifshare.getOffers().get(pr);
			}
		}
		return null;
	}

	@Override
	public IUser connect(String email, String passwd) throws RemoteException {
		for (IUser user : ifshare.getUsers()) {
			if(user.getMail().equals(email)) {
				if(passwds.get(user.getId()).equals(passwd)) {
					return user;
				}
			}
		}
		return null;
	}

	@Override
	public void addPasswd(String iduser, String passwd) throws RemoteException {
		passwds.put(iduser, passwd);
		
	}

	@Override
	public String getid() throws RemoteException {
		List<IUser> users = new Vector<IUser>(ifshare.getUsers());
		IUser user = users.get(users.size()-1);
		int id = Integer.parseInt(user.getId()) + 1;
		return id+"";
	}

	@Override
	public void addpurshase(String iduser, int idoffre, int qt) throws RemoteException {
		IUser user = getUser(iduser);
		IOffer offer =  getofferbyid(idoffre);
		user.purchase(offer,qt);
	}

	@Override
	public List<IPurchase> getpurshasebyuser(String iduser) throws RemoteException {

		IUser user = getUser(iduser);
		List<IPurchase> list = new Vector<IPurchase>(user.getPurchases());		
		return list;
	}

	@Override
	public IOffer getofferbyid(int id) throws RemoteException {
		for (IOffer of : ifshare.getOffers().values()) {
			if(of.getId() == id) {
				return of;
			}
		}
		return null;
	}
	
}
