package fr.uge.service_web.Ecorp.Shared;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;
import java.util.Optional;
import java.util.Set;

public interface IfShareInterface extends Remote {
    IProduct addProduct(String productID, String productName, String description) throws RemoteException;

    Set<IProduct> getProducts() throws RemoteException;

    void addOffer(IPerson seller, IProduct product, ProductState productState, float price, int stock) throws RemoteException;

    Optional<List<IOffer>> getOffers(IProduct product) throws RemoteException;
}
