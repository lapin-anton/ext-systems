import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class Server {
    public static void main(String[] args) throws IOException, InterruptedException {
        ServerSocket socket = new ServerSocket(25225);

        Map<String, Greetable> handlers = loadHandlers();

        while (true) {
            Socket client = socket.accept();
            System.out.println("Accepted");
            new SimpleServer(client, handlers).start();
            System.out.println("Disconnected");
        }
    }

    private static Map<String, Greetable> loadHandlers() {

        Map<String, Greetable> result = new HashMap<>();
        
        try(InputStream is = Server.class.getClassLoader().
                getResourceAsStream("server.properties")) {
            Properties properties = new Properties();
            properties.load(is);

            for (Object cmd : properties.keySet()) {
                String className = properties.getProperty((String) cmd);
                Class<Greetable> cl = (Class<Greetable>) Class.forName(className);
                Greetable handler = cl.getConstructor().newInstance();
                result.put(cmd.toString(), handler);
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
        
        return result;
    }
}

class SimpleServer extends Thread {

    private Socket client;
    private Map<String, Greetable> handlers;

    public SimpleServer(Socket client, Map<String, Greetable> handlers) {
        this.client = client;
        this.handlers = handlers;
    }

    @Override
    public void run() {
        handleRequest();
    }

    private void handleRequest() {
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(client.getInputStream()));
            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(client.getOutputStream()));
            String request = reader.readLine();
            String[] lines = request.split("\\s+");
            String command = lines[0];
            String userName = lines[1];
            System.out.println("Server got string: " + command);
            System.out.println("Server got string: " + userName);
            //Thread.sleep(2000);
            String response = buildResponse(command, userName);
            writer.write(response);
            writer.newLine();
            writer.flush();
            reader.close();
            writer.close();
            client.close();
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
    }

    private String buildResponse(String command, String userName) {
        Greetable handler = handlers.get(command);
        if(handler != null) {
            return handler.buildResponse(userName);
        }
        return "Hi, " + userName;
    }
}
