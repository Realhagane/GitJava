package ficheros;

import java.io.*;

public class ClaseAuxiliar extends ObjectOutputStream{
	
	public ClaseAuxiliar(FileOutputStream fos) throws IOException{
		super(fos);
	}
	
	public ClaseAuxiliar() throws SecurityException, IOException{
		
	}
	
	protected void writeStreamHeader() throws IOException{
		
	}


}
