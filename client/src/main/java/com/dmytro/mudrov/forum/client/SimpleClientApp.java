package com.dmytro.mudrov.forum.client;

import static com.dmytro.mudrov.forum.client.utils.Utils.getCreateCommentDTO;
import static com.dmytro.mudrov.forum.client.utils.Utils.getCreateThemeDTO;
import static com.dmytro.mudrov.forum.client.utils.Utils.getRemoveCommentDTO;
import static com.dmytro.mudrov.forum.client.utils.Utils.getRemoveThemeDTO;
import static com.dmytro.mudrov.forum.client.utils.Utils.getUserDTO;

import com.dmytro.mudrov.forum.dto.comment.CreateCommentResponseDTO;
import com.dmytro.mudrov.forum.dto.theme.CreateThemeResponseDTO;
import com.dmytro.mudrov.forum.dto.user.UserResponseDTO;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class SimpleClientApp {

    private static final int ROUNDS = 1_000;

    public static void main(String[] args) throws IOException {
        ForumClient forumClient = new ForumClient("localhost", 9999);

        UserResponseDTO user = testCreateUser(forumClient);

        List<Long> themes = new ArrayList<>(ROUNDS);
        CreateThemeResponseDTO theme = testCreateTheme(forumClient, user, themes);

        List<Long> comments = new ArrayList<>(ROUNDS);
        testCreateComment(forumClient, user, theme, comments);

        testRemoveComment(forumClient, user, comments);

        testRemoveTheme(forumClient, user, themes);
    }

    private static void testRemoveTheme(ForumClient forumClient, UserResponseDTO user, List<Long> themes) throws IOException {
        long start = System.currentTimeMillis();
        for (Long theme : themes) {
            forumClient.removeTheme(getRemoveThemeDTO(theme, user.getId()));
        }
        long end = System.currentTimeMillis();
        System.out.println("Remove comment time (ms): " + (end - start) / ROUNDS);
    }

    private static void testRemoveComment(ForumClient forumClient, UserResponseDTO user, List<Long> comments) throws IOException {
        long start = System.currentTimeMillis();
        for (Long comment : comments) {
            forumClient.removeComment(getRemoveCommentDTO(comment, user.getId()));
        }
        long end = System.currentTimeMillis();
        System.out.println("Remove comment time (ms): " + (end - start) / ROUNDS);
    }

    private static void testCreateComment(ForumClient forumClient, UserResponseDTO user, CreateThemeResponseDTO theme,
                                          List<Long> comments) throws IOException {
        long start = System.currentTimeMillis();
        for (int i = 0; i < ROUNDS; ++i) {
            CreateCommentResponseDTO comment = forumClient.createComment(getCreateCommentDTO("c.name", "c.description", theme.getId(), user.getId()));
            comments.add(comment.getId());
        }
        long end = System.currentTimeMillis();
        System.out.println("Create comment time (ms): " + (end - start) / ROUNDS);
    }

    private static CreateThemeResponseDTO testCreateTheme(ForumClient forumClient, UserResponseDTO user, List<Long> themes) throws IOException {
        CreateThemeResponseDTO theme = null;
        long start = System.currentTimeMillis();
        for (int i = 0; i < ROUNDS; ++i) {
            theme = forumClient.createTheme(getCreateThemeDTO("t.name", "t.description", user.getId()));
            themes.add(theme.getId());
        }
        long end = System.currentTimeMillis();
        System.out.println("Create theme time (ms): " + (end - start) / ROUNDS);
        return theme;
    }

    private static UserResponseDTO testCreateUser(ForumClient forumClient) throws IOException {
        UserResponseDTO user = null;
        long start = System.currentTimeMillis();
        for (int i = 0; i < ROUNDS; ++i) {
            user = forumClient.createUser(getUserDTO(UUID.randomUUID().toString(), "surname", "email", "pwd", 100));
        }
        long end = System.currentTimeMillis();
        System.out.println("Create user time (ms): " + (end - start) / ROUNDS);
        return user;
    }

}
