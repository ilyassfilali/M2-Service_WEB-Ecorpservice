package fr.uge.service_web.Ecorp.Shared;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Ecommand extends Remote{
	
	public IPerson getbyer() throws RemoteException;
	public IOffer getoffer() throws RemoteException;
	public int getQuantite() throws RemoteException;
	
}
