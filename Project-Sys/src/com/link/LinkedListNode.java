package com.link;
public class LinkedListNode<T>{

        private T data;

        private LinkedListNode next;

        public LinkedListNode(T data){
            this.data = data;
        }

        public void setData(T data){
            this.data = data;
        }

        public T getData(){
            return this.data;
        }

        public void setNext(LinkedListNode next){
            this.next = next;
        }

        public LinkedListNode getNext(){
            return this.next;
        }
}