package fr.uge.service_web.Ecorp.notShared;

import java.rmi.RemoteException;

import fr.uge.service_web.ifshare.shared.IOffer;
import fr.uge.service_web.ifshare.shared.IProduct;
import fr.uge.service_web.ifshare.shared.IUser;
import fr.uge.service_web.ifshare.shared.ProductState;

public class Offer{
	
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


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getSeller() throws RemoteException {
		return seller.getId();
	}


	public void setSeller(IUser seller) {
		this.seller = seller;
	}


	public String getProduct() throws RemoteException {
		return product.getId();
	}


	public void setProduct(IProduct product) {
		this.product = product;
	}


	public ProductState getState() {
		return state;
	}


	public void setState(ProductState state) {
		this.state = state;
	}


	public float getPrice() {
		return price;
	}


	public void setPrice(float price) {
		this.price = price;
	}


	public int getStock() {
		return stock;
	}


	public void setStock(int stock) {
		this.stock = stock;
	}
}
