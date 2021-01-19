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
 * Arguments for 'exceptionInfo' request.
 */
@SuppressWarnings("all")
public class ExceptionInfoArguments {
  /**
   * Thread for which exception information should be retrieved.
   */
  private int threadId;
  
  /**
   * Thread for which exception information should be retrieved.
   */
  @Pure
  public int getThreadId() {
    return this.threadId;
  }
  
  /**
   * Thread for which exception information should be retrieved.
   */
  public void setThreadId(final int threadId) {
    this.threadId = threadId;
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
    ExceptionInfoArguments other = (ExceptionInfoArguments) obj;
    if (other.threadId != this.threadId)
      return false;
    return true;
  }
  
  @Override
  @Pure
  public int hashCode() {
    return 31 * 1 + this.threadId;
  }
}
