package com.example.prj2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Node implements Comparable<Node>{

    int freq=0;
    char ch;
    Node right=null,left=null;

    public Node(char ch,int freq , Node right, Node left) {
        this.freq = freq;
        this.ch = ch;
        this.right = right;
        this.left = left;
    }

    @Override
    public String toString() {
        return
                "freq=" + freq +
                ", ch=" + ch ;

    }

    @Override
    public int compareTo(Node node) {
        int freq_compare=Integer.compare(this.freq,node.freq);
        if(freq_compare!=0){
            return freq_compare;
        }
        return Integer.compare(this.ch,node.ch);
    }
}
