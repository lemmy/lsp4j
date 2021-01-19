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

import org.eclipse.lsp4j.debug.VariablePresentationHint;
import org.eclipse.lsp4j.debug.util.Preconditions;
import org.eclipse.lsp4j.jsonrpc.validation.NonNull;
import org.eclipse.xtext.xbase.lib.Pure;

/**
 * Response to 'setExpression' request.
 */
@SuppressWarnings("all")
public class SetExpressionResponse {
  /**
   * The new value of the expression.
   */
  @NonNull
  private String value;
  
  /**
   * The optional type of the value.
   * <p>
   * This attribute should only be returned by a debug adapter if the client has passed the value true for the
   * 'supportsVariableType' capability of the 'initialize' request.
   * <p>
   * This is an optional property.
   */
  private String type;
  
  /**
   * Properties of a value that can be used to determine how to render the result in the UI.
   * <p>
   * This is an optional property.
   */
  private VariablePresentationHint presentationHint;
  
  /**
   * If variablesReference is &gt; 0, the value is structured and its children can be retrieved by passing
   * variablesReference to the VariablesRequest.
   * <p>
   * The value should be less than or equal to 2147483647 (2^31 - 1).
   * <p>
   * This is an optional property.
   */
  private Integer variablesReference;
  
  /**
   * The number of named child variables.
   * <p>
   * The client can use this optional information to present the variables in a paged UI and fetch them in chunks.
   * <p>
   * The value should be less than or equal to 2147483647 (2^31 - 1).
   * <p>
   * This is an optional property.
   */
  private Integer namedVariables;
  
  /**
   * The number of indexed child variables.
   * <p>
   * The client can use this optional information to present the variables in a paged UI and fetch them in chunks.
   * <p>
   * The value should be less than or equal to 2147483647 (2^31 - 1).
   * <p>
   * This is an optional property.
   */
  private Integer indexedVariables;
  
  /**
   * The new value of the expression.
   */
  @Pure
  @NonNull
  public String getValue() {
    return this.value;
  }
  
  /**
   * The new value of the expression.
   */
  public void setValue(@NonNull final String value) {
    this.value = Preconditions.checkNotNull(value, "value");
  }
  
  /**
   * The optional type of the value.
   * <p>
   * This attribute should only be returned by a debug adapter if the client has passed the value true for the
   * 'supportsVariableType' capability of the 'initialize' request.
   * <p>
   * This is an optional property.
   */
  @Pure
  public String getType() {
    return this.type;
  }
  
  /**
   * The optional type of the value.
   * <p>
   * This attribute should only be returned by a debug adapter if the client has passed the value true for the
   * 'supportsVariableType' capability of the 'initialize' request.
   * <p>
   * This is an optional property.
   */
  public void setType(final String type) {
    this.type = type;
  }
  
  /**
   * Properties of a value that can be used to determine how to render the result in the UI.
   * <p>
   * This is an optional property.
   */
  @Pure
  public VariablePresentationHint getPresentationHint() {
    return this.presentationHint;
  }
  
  /**
   * Properties of a value that can be used to determine how to render the result in the UI.
   * <p>
   * This is an optional property.
   */
  public void setPresentationHint(final VariablePresentationHint presentationHint) {
    this.presentationHint = presentationHint;
  }
  
  /**
   * If variablesReference is &gt; 0, the value is structured and its children can be retrieved by passing
   * variablesReference to the VariablesRequest.
   * <p>
   * The value should be less than or equal to 2147483647 (2^31 - 1).
   * <p>
   * This is an optional property.
   */
  @Pure
  public Integer getVariablesReference() {
    return this.variablesReference;
  }
  
  /**
   * If variablesReference is &gt; 0, the value is structured and its children can be retrieved by passing
   * variablesReference to the VariablesRequest.
   * <p>
   * The value should be less than or equal to 2147483647 (2^31 - 1).
   * <p>
   * This is an optional property.
   */
  public void setVariablesReference(final Integer variablesReference) {
    this.variablesReference = variablesReference;
  }
  
  /**
   * The number of named child variables.
   * <p>
   * The client can use this optional information to present the variables in a paged UI and fetch them in chunks.
   * <p>
   * The value should be less than or equal to 2147483647 (2^31 - 1).
   * <p>
   * This is an optional property.
   */
  @Pure
  public Integer getNamedVariables() {
    return this.namedVariables;
  }
  
  /**
   * The number of named child variables.
   * <p>
   * The client can use this optional information to present the variables in a paged UI and fetch them in chunks.
   * <p>
   * The value should be less than or equal to 2147483647 (2^31 - 1).
   * <p>
   * This is an optional property.
   */
  public void setNamedVariables(final Integer namedVariables) {
    this.namedVariables = namedVariables;
  }
  
  /**
   * The number of indexed child variables.
   * <p>
   * The client can use this optional information to present the variables in a paged UI and fetch them in chunks.
   * <p>
   * The value should be less than or equal to 2147483647 (2^31 - 1).
   * <p>
   * This is an optional property.
   */
  @Pure
  public Integer getIndexedVariables() {
    return this.indexedVariables;
  }
  
  /**
   * The number of indexed child variables.
   * <p>
   * The client can use this optional information to present the variables in a paged UI and fetch them in chunks.
   * <p>
   * The value should be less than or equal to 2147483647 (2^31 - 1).
   * <p>
   * This is an optional property.
   */
  public void setIndexedVariables(final Integer indexedVariables) {
    this.indexedVariables = indexedVariables;
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
    SetExpressionResponse other = (SetExpressionResponse) obj;
    if (this.value == null) {
      if (other.value != null)
        return false;
    } else if (!this.value.equals(other.value))
      return false;
    if (this.type == null) {
      if (other.type != null)
        return false;
    } else if (!this.type.equals(other.type))
      return false;
    if (this.presentationHint == null) {
      if (other.presentationHint != null)
        return false;
    } else if (!this.presentationHint.equals(other.presentationHint))
      return false;
    if (this.variablesReference == null) {
      if (other.variablesReference != null)
        return false;
    } else if (!this.variablesReference.equals(other.variablesReference))
      return false;
    if (this.namedVariables == null) {
      if (other.namedVariables != null)
        return false;
    } else if (!this.namedVariables.equals(other.namedVariables))
      return false;
    if (this.indexedVariables == null) {
      if (other.indexedVariables != null)
        return false;
    } else if (!this.indexedVariables.equals(other.indexedVariables))
      return false;
    return true;
  }
  
  @Override
  @Pure
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((this.value== null) ? 0 : this.value.hashCode());
    result = prime * result + ((this.type== null) ? 0 : this.type.hashCode());
    result = prime * result + ((this.presentationHint== null) ? 0 : this.presentationHint.hashCode());
    result = prime * result + ((this.variablesReference== null) ? 0 : this.variablesReference.hashCode());
    result = prime * result + ((this.namedVariables== null) ? 0 : this.namedVariables.hashCode());
    return prime * result + ((this.indexedVariables== null) ? 0 : this.indexedVariables.hashCode());
  }
}
