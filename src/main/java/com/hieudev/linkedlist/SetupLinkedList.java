package com.hieudev.linkedlist;

import com.hieudev.linkedlist.define.Node;

public class SetupLinkedList {
    public static void main(String[] args) {
        Node n1 = new Node(1); // next=null

    }

    public static void printLinkedList(Node head) {
        if (head == null) {
            System.out.println("linked list is null!");
        }

        Node temp = head;
        while (temp != null) {
            // process node
            System.out.print(temp.getVal() + "->");

            temp = temp.getNext();
        }
    }

    public static Node addToHead(Node curHead, int value) {
        Node newNode = new Node(value);
        if (curHead!=null) {
            newNode.setNext(curHead);
        }

        return newNode;
    }

    public static Node addToTail(Node head, int value) {
        Node newNode = new Node(value);

        if (head == null) {
            return newNode;
        } else {
            // duyet den cuoi
            Node lastNode = head;
            while (lastNode.getNext()!=null) {
                lastNode = lastNode.getNext();
            }
            lastNode.setNext(newNode);
            return head;
        }
    }

}

