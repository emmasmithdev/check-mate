package com.example.codeclan.CheckMate.components;

import com.example.codeclan.CheckMate.models.enums.Reaction;
import com.example.codeclan.CheckMate.models.*;
import com.example.codeclan.CheckMate.models.enums.CheckAsk;
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

    @Autowired
    CheckRepository checkRepository;

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

        post1.addReaction(Reaction.CAT);
        post1.addReaction(Reaction.LOVE);

        postRepository.save(post1);
        postRepository.save(post2);
        postRepository.save(post3);

        Comment comment1 = new Comment(charlie, "Cats are not capable of love.", post1);
        Comment comment2 = new Comment(emma, "Dogs are smelly!", post1);

        commentRepository.save(comment1);
        commentRepository.save(comment2);

        Check check1 = new Check(emma, charlie, CheckAsk.ONE);
        Check check2 = new Check(charlie, greg, CheckAsk.TWO);
        Check check3 = new Check(greg, emma, CheckAsk.THREE);

        checkRepository.save(check1);
        checkRepository.save(check2);
        checkRepository.save(check3);

        group1.addUser(emma);
        group1.addUser(charlie);
        group1.addUser(greg);
        group2.addUser(charlie);
        group3.addUser(emma);
        group3.addUser(greg);
//        emma.addGroup(group1);
//        charlie.addGroup(group1);
//        greg.addGroup(group1);
//        emma.addGroup(group3);
//        charlie.addGroup(group2);
//        greg.addGroup(group3);

    }

}
