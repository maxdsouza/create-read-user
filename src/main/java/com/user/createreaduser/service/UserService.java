package com.user.createreaduser.service;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Service;

import com.user.createreaduser.dto.UserDTO;

@Service
public class UserService {
	
	public List<UserDTO> findAll() {

        List<UserDTO> usersDTO = new ArrayList<>();
        try {
            FileReader writeTxt = new FileReader("users.txt");
            BufferedReader bufferedReader = new BufferedReader(writeTxt);

            String line;

            while ((line = bufferedReader.readLine()) != null) {
                String[] split = line.split(";");
                usersDTO.add(new UserDTO(split[0], split[1], split[2], split[3]));
            }
            writeTxt.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

        return usersDTO;
    }

    public void save(UserDTO userDTO) {
        try {
            FileWriter file = new FileWriter("users.txt", true);
            PrintWriter printWriter = new PrintWriter(file);
            printWriter.println(buildUserToString(userDTO));
            printWriter.flush();
            printWriter.close();
            file.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
	BCrypt bcrypt = new BCrypt();

    private String buildUserToString(UserDTO userDTO) {
        return String.format("%s;%s;%s;%s", UUID.randomUUID().toString(), userDTO.getName(), userDTO.getEmail(), BCrypt.hashpw(userDTO.getPassword(), BCrypt.gensalt()) );
    }
}
