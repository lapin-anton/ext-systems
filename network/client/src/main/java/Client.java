import java.io.*;
import java.net.Socket;

public class Client {
    public static void main(String[] args) throws IOException {
        for (int i = 0; i < 10; i++) {
            SimpleClient sc = new SimpleClient(i);
            sc.start();
        }
    }
}

class SimpleClient extends Thread {

    private final static String[] COMMAND = {
            "HELLO", "MORNING", "DAY", "EVENING"
    };

    private int cmdNumber;

    public SimpleClient(int cmdNumber) {
        this.cmdNumber = cmdNumber;
    }

    @Override
    public void run() {
        //System.out.println("Started: " + LocalDateTime.now());
        Socket socket = null;
        BufferedReader reader = null;
        BufferedWriter writer = null;
        try {
            socket = new Socket("127.0.0.1", 25225);
            reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            writer = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));

            String command = COMMAND[cmdNumber % COMMAND.length];
            String sb = command + " User Name";
            writer.write(sb);
            writer.newLine();
            writer.flush();

            String ans = reader.readLine();
            System.out.println(ans);
        } catch (IOException e) {
            e.printStackTrace(System.out);
        } finally {
            try {
                reader.close();
                writer.close();
                //System.out.println("Finished: " + LocalDateTime.now());
            } catch (IOException e) {
                e.printStackTrace(System.out);
            }
        }
    }
}
