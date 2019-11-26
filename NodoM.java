package MiNodo;

import java.util.Scanner;

/**
 * @author iRoy
 */
public class NodoM {
    Scanner teclado = new Scanner(System.in);
    Nodo nodo_inicial;
    
    public NodoM(){
		nodo_inicial=null;
    }
    
    public void insertar_LLS_vacia(int dato,String palabra){
        
        if(nodo_inicial != null)
        {
            System.out.println("Error : LLS ya tiene datos");
        }
        else{
            Nodo nuevo = new Nodo(dato,palabra);
            nodo_inicial = nuevo;
        }
        
    }
    
    public void insertar_principio(int dato,String palabra)
    {
        if(nodo_inicial == null)
        {
            System.out.println("Error: LLS Vacia");
        }
        else{
            Nodo nuevo = new Nodo(dato,palabra);
            nuevo.ap_sig = nodo_inicial;//aqui el aputandor a sig de nuevo apunta a nodo inicial
            nodo_inicial = nuevo;//aqui el nodo incial ahora es nuevo
        }
    }
    
    public void insertar_final(int dato, String palabra)
    {
        if(nodo_inicial == null)
        {
            System.out.println("Error: LLS Vacia");
        }
        else{
            Nodo aux = nodo_inicial;
            Nodo nuevo = new Nodo(dato,palabra);
            while(aux.ap_sig !=null)
            {
                aux=aux.ap_sig;
                               
            }
            aux.ap_sig = nuevo;
        }
    }
    
    
    public void imprimir(){
        if(nodo_inicial!=null)
        {
            Nodo aux=nodo_inicial;
            while(aux.ap_sig!=null)
            {
                System.out.print("["+aux.dato+"-"+aux.palabra+"]->");
        	aux=aux.ap_sig;
	    }
            System.out.println("["+aux.dato+"-"+aux.palabra+"]->"+aux.ap_sig);
        }else
        {
            System.out.println("ERROR: LLS vacia");
	}
    }
    
    public Integer buscar(int dato)
    {
        int don;
        don = 0;
        if(nodo_inicial == null)
        {
            System.out.println("ERROR: LLS vacia");
            return null;
        }
        else{
            Nodo aux = nodo_inicial;
            while(aux.ap_sig != null)
            {
                if(aux.dato == dato){
                    don = 1;
                }
                aux = aux.ap_sig;
                if(aux.dato == dato){
                    don = 1;
                }
            }
            if(don == 1)
            {
                return don;
            }
            else{
                return null;
            }
        }
    }
    
    
    public Integer buscar(String palabra)
    {
        Integer b = 0;
        if(nodo_inicial == null)
        {
            System.out.println("ERROR: LLS vacia");
            return null;
        }
        else{
            Nodo aux = nodo_inicial;
            while(aux.ap_sig != null)
            {
                if(aux.palabra.equals(palabra) == true)
                {
                    b = 1;
                }
                aux = aux.ap_sig;
                
                if(aux.palabra.equals(palabra) == true)
                {
                    b = 1;
                }
            }
            if(b == 1)
            {
                return b;
            }
            else 
            {
                return null;
            }
        }
    }
    
    public void eliminar_inicio(){
        if(nodo_inicial == null)
        {
            System.out.println("ERROR: LLS vacia");
        }
        else{
            //Nodo aux = nodo_inicial;
            nodo_inicial = nodo_inicial.ap_sig;
            //aux.ap_sig = null;
        }
    }
    
    public void eliminar_final()
    {
        if(nodo_inicial == null)
        {
            System.out.println("ERROR: LLS vacia");
        }
        else{
            Nodo aux = nodo_inicial;//esta en el principio [1|]->ap_sig
            Nodo aux2 = aux.ap_sig;//esta uno despues del principio  [2|]->ap_sig
            while(aux2.ap_sig!=null)
            {
                aux2=aux2.ap_sig;//se avanza uno
                aux = aux.ap_sig;//se avanza uno
            }
            aux.ap_sig = null;
        }
    }
    
