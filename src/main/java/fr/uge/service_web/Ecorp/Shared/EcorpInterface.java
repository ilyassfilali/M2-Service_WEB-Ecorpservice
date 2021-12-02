package fr.uge.service_web.Ecorp.Shared;

import java.rmi.RemoteException;
import java.util.Set;

public interface EcorpInterface extends IfShareInterface{
	
	public void addPersonne(String id,String fistname,String lastname,String adress,String mail,String passwd) throws RemoteException;
	public Set<IPerson> getallPersonnel() throws RemoteException;
	public IPerson getPersonnel(String id) throws RemoteException;
	IPerson getPersonnelbyname(String fistname, String lastname) throws RemoteException;
	boolean connect(String email, String passwd) throws RemoteException;
	
	

}
