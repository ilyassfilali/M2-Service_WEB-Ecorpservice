package fr.uge.service_web.Ecorp;

import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;

import fr.uge.service_web.Ecorp.Shared.EcorpInterface;
import fr.uge.service_web.Ecorp.Shared.IfShareInterface;
import fr.uge.service_web.Ecorp.notShared.EcorpServices;

public class EcorpServer {

	
	public EcorpServer() {
		
		try {
			LocateRegistry.createRegistry(1099);
			IfShareInterface i = (IfShareInterface) Naming.lookup("IfshareService");
			EcorpInterface ecorp = new EcorpServices(i);
			Naming.rebind("EcorpService", ecorp);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	public static void main(String[] args) {
		new EcorpServer();
	}
}
