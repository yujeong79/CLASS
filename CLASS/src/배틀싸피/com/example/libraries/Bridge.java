package 배틀싸피.com.example.libraries;

import java.net.*;
import java.io.*;

public class Bridge {
    private static final String HOST = "127.0.0.1";
    private static final int PORT = 8747;

    private Socket socket = null;
    private byte[] bytes = new byte[1024];

    public String init(String nickname) {
        try {
            socket = new Socket();
            System.out.println("[STATUS] Trying to Connect to " + HOST + ":" + PORT);
            socket.connect(new InetSocketAddress(HOST, PORT));
            System.out.println("[STATUS] Connected");

            String initCommand = "INIT " + nickname;

            return submit(initCommand);
        
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }

    public String submit(String stringToSend) {
        try {
            OutputStream os = socket.getOutputStream();
            bytes = stringToSend.getBytes("UTF-8");
            os.write(bytes);
            os.flush();

            String recvData = receive();

            return recvData;

        } catch (Exception e) {
        	close();
        }
        return "";
    }

    public String receive() {
        try {
            InputStream is = socket.getInputStream();
            bytes = new byte[1024];
            int count_byte = is.read(bytes);
            String gameData = new String(bytes, 0, count_byte, "UTF-8");

            if (gameData.length() == 0 || gameData.startsWith("0")) {
                close();

            } else {
                return gameData;
            }
        
        } catch (Exception e) {
        	close();
        }

        return "";
    }

    // 소켓 닫기
    public void close() {
        try {
            if (socket != null && !socket.isClosed()) {
                socket.close();
                System.out.println("[STATUS] Connection Closed.");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
