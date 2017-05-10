/*
 * SonarQube CSS / SCSS / Less Analyzer
 * Copyright (C) 2013-2017 David RACODON
 * mailto: david.racodon@gmail.com
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
package org.sonar.css.tree.impl.less;

import com.google.common.collect.Iterators;
import org.sonar.css.tree.impl.TreeImpl;
import org.sonar.plugins.css.api.tree.Tree;
import org.sonar.plugins.css.api.tree.css.ValueTree;
import org.sonar.plugins.css.api.tree.less.LessMixinParameterDefaultValueTree;
import org.sonar.plugins.css.api.tree.less.LessMixinParameterTree;
import org.sonar.plugins.css.api.tree.less.LessVariableTree;
import org.sonar.plugins.css.api.visitors.DoubleDispatchVisitor;

import javax.annotation.Nullable;
import java.util.Iterator;

public class LessMixinParameterTreeImpl extends TreeImpl implements LessMixinParameterTree {

  private final LessVariableTree variable;
  private final ValueTree value;
  private final LessMixinParameterDefaultValueTree defaultValue;

  public LessMixinParameterTreeImpl(@Nullable LessVariableTree variable, @Nullable ValueTree value, @Nullable LessMixinParameterDefaultValueTree defaultValue) {
    this.variable = variable;
    this.value = value;
    this.defaultValue = defaultValue;
  }

  @Override
  public Kind getKind() {
    return Kind.LESS_MIXIN_PARAMETER;
  }

  @Override
  public Iterator<Tree> childrenIterator() {
    return Iterators.forArray(variable, value, defaultValue);
  }

  @Override
  public void accept(DoubleDispatchVisitor visitor) {
    visitor.visitLessMixinParameter(this);
  }

  @Override
  @Nullable
  public LessVariableTree variable() {
    return variable;
  }

  @Override
  @Nullable
  public ValueTree value() {
    return value;
  }

  @Override
  @Nullable
  public LessMixinParameterDefaultValueTree defaultValue() {
    return defaultValue;
  }

}
