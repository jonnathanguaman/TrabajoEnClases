package paquete.trabajoClases.Dao;

import org.springframework.data.jpa.repository.JpaRepository;

import paquete.trabajoClases.model.Usuario;

public interface IUsuarioDao extends JpaRepository<Usuario, Long>{

}
