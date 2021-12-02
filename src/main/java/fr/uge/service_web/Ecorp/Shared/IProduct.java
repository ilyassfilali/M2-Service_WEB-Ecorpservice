package fr.uge.service_web.Ecorp.Shared;

import java.io.Serializable;
import java.rmi.Remote;
import java.rmi.RemoteException;

public interface IProduct extends Remote {
    String getId() throws RemoteException;

    String getName() throws RemoteException;

    String getDescription() throws RemoteException;
}
