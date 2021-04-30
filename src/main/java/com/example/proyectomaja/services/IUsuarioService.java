package com.example.proyectomaja.services;


import com.example.proyectomaja.domain.Usuario;

public interface IUsuarioService {

	public Usuario findByUsername(String username);
}
