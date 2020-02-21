package com.example.codeclan.CheckMate.components;

import com.example.codeclan.CheckMate.models.Comment;
import com.example.codeclan.CheckMate.models.Group;
import com.example.codeclan.CheckMate.models.Post;
import com.example.codeclan.CheckMate.models.User;
import com.example.codeclan.CheckMate.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements ApplicationRunner {

    @Autowired
    CommentRepository commentRepository;

    @Autowired
    GroupRepository groupRepository;

    @Autowired
    PostRepository postRepository;

    @Autowired
    UserRepository userRepository;

    public DataLoader() {
    }

    public void run(ApplicationArguments args) {

        User emma = new User("Emma Smith", "emzo11", "thereisnospoon", "picture", "happy");
        User charlie = new User("Charlie Anderson", "charlieboy", "dogsruleok", "picture", "happy");
        User greg = new User("Greg Shanks", "parasitefan4eva", "rosebud", "picture", "happy");

        userRepository.save(emma);
        userRepository.save(charlie);
        userRepository.save(greg);

        Group group1 = new Group("All");
        Group group2 = new Group("Dog Lovers");
        Group group3 = new Group("Cat Lovers");
        Group group4 = new Group("Film Geeks");
        groupRepository.save(group1);
        groupRepository.save(group2);
        groupRepository.save(group3);
        groupRepository.save(group4);

        Post post1 = new Post(emma, "Cats are better than dogs!", group1);
        Post post2 = new Post(charlie, "Dogs are better than cats!", group1);
        Post post3 = new Post(greg, "Parasite is the best movie of the last decade!", group1);

        postRepository.save(post1);
        postRepository.save(post2);
        postRepository.save(post3);

        Comment comment1 = new Comment(charlie, "Cats are not capable of love.", post1);
        Comment comment2 = new Comment(emma, "Dogs are smelly!", post1);

        commentRepository.save(comment1);
        commentRepository.save(comment2);

    }

}
