package br.com.letscode.bejv003.desafios;

import java.util.Objects;

public class ItemLista implements Comparable{

    private Integer elementoLista;

    public ItemLista(Integer elementoLista) {
        this.elementoLista = elementoLista;
    }

    public Integer getElementoLista() {
        return this.elementoLista;
    }

    @Override
    public int compareTo(Object o) {
        ItemLista lista = (ItemLista) o;

        if (lista.getElementoLista() > this.elementoLista) {
            return 1;
        } else if (lista.getElementoLista() < this.elementoLista) {
            return -1;
        } else {
            return lista.getElementoLista().compareTo(this.elementoLista);
        }
        //return 0;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ItemLista lista = (ItemLista) o;
        return Objects.equals(this.elementoLista, lista.getElementoLista());
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.elementoLista);
    }

    @Override
    public String toString() {
        return Integer.toString(getElementoLista());
    }
}
