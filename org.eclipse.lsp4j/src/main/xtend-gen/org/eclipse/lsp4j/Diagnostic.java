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

import com.google.gson.annotations.JsonAdapter;
import java.util.List;
import org.eclipse.lsp4j.DiagnosticCodeDescription;
import org.eclipse.lsp4j.DiagnosticRelatedInformation;
import org.eclipse.lsp4j.DiagnosticSeverity;
import org.eclipse.lsp4j.DiagnosticTag;
import org.eclipse.lsp4j.Range;
import org.eclipse.lsp4j.jsonrpc.json.adapters.JsonElementTypeAdapter;
import org.eclipse.lsp4j.jsonrpc.messages.Either;
import org.eclipse.lsp4j.jsonrpc.validation.NonNull;
import org.eclipse.lsp4j.util.Preconditions;
import org.eclipse.xtext.xbase.lib.Pure;

/**
 * Represents a diagnostic, such as a compiler error or warning. Diagnostic objects are only valid in the scope of a resource.
 */
@SuppressWarnings("all")
public class Diagnostic {
  /**
   * The range at which the message applies
   */
  @NonNull
  private Range range;
  
  /**
   * The diagnostic's severity. Can be omitted. If omitted it is up to the client to interpret diagnostics as error,
   * warning, info or hint.
   */
  private DiagnosticSeverity severity;
  
  /**
   * The diagnostic's code. Can be omitted.
   */
  private Either<String, Integer> code;
  
  /**
   * An optional property to describe the error code.
   * 
   * Since 3.16.0
   */
  private DiagnosticCodeDescription codeDescription;
  
  /**
   * A human-readable string describing the source of this diagnostic, e.g. 'typescript' or 'super lint'.
   */
  private String source;
  
  /**
   * The diagnostic's message.
   */
  @NonNull
  private String message;
  
  /**
   * Additional metadata about the diagnostic.
   * 
   * Since 3.15.0
   */
  private List<DiagnosticTag> tags;
  
  /**
   * An array of related diagnostic information, e.g. when symbol-names within a scope collide
   * all definitions can be marked via this property.
   * 
   * Since 3.7.0
   */
  private List<DiagnosticRelatedInformation> relatedInformation;
  
  /**
   * A data entry field that is preserved between a `textDocument/publishDiagnostics`
   * notification and `textDocument/codeAction` request.
   * 
   * Since 3.16.0
   */
  @JsonAdapter(JsonElementTypeAdapter.Factory.class)
  private Object data;
  
  public Diagnostic() {
  }
  
  public Diagnostic(@NonNull final Range range, @NonNull final String message) {
    this.range = Preconditions.<Range>checkNotNull(range, "range");
    this.message = Preconditions.<String>checkNotNull(message, "message");
  }
  
  public Diagnostic(@NonNull final Range range, @NonNull final String message, final DiagnosticSeverity severity, final String source) {
    this(range, message);
    this.severity = severity;
    this.source = source;
  }
  
  public Diagnostic(@NonNull final Range range, @NonNull final String message, final DiagnosticSeverity severity, final String source, final String code) {
    this(range, message, severity, source);
    this.setCode(code);
  }
  
  /**
   * The range at which the message applies
   */
  @Pure
  @NonNull
  public Range getRange() {
    return this.range;
  }
  
  /**
   * The range at which the message applies
   */
  public void setRange(@NonNull final Range range) {
    this.range = Preconditions.checkNotNull(range, "range");
  }
  
  /**
   * The diagnostic's severity. Can be omitted. If omitted it is up to the client to interpret diagnostics as error,
   * warning, info or hint.
   */
  @Pure
  public DiagnosticSeverity getSeverity() {
    return this.severity;
  }
  
  /**
   * The diagnostic's severity. Can be omitted. If omitted it is up to the client to interpret diagnostics as error,
   * warning, info or hint.
   */
  public void setSeverity(final DiagnosticSeverity severity) {
    this.severity = severity;
  }
  
  /**
   * The diagnostic's code. Can be omitted.
   */
  @Pure
  public Either<String, Integer> getCode() {
    return this.code;
  }
  
  /**
   * The diagnostic's code. Can be omitted.
   */
  public void setCode(final Either<String, Integer> code) {
    this.code = code;
  }
  
  public void setCode(final String code) {
    if (code == null) {
      this.code = null;
      return;
    }
    this.code = Either.forLeft(code);
  }
  
  public void setCode(final Integer code) {
    if (code == null) {
      this.code = null;
      return;
    }
    this.code = Either.forRight(code);
  }
  
