package fr.uge.service_web.project.Ecorp;

import java.rmi.RemoteException;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import fr.uge.service_web.Ecorp.notShared.EcorpServices;
import fr.uge.service_web.Ecorp.notShared.Employe;
import fr.uge.service_web.ifshare.shared.EcorpInterface;

@RestController
public class EcorpController {
	private EcorpInterface ecorps;
	
	@PostMapping("/Ecorp/inscription")
	public void inscription(@RequestBody Employe e) throws RemoteException {
		String id = ecorps.getid();
		e.setId(id);
	}

}
