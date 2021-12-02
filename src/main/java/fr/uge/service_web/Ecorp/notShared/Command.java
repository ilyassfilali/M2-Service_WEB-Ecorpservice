package fr.uge.service_web.Ecorp.notShared;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import fr.uge.service_web.Ecorp.Shared.Ecommand;
import fr.uge.service_web.Ecorp.Shared.IOffer;
import fr.uge.service_web.Ecorp.Shared.IPerson;

public class Command extends UnicastRemoteObject implements Ecommand {
	
	private IPerson byer;
	private IOffer offer;

	public Command(IPerson byer, IOffer offer) throws RemoteException {
		super();
		this.byer = byer;
		this.offer = offer;
	}

	@Override
	public IPerson getbyer() throws RemoteException {
		// TODO Auto-generated method stub
		return byer;
	}

	@Override
	public IOffer getoffer() throws RemoteException {
		// TODO Auto-generated method stub
		return offer;
	}

	@Override
	public int getQuantite() throws RemoteException {
		// TODO Auto-generated method stub
		return 0;
	}

}
