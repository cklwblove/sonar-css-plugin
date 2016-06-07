/*
 * SonarQube CSS Plugin
 * Copyright (C) 2013-2016 Tamas Kende and David RACODON
 * mailto: kende.tamas@gmail.com and david.racodon@gmail.com
 *
 * This program is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License as published by the Free Software Foundation; either
 * version 3 of the License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License
 * along with this program; if not, write to the Free Software Foundation,
 * Inc., 51 Franklin Street, Fifth Floor, Boston, MA  02110-1301, USA.
 */
package org.sonar.css.checks;

import com.google.common.collect.ImmutableList;
import com.sonar.sslr.api.AstNode;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.sonar.api.server.rule.RulesDefinition;
import org.sonar.check.Priority;
import org.sonar.check.Rule;
import org.sonar.css.CssCheck;
import org.sonar.css.parser.CssGrammar;
import org.sonar.squidbridge.annotations.ActivatedByDefault;
import org.sonar.squidbridge.annotations.SqaleConstantRemediation;
import org.sonar.squidbridge.annotations.SqaleSubCharacteristic;

/**
 * https://github.com/stubbornella/csslint/wiki/Require-all-gradient-definitions
 */
@Rule(
  key = "gradients",
  name = "Gradient definitions should be set for all vendors",
  priority = Priority.MAJOR,
  tags = {Tags.BROWSER_COMPATIBILITY})
@SqaleSubCharacteristic(RulesDefinition.SubCharacteristics.ARCHITECTURE_RELIABILITY)
@SqaleConstantRemediation("10min")
@ActivatedByDefault
public class AllGradientDefinitions extends CssCheck {

  private static final List<String> GRADIENTS = ImmutableList.of(
    "-ms-(linear|radial)-gradient.*",
    "-moz-(linear|radial)-gradient.*",
    "-o-(linear|radial)-gradient.*",
    "-webkit-(linear|radial)-gradient.*",
    "-webkit-gradient.*");

  private static final String GRADIENT_MATCHER = "-(ms|o|moz|webkit)-.*gradient.*";
  private List<String> missingGradients;

  @Override
  public void init() {
    subscribeTo(CssGrammar.RULESET, CssGrammar.AT_RULE, CssGrammar.DECLARATION);
  }

  @Override
  public void visitNode(AstNode astNode) {
    if (astNode.is(CssGrammar.RULESET) || astNode.is(CssGrammar.AT_RULE)) {
      missingGradients = new ArrayList<>(GRADIENTS);
    } else if (astNode.is(CssGrammar.DECLARATION)) {
      String value = astNode.getFirstChild(CssGrammar.VALUE).getTokenValue();
      if (value.matches(GRADIENT_MATCHER)) {
        removeMatch(value);
      }
    }
  }

  @Override
  public void leaveNode(AstNode astNode) {
    if (astNode.is(CssGrammar.RULESET) && !missingGradients.isEmpty() && missingGradients.size() != GRADIENTS.size()) {
      StringBuilder message = new StringBuilder()
        .append("Add missing gradient definitions: ")
        .append(missingGradients.get(0));
      for (int i = 1; i < missingGradients.size(); i++) {
        message.append(", ").append(missingGradients.get(i));
      }
      addIssue(
        this,
        message.toString(),
        astNode.getFirstChild(CssGrammar.SELECTOR) != null ? astNode.getFirstChild(CssGrammar.SELECTOR)
          : astNode.getFirstChild(CssGrammar.BLOCK).getFirstChild(CssGrammar.OPEN_CURLY_BRACE));
    }
  }

  private void removeMatch(String value) {
    Iterator<String> gradientIt = missingGradients.iterator();
    while (gradientIt.hasNext()) {
      if (value.matches(gradientIt.next())) {
        gradientIt.remove();
      }
    }
  }

}
