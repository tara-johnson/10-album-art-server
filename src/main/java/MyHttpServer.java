import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

class MyHttpServer {
    public static final int PORT = 6789;

    public static void main(String argv[]) {
        try (ServerSocket socket = new ServerSocket(PORT)) {
            serve(socket);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void serve(ServerSocket socket) throws IOException {
        System.out.println("Listening on http://localhost:" + PORT);
        boolean isRunning = true;
        while (isRunning) {
            System.out.println("waiting for request...");
            Socket connectionSocket = socket.accept();
            BufferedReader inFromClient = new BufferedReader(new InputStreamReader(connectionSocket.getInputStream()));
            BufferedWriter outToClient = new BufferedWriter(new OutputStreamWriter(connectionSocket.getOutputStream()));

            HTTPRequest request = new HTTPRequest(inFromClient);
            HTTPStaticFileReader file = new HTTPStaticFileReader(request);

            try {
                int statusCode = 200;
                String body = file.getContents();
                HTTPResponse response = new HTTPResponse(statusCode, body);
                response.send(outToClient);
            } catch (FileNotFoundException e) {
                HTTPResponse response = new HTTPResponse(404, "Could not find " + request.path);
                response.send(outToClient);
            } catch (IOException e) {
               HTTPResponse response = new HTTPResponse(500, "Internal server error");
               response.send(outToClient);
            }

            System.out.println("closed request.");
        }
    }
}