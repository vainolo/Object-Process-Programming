package com.vainolo.opm.model.io;


import java.util.Map;

import com.eclipsesource.json.JsonArray;
import com.eclipsesource.json.JsonObject;
import com.eclipsesource.json.JsonValue;
import com.google.common.collect.Maps;
import com.vainolo.opm.model.OPLinkView;
import com.vainolo.opm.model.OPModelBase;
import com.vainolo.opm.model.OPModelFactory;
import com.vainolo.opm.model.OPNodeView;
import com.vainolo.opm.model.OPNodeViewContainer;
import com.vainolo.opm.model.OPObjectProcessDiagram;
import com.vainolo.opm.model.OPPoint;
import com.vainolo.opm.model.OPRectangle;
import com.vainolo.opm.model.OPSystem;

public class OPJSONReader {
	
	public OPSystem readOPSystem(JsonObject json) {
		OPSystem system = OPModelFactory.createOPSystem();
		system.setName(json.get("name").asString());
		system.setNextId(json.get("nexId").asInt());
		system.setSD(readOPObjectProcessDiagram(json.get("SD").asObject()));
		return system;
	}
	
	public OPObjectProcessDiagram readOPObjectProcessDiagram(JsonObject json) {
		OPObjectProcessDiagram opd = OPModelFactory.createObjectProcessDiagram();
		readOPModelBase(opd, json);
		readOPNodeViewContainer(opd, json);

		Map<Integer, OPLinkView> idToLink = Maps.newHashMap();
		Map<OPLinkView, Integer> linkToSource = Maps.newHashMap();
		Map<OPLinkView, Integer> linkToTarget = Maps.newHashMap();
		
		for(JsonValue link : json.get("links").asArray()) {
			opd.addLinkView(readOPLinkView(link.asObject(), idToLink, linkToSource, linkToTarget));
		}
		// Fix links between nodes an links
		
		opd.setInzoomed(json.get("isInzoomed").asBoolean());
		if(opd.isInzoomed()) {} // TODO: do something smart
		opd.setUnfolded(json.get("isUnfolded").asBoolean());
		if(opd.isUnfolded()) {} // TODO: do something smart
			
		
		return null;
	}
	
	public OPLinkView readOPLinkView(JsonObject json, Map<Integer, OPLinkView> idToLink, Map<OPLinkView, Integer> linkToSource, Map<OPLinkView, Integer> linkToTarget) {
		OPLinkView link = OPModelFactory.createLinkView();
		readOPModelBase(link, json);
		idToLink.put(link.getId(), link);
		linkToSource.put(link, json.get("source").asInt());
		linkToTarget.put(link, json.get("target").asInt());
		return link;
	}
	
	
	public void readOPNodeViewContainer(OPNodeViewContainer container, JsonObject json) {
		JsonArray nodes = json.get("nodes").asArray();
		for (JsonValue node : nodes) {
			container.addNode(readOPNodeView(node.asObject()));
		}
	}
	
	public OPNodeView readOPNodeView(JsonObject json) {
		OPNodeView node = OPModelFactory.createOPNodeView();
		readOPModelBase(node, json);
		node.setConstraints(readOPRectangle(json.get("constraints").asObject()));
		return node;
	}

	public void readOPModelBase(OPModelBase base, JsonObject json) {
		base.setId(json.get("id").asInt());
	}
	
	public OPRectangle readOPRectangle(JsonObject json) {
		OPRectangle rectangle = OPModelFactory.createOPRectangle();
		rectangle.setWidth(json.get("width").asInt());
		rectangle.setHeight(json.get("height").asInt());
		rectangle.setPoint(readOPPoint(json.get("point").asObject()));
		return rectangle;
	}
	
	public OPPoint readOPPoint(JsonObject json) {
		OPPoint point = OPModelFactory.createOPPoint();
		point.setX(json.get("x").asInt());
		point.setY(json.get("y").asInt());
		return point;
	}
}
