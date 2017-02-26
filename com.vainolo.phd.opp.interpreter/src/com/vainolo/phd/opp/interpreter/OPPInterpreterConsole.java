package com.vainolo.phd.opp.interpreter;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.Reader;
import java.nio.CharBuffer;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.text.BadLocationException;

import bsh.util.GUIConsoleInterface;
import bsh.util.JConsole;

public class OPPInterpreterConsole {

  public JTextArea textArea;

  public OPPInterpreterConsole() {
  }

  public void show() throws BadLocationException {
    JFrame frame = new JFrame("OPP Console");
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    textArea = new JTextArea();
    textArea.setFont(new Font("Arial", Font.PLAIN, 20));
    textArea.insert(">", 0);
    textArea.setCaretPosition(1);
    textArea.getDocument().addDocumentListener(new DocumentListener() {
      @Override
      public void removeUpdate(DocumentEvent e) {
        System.out.println("remove" + e.getLength());
      }

      @Override
      public void insertUpdate(DocumentEvent e) {
        System.out.println("update" + e.getLength());
      }

      @Override
      public void changedUpdate(DocumentEvent e) {
        System.out.println("changed" + e.getLength());
      }
    });
    JScrollPane jScrollPane = new JScrollPane(textArea);
    jScrollPane.setPreferredSize(new Dimension(800, 600));
    frame.getContentPane().add(jScrollPane, BorderLayout.CENTER);
    frame.pack();
    frame.setVisible(true);
  }

  public static void main(String args[]) throws Exception {

    JFrame frame = new JFrame("JConsole example");

    JConsole console = new JConsole();

    frame.getContentPane().add(console);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setSize(600, 400);
    frame.setVisible(true);
    inputLoop(console, "JCE (type 'quit' to exit): ");

    // OPPInterpreterConsole console = new OPPInterpreterConsole();
    // console.show();
    System.in.read();
  }

  public static void inputLoop(GUIConsoleInterface console, String prompt) throws Exception {
    Reader input = console.getIn();
    BufferedReader bufInput = new BufferedReader(input);

    String newline = System.getProperty("line.separator");

    console.print(prompt, Color.BLUE);

    String line;
    try {
      boolean reading = true;
      while (reading) {
        if (bufInput.ready()) {
          CharBuffer buf = CharBuffer.allocate(100);
          bufInput.read(buf);
          System.out.println("Read :" + buf.charAt(0));
        }
        Thread.sleep(100);
      }
    } catch (Exception e) {

    }

    // try {
    // while ((line = bufInput.readLine()) != null) {
    // console.print("You typed: " + line + newline, Color.ORANGE);
    // if (line.equals("quit"))
    // break;
    // console.print(prompt, Color.BLUE);
    // }
    // bufInput.close();
    // } catch (IOException e) {
    // e.printStackTrace();
    // }

  }
}
