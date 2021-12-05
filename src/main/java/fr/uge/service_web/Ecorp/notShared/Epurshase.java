package fr.uge.service_web.Ecorp.notShared;

import java.rmi.RemoteException;
import java.util.Date;

import fr.uge.service_web.ifshare.shared.IOffer;
import fr.uge.service_web.ifshare.shared.IPurchase;
import fr.uge.service_web.ifshare.shared.IUser;
import fr.uge.service_web.ifshare.shared.PurchaseStatus;

public class Epurshase{
	
	private IOffer offer;
	private int qt;
	private PurchaseStatus status;
	private IUser buyer;
	private Date date;
	
	public Epurshase(IOffer offer, int qt, PurchaseStatus status,IUser buyer,Date date) {
		super();
		this.offer = offer;
		this.qt = qt;
		this.buyer = buyer;
		this.date = date;
		this.status = status;
	}

	public int getOffer() throws RemoteException {
		return offer.getId();
	}

	public void setOffer(IOffer offer) {
		this.offer = offer;
	}

	public int getQt() {
		return qt;
	}

	public void setQt(int qt) {
		this.qt = qt;
	}

	public PurchaseStatus getStatus() {
		return status;
	}

	public void setStatus(PurchaseStatus status) {
		this.status = status;
	}

	public String getBuyer() throws RemoteException {
		return buyer.getId();
	}

	public void setBuyer(IUser buyer) {
		this.buyer = buyer;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

}
