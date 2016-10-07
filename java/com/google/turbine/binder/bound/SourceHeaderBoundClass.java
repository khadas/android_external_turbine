/*
 * Copyright 2016 Google Inc. All Rights Reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.google.turbine.binder.bound;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.turbine.binder.lookup.CompoundScope;
import com.google.turbine.binder.lookup.MemberImportIndex;
import com.google.turbine.binder.sym.ClassSymbol;
import com.google.turbine.binder.sym.TyVarSymbol;
import com.google.turbine.model.TurbineTyKind;
import com.google.turbine.model.TurbineVisibility;
import com.google.turbine.tree.Tree;

/** A {@link HeaderBoundClass} that corresponds to a source file being compiled. */
public class SourceHeaderBoundClass implements HeaderBoundClass {

  private final PackageSourceBoundClass base;
  private final ClassSymbol superclass;
  private final ImmutableList<ClassSymbol> interfaces;
  private final TurbineVisibility visibility;
  private final int access;
  private final ImmutableMap<String, TyVarSymbol> typeParameters;

  public SourceHeaderBoundClass(
      PackageSourceBoundClass base,
      ClassSymbol superclass,
      ImmutableList<ClassSymbol> interfaces,
      TurbineVisibility visibility,
      int access,
      ImmutableMap<String, TyVarSymbol> typeParameters) {

    this.base = base;
    this.superclass = superclass;
    this.interfaces = interfaces;
    this.visibility = visibility;
    this.access = access;
    this.typeParameters = typeParameters;
  }

  @Override
  public ClassSymbol superclass() {
    return superclass;
  }

  @Override
  public ImmutableList<ClassSymbol> interfaces() {
    return interfaces;
  }

  @Override
  public int access() {
    return access;
  }

  @Override
  public TurbineTyKind kind() {
    return base.kind();
  }

  @Override
  public ClassSymbol owner() {
    return base.owner();
  }

  @Override
  public ImmutableMap<String, ClassSymbol> children() {
    return base.children();
  }

  public TurbineVisibility visibility() {
    return visibility;
  }

  /** Declared type parameters. */
  @Override
  public ImmutableMap<String, TyVarSymbol> typeParameters() {
    return typeParameters;
  }

  public CompoundScope scope() {
    return base.scope();
  }

  public Tree.TyDecl decl() {
    return base.decl();
  }

  /** The static member import index for the enclosing compilation unit. */
  public MemberImportIndex memberImports() {
    return base.memberImports();
  }
}
