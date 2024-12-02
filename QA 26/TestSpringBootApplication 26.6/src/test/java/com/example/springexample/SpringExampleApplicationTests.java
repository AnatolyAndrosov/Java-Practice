package com.example.springexample;

import com.example.springexample.entity.Author;
import com.example.springexample.entity.Comment;
import com.example.springexample.repositories.AuthorRepository;
import com.example.springexample.repositories.CommentRepository;
import liquibase.util.StringClauses;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.testcontainers.containers.PostgreSQLContainer;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class SpringExampleApplicationTests {

    @LocalServerPort
    private Integer port;
    @Autowired
    private CommentRepository commentRepository;
    @Autowired
    private AuthorRepository authorRepository;
    private TestRestTemplate template = new TestRestTemplate();
    private static PostgreSQLContainer<?> postgres =
            new PostgreSQLContainer<>("postgres:14");

    @BeforeAll
    public static void beforeAll() {
        postgres.start();
    }

    @AfterAll
    public static void afterAll() {
        postgres.stop();
    }

    @DynamicPropertySource
    public static void configureProperties(DynamicPropertyRegistry registry) {
        registry.add("spring.datasource.url", postgres::getJdbcUrl);
        registry.add("spring.datasource.username", postgres::getUsername);
        registry.add("spring.datasource.password", postgres::getPassword);
    }

    @BeforeEach
    private void fillingDatabase() {
        Comment comment = new Comment();
        comment.setText("Комментарий");
        comment.setAuthor(authorRepository.save(new Author()));
        commentRepository.save(comment);
    }

    @AfterEach
    public void clearDatabase() {
        authorRepository.deleteAll();
    }
}
