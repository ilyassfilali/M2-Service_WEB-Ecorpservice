package fr.uge.service_web.Ecorp.notShared;

import java.rmi.RemoteException;

import fr.uge.service_web.Ecorp.Shared.IPerson;

public class Employe implements IPerson {
	private String fistname;
	private String lastname;
	private String address;
	private String mail;
	
	

	public Employe(String fistname, String lastname, String address, String mail) {
		super();
		this.fistname = fistname;
		this.lastname = lastname;
		this.address = address;
		this.mail = mail;
	}

	@Override
	public String getFirstName() throws RemoteException {
		// TODO Auto-generated method stub
		return fistname;
	}

	@Override
	public String getLastName() throws RemoteException {
		// TODO Auto-generated method stub
		return lastname;
	}

	@Override
	public String getAddress() throws RemoteException {
		// TODO Auto-generated method stub
		return address;
	}

	@Override
	public String getMail() throws RemoteException {
		// TODO Auto-generated method stub
		return mail;
	}
	
}
