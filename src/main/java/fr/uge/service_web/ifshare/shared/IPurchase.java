package fr.uge.service_web.ifshare.shared;

import java.io.Serializable;
import java.rmi.Remote;
import java.rmi.RemoteException;

public interface IPurchase extends Remote {
    IOffer getOffer() throws RemoteException;

    int getQuantity();

    PurchaseStatus getStatus();
}
