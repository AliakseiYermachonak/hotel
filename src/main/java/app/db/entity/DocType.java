package app.db.entity;

/**
 * Usual entity class to describe
 * document type according to their
 * identifiers
 * @author Alexey Yermachyonok
 * @version 1.0
 */

public class DocType {
	private int idDocType;
	private String document;
	
	public DocType(int idDocType, String document) {
		this.idDocType = idDocType;
		this.document = document;
	}
	
	public DocType() {}

	@Override
	public String toString() {
		return this.getClass().getSimpleName() +" [idDocType=" + idDocType + ", document=" + document + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((document == null) ? 0 : document.hashCode());
		result = prime * result + idDocType;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		DocType other = (DocType) obj;
		if (document == null) {
			if (other.document != null)
				return false;
		} else if (!document.equals(other.document))
			return false;
		if (idDocType != other.idDocType)
			return false;
		return true;
	}

	public int getIdDocType() {
		return idDocType;
	}

	public void setIdDocType(int idDocType) {
		this.idDocType = idDocType;
	}

	public String getDocument() {
		return document;
	}

	public void setDocument(String document) {
		this.document = document;
	}
}
