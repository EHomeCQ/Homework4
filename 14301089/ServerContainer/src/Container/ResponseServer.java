package Container;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.Locale;

import javax.servlet.ServletOutputStream;
import javax.servlet.ServletResponse;

public class ResponseServer implements ServletResponse{

	private OutputStream out = null;
	
	public ResponseServer(OutputStream out){
		this.out = out;
	}
	
	public OutputStream getOutputStream1(){
		return this.out;
	}

	public void flushBuffer() throws IOException {
		// TODO Auto-generated method stub
		
	}

	public int getBufferSize() {
		// TODO Auto-generated method stub
		return 0;
	}

	public String getCharacterEncoding() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getContentType() {
		// TODO Auto-generated method stub
		return null;
	}

	public Locale getLocale() {
		// TODO Auto-generated method stub
		return null;
	}

	public ServletOutputStream getOutputStream() throws IOException {
		// TODO Auto-generated method stub
		return null;
	}

	public PrintWriter getWriter() throws IOException {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean isCommitted() {
		// TODO Auto-generated method stub
		return false;
	}

	public void reset() {
		// TODO Auto-generated method stub
		
	}

	public void resetBuffer() {
		// TODO Auto-generated method stub
		
	}

	public void setBufferSize(int arg0) {
		// TODO Auto-generated method stub
		
	}

	public void setCharacterEncoding(String arg0) {
		// TODO Auto-generated method stub
		
	}

	public void setContentLength(int arg0) {
		// TODO Auto-generated method stub
		
	}

	public void setContentLengthLong(long arg0) {
		// TODO Auto-generated method stub
		
	}

	public void setContentType(String arg0) {
		// TODO Auto-generated method stub
		
	}

	public void setLocale(Locale arg0) {
		// TODO Auto-generated method stub
		
	}
	
	

}
