package kz.proffix4.rmi;

import java.rmi.*;

// Интерфейс для описания возможностей сервера
public interface IRemoteService extends Remote {
    String SERVICE_NAME = "egov/person";
    int PORT = 1101;
    Object getData(Person data) throws RemoteException;
    void stopServer() throws RemoteException;
}
