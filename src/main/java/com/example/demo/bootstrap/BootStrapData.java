package com.example.demo.bootstrap;

import com.example.demo.model.Post;
import com.example.demo.model.Task;
import com.example.demo.model.User;

import com.example.demo.respo.PostRepository;
import com.example.demo.respo.TaskRepository;
import com.example.demo.respo.UserRepository;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootStrapData implements CommandLineRunner {

    private final UserRepository userRepository;
    private final PostRepository postRepository;
    private final TaskRepository taskRepository;

    public BootStrapData(UserRepository userRepository, PostRepository postRepository, TaskRepository taskRepository) {
        this.userRepository = userRepository;
        this.postRepository = postRepository;
        this.taskRepository = taskRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        User abdellah = new User("Abdellah Essordo", 21, "abdoessordo01@gmail.com");
        User oussama = new User("Oussama Zaid", 21, "ussaz24@gmail.com");
        User saad = new User("Saad Ennigro", 21, "saadenr@gmail.com");

        userRepository.save(abdellah);
        userRepository.save(saad);
        userRepository.save(oussama);

        Post post1 = new Post("Post 1", "Post 1 Body");
        Post post2 = new Post("Post 2", "Post 2 Body");
        Post post3 = new Post("Post 3", "Post 3 Body");

        Task study = new Task("Study", "Study Java", "In Progress");
        Task sleep = new Task("Sleep", "Sleep 8 hours", "In Progress");

        // Abdellah
        post1.setUser(abdellah);

        abdellah.getPosts().add(post1);

        abdellah.getTasks().add(study);
        abdellah.getTasks().add(sleep);

        sleep.getUsers().add(abdellah);
        study.getUsers().add(abdellah);

        taskRepository.save(study);
        taskRepository.save(sleep);

        // Saad
        saad.getPosts().add(post2);

        post2.setUser(saad);

        saad.getTasks().add(study);
        saad.getTasks().add(sleep);

        study.getUsers().add(saad);
        sleep.getUsers().add(saad);

        taskRepository.save(study);
        taskRepository.save(sleep);

        // Oussama
        oussama.getPosts().add(post3);

        post3.setUser(oussama);

        oussama.getTasks().add(sleep);

        sleep.getUsers().add(oussama);

        taskRepository.save(sleep);

        // save to db
        postRepository.save(post1);
        postRepository.save(post2);
        postRepository.save(post3);

        userRepository.save(abdellah);
        userRepository.save(saad);
        userRepository.save(oussama);

        taskRepository.save(study);
        taskRepository.save(sleep);

        System.out.println("Started in Bootstrap");
        System.out.println("Number of Users: " + userRepository.count());
        System.out.println("Number of Posts: " + postRepository.count());
        System.out.println("Number of Tasks: " + taskRepository.count());
    }
}