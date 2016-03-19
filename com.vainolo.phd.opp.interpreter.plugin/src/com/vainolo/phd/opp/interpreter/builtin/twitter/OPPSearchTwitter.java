/*******************************************************************************
 * Copyright (c) 2015 Arieh "Vainolo" Bibliowicz and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which is available at http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package com.vainolo.phd.opp.interpreter.builtin.twitter;

import java.util.List;

import twitter4j.Query;
import twitter4j.QueryResult;
import twitter4j.Status;

import com.google.common.collect.Lists;
import com.vainolo.phd.opp.interpreter.OPPAbstractProcessInstance;
import com.vainolo.phd.opp.interpreter.OPPObjectInstance;
import com.vainolo.phd.opp.interpreter.OPPParameter;

public class OPPSearchTwitter extends OPPAbstractProcessInstance {

  @Override
  protected void executing() throws Exception {
    String queryStr = getArgument("Query").getStringValue();
    Query query = new Query(queryStr);
    QueryResult result = TwitterClientHelper.twitter.search(query);

    for (Status status : result.getTweets()) {
      System.out.println("@" + status.getUser().getScreenName() + ":" + status.getText());
    }

    OPPObjectInstance tweets = OPPObjectInstance.createCompositeInstance();
    for (Status status : result.getTweets()) {
      tweets.addLastPart(OPPObjectInstance.createFromValue(status.getText()));
    }
    setArgument("Tweets", tweets);
  }

  @Override
  public String getName() {
    return "Search Twitter";
  }

  @Override
  public List<OPPParameter> getIncomingParameters() {
    return Lists.newArrayList(new OPPParameter("Query"));
  }

  @Override
  public List<OPPParameter> getOutgoingParameters() {
    return Lists.newArrayList(new OPPParameter("Tweets"));
  }

}
