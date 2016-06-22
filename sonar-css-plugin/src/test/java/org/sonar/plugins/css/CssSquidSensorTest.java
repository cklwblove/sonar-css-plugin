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
package org.sonar.plugins.css;

import java.io.File;

import org.junit.Test;
import org.sonar.api.batch.fs.InputFile;
import org.sonar.api.batch.fs.internal.DefaultInputFile;
import org.sonar.api.batch.fs.internal.FileMetadata;
import org.sonar.api.batch.rule.ActiveRules;
import org.sonar.api.batch.rule.CheckFactory;
import org.sonar.api.batch.rule.internal.ActiveRulesBuilder;
import org.sonar.api.batch.sensor.internal.DefaultSensorDescriptor;
import org.sonar.api.batch.sensor.internal.SensorContextTester;
import org.sonar.api.internal.google.common.base.Charsets;
import org.sonar.api.issue.NoSonarFilter;
import org.sonar.api.measures.CoreMetrics;
import org.sonar.api.rule.RuleKey;
import org.sonar.css.checks.CheckList;

import static org.fest.assertions.Assertions.assertThat;
import static org.mockito.Mockito.mock;

public class CssSquidSensorTest {

  private final File baseDir = new File("src/test/resources");
  private final SensorContextTester context = SensorContextTester.create(baseDir);
  private CheckFactory checkFactory = new CheckFactory(mock(ActiveRules.class));

  @Test
  public void should_create_a_valid_sensor_descriptor() {
    DefaultSensorDescriptor descriptor = new DefaultSensorDescriptor();
    createCssSquidSensor().describe(descriptor);
    assertThat(descriptor.name()).isEqualTo("CSS Squid Sensor");
    assertThat(descriptor.languages()).containsOnly("css");
    assertThat(descriptor.type()).isEqualTo(InputFile.Type.MAIN);
  }

  @Test
  public void should_execute_and_compute_valid_measures() {
    String relativePath = "measures.css";
    inputFile(relativePath);

    createCssSquidSensor().execute(context);

    String key = "moduleKey:" + relativePath;

    assertThat(context.measure(key, CoreMetrics.NCLOC).value()).isEqualTo(31);
    assertThat(context.measure(key, CoreMetrics.STATEMENTS).value()).isEqualTo(21);
    assertThat(context.measure(key, CoreMetrics.COMMENT_LINES).value()).isEqualTo(6);
  }

  @Test
  public void should_execute_and_save_issues() throws Exception {
    inputFile("issues.css");

    ActiveRules activeRules = (new ActiveRulesBuilder())
      .create(RuleKey.of(CheckList.REPOSITORY_KEY, "formatting"))
      .activate()
      .create(RuleKey.of(CheckList.REPOSITORY_KEY, "important"))
      .activate()
      .build();
    checkFactory = new CheckFactory(activeRules);

    createCssSquidSensor().execute(context);

    assertThat(context.allIssues()).hasSize(3);
  }

  private CssSquidSensor createCssSquidSensor() {
    return new CssSquidSensor(context.fileSystem(), checkFactory, new NoSonarFilter());
  }

  private DefaultInputFile inputFile(String relativePath) {
    DefaultInputFile inputFile = new DefaultInputFile("moduleKey", relativePath)
      .setModuleBaseDir(baseDir.toPath())
      .setType(InputFile.Type.MAIN)
      .setLanguage(CssLanguage.KEY);

    context.fileSystem().add(inputFile);

    return inputFile.initMetadata(new FileMetadata().readMetadata(inputFile.file(), Charsets.UTF_8));
  }

}
