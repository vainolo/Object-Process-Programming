/*******************************************************************************
 * Copyright (c) 2015 Arieh "Vainolo" Bibliowicz and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which is available at http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package com.vainolo.phd.opp.interpreter.builtin.twitter;

import java.util.List;

import twitter4j.TwitterFactory;
import twitter4j.conf.ConfigurationBuilder;

import com.google.common.collect.Lists;
import com.vainolo.phd.opp.interpreter.OPPAbstractProcessInstance;
import com.vainolo.phd.opp.interpreter.OPPParameter;

public class OPPInitializeTwitterClientProcessInstance extends OPPAbstractProcessInstance {

  @Override
  protected void executing() {
    String OAuthKey = getArgument("OAuthKey").getStringValue();
    String OAuthSecret = getArgument("OAuthSecret").getStringValue();
    String OAuthAccessToken = getArgument("OAuthAccessToken").getStringValue();
    String OAuthAccessSecret = getArgument("OAuthAccessSecret").getStringValue();
    ConfigurationBuilder cb = new ConfigurationBuilder();
    cb.setDebugEnabled(true).setOAuthConsumerKey(OAuthKey).setOAuthConsumerSecret(OAuthSecret).setOAuthAccessToken(OAuthAccessToken)
        .setOAuthAccessTokenSecret(OAuthAccessSecret);
    TwitterFactory tf = new TwitterFactory(cb.build());
    TwitterClientHelper.twitter = tf.getInstance();

  }

  @Override
  public String getName() {
    return "Initializer Twitter Client";
  }

  @Override
  public List<OPPParameter> getIncomingParameters() {
    return Lists.newArrayList(new OPPParameter("OAuthKey"), new OPPParameter("OAuthSecret"), new OPPParameter("OAuthAccessToken"), new OPPParameter(
        "OAuthAccessSecret"));
  }

}
