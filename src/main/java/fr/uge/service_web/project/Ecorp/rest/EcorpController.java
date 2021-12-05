package fr.uge.service_web.project.Ecorp.rest;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Vector;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import fr.uge.service_web.Ecorp.notShared.EcorpServices;
import fr.uge.service_web.Ecorp.notShared.Employe;
import fr.uge.service_web.Ecorp.notShared.Offer;
import fr.uge.service_web.ifshare.shared.EcorpInterface;
import fr.uge.service_web.ifshare.shared.IOffer;
import fr.uge.service_web.ifshare.shared.IProduct;
import fr.uge.service_web.ifshare.shared.IPurchase;
import fr.uge.service_web.ifshare.shared.IUser;
import fr.uge.service_web.project.Ecorp.dto.IdReq;
import fr.uge.service_web.project.Ecorp.dto.LoginReq;
import fr.uge.service_web.project.Ecorp.dto.OfferReq;
import fr.uge.service_web.project.Ecorp.dto.Product;
import fr.uge.service_web.project.Ecorp.dto.PurshaseReq;
import fr.uge.service_web.project.Ecorp.dto.SignupReq;

@RestController
public class EcorpController {
	private EcorpInterface ecorps;
	
	public EcorpInterface rmiconnect() throws MalformedURLException, RemoteException, NotBoundException {
		return (EcorpInterface) Naming.lookup("rmi://localhost:1201/EcorpService");
	}
	
	@PostMapping("/Ecorp/inscription")
	public IUser inscription(@RequestBody SignupReq e) throws RemoteException, MalformedURLException, NotBoundException {
		this.ecorps = rmiconnect();
		String id = ecorps.getid();
		ecorps.addPasswd(id, e.getPasswd());
		return ecorps.addUser(id, e.getFirstname(), e.getLastname(), e.getAddress(), e.getMail());
		
	}
	
	@PostMapping("/Ecorp/connect")
	public IUser connect(@RequestBody LoginReq req) throws RemoteException, MalformedURLException, NotBoundException {
		this.ecorps = rmiconnect();
		return ecorps.connect(req.getEmail(), req.getPasswd());
	}
	
	@PostMapping("/Ecorp/newProduct")
	public IProduct addProduct(@RequestBody Product p) throws RemoteException, MalformedURLException, NotBoundException {
		this.ecorps = rmiconnect();
		return ecorps.addProduct(p.getId(), p.getNom(), p.getDescription());
	}
	
	@GetMapping("/Ecorp/products")
	public Set<IProduct> getproducts() throws RemoteException, MalformedURLException, NotBoundException {
		this.ecorps = rmiconnect();
		return new HashSet<IProduct>(ecorps.getProducts());
	}
	
	@PostMapping("/Ecorp/newoffres")
	public void addOffer(@RequestBody OfferReq o) throws MalformedURLException, RemoteException, NotBoundException {
		this.ecorps = rmiconnect();
		ecorps.addoffer(o.getIdproduct(), o.getIduser(), o.getState(),o.getPrice() , o.getQt());
	}
	
	@GetMapping("/Ecorp/offers")
	public Set<IOffer> getoffers() throws MalformedURLException, RemoteException, NotBoundException {
		this.ecorps = rmiconnect();
		return new HashSet<IOffer>(ecorps.getOffers());
	}
	
	
	@PostMapping("/Ecorp/myoffers")
	public Set<IOffer> getmesoffers(@RequestBody IdReq i) throws MalformedURLException, RemoteException, NotBoundException {
		this.ecorps = rmiconnect();
		return new HashSet<IOffer>(ecorps.getoffersbyuser(i.getId()));
	}
	
	@PostMapping("/Ecorp/offersbyproduct")
	public Set<IOffer> getoffersbyproduct(@RequestBody IdReq i) throws MalformedURLException, RemoteException, NotBoundException {
		this.ecorps = rmiconnect();
		return new HashSet<IOffer>(ecorps.getoffersbyproduct(i.getId()));
	}
	
	@PostMapping("/Ecorp/newpurshase")
	public void purshase(@RequestBody PurshaseReq p) throws MalformedURLException, RemoteException, NotBoundException {
		this.ecorps = rmiconnect();
		ecorps.addpurshase(p.getIduser(), p.getIdoffer(), p.getQt());
	}
	
	@PostMapping("/Ecorp/myPurshases")
	public List<IPurchase> getmyPurshases(@RequestBody IdReq i) throws MalformedURLException, RemoteException, NotBoundException {
		this.ecorps = rmiconnect();
		return ecorps.getpurshasebyuser(i.getId());
	}
	
	
	
}