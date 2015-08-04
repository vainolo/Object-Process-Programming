package com.vainolo.opm.model.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.vainolo.opm.model.OPNode;
import com.vainolo.opm.model.OPLink;
import com.vainolo.opm.model.OPModelObserver;
import com.vainolo.opm.model.OPContainer;
import com.vainolo.opm.model.view.OPNodeView;

public abstract class OPAbstractNodeImpl extends OPAbstractElementImpl implements OPNode {

  private String name = "";
  private List<OPLink> links = new ArrayList<OPLink>();
  private OPNodeView view;
  private OPContainer container;
	
  public OPAbstractNodeImpl(int id) {
    super(id);
   }


  @Override
  public String getName() {
    return name;
  }

  @Override
  public void setName(String name) {
    this.name = name;
    notifyObservers();
  }

  @Override
  public List<OPLink> getLinks() {
    return Collections.unmodifiableList(links);
  }

  @Override
  public void addLink(OPLink link) {
    links.add(link);
    notifyObservers();

  }

  @Override
  public void removeLink(OPLink link) {
    links.remove(link);
    notifyObservers();
  }


  @Override
	public OPNodeView getView() {
	  return view;
	}
  
  @Override
	public void setView(OPNodeView view) {
	  this.view = view;
	  if(!this.equals(view.getModel()))
		  view.setModel(this);
	  notifyObservers();
	}
  
  @Override
  public OPContainer getContainer() {
	  return container;
  }
  
  @Override
  public void setContainer(OPContainer container) {
	  this.container = container;
	  this.container.addNode(this);
	  notifyObservers();
  }  
}
