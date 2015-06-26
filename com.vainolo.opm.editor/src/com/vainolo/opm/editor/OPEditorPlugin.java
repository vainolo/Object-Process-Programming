package com.vainolo.opm.editor;

public class OPEditorPlugin {

  private OPEditorPlugin() {
  };

  public static OPEditorPlugin INSTANCE = new OPEditorPlugin();

  public void log(String s) {
    System.out.println(s);
  }

  public void log(Exception exception) {
    System.out.println(exception.getLocalizedMessage());
  }
}