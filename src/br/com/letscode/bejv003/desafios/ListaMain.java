package br.com.letscode.bejv003.desafios;

import java.util.*;

public class ListaMain {

    public static void main(String[] args) {

        Collection lista1 = new ArrayList();
        lista1.add(new ItemLista(1));
        lista1.add(new ItemLista(2));
        lista1.add(new ItemLista(3));
        lista1.add(new ItemLista(4));

        System.out.println("==> LISTA 1  (" + lista1.size() + " elementos): " + lista1);

        Collection lista2 = new ArrayList();
        lista2.add(new ItemLista(2));
        lista2.add(new ItemLista(5));

        System.out.println("==> LISTA 2  (" + lista2.size() + " elementos): " + lista2);

        Collection mergedAndOrderedList = new HashSet();
        mergedAndOrderedList.addAll(lista1);
        mergedAndOrderedList.addAll(lista2);

        System.out.println("==> LISTA 3  (" + mergedAndOrderedList.size() + " elementos): " + mergedAndOrderedList);

        List listaFinal = Arrays.asList(mergedAndOrderedList.toArray());
        Collections.sort(listaFinal);
        System.out.println("==> LISTA 3- (" + listaFinal.size() + " elementos): " + listaFinal);


    }
}
