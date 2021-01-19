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

import java.util.Arrays;
import org.eclipse.lsp4j.debug.CompletionItem;
import org.eclipse.lsp4j.debug.util.Preconditions;
import org.eclipse.lsp4j.jsonrpc.validation.NonNull;
import org.eclipse.xtext.xbase.lib.Pure;
import org.eclipse.xtext.xbase.lib.util.ToStringBuilder;

/**
 * Response to 'completions' request.
 */
@SuppressWarnings("all")
public class CompletionsResponse {
  /**
   * The possible completions for .
   */
  @NonNull
  private CompletionItem[] targets;
  
  /**
   * The possible completions for .
   */
  @Pure
  @NonNull
  public CompletionItem[] getTargets() {
    return this.targets;
  }
  
  /**
   * The possible completions for .
   */
  public void setTargets(@NonNull final CompletionItem[] targets) {
    this.targets = Preconditions.checkNotNull(targets, "targets");
  }
  
  @Override
  public String toString() {
    ToStringBuilder b = new ToStringBuilder(this);
    b.add("targets", this.targets);
    return b.toString();
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
    CompletionsResponse other = (CompletionsResponse) obj;
    if (this.targets == null) {
      if (other.targets != null)
        return false;
    } else if (!Arrays.deepEquals(this.targets, other.targets))
      return false;
    return true;
  }
  
  @Override
  @Pure
  public int hashCode() {
    return 31 * 1 + ((this.targets== null) ? 0 : Arrays.deepHashCode(this.targets));
  }
}
