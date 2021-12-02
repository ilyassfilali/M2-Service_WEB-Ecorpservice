package fr.uge.service_web.Ecorp.Shared;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface IOffer extends Remote {
    IPerson getSeller() throws RemoteException;

    IProduct getProduct() throws RemoteException;

    ProductState getProductState() throws RemoteException;

    float getPrice() throws RemoteException;

    int getStock() throws RemoteException;
}
