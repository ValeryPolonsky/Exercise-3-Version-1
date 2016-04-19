package io;

import java.io.IOException;
import java.io.OutputStream;

public class MyCopressorOutputStream extends OutputStream {

	private OutputStream out;
	
	MyCopressorOutputStream()
	{
		out=null;
	}
	@Override
	public void write(int arg0) throws IOException {
		System.out.println(out);
		
	}

}
