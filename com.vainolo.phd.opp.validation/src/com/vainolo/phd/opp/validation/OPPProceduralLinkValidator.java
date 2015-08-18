package com.vainolo.phd.opp.validation;

import java.util.List;

import com.google.common.collect.Lists;
import com.vainolo.phd.opp.model.OPPProceduralLink;

/**
 * Validate operations on {@link OPMProceduralLink}s
 * 
 * @author Arieh "Vainolo" Bibliowicz
 * 
 */
public class OPPProceduralLinkValidator {
  List<String> validSubkinds = Lists.newArrayList("c", "e", "o");

  /**
   * Check if a subkind can be added to a procedural link.
   * 
   * @param link
   *          that is being checked
   * @param subkind
   *          that is being added
   * @return <code>true</code> if the subkind can be added to the link,
   *         <code>false</code> otherwise.
   */
  public boolean canSubkindBeAdded(OPPProceduralLink link, String subkind) {
    return link != null && validSubkinds.contains(subkind) && !link.getSubKinds().contains(subkind);
  }

  /**
   * Check if a subkind can be removed from a procedural link.
   * 
   * @param link
   *          that is being checked
   * @param subkind
   *          that is being added
   * @return <code>true</code> if the subkind can be removed from the link,
   *         <code>false</code> otherwise.
   */
  public boolean canSubkindBeRemoved(OPPProceduralLink link, String subkind) {
    return link != null && link.getSubKinds().contains(subkind);
  }

}
