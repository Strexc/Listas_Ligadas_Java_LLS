package MiNodo;

/**
 * @author iRoy
 */
 
public class Nodo {
    	
    	public int dato;
	    public String palabra;
	    public Nodo ap_sig;

	public Nodo(int dato,String palabra){
		this.dato=dato;
		this.palabra=palabra;
		ap_sig=null;
	}
}