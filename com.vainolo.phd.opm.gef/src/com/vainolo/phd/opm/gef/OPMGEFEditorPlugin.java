package com.vainolo.phd.opm.gef;

import com.vainolo.phd.opm.gef.editor.factory.OPMIdManager;

public class OPMGEFEditorPlugin {

  private OPMIdManager idManager;

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
