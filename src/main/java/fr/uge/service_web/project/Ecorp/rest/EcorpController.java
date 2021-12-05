package fr.uge.service_web.project.Ecorp.rest;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Vector;
import java.util.stream.Collectors;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import fr.uge.service_web.Ecorp.notShared.EProduct;
import fr.uge.service_web.Ecorp.notShared.EcorpServices;
import fr.uge.service_web.Ecorp.notShared.Employe;
import fr.uge.service_web.Ecorp.notShared.Epurshase;
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
	public Employe inscription(@RequestBody SignupReq e) throws RemoteException, MalformedURLException, NotBoundException {
		this.ecorps = rmiconnect();
		String id = ecorps.getid();
		ecorps.addPasswd(id, e.getPasswd());
		IUser u = ecorps.addUser(id, e.getFirstname(), e.getLastname(), e.getAddress(), e.getMail());
		return new Employe(u.getFirstName(), u.getLastName(), u.getAddress(), u.getMail());
		
	}
	
	@PostMapping("/Ecorp/connect")
	public Employe connect(@RequestBody LoginReq req) throws RemoteException, MalformedURLException, NotBoundException {
		this.ecorps = rmiconnect();
		IUser u = ecorps.connect(req.getEmail(), req.getPasswd());
		return new Employe(u.getFirstName(), u.getLastName(), u.getAddress(), u.getMail());
	}
	
	@PostMapping("/Ecorp/newProduct")
	public EProduct addProduct(@RequestBody Product p) throws RemoteException, MalformedURLException, NotBoundException {
		this.ecorps = rmiconnect();
		IProduct pr = ecorps.addProduct(p.getId(), p.getNom(), p.getDescription());
		return new EProduct(pr.getId(), pr.getName(), pr.getDescription());
	}
	
	@GetMapping("/Ecorp/products")
	public Set<EProduct> getproducts() throws RemoteException, MalformedURLException, NotBoundException {
		this.ecorps = rmiconnect();
		return ecorps.getProducts().stream().map(p->{
			try {
				return new EProduct(p.getId(), p.getName(),p.getDescription());
			} catch (RemoteException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return null;
		}).collect(Collectors.toUnmodifiableSet());
		
	}

	
	@PostMapping("/Ecorp/newoffres")
	public void addOffer(@RequestBody OfferReq o) throws MalformedURLException, RemoteException, NotBoundException {
		this.ecorps = rmiconnect();
		ecorps.addoffer(o.getIdproduct(), o.getIduser(), o.getState(),o.getPrice() , o.getQt());
	}
	
	@GetMapping("/Ecorp/offers")
	public Set<Offer> getoffers() throws MalformedURLException, RemoteException, NotBoundException {
		this.ecorps = rmiconnect();
		return ecorps.getOffers().stream().map(p->{
			try {
				return new Offer(p.getId(), p.getSeller(), p.getProduct(), p.getProductState(), p.getPrice(), p.getStock());
			} catch (Exception e) {
				e.getMessage();
			}
			return null;
		}).collect(Collectors.toUnmodifiableSet());
	}
	
	
	@PostMapping("/Ecorp/myoffers")
	public Set<Offer> getmesoffers(@RequestBody String i) throws MalformedURLException, RemoteException, NotBoundException {
		this.ecorps = rmiconnect();
		return ecorps.getoffersbyuser(i).stream().map(p->{
			try {
				return new Offer(p.getId(), p.getSeller(), p.getProduct(), p.getProductState(), p.getPrice(), p.getStock());
			} catch (Exception e) {
				e.getMessage();
			}
			return null;
		}).collect(Collectors.toUnmodifiableSet());
	}
	
	@PostMapping("/Ecorp/offersbyproduct")
	public Set<Offer> getoffersbyproduct(@RequestBody String i) throws MalformedURLException, RemoteException, NotBoundException {
		this.ecorps = rmiconnect();
		return ecorps.getoffersbyproduct(i).stream().map(p->{
			try {
				return new Offer(p.getId(), p.getSeller(), p.getProduct(), p.getProductState(), p.getPrice(), p.getStock());
			} catch (Exception e) {
				e.getMessage();
			}
			return null;
		}).collect(Collectors.toUnmodifiableSet());
	}
	
	@PostMapping("/Ecorp/newpurshase")
	public void purshase(@RequestBody PurshaseReq p) throws MalformedURLException, RemoteException, NotBoundException {
		this.ecorps = rmiconnect();
		ecorps.addpurshase(p.getIduser(), p.getIdoffer(), p.getQt());
	}
	
	@PostMapping("/Ecorp/myPurshases")
	public List<Epurshase> getmyPurshases(@RequestBody String i) throws MalformedURLException, RemoteException, NotBoundException {
		this.ecorps = rmiconnect();
		return ecorps.getpurshasebyuser(i)
				.stream().map(p->{
					try {
						return new Epurshase(p.getOffer(), p.getQuantity(), p.getStatus(), p.getBuyer(), p.getPurchaseDate());
					} catch (Exception e) {
						// TODO: handle exception
					}
					return null;
				}).collect(Collectors.toUnmodifiableList());
	}
	
	
	
}
