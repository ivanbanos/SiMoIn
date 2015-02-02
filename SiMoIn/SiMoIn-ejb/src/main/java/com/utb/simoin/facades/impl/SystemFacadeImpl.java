/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.utb.simoin.facades.impl;

import com.utb.simoin.entities.Perfil;
import com.utb.simoin.entities.Permiso;
import com.utb.simoin.entities.Usuario;
import com.utb.simoin.entities.Vista;
import com.utb.simoin.exceptions.ClavesNoConcuerdanException;
import com.utb.simoin.exceptions.NoCambioContrasenaException;
import com.utb.simoin.exceptions.NombreUsuarioExistenteException;
import com.utb.simoin.exceptions.PerfilExistenteException;
import com.utb.simoin.exceptions.UsuarioNoConectadoException;
import com.utb.simoin.exceptions.UsuarioNoExisteException;
import com.utb.simoin.facades.SystemFacade;
import com.utb.simoin.facades.UsuarioFacadeLocal;
import com.utb.simoin.util.EncryptUtil;
import java.security.NoSuchAlgorithmException;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;



/**
 *
 * @author ideacentre
 */
@Stateless
public class SystemFacadeImpl implements SystemFacade {
    
    @EJB
    UsuarioFacadeLocal usuarioFacadeLocal;

    @Override
    public Usuario iniciarSession(Usuario usuario) throws ClavesNoConcuerdanException, UsuarioNoExisteException, UsuarioNoConectadoException {try {
            Usuario usuarios = usuarioFacadeLocal.findByNombreUsuario(usuario.getNombreUsusario());
            if (usuarios != null) {
                Usuario usuarioConectado = usuarios;
                if (!EncryptUtil.comparePassword(usuario.getContrasena(), usuarioConectado.getContrasena())) {
                    throw new ClavesNoConcuerdanException();
                }
                return usuarioConectado;
            } else {
                throw new UsuarioNoExisteException();
            }
        } catch (NoSuchAlgorithmException ex) {
            throw new UsuarioNoConectadoException();
        }
    }

    @Override
    public Usuario actualizarUsuario(Usuario usuario) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Usuario cambiarContrasena(String contrasena, String nueva, Usuario usuario) throws ClavesNoConcuerdanException, NoCambioContrasenaException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Usuario getUsuario(Integer idUsuario) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Usuario> findAllUsuarios() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void deleteUsuarios(Usuario elemento) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean guardarUsuarios(Usuario elemento) throws NombreUsuarioExistenteException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void deletePerfiles(Perfil elemento) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Perfil> findAllPerfiles() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean guardarPerfiles(Perfil elemento) throws PerfilExistenteException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Permiso> findAllFormularios() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void deleteFormularios(Permiso elemento) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean guardarFormularios(Permiso elemento) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Vista> findAllVistas() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void deleteVistas(Vista elemento) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean guardarVistas(Vista elemento) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Perfil findPerfil(Integer idPerfil) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Usuario> findAllUsuariosHostess() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Usuario findUsuarios(Integer idUsuario) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Vista findVistasByNombre(String nombre) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
}
