package com.vainolo.opm.editor;

public class OPMEditorPlugin {

  private OPMEditorPlugin() {
  };

  public static OPMEditorPlugin INSTANCE = new OPMEditorPlugin();

  public void log(String s) {
    System.out.println(s);
  }

  public void log(Exception exception) {
    System.out.println(exception.getLocalizedMessage());
  }
}