package kz.proffix4.rmi;

import java.rmi.*;
import java.rmi.registry.*;
import java.rmi.server.*;
import java.util.concurrent.atomic.AtomicBoolean;

public class RmiServer implements IRemoteHelloService {

    private static AtomicBoolean stopServer = new AtomicBoolean(false);

    @Override
    public Object sayHello(RemoteHello data) {
        String txt = "Hello, " + data + "!";
        try {
            System.out.println(txt + " from " + UnicastRemoteObject.getClientHost());
        } catch (ServerNotActiveException e) {
            System.out.println(e.getMessage());
        }
        return txt;
    }

    @Override
    public void stopServer() {
        System.out.println("Shutting down...");
        stopServer.set(true);
    }

    public static void main(String... args) throws AccessException, RemoteException, AlreadyBoundException {

        System.out.print("Starting registry...");

        final Registry registry = LocateRegistry.createRegistry(IRemoteHelloService.PORT);
        System.out.println(" OK");

        final IRemoteHelloService service = new RmiServer();
        Remote stub = UnicastRemoteObject.exportObject(service, 0);

        System.out.print("Binding service...");
        registry.bind(IRemoteHelloService.BINDING_NAME, stub);
        System.out.println(" OK");

        while (!stopServer.get()) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                break;
            }
        }
        System.out.println("Server stopped");
        System.exit(0);

    }

}