  /**
   * An optional property to describe the error code.
   * 
   * Since 3.16.0
   */
  @Pure
  public DiagnosticCodeDescription getCodeDescription() {
    return this.codeDescription;
  }
  
  /**
   * An optional property to describe the error code.
   * 
   * Since 3.16.0
   */
  public void setCodeDescription(final DiagnosticCodeDescription codeDescription) {
    this.codeDescription = codeDescription;
  }
  
  /**
   * A human-readable string describing the source of this diagnostic, e.g. 'typescript' or 'super lint'.
   */
  @Pure
  public String getSource() {
    return this.source;
  }
  
  /**
   * A human-readable string describing the source of this diagnostic, e.g. 'typescript' or 'super lint'.
   */
  public void setSource(final String source) {
    this.source = source;
  }
  
  /**
   * The diagnostic's message.
   */
  @Pure
  @NonNull
  public String getMessage() {
    return this.message;
  }
  
  /**
   * The diagnostic's message.
   */
  public void setMessage(@NonNull final String message) {
    this.message = Preconditions.checkNotNull(message, "message");
  }
  
  /**
   * Additional metadata about the diagnostic.
   * 
   * Since 3.15.0
   */
  @Pure
  public List<DiagnosticTag> getTags() {
    return this.tags;
  }
  
  /**
   * Additional metadata about the diagnostic.
   * 
   * Since 3.15.0
   */
  public void setTags(final List<DiagnosticTag> tags) {
    this.tags = tags;
  }
  
  /**
   * An array of related diagnostic information, e.g. when symbol-names within a scope collide
   * all definitions can be marked via this property.
   * 
   * Since 3.7.0
   */
  @Pure
  public List<DiagnosticRelatedInformation> getRelatedInformation() {
    return this.relatedInformation;
  }
  
  /**
   * An array of related diagnostic information, e.g. when symbol-names within a scope collide
   * all definitions can be marked via this property.
   * 
   * Since 3.7.0
   */
  public void setRelatedInformation(final List<DiagnosticRelatedInformation> relatedInformation) {
    this.relatedInformation = relatedInformation;
  }
  
  /**
   * A data entry field that is preserved between a `textDocument/publishDiagnostics`
   * notification and `textDocument/codeAction` request.
   * 
   * Since 3.16.0
   */
  @Pure
  public Object getData() {
    return this.data;
  }
  
  /**
   * A data entry field that is preserved between a `textDocument/publishDiagnostics`
   * notification and `textDocument/codeAction` request.
   * 
   * Since 3.16.0
   */
  public void setData(final Object data) {
    this.data = data;
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
    Diagnostic other = (Diagnostic) obj;
    if (this.range == null) {
      if (other.range != null)
        return false;
    } else if (!this.range.equals(other.range))
      return false;
    if (this.severity == null) {
      if (other.severity != null)
        return false;
    } else if (!this.severity.equals(other.severity))
      return false;
    if (this.code == null) {
      if (other.code != null)
        return false;
    } else if (!this.code.equals(other.code))
      return false;
    if (this.codeDescription == null) {
      if (other.codeDescription != null)
        return false;
    } else if (!this.codeDescription.equals(other.codeDescription))
      return false;
    if (this.source == null) {
      if (other.source != null)
        return false;
    } else if (!this.source.equals(other.source))
      return false;
    if (this.message == null) {
      if (other.message != null)
        return false;
    } else if (!this.message.equals(other.message))
      return false;
    if (this.tags == null) {
      if (other.tags != null)
        return false;
    } else if (!this.tags.equals(other.tags))
      return false;
    if (this.relatedInformation == null) {
      if (other.relatedInformation != null)
        return false;
    } else if (!this.relatedInformation.equals(other.relatedInformation))
      return false;
    if (this.data == null) {
      if (other.data != null)
        return false;
    } else if (!this.data.equals(other.data))
      return false;
    return true;
  }
  
  @Override
  @Pure
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((this.range== null) ? 0 : this.range.hashCode());
    result = prime * result + ((this.severity== null) ? 0 : this.severity.hashCode());
    result = prime * result + ((this.code== null) ? 0 : this.code.hashCode());
    result = prime * result + ((this.codeDescription== null) ? 0 : this.codeDescription.hashCode());
    result = prime * result + ((this.source== null) ? 0 : this.source.hashCode());
    result = prime * result + ((this.message== null) ? 0 : this.message.hashCode());
    result = prime * result + ((this.tags== null) ? 0 : this.tags.hashCode());
    result = prime * result + ((this.relatedInformation== null) ? 0 : this.relatedInformation.hashCode());
    return prime * result + ((this.data== null) ? 0 : this.data.hashCode());
  }
}
