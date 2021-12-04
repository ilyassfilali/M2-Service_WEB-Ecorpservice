package fr.uge.service_web.project.Ecorp.notShared;

import java.rmi.RemoteException;
import java.util.List;
import java.util.Map;
import java.util.Set;

import fr.uge.service_web.project.shared.EcorpInterface;
import fr.uge.service_web.project.shared.Ecorpsharedinterface;
import fr.uge.service_web.project.shared.IOffer;
import fr.uge.service_web.project.shared.IProduct;
import fr.uge.service_web.project.shared.IPurchase;
import fr.uge.service_web.project.shared.IUser;

public class Ecorpshared implements Ecorpsharedinterface{
	
	private EcorpInterface interface1;
	
	public Ecorpshared(EcorpInterface interface1) {
		this.interface1 = interface1;
	}

	@Override
	public void addpurshase(String iduser, String idoffre, int qt) throws RemoteException {
		interface1.addpushase(iduser, idoffre, qt);
	}

	@Override
	public List<IPurchase> getpurshasebyuser(String iduser) throws RemoteException {
		return interface1.getpurshasebyuser(iduser);
	}

	@Override
	public IUser connect(String email, String passwd) throws RemoteException {
		return interface1.connect(email, passwd);
	}

	@Override
	public void addPasswd(String iduser, String passwd) throws RemoteException {
		interface1.addPasswd(iduser, passwd);
	}

	@Override
	public String getid() throws RemoteException {
		// TODO Auto-generated method stub
		return interface1.getid();
	}

	@Override
	public Set<? extends IProduct> getProducts() throws RemoteException {
		// TODO Auto-generated method stub
		return interface1.getProducts();
	}

	@Override
	public Map<? extends IProduct, ? extends IOffer> getOffers() throws RemoteException {
		// TODO Auto-generated method stub
		return interface1.getOffers();
	}

	@Override
	public IUser addUser(String id, String firstName, String lastName, String address, String mail)
			throws RemoteException {
		// TODO Auto-generated method stub
		return interface1.addUser(id, firstName, lastName, address, mail);
	}
	
	

}
