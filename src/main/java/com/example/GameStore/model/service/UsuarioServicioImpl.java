package com.example.GameStore.model.service;

import com.example.GameStore.model.dto.UsuarioRegistroDTO;
import com.example.GameStore.model.entity.Rol;
import com.example.GameStore.model.entity.Usuario;
import com.example.GameStore.model.repository.UsuarioRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UsuarioServicioImpl implements UsuarioServicio{

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @Autowired//genera un constructor
    private UsuarioRepositorio usuarioRepositorio;

    //guardar un usuario con la condificación de contraseña
    @Override
    public Usuario guardar(UsuarioRegistroDTO registroDTO) {
        Usuario usuario = new Usuario(registroDTO.getNombre(),registroDTO.getApPaterno(),
                registroDTO.getApMaterno(),registroDTO.getTelefono(),registroDTO.getDireccion(),
                registroDTO.getDni(),registroDTO.getFechaInscripcion(),registroDTO.getSexo(),
                registroDTO.getEstado(),registroDTO.getEmail(),passwordEncoder.encode(registroDTO.getPassword()),
                Arrays.asList(new Rol("ROLE_USER","Rol mas básico")));
        return usuarioRepositorio.save(usuario);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        //se va  a pasar el email por el "username"
        Usuario usuario = usuarioRepositorio.findByEmail(username);
        if(usuario == null){
            throw new UsernameNotFoundException("Usuario o password inválidos");
        }
        return new User(usuario.getEmail(), usuario.getPassword(), mapearAutoridadesRoles(usuario.getRoles()));
    }

    //se obtiene el nombre de cada rol y se mapea
    private Collection<? extends GrantedAuthority> mapearAutoridadesRoles(Collection<Rol> roles){
        return roles.stream().map(role -> new SimpleGrantedAuthority(role.getNombreRol())).collect(Collectors.toList());
    }

    //método para listar todos los usuarios
    @Override
    public List<Usuario> listarUsuarios() {
        return usuarioRepositorio.findAll();
    }
    /*
    @Override
    public Usuario guardarUsuario(Usuario usuario) {
        return repositorio.save(usuario);
    }

    @Override
    public Usuario obtenerUsuarioPorId(Long id) {
        return repositorio.findById(id).get();
    }

    @Override
    public Usuario actualizarUsuario(Usuario usuario) {
        return repositorio.save(usuario);
    }

    @Override
    public void eliminarUsuario(Long id) {
        repositorio.deleteById(id);
    }
    */

}
