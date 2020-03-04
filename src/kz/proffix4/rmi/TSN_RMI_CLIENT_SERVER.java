package kz.proffix4.rmi;

import java.util.Timer;
import java.util.TimerTask;

public class TSN_RMI_CLIENT_SERVER {

    public static void main(String[] args) {

        // Запуск сервера RMI в отдельном потоке
        new Timer().schedule(new TimerTask() {
                @Override
                public void run() {
                    try {
                        RmiServer.main();
                    } catch (Exception ex) {
                        System.err.println("RmiServer error!");
                    }
                }
            }, 0);

        // Запуск клиента RMI в отдельном потоке с задержкой 1 секунда
        new Timer().schedule(new TimerTask() {
                @Override
                public void run() {
                    try {
                        RmiClient.main();
                    } catch (Exception ex) {
                        System.err.println("RmiClient error!");
                        ex.printStackTrace();
                    }
                }
            }, 1000);

    }
}
