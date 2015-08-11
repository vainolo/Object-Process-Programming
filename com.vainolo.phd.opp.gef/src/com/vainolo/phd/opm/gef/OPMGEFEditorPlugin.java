package com.vainolo.phd.opm.gef;

public class OPMGEFEditorPlugin {

  private OPMGEFEditorPlugin() {
  };

  public static OPMGEFEditorPlugin INSTANCE = new OPMGEFEditorPlugin();

  public void log(String s) {
    System.out.println(s);
  }

  public void log(Exception exception) {
    System.out.println(exception.getLocalizedMessage());
  }
}
