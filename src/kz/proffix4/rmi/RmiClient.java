package kz.proffix4.rmi;

import java.rmi.registry.*;

// Клиент RMI
public class RmiClient {
    final static String HOST = "localhost"; // Адрес сервера

    public static void main(String... args) throws Exception {
        Registry server = LocateRegistry.getRegistry(HOST, IRemoteService.PORT);
        IRemoteService remoteService = (IRemoteService) server.lookup(IRemoteService.SERVICE_NAME);
        System.out.println(remoteService.getData(new Person("John", 23)));
        System.out.println(remoteService.getData(new Person("Jan", 18)));
        System.out.println(remoteService.getData(new Person("Hans", 24)));
        System.out.println(remoteService.getData(new Person("Bill", 31)));
        remoteService.stopServer();
    }
}
