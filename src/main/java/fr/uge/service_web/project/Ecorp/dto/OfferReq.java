package fr.uge.service_web.project.Ecorp.dto;

import fr.uge.service_web.ifshare.shared.ProductState;

public class OfferReq {
	
	private String iduser;
	private String idproduct;
	private float price;
	private int qt;
	private ProductState state;
	
	public OfferReq(String iduser, String idproduct, float price, int qt, ProductState state) {
		super();
		this.iduser = iduser;
		this.idproduct = idproduct;
		this.price = price;
		this.qt = qt;
		this.state = state;
	}

	public String getIduser() {
		return iduser;
	}

	public void setIduser(String iduser) {
		this.iduser = iduser;
	}

	public String getIdproduct() {
		return idproduct;
	}

	public void setIdproduct(String idproduct) {
		this.idproduct = idproduct;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public int getQt() {
		return qt;
	}

	public void setQt(int qt) {
		this.qt = qt;
	}

	public ProductState getState() {
		return state;
	}

	public void setState(ProductState state) {
		this.state = state;
	}

}
