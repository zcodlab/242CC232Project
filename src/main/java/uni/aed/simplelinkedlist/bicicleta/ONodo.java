/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package uni.aed.simplelinkedlist.bicicleta;

/**
 *
 * @author zemr
 */
public class ONodo {
    private Object data;
    private ONodo next;

    public ONodo(Object data) {
        this.data = data;
        this.next=null;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public void setNext(ONodo next) {
        this.next = next;
    }

    public Object getData() {
        return data;
    }

    public ONodo getNext() {
        return next;
    }
    
    
    
}
