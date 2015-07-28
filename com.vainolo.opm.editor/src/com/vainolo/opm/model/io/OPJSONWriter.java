package com.vainolo.opm.model.io;

import com.eclipsesource.json.JsonArray;
import com.eclipsesource.json.JsonObject;
import com.vainolo.opm.model.OPElement;
import com.vainolo.opm.model.OPObjectProcessDiagram;
import com.vainolo.opm.model.OPSystem;
import com.vainolo.opm.model.view.OPElementView;
import com.vainolo.opm.model.view.OPElementViewContainer;
import com.vainolo.opm.model.view.OPLinkView;
import com.vainolo.opm.model.view.OPNodeView;

public class OPJSONWriter {

	public JsonObject writeOPSystem(OPSystem system) {
		JsonObject json = new JsonObject();
		json.set("name",  system.getName());
		json.set("nexId", system.getNextId());
		json.set("SD", writeOPObjectProcessDiagram(system.getSD()));
		return json;
	}
	
	public JsonObject writeOPObjectProcessDiagram(OPObjectProcessDiagram opd) {
		JsonObject json = new JsonObject();
		writeOPModelBase(json, opd);
		
		json.set("isInzoomed", opd.isInzoomed());
		if(opd.isInzoomed())
			json.set("inZoomedThing", opd.getInzoomedThing().getId());
		if(opd.isUnfolded())
			json.set("unfolded", opd.getUnfoldedThing().getId());
		JsonArray links = new JsonArray();
		for(OPLinkView link:opd.getLinks()) {
			links.add(writeOPLinkView(link));
		}
		json.set("links", links);
		JsonArray nodes = new JsonArray();
		json.set("nodes", nodes);
		
		return json;
	}

	public String writeOPLinkView(OPLinkView link) {
		JsonObject json = new JsonObject();
		writeOPModelBase(json, link);
		json.set("source", link.getSource().getId());
		json.set("target", link.getTarget().getId());
		return null;
	}

	public void writeOPModelBase(JsonObject json, OPElement base) {
		json.set("id", base.getId());
	}
}
