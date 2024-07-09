package com.pedido.test.model;

import java.io.Serializable;
import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.Transient;
import lombok.Getter;
import lombok.Setter;

@MappedSuperclass
public class EntidadBase implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Column(name = "fecha_creacion", insertable = true, updatable = false, nullable = true)
	protected Date fechaCreacion;
	@Column(name = "usuario_creacion", insertable = true, updatable = false, nullable = true, length = 50)
	protected String usuarioCreacion;
	@Column(name = "fecha_modificacion", insertable = false, updatable = true, nullable = true)
	protected Date fechaModificacion;
	@Column(name = "usuario_modificacion", insertable = false, updatable = true, nullable = true, length = 50)
	protected String usuarioModificacion;
	@Getter
	@Setter
	@Column(name = "observacion")
	private String observacion;
	@Transient
	@Getter
	@Setter
	protected boolean registroEliminado;

	public Date getFechaCreacion() {
		return fechaCreacion;
	}

	public void setFechaCreacion(Date fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}

	public String getUsuarioCreacion() {
		return usuarioCreacion;
	}

	public void setUsuarioCreacion(String usuarioCreacion) {
		this.usuarioCreacion = usuarioCreacion;
	}

	public Date getFechaModificacion() {
		return fechaModificacion;
	}

	public void setFechaModificacion(Date fechaModificacion) {
		this.fechaModificacion = fechaModificacion;
	}

	public String getUsuarioModificacion() {
		return usuarioModificacion;
	}

	public void setUsuarioModificacion(String usuarioModificacion) {
		this.usuarioModificacion = usuarioModificacion;
	}

}
