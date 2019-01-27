package com.jdavidagudelo.text_editor;

import javax.swing.plaf.synth.SynthTextAreaUI;
import javax.xml.soap.Text;
import java.util.Stack;

public class TextEditor {
    private Stack<String> stack = new Stack<>();
    private String sb = "";

    public void printData(String command){
        String[] split = command.split(" ");
            int operation = Integer.parseInt(split[0]);
            if(operation == 1){
                stack.push(sb);
                sb += split[1];
            }
            else if(operation == 2){
                stack.push(sb);
                int k = Integer.parseInt(split[1]);
                sb = sb.substring(0, sb.length() - k);
            }
            else if(operation == 3){
                int k = Integer.parseInt(split[1]);
                System.out.println(sb.substring(k-1, k));
            }
            else{
                sb = stack.pop();
            }

    }

    public static void main(String[] args){
        TextEditor obj = new TextEditor();
        String[] commands = new String[]{
                "1 abc",
                "3 3",
                "2 3",
                "1 xy",
                "3 2",
                "4",
                "4",
                "3 1"
        };
    }

}
