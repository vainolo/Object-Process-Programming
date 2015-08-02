package com.vainolo.opm.model.io;

import com.eclipsesource.json.JsonArray;
import com.eclipsesource.json.JsonObject;
import com.vainolo.opm.model.OPElement;
import com.vainolo.opm.model.OPLink;
import com.vainolo.opm.model.OPNode;
import com.vainolo.opm.model.OPObject;
import com.vainolo.opm.model.OPObjectProcessDiagram;
import com.vainolo.opm.model.OPProceduralLink;
import com.vainolo.opm.model.OPProcess;
import com.vainolo.opm.model.OPState;
import com.vainolo.opm.model.OPStructuralLink;
import com.vainolo.opm.model.OPSystem;
import com.vainolo.opm.model.OPThing;
import com.vainolo.opm.model.view.OPElementView;
import com.vainolo.opm.model.view.OPElementViewContainer;
import com.vainolo.opm.model.view.OPLinkView;
import com.vainolo.opm.model.view.OPNodeView;
import com.vainolo.opm.model.view.OPProceduralLinkView;
import com.vainolo.opm.model.view.OPStateView;
import com.vainolo.opm.model.view.OPStructuralLinkGrouperView;
import com.vainolo.opm.model.view.OPStructuralLinkPartView;
import com.vainolo.opm.model.view.OPThingView;

public class OPJsonWriter {

	public JsonObject writeOPSystem(OPSystem system) {
		JsonObject json = new JsonObject();
		json.set("type", OPSystem.class.getSimpleName());
		writeOPElement(json, system);
		json.set("name", system.getName());
		json.set("nextId", system.getNextId());
		json.set("sd", writeOPObjectProcessDiagram(system.getSD()));
		JsonArray array = new JsonArray();
		for(OPThing thing:system.getThings()) {
			if(OPObject.class.isInstance(thing))
				array.add(writeOPObject(OPObject.class.cast(thing)));
			else if(OPProcess.class.isInstance(thing))
				array.add(writeOPProcess(OPProcess.class.cast(thing)));
			else
				throw new IllegalStateException("Unexpected thing subclass "+thing.getClass());
		}
		json.set("things", array);
		array = new JsonArray();
		for(OPLink link:system.getLinks()) {
			if(OPProceduralLink.class.isInstance(link)) 
				array.add(writeOPProceduralLink(OPProceduralLink.class.cast(link)));
			else if(OPStructuralLink.class.isInstance(link))
				array.add(writeOPStructuralLink(OPStructuralLink.class.cast(link)));
		}
		return json;
	}
	
	 JsonObject writeOPProceduralLink(OPProceduralLink proceduralLink) {
		JsonObject json = new JsonObject();
		json.set("type", OPProceduralLink.class.getSimpleName());
		writeOPLink(json, proceduralLink);
		json.set("kind", proceduralLink.getKind().getName());
		return json;

	}

	 JsonObject writeOPStructuralLink(OPStructuralLink structuralLink) {
		JsonObject json = new JsonObject();
		json.set("type", OPStructuralLink.class.getSimpleName());
		writeOPLink(json, structuralLink);
		json.set("kind", structuralLink.getKind().getName());
		return json;
	}
	
	void writeOPLink(JsonObject json, OPLink link) {
		json.set("source", link.getSource().getId());
		json.set("target", link.getTarget().getId());
	}

	void writeOPElement(JsonObject json, OPElement element) {
		json.set("id", element.getId());
	}
	
	JsonObject writeOPObjectProcessDiagram(OPObjectProcessDiagram opd) {
		JsonObject json = new JsonObject();
		json.set("type", OPObjectProcessDiagram.class.getSimpleName());
		writeOPElement(json, opd);
		writeOPElementViewContainer(json, opd);
		json.set("inzoomed", opd.isInzoomed());
		if(opd.isInzoomed()) 
			json.set("inzoomedThing", opd.getInzoomedThing().getId());
		json.set("unfolded", opd.isUnfolded());
		if(opd.isUnfolded())
			json.set("unfoldedThing",opd.getUnfoldedThing().getId());
		return json;
	}
	
	JsonObject writeOPObject(OPObject object) {
		JsonObject json = new JsonObject();
		json.set("type", OPObject.class.getSimpleName());
		writeOPThing(json, object);
		return json;
	}

	JsonObject writeOPProcess(OPProcess process) {
		JsonObject json = new JsonObject();
		json.set("type", OPProcess.class.getSimpleName());
		writeOPThing(json, process);
		return json;
	}
	
