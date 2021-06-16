package com.example.proyectomaja.services;


import com.example.proyectomaja.domain.Usuario;

public interface IUsuarioService {

//	public Boolean findByEmailAndPassword(String email,String Password);
public Usuario findByUsername(String username);
}
