package Iterator;

import java.util.List;
import java.util.ArrayList;

interface Iterador {
    void first();
    Object current();
    Object next();
    boolean hasNext();
}

class ListaNombres implements Agregado {
    private List<String> nombres = new ArrayList<>();
    private int contador = 0;

    public void llenarLista() {
        agregar("Laura");
        agregar("David");
        agregar("Kenia");
        agregar("Hector");
        agregar("Karen");
        agregar("Johann");
    }

    public void agregar(String nombre) {
        nombres.add(nombre);
        contador++;
    }

    public Iterador obtenerIterador() {
        return new IteradorNombres();
    }

    private class IteradorNombres implements Iterador {
        private int indice = 0;

        @Override
        public void first() {
            if (!nombres.isEmpty()) {
                System.out.println("Primer nombre de la colección: " + nombres.get(0) + "\n");
            }
        }

        @Override
        public Object current() {
            if (indice > 0) {
                return nombres.get(indice - 1);
            }
            return null;
        }

        @Override
        public Object next() {
            if (this.hasNext()) {
                return nombres.get(indice++);
            }
            return null;
        }

        @Override
        public boolean hasNext() {
            return indice < contador;
        }
    }
}

interface Agregado {
    Iterador obtenerIterador();
}

public class Iterator2 {
    public static void main(String[] args) {
        ListaNombres lista = new ListaNombres();
        lista.llenarLista();

        Iterador iterador = lista.obtenerIterador();

        iterador.first();

        System.out.println("Comenzando Iterator \n");

        while (iterador.hasNext()) {
            Object nombre = iterador.next();
            System.out.println("Nombre siguiente: " + nombre);
            System.out.println("Recorriendo Iterator ");
            System.out.println("Nombre actual: " + iterador.current());
            System.out.println("Procesando nombre... Listo!!!\n ");

            if (!iterador.hasNext()) {
                System.out.println("Ya recorriste toda la lista, no quedan nombres en la colección. ");
            }
        }
    }
}
