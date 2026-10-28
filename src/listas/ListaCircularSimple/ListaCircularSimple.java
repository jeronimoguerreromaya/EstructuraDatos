package listas.ListaCircularSimple;

public class ListaCircularSimple {

    private Nodo cabeza;
    private Nodo cola;
    private int size;

    public ListaCircularSimple() {
        this.cabeza = null;
        this.cola = null;
        this.size = 0;
    }

    public void eliminarLista() {
        this.cabeza = null;
        this.cola = null;
        this.size = 0;
    }

    public boolean estaVacia() {
        return this.cabeza == null;
    }

    public int getSize() {
        return this.size;
    }

    public void insertarFinal(int valor) {
        Nodo nuevoNodo = new Nodo(valor);
        if (this.estaVacia()) {
            this.cabeza = nuevoNodo;
            this.cola = nuevoNodo;
            nuevoNodo.siguiente = this.cabeza;
        } else {
            this.cola.siguiente = nuevoNodo;
            nuevoNodo.siguiente = this.cabeza;
            this.cola = nuevoNodo;

        }
        this.size++;
    }
    public void insertarInicio(int valor){
        Nodo nuevoNodo = new Nodo (valor);
        if(this.estaVacia()){
            this.cabeza = nuevoNodo;
            this.cola = nuevoNodo;
            nuevoNodo.siguiente = this.cabeza;
        }else{
            nuevoNodo.siguiente = this.cabeza;
            this.cola.siguiente = nuevoNodo;
            this.cabeza = nuevoNodo;
        }
        size++;
    }

    public void insertarEnPosicion(int posicion, int valor){
        if(posicion < 0 || posicion > this.size){
            throw new IndexOutOfBoundsException("Posición inválida: " + posicion);
        }
        if(posicion == 0){
            insertarInicio(valor);
            return;
        }
        if(posicion == this.size) {
            insertarFinal(valor);
            return;
        }

        Nodo nuevoNodo = new Nodo(valor);
        Nodo actual = this.cabeza;
        for(int i = 0; i < posicion - 1; i++){
            actual = actual.siguiente;
        }
        nuevoNodo.siguiente = actual.siguiente;
        actual.siguiente = nuevoNodo;
        size++;
    }

    public Object getValor(int posicion){
        if(posicion < 0 || posicion >= this.size){
            throw new IndexOutOfBoundsException("Posición inválida: " + posicion);
        }
        Nodo actual = this.cabeza;
        for(int i = 0; i < posicion; i++){
            actual = actual.siguiente;
        }
        return actual.valor;
    }
    public boolean buscar(int referencia) {
        if (estaVacia()) return false;

        Nodo actual = cabeza;
        do {
            if (actual.valor == (int) referencia) return true;
            actual = actual.siguiente;
        } while (actual != cabeza);
        return false;
    }

    public int getPosicion(Object referencia){
        if(estaVacia()) return -1;

        Nodo actual = cabeza;

        int pos = 0;
        do {
            if (actual.valor == (int) referencia) return pos;
            actual = actual.siguiente;
            pos++;
        } while (actual != cabeza);

        return -1;
    }

    public void removerPorPosicion(int posicion){
        if(posicion < 0 || posicion >= this.size){
            throw new IndexOutOfBoundsException("Posición inválida: " + posicion);
        }
        if(posicion == 0){
            if(cola == cabeza){
                cabeza = null;
                cola = null;
            }else {
                this.cabeza = this.cabeza.siguiente;
                this.cola.siguiente = this.cabeza;
            }
            this.size--;
            return;
        }

        Nodo actual = this.cabeza;
        for(int i = 0; i < posicion - 1; i++){
            actual = actual.siguiente;
        }
        actual.siguiente = actual.siguiente.siguiente;
        if(posicion == this.size - 1){

            this.cola = actual;
        }
        this.size--;
    }

    public void imprimir (){
        if(estaVacia()) return;

        Nodo actual = cabeza;
        do {
            System.out.print(actual.valor + " ");
            actual = actual.siguiente;
        } while (actual != cabeza);
        System.out.println();
    }

    public void insertarFinalRecursivo(int valor){
        if(estaVacia()){
            cabeza = new Nodo(valor);
            cola = cabeza;
            cabeza.siguiente = cabeza;
        }else{
            insertarFinalRecursivoHelper(cabeza, valor);
        }
        size++;
    }

    private void insertarFinalRecursivoHelper(Nodo actual, int valor){
        if(actual.siguiente == cabeza){
            Nodo nuevo = new Nodo(valor);
            actual.siguiente = nuevo;
            nuevo.siguiente = cabeza;
            cola = nuevo;
            return;
        }
        insertarFinalRecursivoHelper(actual.siguiente, valor);
    }

    public void insertarEnPosicionRecursivo(int posicion, int valor){
        if(posicion < 0 || posicion > size){
            throw new IndexOutOfBoundsException("Posición inválida: " + posicion);
        }
        .
        if(posicion == 0){
            insertarInicio(valor);
            return;
        }
        if(posicion == size){
            insertarFinal(valor);
            return;
        }
        insertarEnPosicionRecursivoHelper(cabeza, posicion - 1, 0, valor);
        size++;
    }

    private void insertarEnPosicionRecursivoHelper(Nodo actual, int indiceAnterior,
                                                   int indiceActual, int valor){
        if(indiceActual == indiceAnterior){
            Nodo nuevo = new Nodo(valor);
            nuevo.siguiente = actual.siguiente;
            actual.siguiente = nuevo;
            return;
        }
        insertarEnPosicionRecursivoHelper(actual.siguiente, indiceAnterior,
                                          indiceActual + 1, valor);
    }

    public boolean buscarRecursivo(Object referencia){
        if(estaVacia()) return false;
        return buscarRecursivoHelper(cabeza, referencia);
    }

    private boolean buscarRecursivoHelper(Nodo actual, Object referencia) {

        if(actual.valor == (int) referencia) return true;

        if(actual.siguiente == cabeza) return false;

        return buscarRecursivoHelper(actual.siguiente, referencia);


    }



}