    public void inserta_LLS_enmedio(int dato,String palabra)
    {
        int d1 = 0;
        if(nodo_inicial == null ){
            System.out.println("ERROR: LLS vacia");
        }
        else{
            System.out.println("Inserta despues de que dato quieres que se ingrese");
            System.out.println("Dato: ");
            d1=teclado.nextInt();
            if(buscar(d1) == null)
            {
                System.out.println("Dato no encontrado");
            }
            else
            {
                Nodo aux2 = nodo_inicial;
                Nodo nuevo = new Nodo(dato,palabra);
                while(aux2.dato != d1) // mientras el dato sea diferente de dato insertado seguir
                {
                    aux2 = aux2.ap_sig;//avanza uno
                }
                nuevo.ap_sig = aux2.ap_sig;// nuevo se le asigna el ap_sig de aux 
                aux2.ap_sig = nuevo; // aux2 asu ap_sig se le asinga nuevo
            }
        }
    }
    
    public void eliminar_dato()
    {
        int d1 = 0;
        boolean b =false;
        if(nodo_inicial == null)
        {
            System.out.println("ERROR: LLS vacia");
        }
        else{
            System.out.println("Eliminar: que dato quieres eliminar?");
            System.out.println("Dato: ");
            d1=teclado.nextInt();
            if(buscar(d1)==null)
            {
                System.out.println("Dato no encontrado");
            }
            else{  
                Nodo aux = null;
                Nodo aux2 = nodo_inicial;
                Nodo aux3 = aux2.ap_sig;
               
                if(aux2.dato == d1)
                {
                    eliminar_inicio();
                }
                else{
                    while(aux2.dato != d1 && b!= true)
                    {
                        aux = aux2;
                        aux2 = aux2.ap_sig;
                        aux3 = aux2.ap_sig;
                        if(aux2.ap_sig==null)
                        {
                            eliminar_final();
                            b = true;
                            
                        }
                    }
                    /*System.out.println("aux: "+aux.dato);
                    System.out.println("aux2: "+aux2.dato);
                    System.out.println("aux3: "+aux3.dato);*/
                    if(b==false){
                    aux.ap_sig = aux3;
                    aux2.ap_sig = null;}
                } 
            }
        }    
    }
    
    public void eliminar_palabra(){
        String d2="";
        boolean b= false;
        if(nodo_inicial == null)
        {
            System.out.println("ERROR: LLS vacia");
        }
        else{
            int d1 = 0;
            System.out.println("Eliminar: que palabra quieres eliminar?");
            System.out.println("Dato: ");
            d2=teclado.next();
            if(buscar(d2) == null)
            {
                System.out.println("Dato no encontrado");
            }
            else{
                    Nodo aux = null;
                    Nodo aux2 = nodo_inicial;
                    Nodo aux3 = aux2.ap_sig;
                    if(aux2.palabra.equals(d2)==true)
                    {
                        eliminar_inicio();
                    }
                    else
                    {
                        while(aux2.palabra.equals(d2) != true && b != true)
                        {
                            aux = aux2;
                            aux2 = aux2.ap_sig;
                            aux3 = aux2.ap_sig;
                            if(aux2.ap_sig==null)
                            {
                                eliminar_final();
                                b = true;
                            }
                        }
                        /*System.out.println("aux: "+aux.palabra);
                        System.out.println("aux2: "+aux2.palabra);
                        System.out.println("aux3: "+aux3.palabra);*/
                    if(b==false)
                    {
                    aux.ap_sig = aux3;
                    aux2.ap_sig = null;
                    }    
                }   
            }
        }
    }
    
    public void ordenar_lls()
    {
        if(nodo_inicial==null)
        {
            System.out.println("ERROR: LLS vacia");
        }
        else
        {  
            int t=1,c=1;
            Nodo act = nodo_inicial;

            while(act.ap_sig !=null)
            {
                act = act.ap_sig;
                c++;
            }
            int tem=0;
            String tem1 ="";
            
            do{
                //System.out.println("t: "+t);
                act = nodo_inicial;
                Nodo sig = act.ap_sig;
                while(act.ap_sig != null)
                {
                    if(act.dato > sig.dato)
                    {
                        tem = act.dato;
                        tem1 = act.palabra;
                        act.dato = sig.dato;
                        act.palabra = sig.palabra;
                        sig.dato = tem;
                        sig.palabra = tem1;
                        //imprimir();
                        act = act.ap_sig;
                        sig = sig.ap_sig;
                    }
                    else
                    {
                        //[1] [3] [2]
                        //    act sig 
                        act = act.ap_sig;
                        sig = sig.ap_sig;
                        //imprimir();
                    }
                }
                t++;
                
            }while(t<=c);
        }
    }
}
