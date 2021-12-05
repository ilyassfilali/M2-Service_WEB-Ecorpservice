package fr.uge.service_web.project.Ecorp.dto;

public class PurshaseReq {

	private String iduser;
	private int idoffer;
	private int qt;
	public PurshaseReq(String iduser, int idoffer, int qt) {
		super();
		this.iduser = iduser;
		this.idoffer = idoffer;
		this.qt = qt;
	}
	public String getIduser() {
		return iduser;
	}
	public void setIduser(String iduser) {
		this.iduser = iduser;
	}
	public int getIdoffer() {
		return idoffer;
	}
	public void setIdoffer(int idoffer) {
		this.idoffer = idoffer;
	}
	public int getQt() {
		return qt;
	}
	public void setQt(int qt) {
		this.qt = qt;
	}
	
}
