package kz.proffix4.rmi;

import java.rmi.registry.*;

public class RmiClient {

    final static String HOST = "localhost";

    public static void main(String... args) throws Exception {
        Registry registry = LocateRegistry.getRegistry(HOST, IRemoteHelloService.PORT);
        IRemoteHelloService service = (IRemoteHelloService) registry.lookup(IRemoteHelloService.BINDING_NAME);
        System.out.println(service.sayHello(new RemoteHello("John", 23)).toString());
        System.out.println(service.sayHello(new RemoteHello("Jan", 18)));
        System.out.println(service.sayHello(new RemoteHello("Hans", 24)));
        System.out.println(service.sayHello(new RemoteHello("Bill", 31)));
        Thread.sleep(3000);
        service.stopServer();
    }
}
