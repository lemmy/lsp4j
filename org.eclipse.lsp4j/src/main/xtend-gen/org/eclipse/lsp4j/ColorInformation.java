/**
 * Copyright (c) 2016-2018 TypeFox and others.
 * 
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License v. 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0,
 * or the Eclipse Distribution License v. 1.0 which is available at
 * http://www.eclipse.org/org/documents/edl-v10.php.
 * 
 * SPDX-License-Identifier: EPL-2.0 OR BSD-3-Clause
 */
package org.eclipse.lsp4j;

import org.eclipse.lsp4j.Color;
import org.eclipse.lsp4j.Range;
import org.eclipse.lsp4j.jsonrpc.validation.NonNull;
import org.eclipse.lsp4j.util.Preconditions;
import org.eclipse.xtext.xbase.lib.Pure;

@SuppressWarnings("all")
public class ColorInformation {
  /**
   * The range in the document where this color appears.
   */
  @NonNull
  private Range range;
  
  /**
   * The actual color value for this color range.
   */
  @NonNull
  private Color color;
  
  public ColorInformation() {
  }
  
  public ColorInformation(@NonNull final Range range, @NonNull final Color color) {
    this.range = Preconditions.<Range>checkNotNull(range, "range");
    this.color = Preconditions.<Color>checkNotNull(color, "color");
  }
  
  /**
   * The range in the document where this color appears.
   */
  @Pure
  @NonNull
  public Range getRange() {
    return this.range;
  }
  
  /**
   * The range in the document where this color appears.
   */
  public void setRange(@NonNull final Range range) {
    this.range = Preconditions.checkNotNull(range, "range");
  }
  
  /**
   * The actual color value for this color range.
   */
  @Pure
  @NonNull
  public Color getColor() {
    return this.color;
  }
  
  /**
   * The actual color value for this color range.
   */
  public void setColor(@NonNull final Color color) {
    this.color = Preconditions.checkNotNull(color, "color");
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
    ColorInformation other = (ColorInformation) obj;
    if (this.range == null) {
      if (other.range != null)
        return false;
    } else if (!this.range.equals(other.range))
      return false;
    if (this.color == null) {
      if (other.color != null)
        return false;
    } else if (!this.color.equals(other.color))
      return false;
    return true;
  }
  
  @Override
  @Pure
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((this.range== null) ? 0 : this.range.hashCode());
    return prime * result + ((this.color== null) ? 0 : this.color.hashCode());
  }
}
