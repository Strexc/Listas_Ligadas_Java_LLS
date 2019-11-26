package MiNodo;

import java.util.Scanner;

/**
 *
 * @author iRoy
 */
public class TestNodo {
    public static void main(String[] args){
    Scanner p = new Scanner(System.in);
    int d1=0,d2=0;
    String d3="";
    NodoM list = new NodoM();
    
    list.insertar_LLS_vacia(3, "Perro");
    list.insertar_principio(1, "palabra");
    list.insertar_final(2, "oso");
    do{
           System.out.println("1.- Insertar dato");
           System.out.println("2.- Eliminar por numero");
           System.out.println("3.- Eliminar por palabra");
           System.out.println("4.- Imprimir LLS");
           System.out.println("5.- Ordenar menor a mayor");
           System.out.println("7.- Detener");
           System.out.println("Elige la opcion");
           d1 = p.nextInt();
           if(d1>0 && d1<6)
           {
               if(d1==1)
               {
                   System.out.println("Dame un numero");
                   d2 = p.nextInt();
                   System.out.println("Dame un palabra");
                   d3 = p.next();
                   list.imprimir();
                   list.inserta_LLS_enmedio(d2, d3);
                   System.out.println("");
               }
               if(d1==2)
               {
                   list.imprimir();
                   list.eliminar_dato();
                   list.imprimir();
                   System.out.println("");
               }
               if(d1==3){
                   list.imprimir();
                   list.eliminar_palabra();
                   list.imprimir();
                   System.out.println("");
               }
               if(d1==4){
                   list.imprimir();
                   System.out.println("");
               }
               if(d1==5)
               {
                   list.ordenar_lls();
               }
           }
           else
           {
               System.out.println("Opcion invalidad");
           }
    }while(d1 != 7);
    
    }
}