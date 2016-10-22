package Container;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class Server {
	static ServletRequest req = null;
	static ServletResponse res = null;
	
	public static void main(String args[]) throws Exception{
		final int port = 3333; 
		ServerSocket serverSocket = null;
		
		try {
			serverSocket = new ServerSocket(port);
			println("" + serverSocket.getLocalPort());
			Store.mapJsp();
			Store.Serve();
			Analysis.Jsp2Servlet();
			while(true){
				Socket clientSocket = serverSocket.accept();
				println("" + clientSocket.getInetAddress() + ": " + clientSocket.getPort());
				
				service(clientSocket);
				clientSocket.close();
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public static void service(Socket socket) throws Exception{
		try {
			InputStream socketIn = socket.getInputStream();
			//Thread.sleep(500);
			req = new RequestServer(socketIn);
			println("正在创建ServletRequest对象");
			OutputStream socketOut = socket.getOutputStream();
			res = new ResponseServer(socketOut);
			println("正在创建ServletResponse对象");
			
			Processor sp = new Processor();
			
			sp.processServletRequest((RequestServer)req, (ResponseServer)res); 
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	public static void println(String content){
		System.out.println(content);
	}
}
