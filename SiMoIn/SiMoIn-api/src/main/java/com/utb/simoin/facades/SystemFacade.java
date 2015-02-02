/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.utb.simoin.facades;

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
import java.util.List;

/**
 *
 * @author ideacentre
 */
public interface SystemFacade {

    public Usuario iniciarSession(Usuario usuario)throws ClavesNoConcuerdanException, UsuarioNoExisteException, UsuarioNoConectadoException ;

    public Usuario actualizarUsuario(Usuario usuario);

    public Usuario cambiarContrasena(String contrasena, String nueva, Usuario usuario)throws ClavesNoConcuerdanException, NoCambioContrasenaException;

    public Usuario getUsuario(Integer idUsuario);
    
    public List<Usuario> findAllUsuarios();
   
    public void deleteUsuarios(Usuario elemento);
    
    public boolean guardarUsuarios(Usuario elemento) throws NombreUsuarioExistenteException;
    
    public void deletePerfiles(Perfil elemento);
    
    public List<Perfil> findAllPerfiles();
    
    public boolean guardarPerfiles(Perfil elemento) throws PerfilExistenteException;
    
    public List<Permiso> findAllFormularios();
    
    public void deleteFormularios(Permiso elemento);
    
    public boolean guardarFormularios(Permiso elemento);
    
    public List<Vista> findAllVistas();
    
    public void deleteVistas(Vista elemento);
    
    public boolean guardarVistas(Vista elemento);
    
    public Perfil findPerfil(Integer idPerfil);
    
    public List<Usuario> findAllUsuariosHostess() ;
    
    public Usuario findUsuarios(Integer idUsuario);

    public Vista findVistasByNombre(String nombre);
    
}
