package kz.proffix4.rmi;

import java.rmi.*;

public interface IRemoteHelloService extends Remote {

    String BINDING_NAME = "sample/HelloService";
    int PORT = 1100;

    Object sayHello(RemoteHello data) throws RemoteException;

    void stopServer() throws RemoteException;

}
