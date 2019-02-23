package App;

import List.Listas;
import Node.Node;

public class Ejer<T extends Comparable<T>> {

    private int CN = 0;
    private long S = 0;
    private T MXF = null;

public boolean E2(Listas<T> list1, Listas<T> list2) {
        if (list1.getLength() != list2.getLength()) {
            return false;
        } else {
            if (list1.getElementAt(0) != null) {
                if (Comp(list1.getElementAt(0), list2.getElementAt(0))) {
                    return true;
                } else {
                    return false;
                }
            } else {
                return true;
            }
        }
    }

    private boolean Comp(Node<T> n1, Node<T> n2) {
        if (n1.getNext() == null && n2.getNext() == null) {
            return true;
        } else {
            if (n1.getValue().equals(n2.getValue()))
                return Comp(n1.getNext(), n2.getNext());
            else {
                return false;
            }
        }
    }

    public int E3(T value, Listas<T> list) {
        CN = 0;
        if (ExisteElemento(value, list.getElementAt(0)))
            return CN;
        else {
            return CN - 1;
        }
    }

    private boolean ExisteElemento(T value, Node<T> node) {
        if (node.getNext() == null) {
            if(node.getValue().equals(value)) CN++;
            return false;
        } else {
            if (value.equals(node.getValue())) {
                return true;
            } else {
                CN++;
                return ExisteElemento(value, node.getNext());
            }
        }
    }

    public int E4(T value, Listas<T> list) {
        CN = 0;
        if (list.getElementAt(0) != null)
            Ocurrencia(value, list.getElementAt(0));
        return CN;
    }

    private boolean Ocurrencia(T value, Node<T> node) {
        if (node.getNext() == null) {
            if (node.getValue().equals(value))
                CN++;
            return true;
        } else {
            if (value.equals(node.getValue())) {
                CN++;
                return Ocurrencia(value, node.getNext());
            } else {
                return Ocurrencia(value, node.getNext());
            }
        }
    }

    public long E5(Listas<Integer> list) {
        S = 0;
        if (list.getElementAt(0) != null)
            Plus(list.getElementAt(0));
        return S;
    }

    private boolean Plus(Node<Integer> node) {
        if (node.getNext() == null) {
            S = S + node.getValue();
            return true;
        } else {
            S = S + node.getValue();
            return Plus(node.getNext());
        }
    }

    public T E1(Listas<T> list){
        MXF = list.getElementAt(0).getValue();
        Maximo(list.getElementAt(0));
        return MXF;
    }

    private T Maximo(Node<T> node){
        if(node.getNext() == null){
            if(node.getValue().compareTo(MXF) > 0) MXF = node.getValue();
            return MXF;
        } else {
            if(node.getValue().compareTo(MXF) > 0){
                MXF = node.getValue();
                return Maximo(node.getNext());
            } else {
                return Maximo(node.getNext());
            }
        }
    }


}
