/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.utb.simoin.controladores;

import com.utb.simoin.entities.Permiso;
import com.utb.simoin.entities.Usuario;
import com.utb.simoin.entities.Vista;
import com.utb.simoin.exceptions.ClavesNoConcuerdanException;
import com.utb.simoin.exceptions.UsuarioNoConectadoException;
import com.utb.simoin.exceptions.UsuarioNoExisteException;
import com.utb.simoin.facades.SystemFacade;
import com.utb.simoin.interfaces.Observer;
import com.utb.simoin.interfaces.Subject;
import com.utb.simoin.util.FacesUtil;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;

/**
 *
 * @author ideacentre
 */
@Named(value = "sessionBean")
@SessionScoped
public class SessionBean implements Serializable, Subject {
    @EJB
    SystemFacade sessionFacade;
    private Usuario usuario;//Almacena el objeto usuario de la session
    private HashMap<String, Object> Attributes;
    private String active;
    private List<Observer> observers;

    /**
     * Creates a new instance of SessionFlowumiUtil
     */
    public SessionBean() {
    }

    @PostConstruct
    public void init() {
        usuario = new Usuario();
        Attributes = new HashMap<String, Object>();
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public String Conectar() {
        try {
            usuario = sessionFacade.iniciarSession(usuario);
            active = "inicio";
            return "/pages/index.xhtml";
        } catch (ClavesNoConcuerdanException | UsuarioNoExisteException | UsuarioNoConectadoException ex) {
            FacesUtil.addErrorMessage("Usuario no conectado", ex.getMessage());
            usuario = new Usuario();
        }
        return "";
    }

    public String Desconectar() {
        usuario = new Usuario();
        return "/pages/InicioSession.xhtml";
    }

    public boolean perfilViewMatch(String vista) {
        if (usuario == null || usuario.getPerfil()== null || usuario.getPerfil().getVistaList()== null) {
            try {
                FacesContext.getCurrentInstance().getExternalContext().redirect("InicioSession.xhtml");
            } catch (IOException ex) {
            }
        } else {
            List<Vista> vistasUsuario = usuario.getPerfil().getVistaList();
            for (Vista v : vistasUsuario) {
                if (v.getNombre().equals(vista)) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean perfilFormMatch(String permiso) {
       if (usuario == null || usuario.getPerfil()== null || usuario.getPerfil().getPermisoList()== null) {
            try {
                FacesContext.getCurrentInstance().getExternalContext().redirect("InicioSession.xhtml");
            } catch (IOException ex) {
            }
        } else {
            List<Permiso> permisosUsuario = usuario.getPerfil().getPermisoList();
            for (Permiso p : permisosUsuario) {
                if (p.getNombre().equals(permiso)) {
                    return true;
                }
            }
        }
        return false;
    }

    public void actualizarUsuario() {
        usuario = sessionFacade.actualizarUsuario(usuario);
    }

    public HashMap<String, Object> getAttributes() {
        return Attributes;
    }

    public void setAttributes(HashMap<String, Object> Attributes) {
        this.Attributes = Attributes;
    }
    @Override
    public void removeObserver(Observer o) {
        observers.remove(o);
    }

    @Override
    public void registerObserver(Observer o) {
        observers.add(o);
    }

    @Override
    public void notifyObserver(String tabla) {
        Iterator<Observer> i = observers.iterator();
        while (i.hasNext()) {
            Observer o = i.next();
            if (o == null) {
                i.remove();
            } else {
                o.update();
            }

        }
    }

    public void checkUsuarioConectado() {
        if (usuario == null
                || usuario.getId()== null
                || usuario.getId()<= 0) {
            try {
                System.out.println("No lo coje");
                Desconectar();
                FacesUtil.addErrorMessage("Session finalizada", "No existe usuario conectado");
                FacesContext.getCurrentInstance().getExternalContext().redirect("InicioSession.xhtml");
            } catch (IOException ex) {
            }
        }
    }

    public String getActive() {
        return active;
    }

    public void setActive(String active) {
        this.active = active;
    }

    public boolean isActive(String pestaña) {
        if (active == null) {
            return false;
        }
        return active.equals(pestaña);
    }

    public boolean isNotActive(String pestaña) {
        if (active == null) {
            return true;
        }
        return !active.equals(pestaña);
    }

    public String go(String page) {
        if (page.equals("inicio")) {
            active = "inicio";
            return "/pages/index.xhtml";
        } else if (page.equals("AtributosSistema")) {
            active = "configuracion";
            return "/pages/AdministradorAtributosSistema.xhtml";
        } else if (page.equals("AtributosMarketing")) {
            active = "configuracion";
            return "/pages/AdministradorAtributosMarketing.xhtml";
        } else if (page.equals("ConfiguracionesGenerales")) {
            active = "configuracion";
            return "/pages/ConfiguracionesGenerales.xhtml";
        } else if (page.equals("clientes")) {
            active = "clientes";
            return "/pages/clientes.xhtml";
        } else if (page.equals("eventos")) {
            active = "eventos";
            return "/pages/eventos.xhtml";
        } else if (page.equals("eventoshostess")) {
            active = "eventoshostess";
            return "/pages/tareasHostess.xhtml";
        } else if (page.equals("reportes")) {
            active = "reportes";
            return "/pages/Reportes.xhtml";
        } else if (page.equals("cuenta")) {
            active = "cuenta";
            return "/pages/CuentaUsuarios.xhtml";
        } else if (page.equals("tareas")) {
            active = "tareas";
            return "/pages/tareas.xhtml";
        }
        return "/pages/InicioSession.xhtml";
    }


    void obtenerUsuario(Integer idUsuario) {
        usuario = sessionFacade.getUsuario(idUsuario);
    }
}
