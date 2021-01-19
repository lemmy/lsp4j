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

import org.eclipse.lsp4j.Range;
import org.eclipse.lsp4j.jsonrpc.validation.NonNull;
import org.eclipse.lsp4j.util.Preconditions;
import org.eclipse.xtext.xbase.lib.Pure;

/**
 * Represents a link between a source and a target location.
 */
@SuppressWarnings("all")
public class LocationLink {
  /**
   * Span of the origin of this link.
   * 
   * Used as the underlined span for mouse interaction. Defaults to the word range at
   * the mouse position.
   */
  private Range originSelectionRange;
  
  /**
   * The target resource identifier of this link.
   */
  @NonNull
  private String targetUri;
  
  /**
   * The full target range of this link. If the target for example is a symbol then target range is the
   * range enclosing this symbol not including leading/trailing whitespace but everything else
   * like comments. This information is typically used to highlight the range in the editor.
   */
  @NonNull
  private Range targetRange;
  
  /**
   * The range that should be selected and revealed when this link is being followed, e.g the name of a function.
   * Must be contained by the the `targetRange`. See also `DocumentSymbol#range`
   */
  @NonNull
  private Range targetSelectionRange;
  
  public LocationLink() {
  }
  
  public LocationLink(@NonNull final String targetUri, @NonNull final Range targetRange, @NonNull final Range targetSelectionRange) {
    this.targetUri = Preconditions.<String>checkNotNull(targetUri, "targetUri");
    this.targetRange = Preconditions.<Range>checkNotNull(targetRange, "targetRange");
    this.targetSelectionRange = Preconditions.<Range>checkNotNull(targetSelectionRange, "targetSelectionRange");
  }
  
  public LocationLink(@NonNull final String targetUri, @NonNull final Range targetRange, @NonNull final Range targetSelectionRange, final Range originSelectionRange) {
    this(targetUri, targetRange, targetSelectionRange);
    this.originSelectionRange = originSelectionRange;
  }
  
  /**
   * Span of the origin of this link.
   * 
   * Used as the underlined span for mouse interaction. Defaults to the word range at
   * the mouse position.
   */
  @Pure
  public Range getOriginSelectionRange() {
    return this.originSelectionRange;
  }
  
  /**
   * Span of the origin of this link.
   * 
   * Used as the underlined span for mouse interaction. Defaults to the word range at
   * the mouse position.
   */
  public void setOriginSelectionRange(final Range originSelectionRange) {
    this.originSelectionRange = originSelectionRange;
  }
  
  /**
   * The target resource identifier of this link.
   */
  @Pure
  @NonNull
  public String getTargetUri() {
    return this.targetUri;
  }
  
  /**
   * The target resource identifier of this link.
   */
  public void setTargetUri(@NonNull final String targetUri) {
    this.targetUri = Preconditions.checkNotNull(targetUri, "targetUri");
  }
  
  /**
   * The full target range of this link. If the target for example is a symbol then target range is the
   * range enclosing this symbol not including leading/trailing whitespace but everything else
   * like comments. This information is typically used to highlight the range in the editor.
   */
  @Pure
  @NonNull
  public Range getTargetRange() {
    return this.targetRange;
  }
  
  /**
   * The full target range of this link. If the target for example is a symbol then target range is the
   * range enclosing this symbol not including leading/trailing whitespace but everything else
   * like comments. This information is typically used to highlight the range in the editor.
   */
  public void setTargetRange(@NonNull final Range targetRange) {
    this.targetRange = Preconditions.checkNotNull(targetRange, "targetRange");
  }
  
  /**
   * The range that should be selected and revealed when this link is being followed, e.g the name of a function.
   * Must be contained by the the `targetRange`. See also `DocumentSymbol#range`
   */
  @Pure
  @NonNull
  public Range getTargetSelectionRange() {
    return this.targetSelectionRange;
  }
  
  /**
   * The range that should be selected and revealed when this link is being followed, e.g the name of a function.
   * Must be contained by the the `targetRange`. See also `DocumentSymbol#range`
   */
  public void setTargetSelectionRange(@NonNull final Range targetSelectionRange) {
    this.targetSelectionRange = Preconditions.checkNotNull(targetSelectionRange, "targetSelectionRange");
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
    LocationLink other = (LocationLink) obj;
    if (this.originSelectionRange == null) {
      if (other.originSelectionRange != null)
        return false;
    } else if (!this.originSelectionRange.equals(other.originSelectionRange))
      return false;
    if (this.targetUri == null) {
      if (other.targetUri != null)
        return false;
    } else if (!this.targetUri.equals(other.targetUri))
      return false;
    if (this.targetRange == null) {
      if (other.targetRange != null)
        return false;
    } else if (!this.targetRange.equals(other.targetRange))
      return false;
    if (this.targetSelectionRange == null) {
      if (other.targetSelectionRange != null)
        return false;
    } else if (!this.targetSelectionRange.equals(other.targetSelectionRange))
      return false;
    return true;
  }
  
  @Override
  @Pure
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((this.originSelectionRange== null) ? 0 : this.originSelectionRange.hashCode());
    result = prime * result + ((this.targetUri== null) ? 0 : this.targetUri.hashCode());
    result = prime * result + ((this.targetRange== null) ? 0 : this.targetRange.hashCode());
    return prime * result + ((this.targetSelectionRange== null) ? 0 : this.targetSelectionRange.hashCode());
  }
}
