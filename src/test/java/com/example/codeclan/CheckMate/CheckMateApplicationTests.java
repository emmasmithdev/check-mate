package com.example.codeclan.CheckMate;

import com.example.codeclan.CheckMate.repositories.CommentRepository;
import com.example.codeclan.CheckMate.repositories.GroupRepository;
import com.example.codeclan.CheckMate.repositories.PostRepository;
import com.example.codeclan.CheckMate.repositories.UserRepository;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
class CheckMateApplicationTests {

	@Autowired
	UserRepository userRepository;

	@Autowired
	PostRepository postRepository;

	@Autowired
	GroupRepository groupRepository;

	@Autowired
	CommentRepository commentRepository;


	@Test
	void contextLoads() {
	}

	@Test
	public void canCreateAndSavePost(){

	}


}
