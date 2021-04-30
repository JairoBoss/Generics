/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package generics;

import javax.sound.midi.spi.MidiDeviceProvider;

/**
 *
 * @author megabit
 */
public class Lista<T> {
    private Nodo inicio;
    
    public Lista(){
        inicio = null;
    }
    
    public void insertar(T dato){
        Nodo<T> nuevo = new Nodo();
        nuevo.setDato(dato);
        nuevo.setSiguiente(null);
        
        if (inicio == null) {
            inicio = nuevo;
        }else{
            nuevo.setSiguiente(inicio);
            inicio = nuevo;
        }
    }
    
    public void mostrar(){
        Nodo<T> aux = inicio;
        while(aux != null){
            System.out.println(aux.getDato());
            aux = aux.getSiguiente();
        }
    }    
    
    public static void main(String[] args) {
        Lista<Integer> lista = new Lista<>();
        lista.insertar(1);
        lista.insertar(2);
        lista.insertar(3);
        lista.insertar(4);
        lista.insertar(5);
        
        lista.mostrar();        
        
        Lista<String> lista2 = new Lista<>();
        lista2.insertar("A");
        lista2.insertar("B");
        lista2.insertar("C");
        lista2.insertar("D");
        
        lista2.mostrar();
    }
}
