package com.vainolo.phd.opp.editor;

public class OPPEditorPlugin {

  private OPPEditorPlugin() {
  };

  public static OPPEditorPlugin INSTANCE = new OPPEditorPlugin();

  public void log(String s) {
    System.out.println(s);
  }

  public void log(Exception exception) {
    System.out.println(exception.getLocalizedMessage());
  }
}
