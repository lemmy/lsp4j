/**
 * Copyright (c) 2017, 2020 Kichwa Coders Ltd. and others.
 * 
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License v. 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0,
 * or the Eclipse Distribution License v. 1.0 which is available at
 * http://www.eclipse.org/org/documents/edl-v10.php.
 * 
 * SPDX-License-Identifier: EPL-2.0 OR BSD-3-Clause
 */
package org.eclipse.lsp4j.debug;

import org.eclipse.xtext.xbase.lib.Pure;

/**
 * Arguments for 'scopes' request.
 */
@SuppressWarnings("all")
public class ScopesArguments {
  /**
   * Retrieve the scopes for this stackframe.
   */
  private int frameId;
  
  /**
   * Retrieve the scopes for this stackframe.
   */
  @Pure
  public int getFrameId() {
    return this.frameId;
  }
  
  /**
   * Retrieve the scopes for this stackframe.
   */
  public void setFrameId(final int frameId) {
    this.frameId = frameId;
  }
  
  @Override
  @Pure
  public boolean equals(final Object obj) {
    if (this == obj)
      return true;
    if (obj == null)
      return false;
    if (getClass() != obj.getClass())
      return false;
    ScopesArguments other = (ScopesArguments) obj;
    if (other.frameId != this.frameId)
      return false;
    return true;
  }
  
  @Override
  @Pure
  public int hashCode() {
    return 31 * 1 + this.frameId;
  }
}
