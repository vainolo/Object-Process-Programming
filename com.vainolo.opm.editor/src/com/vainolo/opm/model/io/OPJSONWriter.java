package com.vainolo.opm.model.io;

import com.eclipsesource.json.JsonArray;
import com.eclipsesource.json.JsonObject;
import com.vainolo.opm.model.OPLinkView;
import com.vainolo.opm.model.OPModelBase;
import com.vainolo.opm.model.OPNodeView;
import com.vainolo.opm.model.OPObjectProcessDiagram;
import com.vainolo.opm.model.OPPoint;
import com.vainolo.opm.model.OPRectangle;
import com.vainolo.opm.model.OPSystem;
import com.vainolo.opm.model.OPNodeViewContainer;

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
		writeOPNodeViewContainer(json, opd);
		
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
		for(OPNodeView node:opd.getNodes()) {
			nodes.add(writeOPNodeView(node));
		}
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

	public void writeOPNodeViewContainer(JsonObject json, OPNodeViewContainer container) {
		JsonArray jsonNodes = new JsonArray();
		for(OPNodeView node:container.getNodes()) {
			jsonNodes.add(writeOPNodeView(node));
		}
		json.set("nodes", jsonNodes);
	}

	public JsonObject writeOPNodeView(OPNodeView node) {
		JsonObject json = new JsonObject();
		writeOPModelBase(json, node);
		json.set("constraints", writeOPRectangle(node.getConstraints()));
		JsonArray jsonLinks = new JsonArray();
		for(OPLinkView link:node.getLinks()) {
			jsonLinks.add(link.getId());
		}
		json.set("container", node.getContainer().getId());
		return json;
	}

	public void writeOPModelBase(JsonObject json, OPModelBase base) {
		json.set("id", base.getId());
	}

	public JsonObject writeOPRectangle(OPRectangle constraints) {
		JsonObject json = new JsonObject();
		json.set("width", constraints.getWidth());
		json.set("height", constraints.getHeight());
		json.set("point", writeOPPoint(constraints.getPoint()));
		return json;
	}

	public JsonObject writeOPPoint(OPPoint point) {
		JsonObject json = new JsonObject();
		json.set("x", point.getX());
		json.set("y", point.getY());
		return json;
	}	
}
