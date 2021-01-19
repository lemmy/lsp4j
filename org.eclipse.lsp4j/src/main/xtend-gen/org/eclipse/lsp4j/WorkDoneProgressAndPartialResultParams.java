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

import org.eclipse.lsp4j.PartialResultParams;
import org.eclipse.lsp4j.WorkDoneProgressParams;
import org.eclipse.lsp4j.jsonrpc.messages.Either;
import org.eclipse.xtext.xbase.lib.Pure;
import org.eclipse.xtext.xbase.lib.util.ToStringBuilder;

/**
 * Abstract class which implements work done progress and partial result request parameter.
 * It is not present in protocol specification, so it's just "dry" class.
 * 
 * Since 3.15.0
 */
@SuppressWarnings("all")
public abstract class WorkDoneProgressAndPartialResultParams implements WorkDoneProgressParams, PartialResultParams {
  /**
   * An optional token that a server can use to report work done progress.
   */
  private Either<String, Integer> workDoneToken;
  
  /**
   * An optional token that a server can use to report partial results (e.g. streaming) to
   * the client.
   */
  private Either<String, Integer> partialResultToken;
  
  /**
   * An optional token that a server can use to report work done progress.
   */
  @Pure
  public Either<String, Integer> getWorkDoneToken() {
    return this.workDoneToken;
  }
  
  /**
   * An optional token that a server can use to report work done progress.
   */
  public void setWorkDoneToken(final Either<String, Integer> workDoneToken) {
    this.workDoneToken = workDoneToken;
  }
  
  public void setWorkDoneToken(final String workDoneToken) {
    if (workDoneToken == null) {
      this.workDoneToken = null;
      return;
    }
    this.workDoneToken = Either.forLeft(workDoneToken);
  }
  
  public void setWorkDoneToken(final Integer workDoneToken) {
    if (workDoneToken == null) {
      this.workDoneToken = null;
      return;
    }
    this.workDoneToken = Either.forRight(workDoneToken);
  }
  
  /**
   * An optional token that a server can use to report partial results (e.g. streaming) to
   * the client.
   */
  @Pure
  public Either<String, Integer> getPartialResultToken() {
    return this.partialResultToken;
  }
  
  /**
   * An optional token that a server can use to report partial results (e.g. streaming) to
   * the client.
   */
  public void setPartialResultToken(final Either<String, Integer> partialResultToken) {
    this.partialResultToken = partialResultToken;
  }
  
  public void setPartialResultToken(final String partialResultToken) {
    if (partialResultToken == null) {
      this.partialResultToken = null;
      return;
    }
    this.partialResultToken = Either.forLeft(partialResultToken);
  }
  
  public void setPartialResultToken(final Integer partialResultToken) {
    if (partialResultToken == null) {
      this.partialResultToken = null;
      return;
    }
    this.partialResultToken = Either.forRight(partialResultToken);
  }
  
  @Override
  public String toString() {
    ToStringBuilder b = new ToStringBuilder(this);
    b.add("workDoneToken", this.workDoneToken);
    b.add("partialResultToken", this.partialResultToken);
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
    WorkDoneProgressAndPartialResultParams other = (WorkDoneProgressAndPartialResultParams) obj;
    if (this.workDoneToken == null) {
      if (other.workDoneToken != null)
        return false;
    } else if (!this.workDoneToken.equals(other.workDoneToken))
      return false;
    if (this.partialResultToken == null) {
      if (other.partialResultToken != null)
        return false;
    } else if (!this.partialResultToken.equals(other.partialResultToken))
      return false;
    return true;
  }
  
  @Override
  @Pure
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((this.workDoneToken== null) ? 0 : this.workDoneToken.hashCode());
    return prime * result + ((this.partialResultToken== null) ? 0 : this.partialResultToken.hashCode());
  }
}
