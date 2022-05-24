package com.example.prj2;

import java.io.*;
import java.util.PriorityQueue;
import java.util.Scanner;


public class Calc {


    static int size = 256;
    static int arr[] = new int[size];
    static String code[] = new String[size];
    static String instr="";
    static  String strco="";
    static String strbath="";
    static  String strf="";
    static  String decode = "";

    static  PriorityQueue<Node> pq = new PriorityQueue<Node>();

      public void Scan(String text) throws FileNotFoundException {

            int spp = text.lastIndexOf(".");
            strbath = text.substring(spp+1);

            File file = new File(text);
            Scanner scan = new Scanner(file);
            int s=2;
            char ss=(char) s;
            while (scan.hasNextLine()) {

                StringBuilder p = new StringBuilder();
                p.append(scan.nextLine());
                instr += p.toString() + (char)ss;

            }
            instr = instr.substring(0,instr.length());
          System.out.println(instr);
        }

      public void fun(){
          int ans;
          char ch;

          for (int i=0;i<instr.length();i++){
              ch = instr.charAt(i);
              ans =(int)ch;
              arr[ans]++;
          }


          for (int i=0;i<size;i++){

              if (arr[i] != 0){

                  Node n = new Node((char)i,arr[i],null,null);

                  pq.add(n);

              }
          }


          int fi = pq.size();
          Node ji = null;
          for (int i=0;i<fi-1;i++){

              Node z = new Node('\n',0,null,null),x,y;

              x = (Node) pq.remove();
              y= (Node) pq.remove();

              z.freq = x.freq + y.freq;
              z.right = x;
              z.left = y;
              pq.add(z);

              ji=z;
          }

          GetCode(ji,"");
      }

      public String code(){

          char cha;

            for (int i=0;i<instr.length();i++){
             cha = instr.charAt(i);
             strf += code[(int) cha];
            }

          String ans=strco+strf;
          System.out.println(ans);
          String FinalAns = strbath + ":";
          int modesys = 0;

              modesys = 8 - ans.length()%8;
              int sys = ans.length();
          int c=1;
        if (ans.length()/8 != 8){
            sys = (ans.length()+modesys);
            for (int i=0;i<modesys;i++){
                ans += "0";
                c++;
            }
        }

          FinalAns += c-1;


          int x=8;
          for (int i=0;i<sys-1;i+=x){

              int sul =Integer.parseInt(ans.substring(i,i+x),2);
              FinalAns += (char)sul;
          }

          System.out.println(FinalAns);
            return FinalAns;

      }

      public  void GetCode(Node root, String s) {

            if (root != null) {
                if (root.left == null && root.right == null ) {

                    int count = (int)(root.ch);
                    code[count] = s;
                    strco+= "1"+ String.format("%8s", Integer.toBinaryString(root.ch)).replaceAll(" ", "0");
                    return;
                }
                else {
                    strco += "0";
                    }
                }

                GetCode(root.left, s + "0");
                GetCode(root.right, s + "1");
            }

      public void PrintCode(String bath) throws IOException {

          BufferedWriter bb = new BufferedWriter(new FileWriter(bath));

          bb.write(code());
          bb.close();
      }

      public void DeCode (String bath) throws FileNotFoundException {

          File file = new File(bath);
          Scanner scan = new Scanner(file);
            String yy="";
          while (scan.hasNextLine()) {

              StringBuilder p = new StringBuilder();
              p.append(scan.nextLine());
              yy += p.toString() ;

          }
          int space = yy.indexOf(":");
          strbath = yy.substring(0,space);
          yy = yy.substring(space+1);
          int rim = Integer.parseInt(yy.substring(0,1));
          yy = yy.substring(1);
          System.out.println(yy.length());

          for (int i=0;i<yy.length();i++){

              String resultBin = String.format("%08d",Integer.parseInt(Integer.toBinaryString(yy.charAt(i))));

             decode += resultBin+"";
          }

          int fl = decode.length()-rim;
          decode = decode.substring(0,fl);
          System.out.println(decode);


      }

    static int counter=0;
      public Node de (){

                int x = Integer.parseInt(String.valueOf(decode.charAt(counter)));
              if (x == 0){
                  counter++;
                  return new Node('\n',0,de(),de());
              }
              else {
                  String st = decode.substring(counter + 1,counter+9);
                  counter+=9;
                  return new Node((char) Integer.parseInt(st,2),0,null,null);
              }
      }
       // Node ro = de();

    static String dearr[] = new String[size];

    static int i=0;
      public void GetDecode(Node root,String s){

          if (root != null) {
              if (root.left == null && root.right == null ) {

                  dearr[i]=root.ch+s;
                    i++;
                  return;
              }

          }

          GetDecode(root.left, s + "1");
          GetDecode(root.right, s + "0");
      }

    static String FinalString="";
      public String fend(){

          int rr = counter;
          int flag = 0;
          int stop=rr + 1;

                 String xo ="";
                 while (stop <= decode.length()) {
                     xo = decode.substring(rr, stop);

                     for (int y = 0; dearr[y] != null; y++) {
                         if (xo.equals(dearr[y].substring(1))) {
                             String cs=dearr[y].substring(0, 1);
                             char cha = cs.charAt(0);
                             if (cha == (char)2){
                                 FinalString += "\n";
                             }
                             else{
                                 FinalString += dearr[y].substring(0, 1);
                             }


                             flag = 1;
                         }
                     }
                     if (flag == 1) {
                         rr = stop;
                     }
                     stop++;
                     flag=0;
                 }
                 return FinalString;
      }

      public void PrintDecode(String bath) throws IOException {

          BufferedWriter bb = new BufferedWriter(new FileWriter(bath));

          bb.write(fend());
          bb.close();



      }


    }


