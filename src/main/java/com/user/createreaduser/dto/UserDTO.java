package com.user.createreaduser.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

public class UserDTO {
	
	private String id;
	@NotBlank(message = "Por favor preencha este campo")
    private String name;
	@NotBlank(message = "Por favor preencha este campo")
    @Email(message = "Por favor digite o e-mail corretamente")
    private String email;
	@NotBlank(message = "Por favor preencha este campo")
    private String password;
    
	public UserDTO() {
	}

	public UserDTO(String id, String name, String email, String password) {
		this.id = id;
		this.name = name;
		this.email = email;
		this.password = password;
	}

	public UserDTO(String name, String email, String password) {
		this.name = name;
		this.email = email;
		this.password = password;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}
