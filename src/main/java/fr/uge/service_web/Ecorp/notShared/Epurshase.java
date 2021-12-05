package fr.uge.service_web.Ecorp.notShared;

import java.rmi.RemoteException;

import fr.uge.service_web.ifshare.shared.IOffer;
import fr.uge.service_web.ifshare.shared.IPurchase;
import fr.uge.service_web.ifshare.shared.PurchaseStatus;

public class Epurshase implements IPurchase{
	
	private IOffer offer;
	private int qt;
	private PurchaseStatus status;
	
	public Epurshase(IOffer offer, int qt, PurchaseStatus status) {
		super();
		this.offer = offer;
		this.qt = qt;
		this.status = status;
	}

	@Override
	public IOffer getOffer() throws RemoteException {
		// TODO Auto-generated method stub
		return offer;
	}

	@Override
	public int getQuantity() {
		// TODO Auto-generated method stub
		return qt;
	}

	@Override
	public PurchaseStatus getStatus() {
		// TODO Auto-generated method stub
		return status;
	}

}
