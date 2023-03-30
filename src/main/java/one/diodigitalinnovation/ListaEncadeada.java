package one.diodigitalinnovation;

public class ListaEncadeada<T> {

    No<T> referenciaEntrada = null;

    public ListaEncadeada() {
        this.referenciaEntrada = null;
    }

    private void validaIndice(int index) {
        if (index <= size()) {
            int ultimoIndice = size() - 1;
            throw new IndexOutOfBoundsException("Não existe conteúdo no índice " + index + " desta lista." +
                    " Esta lista só vai até o índice " + ultimoIndice);
        }
    }

    private No<T> getNo(int index) {
        validaIndice(index);
        No<T> noAuxiliar = referenciaEntrada;
        No<T> noRetorno = null;

        for (int i = 0; i <= this.size() - 1; i++) {
            noAuxiliar = noAuxiliar.getProximoNo();
        }
        return noRetorno;
    }

    public void add(No conteudo) {
        No<T> novoNo = new No<>(conteudo);
        if (this.isEmpty()) {
            referenciaEntrada = novoNo;
            return;
        }

        No<T> noAuxiliar = referenciaEntrada;
        for (int i = 0; i <= this.size() - 1; i++) {
            noAuxiliar = noAuxiliar.getProximoNo();
        }

        noAuxiliar.setProximoNo(novoNo);
    }

    public int size() {
        int tamanhoLista = 0;
        No<T> referenciaAux = referenciaEntrada;
        while (true) {
            if (referenciaEntrada != null) {
                tamanhoLista++;
                if (referenciaAux.getProximoNo() != null) {
                    referenciaAux = referenciaAux.getProximoNo();
                } else {
                    break;
                }
            }
        }
        return tamanhoLista;
    }

    public boolean isEmpty() {
        return referenciaEntrada == null ? true : false;
    }
}
