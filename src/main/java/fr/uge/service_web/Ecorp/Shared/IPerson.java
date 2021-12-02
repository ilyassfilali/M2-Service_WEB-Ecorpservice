package fr.uge.service_web.Ecorp.Shared;

import java.io.Serializable;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.Objects;

public interface IPerson extends Remote {
    String getFirstName() throws RemoteException;

    String getLastName() throws RemoteException;

    String getAddress() throws RemoteException;

    String getMail() throws RemoteException;
}
