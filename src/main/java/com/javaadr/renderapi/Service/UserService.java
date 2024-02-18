package com.javaadr.renderapi.Service;

import com.javaadr.renderapi.Entity.User;
import com.javaadr.renderapi.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Base64;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import org.springframework.web.multipart.MultipartFile;

@Service
public class UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    @Value("${upload.directory}")
    private String uploadDirectory;

    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public List<User> getUsers(){
        return userRepository.findAll();
    }

    public Optional<User> findById(UUID id){
        return userRepository.findById(id);
    }

    public User saveUser(User toSave) {
        String hashedPassword = passwordEncoder.encode(toSave.getPassword());
        toSave.setPassword(hashedPassword);
        return userRepository.save(toSave);
    }

    public User authenticate(String email, String password) {
        User user = userRepository.findByEmail(email);

        if (user != null && passwordEncoder.matches(password, user.getPassword())) {
            return user;
        }

        return null;
    }

    public Optional<User> getUserById(UUID userId){
        return userRepository.findById(userId);
    }



    public User saveUserWithImage(UUID userId, MultipartFile image) {
        try {
            Optional<User> optionalUser = getUserById(userId);

            if (optionalUser.isEmpty()) {
                return null;
            }

            User user = optionalUser.get();

            byte[] imageBytes = image.getBytes(); // Obtenez les bytes de l'image directement depuis MultipartFile

            String profilePath = uploadDirectory;

            // Vérifiez l'existence du répertoire et créez-le s'il n'existe pas
            File directory = new File(profilePath);
            if (!directory.exists()) {
                directory.mkdirs(); // Créer le répertoire s'il n'existe pas
            }

            String imagePath = saveImageToDirectory(imageBytes, profilePath);

            user.setProfil(imagePath);

            userRepository.save(user);

            return user;
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Erreur lors de la sauvegarde de l'utilisateur avec image.");
        }
    }

    private String saveImageToDirectory(byte[] imageBytes, String directoryPath) {
        try {
            String fileName = UUID.randomUUID().toString() + ".jpg";

            String filePath = directoryPath + File.separator + fileName;

            // Log avant l'écriture du fichier
            System.out.println("Avant l'écriture du fichier : " + filePath);

            // Modifiez le chemin pour utiliser le répertoire 'resources/static'
            String relativePath = "saves" + File.separator + fileName;
            Files.write(Paths.get(filePath), imageBytes);

            // Log après l'écriture du fichier
            System.out.println("Après l'écriture du fichier : " + filePath);

            return filePath;
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException("Erreur lors de la sauvegarde de l'image dans le répertoire.");
        }
    }




}
