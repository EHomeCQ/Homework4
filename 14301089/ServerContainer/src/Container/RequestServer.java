package Container;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

import javax.servlet.AsyncContext;
import javax.servlet.DispatcherType;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletInputStream;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class RequestServer implements ServletRequest{
	
	
	private Map<String, String> paramters = new HashMap<String, String>();
	private StringBuffer requestContentBuffer = new StringBuffer(2048);
	
	private static String ext = null;
	
	private InputStream in = null;
	private String uri = null;
	
	public RequestServer(InputStream in){
		this.in = in;
	
		prepareBuffer();
		
		parseString();
	}
	
	public void prepareBuffer(){
		byte[] buffer = new byte[2048];
		int i = -1;
		try {
			i = this.in.read(buffer);
			
			for(int k = 0; k < i ; ++k){
				requestContentBuffer.append((char)buffer[k]);
			}
			
			System.out.println(requestContentBuffer.toString());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void parseString(){
		String[] lines = requestContentBuffer.toString().split("\r\n");
		
		String[] firstLineEle = lines[0].split(" ");
		
		String[] urlInfo = firstLineEle[1].split("\\?");
		if(urlInfo!=null){
			this.uri = urlInfo[0];
			if((uri.lastIndexOf(".")) != -1)
				ext = uri.substring(uri.lastIndexOf(".") + 1, uri.length());
			if(urlInfo.length == 2){
				String remainer = urlInfo[1];
				String[] pairs = remainer.split("&");
				for(int i = 0; i < pairs.length; ++i){
					String[] keys = pairs[i].split("=");
					paramters.put(keys[0], keys[1]);
				}
			}
			
		}else{
			return;
		}
	}
	
	public static String getExt(){
		return ext;
	}
	
	public String getURI(){
		return this.uri;
	}

	public AsyncContext getAsyncContext() {
		// TODO Auto-generated method stub
		return null;
	}

	public Object getAttribute(String arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	public Enumeration<String> getAttributeNames() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getCharacterEncoding() {
		// TODO Auto-generated method stub
		return null;
	}

	public int getContentLength() {
		// TODO Auto-generated method stub
		return 0;
	}

	public long getContentLengthLong() {
		// TODO Auto-generated method stub
		return 0;
	}

	public String getContentType() {
		// TODO Auto-generated method stub
		return null;
	}

	public DispatcherType getDispatcherType() {
		// TODO Auto-generated method stub
		return null;
	}

	public ServletInputStream getInputStream() throws IOException {
		// TODO Auto-generated method stub
		return null;
	}

	public String getLocalAddr() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getLocalName() {
		// TODO Auto-generated method stub
		return null;
	}

	public int getLocalPort() {
		// TODO Auto-generated method stub
		return 0;
	}

	public Locale getLocale() {
		// TODO Auto-generated method stub
		return null;
	}

	public Enumeration<Locale> getLocales() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getParameter(String arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	public Map<String, String[]> getParameterMap() {
		// TODO Auto-generated method stub
		return null;
	}

	public Enumeration<String> getParameterNames() {
		// TODO Auto-generated method stub
		return null;
	}

	public String[] getParameterValues(String arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	public String getProtocol() {
		// TODO Auto-generated method stub
		return null;
	}

	public BufferedReader getReader() throws IOException {
		// TODO Auto-generated method stub
		return null;
	}

	public String getRealPath(String arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	public String getRemoteAddr() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getRemoteHost() {
		// TODO Auto-generated method stub
		return null;
	}

	public int getRemotePort() {
		// TODO Auto-generated method stub
		return 0;
	}

	public RequestDispatcher getRequestDispatcher(String arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	public String getScheme() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getServerName() {
		// TODO Auto-generated method stub
		return null;
	}

	public int getServerPort() {
		// TODO Auto-generated method stub
		return 0;
	}

	public ServletContext getServletContext() {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean isAsyncStarted() {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean isAsyncSupported() {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean isSecure() {
		// TODO Auto-generated method stub
		return false;
	}

	public void removeAttribute(String arg0) {
		// TODO Auto-generated method stub
		
	}

	public void setAttribute(String arg0, Object arg1) {
		// TODO Auto-generated method stub
		
	}

	public void setCharacterEncoding(String arg0)
			throws UnsupportedEncodingException {
		// TODO Auto-generated method stub
		
	}

	public AsyncContext startAsync() throws IllegalStateException {
		// TODO Auto-generated method stub
		return null;
	}

	public AsyncContext startAsync(ServletRequest arg0, ServletResponse arg1)
			throws IllegalStateException {
		// TODO Auto-generated method stub
		return null;
	}
	
	
}
