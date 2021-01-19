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

import org.eclipse.lsp4j.CallHierarchyItem;
import org.eclipse.lsp4j.WorkDoneProgressAndPartialResultParams;
import org.eclipse.lsp4j.jsonrpc.validation.NonNull;
import org.eclipse.lsp4j.util.Preconditions;
import org.eclipse.xtext.xbase.lib.Pure;
import org.eclipse.xtext.xbase.lib.util.ToStringBuilder;

/**
 * The parameter of a `callHierarchy/incomingCalls` request.
 * 
 * Since 3.16.0
 */
@SuppressWarnings("all")
public class CallHierarchyIncomingCallsParams extends WorkDoneProgressAndPartialResultParams {
  @NonNull
  private CallHierarchyItem item;
  
  public CallHierarchyIncomingCallsParams() {
  }
  
  public CallHierarchyIncomingCallsParams(@NonNull final CallHierarchyItem item) {
    this.item = Preconditions.<CallHierarchyItem>checkNotNull(item, "item");
  }
  
  @Pure
  @NonNull
  public CallHierarchyItem getItem() {
    return this.item;
  }
  
  public void setItem(@NonNull final CallHierarchyItem item) {
    this.item = Preconditions.checkNotNull(item, "item");
  }
  
  @Override
  public String toString() {
    ToStringBuilder b = new ToStringBuilder(this);
    b.add("item", this.item);
    b.add("workDoneToken", getWorkDoneToken());
    b.add("partialResultToken", getPartialResultToken());
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
    if (!super.equals(obj))
      return false;
    CallHierarchyIncomingCallsParams other = (CallHierarchyIncomingCallsParams) obj;
    if (this.item == null) {
      if (other.item != null)
        return false;
    } else if (!this.item.equals(other.item))
      return false;
    return true;
  }
  
  @Override
  @Pure
  public int hashCode() {
    return 31 * super.hashCode() + ((this.item== null) ? 0 : this.item.hashCode());
  }
}
