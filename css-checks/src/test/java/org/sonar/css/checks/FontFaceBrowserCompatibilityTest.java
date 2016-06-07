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

import java.io.File;

import org.junit.Test;
import org.sonar.css.checks.verifier.CssCheckVerifier;

public class FontFaceBrowserCompatibilityTest {

  @Test
  public void basic() {
    CssCheckVerifier.verify(new FontFaceBrowserCompatibility(), new File("src/test/resources/checks/fontface/basic.css"));
  }

  @Test
  public void deep() {
    FontFaceBrowserCompatibility check = new FontFaceBrowserCompatibility();
    check.setBrowserSupportLevel("deep");
    CssCheckVerifier.verify(check, new File("src/test/resources/checks/fontface/deep.css"));
  }

  @Test
  public void deepest() {
    FontFaceBrowserCompatibility check = new FontFaceBrowserCompatibility();
    check.setBrowserSupportLevel("deepest");
    CssCheckVerifier.verify(check, new File("src/test/resources/checks/fontface/deepest.css"));
  }

}
