package fr.uge.service_web.project.Ecorp;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;

import fr.uge.service_web.Ecorp.notShared.EcorpServices;
import fr.uge.service_web.Ecorp.notShared.Ecorpshared;
import fr.uge.service_web.ifshare.shared.EcorpInterface;
import fr.uge.service_web.ifshare.shared.Ecorpsharedinterface;
import fr.uge.service_web.ifshare.shared.IfShareInterface;

public class EcorpServer {

	
	public EcorpServer() throws RemoteException, MalformedURLException, NotBoundException {
			LocateRegistry.createRegistry(1201);
			IfShareInterface i = (IfShareInterface) Naming.lookup("rmi://localhost:1200/IfShareService");
			EcorpInterface ecorp = new EcorpServices(i);
			//System.out.println(ecorp.addUser("0", "ilyass", "filali", "paris", "ta@gmail.com").getFirstName());
			//System.out.println(ecorp.getUser("0").getAddress());
			Ecorpsharedinterface ecorpshared =  new Ecorpshared(ecorp); 
			Naming.rebind("rmi://localhost:1201/EcorpService", ecorp);
			Naming.rebind("rmi://localhost:1201/EcorpSharedService", ecorpshared);
		
	}
	
	public static void main(String[] args) throws RemoteException, MalformedURLException, NotBoundException {
		new EcorpServer();
	}
}
