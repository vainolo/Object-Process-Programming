package com.vainolo.opm.model.io;

import java.util.Map;

import com.eclipsesource.json.JsonArray;
import com.eclipsesource.json.JsonObject;
import com.eclipsesource.json.JsonValue;
import com.vainolo.opm.model.OPElement;
import com.vainolo.opm.model.OPModelFactory;
import com.vainolo.opm.model.OPObjectProcessDiagram;
import com.vainolo.opm.model.OPSystem;
import com.vainolo.opm.model.view.OPElementView;
import com.vainolo.opm.model.view.OPElementViewContainer;
import com.vainolo.opm.model.view.OPNodeView;
import com.vainolo.opm.model.view.OPStateView;
import com.vainolo.opm.model.view.OPStructuralLinkGrouperView;
import com.vainolo.opm.model.view.OPThingView;

public class OPJsonReader {
	
	private OPModelFactory factory;
	// Needed to later fill node model and links views
	private Map<OPNodeView, JsonObject> nodeViews;
	

	public OPSystem readOPSystem(JsonObject json) {
		factory = new OPModelFactory();
		OPSystem system = factory.createSystem();
		factory.setSystem(system);
		
		readOPElement(system, json);
		system.setName(json.get("name").asString());
//		system.setSD(readOPObjectProcessDiagram(json.get("sd").asObject()));

		// This is the last thing we have to do.
		system.setNextId(json.get("nextId").asInt());
		return system;
	}
	
//	private OPObjectProcessDiagram readOPObjectProcessDiagram(JsonObject json) {
//		OPObjectProcessDiagram opd = factory.createObjectProcessDiagram();
//		readOPElement(opd, json);
//		readOPElementViewContainer(opd, json);
//	}
		
	private void readOPElement(OPElement element, JsonObject json) {
		element.setId(json.get("id").asInt());
	}
	
//	private void readOPElementViewContainer(OPElementViewContainer viewContainer, JsonObject json) {
//		JsonArray array = json.get("elementViews").asArray();
//		for(JsonValue value : array) {
//			JsonObject elementViewJson = value.asObject();
//			String type = elementViewJson.get("type").asString();
//			if(type.equals(OPThingView.class.getSimpleName()))
//				viewContainer.addElementView(readOPThingView(elementViewJson));
//			else if(type.equals(OPStateView.class.getSimpleName())) 
//				viewContainer.addElementView(readOPStateView(elementViewJson));
//			else if(type.equals(OPStructuralLinkGrouperView.class.getSimpleName()))
//				viewContainer.addElementView(readOPStructuralLinkGrouperView(elementViewJson));
//			else if(type.equals(OPProceduralLinkView.class.getSimpleName()))
//				viewContainer.addElementView(readOPProceduralLinkView(elementViewJson));
//			else if(type.equals(OPStructuralLinkPartView.class.getSimpleName()))
//				viewContainer.addElementView(readOPStructuralLinkPartView(elementViewJson));
//			else
//				throw new IllegalStateException("Unknown view type: "+elementViewJson);
//		}
//	}
	
	
	private OPStructuralLinkGrouperView readOPStructuralLinkGrouperView(JsonObject json) {
		OPStructuralLinkGrouperView structuralLinkGrouperView = factory.createStructuralLinkGrouperView();
		readOPNodeView(structuralLinkGrouperView, json);
		return structuralLinkGrouperView;
	}

	private OPStateView readOPStateView(JsonObject json) {
		OPStateView stateView = factory.createStateView();
		readOPNodeView(stateView, json);
		return stateView;
	}

//	private OPThingView readOPThingView(JsonObject json) {	
//		OPThingView thingView = factory.createThingView();
//		readOPNodeView(thingView, json);
//		readOPElementViewContainer(thingView, json);
//		return thingView;
//	}
	
	private void readOPNodeView(OPNodeView nodeView, JsonObject json) {
		readOPElementView(nodeView, json);
		nodeView.setConstraints(json.get("x").asInt(), json.get("y").asInt(), json.get("width").asInt(), json.get("height").asInt());
		nodeViews.put(nodeView, json);
	}
	
	private void readOPElementView(OPElementView elementView, JsonObject json) {
		readOPElement(elementView, json);
	}


	
//	public OPSystem readOPSystem(JsonObject json) {
//		OPSystem system = OPModelFactory.createOPSystem();
//		system.setName(json.get("name").asString());
//		system.setNextId(json.get("nexId").asInt());
//		system.setSD(readOPObjectProcessDiagram(json.get("SD").asObject()));
//		return system;
//	}
//	
//	public OPObjectProcessDiagram readOPObjectProcessDiagram(JsonObject json) {
//		OPObjectProcessDiagram opd = OPModelFactory.createObjectProcessDiagram();
//		readOPModelBase(opd, json);
//		readOPElementViewContainer(opd, json);
//
//		Map<Integer, OPLinkView> idToLink = Maps.newHashMap();
//		Map<OPLinkView, Integer> linkToSource = Maps.newHashMap();
//		Map<OPLinkView, Integer> linkToTarget = Maps.newHashMap();
//		
//		for(JsonValue link : json.get("links").asArray()) {
//			opd.addLinkView(readOPLinkView(link.asObject(), idToLink, linkToSource, linkToTarget));
//		}
//		// Fix links between nodes an links
//		
//		opd.setInzoomed(json.get("isInzoomed").asBoolean());
//		if(opd.isInzoomed()) {} // TODO: do something smart
//		opd.setUnfolded(json.get("isUnfolded").asBoolean());
//		if(opd.isUnfolded()) {} // TODO: do something smart
//			
//		
//		return null;
//	}
//	
//	public OPLinkView readOPLinkView(JsonObject json, Map<Integer, OPLinkView> idToLink, Map<OPLinkView, Integer> linkToSource, Map<OPLinkView, Integer> linkToTarget) {
//		OPLinkView link = OPModelFactory.createLinkView();
//		readOPModelBase(link, json);
//		idToLink.put(link.getId(), link);
//		linkToSource.put(link, json.get("source").asInt());
//		linkToTarget.put(link, json.get("target").asInt());
//		return link;
//	}
//	
//	
//	public void readOPElementViewContainer(OPElementViewContainer container, JsonObject json) {
//		JsonArray nodes = json.get("nodes").asArray();
//		for (JsonValue node : nodes) {
////			container.addNode(readOPNodeView(node.asObject()));
//		}
//	}
//	
//	public void readOPModelBase(OPElement base, JsonObject json) {
//		base.setId(json.get("id").asInt());
//	}
}
