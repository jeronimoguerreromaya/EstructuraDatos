package listas.ListaSimple;

public class ListaSimple {
    private Nodo cabeza;
    private int size;

    public ListaSimple() {
        this.cabeza = null;
        this.size = 0;
    }

    public void eliminarLista() {
        this.cabeza = null;
        this.size = 0;
    }

    public boolean estaVacia() {
        return this.cabeza == null;
    }

    public int getSize() {
        return this.size;
    }

    public void insertarAlFinal(int valor) {
        Nodo nuevoNodo = new Nodo(valor);
        if (this.estaVacia()) {
            this.cabeza = nuevoNodo;
        } else {
            Nodo actual = this.cabeza;
            while (actual.siguiente != null) {
                actual = actual.siguiente;
            }
            actual.siguiente = nuevoNodo;
        }
        this.size++;
    }

    public void insertarAlInicio(int valor) {
        Nodo nuevoNodo = new Nodo(valor);
        nuevoNodo.siguiente = this.cabeza;
        this.cabeza = nuevoNodo;
        this.size++;
    }

    public void insertarEnPosicion(int valor, int posicion) {
        if (posicion < 0 || posicion > this.size) {
            throw new IndexOutOfBoundsException("Posición inválida: " + posicion);
        }

        if (posicion == 0) {
            insertarAlInicio(valor);
            return;
        }

        Nodo nuevoNodo = new Nodo(valor);
        Nodo actual = this.cabeza;
        for (int i = 0; i < posicion - 1; i++) {
            actual = actual.siguiente;
        }

        nuevoNodo.siguiente = actual.siguiente;
        actual.siguiente = nuevoNodo;
        this.size++;
    }

    public int getValor(int posicion) {
        if (posicion < 0 || posicion >= this.size) {
            throw new IndexOutOfBoundsException("Posición inválida: " + posicion);
        }

        Nodo actual = this.cabeza;
        for (int i = 0; i < posicion; i++) {
            actual = actual.siguiente;
        }
        return actual.valor;
    }

    public boolean buscar(Object referencia){
        Nodo actual = this.cabeza;
        while (actual != null) {
            if (actual.valor == (int) referencia) {
                return true;
            }
            actual = actual.siguiente;
        }
        return false;
    }

    public int getPosicion(Object referencia) {
        Nodo actual = this.cabeza;
        int pos = 0;
        while (actual != null) {
            if (actual.valor == (int) referencia) {
                return pos;
            }
            actual = actual.siguiente;
            pos++;
        }
        return -1;
    }
     public void removerPorPosicion(int posicion){
        if (posicion < 0 || posicion >= this.size) {
            throw new IndexOutOfBoundsException("Posición inválida: " + posicion);
        }
        if(posicion == 0){
            this.cabeza= this.cabeza.siguiente;
        } else {
            Nodo actual = this.cabeza;
            for(int i=0; i<posicion-1; i++){
                actual = actual.siguiente;
            }
            actual.siguiente = actual.siguiente.siguiente;
        }
        this.size--;
     }

     public void imprimir (){
        Nodo actual = this.cabeza;
        while (actual != null) {
            System.out.print(actual.valor + " -> ");
            actual = actual.siguiente;
        }
        System.out.println("null");
     }

     public boolean buscarRecursivo(Object referencia){

        return buscarRecursivoAux(cabeza,referencia);

     }
     private boolean buscarRecursivoAux(Nodo nodo, Object referencia){
        if(nodo == null){
            return false;
        }
        if(nodo.valor == (int) referencia){
            return true;
        }
        return buscarRecursivoAux(nodo.siguiente,referencia);
     }

     public void insertarFinalRecusivo(int valor){
        insertarFinalRecusivoAux(cabeza,valor);
        size++;
     }
     private void insertarFinalRecusivoAux(Nodo nodo, int valor){
        if(nodo == null){
            cabeza = new Nodo(valor);
        }
        else if(nodo.siguiente == null){
            nodo.siguiente = new Nodo(valor);
        } else {
            insertarFinalRecusivoAux(nodo.siguiente,valor);
        }
    }

   public void removerEnPosicionRecursivo(int posicion){
        if(posicion <0 || posicion >= size){
            throw new IndexOutOfBoundsException("Posición inválida: " + posicion);
        }
       if (posicion == 0) {
           cabeza = cabeza.siguiente;
        } else {
           removerEnPosicionRecursivo(cabeza, posicion, 0);
       }
        size--;

    }
     private void removerEnPosicionRecursivo(Nodo nodo,int posicion, int i){
        if(i == posicion-1){
            nodo.siguiente = nodo.siguiente.siguiente;
        } else {
            removerEnPosicionRecursivo(nodo.siguiente,posicion,i+1);
        }
     }

    public void insertarEnPosicionRecursivo(int posicion, int valor) {
        if (posicion < 0 || posicion > size) {
            throw new IndexOutOfBoundsException("Posición inválida: " + posicion);
        }

        if (posicion == 0) {
            Nodo nuevo = new Nodo(valor);
            nuevo.siguiente = cabeza;
            cabeza = nuevo;
        } else {
            insertarEnPosicionRecursivoAux(cabeza, posicion, valor);
        }

        size++;
    }

    private void insertarEnPosicionRecursivoAux(Nodo nodo, int posicion, int valor) {
        if (posicion == 1) {
            Nodo nuevo = new Nodo(valor);
            nuevo.siguiente = nodo.siguiente;
            nodo.siguiente = nuevo;
        } else {
            insertarEnPosicionRecursivoAux(nodo.siguiente, posicion - 1, valor);
        }
    }


}