	void writeOPThing(JsonObject json, OPThing thing) {
		writeOPNode(json, thing);
		JsonArray array = new JsonArray();
		for(OPNode node:thing.getNodes()) {
			if(OPObject.class.isInstance(node)) 
				array.add(writeOPObject(OPObject.class.cast(node)));
			else if(OPProcess.class.isInstance(node))
				array.add(writeOPProcess(OPProcess.class.cast(node)));
			else if(OPState.class.isInstance(node))
				array.add(writeOPState(OPState.class.cast(node)));
		}
		json.set("nodes", array);
		json.set("inzoomed", thing.isInzoomed());
		if(thing.isInzoomed())
			json.set("inzoomedObjectProcesDiagram", writeOPObjectProcessDiagram(thing.getInzoomedObjectProcessDiagram()));
		json.set("unfolded", thing.isUnfolded());
		if(thing.isUnfolded())
			json.set("unfoldedObjectProcessDiagram", writeOPObjectProcessDiagram(thing.getUnfoldedObjectProcessDiagram()));
	}
	
	JsonObject writeOPState(OPState state) {
		JsonObject json = new JsonObject();
		json.set("type", OPState.class.getSimpleName());
		writeOPNode(json, state);
		return json;
	}
	
	void writeOPNode(JsonObject json, OPNode node) {
		writeOPElement(json, node);
		json.set("name", node.getName());
		JsonArray array = new JsonArray();
		for(OPLink link:node.getLinks()) 
			array.add(link.getId());
		json.set("links", array);
		// TODO: what about the link to the view???
	}
	
	void writeOPElementViewContainer(JsonObject json, OPElementViewContainer viewContainer) {
		JsonArray array = new JsonArray();
		for(OPElementView elementView:viewContainer.getElementViews()) {
			if(OPThingView.class.isInstance(elementView))
				array.add(writeOPThingView(OPThingView.class.cast(elementView)));
			else if(OPStateView.class.isInstance(elementView))
				array.add(writeOPStateView(OPStateView.class.cast(elementView)));
			else if(OPStructuralLinkGrouperView.class.isInstance(elementView))
				array.add(writeOPStructuralLinkGrouperView(OPStructuralLinkGrouperView.class.cast(elementView)));
			else if(OPProceduralLinkView.class.isInstance(elementView))
				array.add(writeOPProceduralLinkView(OPProceduralLinkView.class.cast(elementView)));
			else if(OPStructuralLinkPartView.class.isInstance(elementView))
				array.add(writeOPStructuralLinkPartView(OPStructuralLinkPartView.class.cast(elementView)));
			else
				throw new IllegalStateException("Unexpected view type: "+elementView);
		}
		json.set("elementViews", array);
	}
	


	JsonObject writeOPThingView(OPThingView thingView) {
		JsonObject json = new JsonObject();
		json.set("type", OPThingView.class.getSimpleName());
		writeOPNodeView(json, thingView);
		writeOPElementViewContainer(json, thingView);
		return json;
	}
	
	JsonObject writeOPStateView(OPStateView stateView) {
		JsonObject json = new JsonObject();
		json.set("type", OPStateView.class.getSimpleName());
		writeOPNodeView(json, stateView);
		return json;
	}

	JsonObject writeOPStructuralLinkGrouperView(OPStructuralLinkGrouperView structuralLinkGrouperView) {
		JsonObject json = new JsonObject();
		json.set("type", OPStructuralLinkGrouperView.class.getSimpleName());
		writeOPNodeView(json, structuralLinkGrouperView);
		return json;
	}

	JsonObject writeOPProceduralLinkView(OPProceduralLinkView proceduralLinkView) {
		JsonObject json = new JsonObject();
		json.set("type", OPProceduralLinkView.class.getSimpleName());
		writeOPLinkView(json, proceduralLinkView);
		return json;
	}


	JsonObject writeOPStructuralLinkPartView(OPStructuralLinkPartView structuralLinkPartView) {
		JsonObject json = new JsonObject();
		json.set("type", OPStructuralLinkPartView.class.getSimpleName());
		writeOPLinkView(json, structuralLinkPartView);
		return json;
	}

	
	void writeOPNodeView(JsonObject json, OPNodeView nodeView) {
		writeOPElementView(json, nodeView);
		int[] constraints = nodeView.getConstraints();
		json.set("x", constraints[0]);
		json.set("y", constraints[1]);		
		json.set("width", constraints[2]);
		json.set("height", constraints[3]);
		if(nodeView.getModel() != null) // can be null for structural aggregators
			json.set("model", nodeView.getModel().getId());
		JsonArray array = new JsonArray();
		for(OPLinkView link: nodeView.getLinks()) 
			array.add(link.getId());
	}

	void writeOPLinkView(JsonObject json, OPLinkView proceduralLinkView) {
		writeOPElementView(json, proceduralLinkView);
		json.set("model", proceduralLinkView.getModel().getId());
		json.set("source", proceduralLinkView.getSource().getId());
		json.set("target", proceduralLinkView.getTarget().getId());
	}

	void writeOPElementView(JsonObject json, OPElementView elementView) {
		writeOPElement(json, elementView);
		json.set("elementViewContainer", elementView.getElementViewContainer().getId());
	}

}
