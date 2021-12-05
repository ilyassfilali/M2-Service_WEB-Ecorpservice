package fr.uge.service_web.Ecorp.notShared;

import java.rmi.RemoteException;

import fr.uge.service_web.ifshare.shared.IOffer;
import fr.uge.service_web.ifshare.shared.IProduct;
import fr.uge.service_web.ifshare.shared.IUser;
import fr.uge.service_web.ifshare.shared.ProductState;

public class Offer implements IOffer{
	
	private int id;
	private IUser seller;
	private IProduct product;
	private ProductState state;
	private float price;
	private int stock;
	

	public Offer(int id, IUser seller, IProduct product, ProductState state, float price, int stock) {
		super();
		this.id = id;
		this.seller = seller;
		this.product = product;
		this.state = state;
		this.price = price;
		this.stock = stock;
	}

	@Override
	public int getId() throws RemoteException {
		// TODO Auto-generated method stub
		return id;
	}

	@Override
	public IUser getSeller() throws RemoteException {
		// TODO Auto-generated method stub
		return seller;
	}

	@Override
	public IProduct getProduct() throws RemoteException {
		// TODO Auto-generated method stub
		return product;
	}

	@Override
	public ProductState getProductState() throws RemoteException {
		// TODO Auto-generated method stub
		return state;
	}

	@Override
	public float getPrice() throws RemoteException {
		// TODO Auto-generated method stub
		return price;
	}

	@Override
	public void setPrice(float price) throws RemoteException {
		this.price = price;
	}

	@Override
	public int getStock() throws RemoteException {
		// TODO Auto-generated method stub
		return stock;
	}

	@Override
	public void refill(int quantity) throws RemoteException {
		this.stock += quantity;
	}


}
