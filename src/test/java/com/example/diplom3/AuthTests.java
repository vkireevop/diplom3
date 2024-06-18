package com.example.diplom3;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;
import static org.mockito.Mockito.when;

import java.util.Optional;

import com.example.diplom3.model.Role;
import com.example.diplom3.model.User;
import com.example.diplom3.repository.UserRepository;
import com.example.diplom3.security.UserService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.test.context.support.WithMockUser;

@RunWith(MockitoJUnitRunner.class)
public class AuthTests {

    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private UserService userService;

    private User testUser;

    @Before
    public void setUp() {
        // Инициализация тестовых данных
        testUser = new User();
        testUser.setUsername("testUser");
        testUser.setEmail("testUser@example.com");
        testUser.setRole(Role.ROLE_USER);

        // Моки для методов репозитория
        when(userRepository.save(testUser)).thenReturn(testUser);
        when(userRepository.findByUsername(testUser.getUsername())).thenReturn(Optional.of(testUser));
    }

    @Test
    public void testSave() {
        // Мок для метода save
        when(userRepository.save(testUser)).thenReturn(testUser);

        User savedUser = userService.save(testUser);
        assertEquals(testUser, savedUser);
    }

    @Test
    public void testCreate() {
        // Моки для методов existsByUsername и existsByEmail
        when(userRepository.existsByUsername(testUser.getUsername())).thenReturn(false);
        when(userRepository.existsByEmail(testUser.getEmail())).thenReturn(false);

        User createdUser = userService.create(testUser);
        assertEquals(testUser, createdUser);
    }

    @Test
    public void testGetByUsername() {
        // Мок для метода findByUsername
        when(userRepository.findByUsername(testUser.getUsername())).thenReturn(Optional.of(testUser));

        User user = userService.getByUsername(testUser.getUsername());
        assertEquals(testUser.getUsername(), user.getUsername());
    }

    @Test
    public void testGetByUsernameNotFound() {
        // Мок для метода findByUsername, когда пользователь не найден
        when(userRepository.findByUsername("nonExistentUser")).thenReturn(Optional.empty());

        assertThrows(UsernameNotFoundException.class, () -> userService.getByUsername("nonExistentUser"));
    }
    @Test
    @WithMockUser(username = "testUser")
    public void testGetCurrentUser() {
        // Мок для метода findByUsername
        when(userRepository.findByUsername(testUser.getUsername())).thenReturn(Optional.of(testUser));

        User currentUser = userService.getCurrentUser();
        assertEquals(testUser.getUsername(), currentUser.getUsername());
    }

    @Test
    @WithMockUser(username = "testUser", roles = "ADMIN")
    public void testGetAdmin() {
        // Моки для методов existsByUsername и existsByEmail
        when(userRepository.existsByUsername(testUser.getUsername())).thenReturn(false);
        when(userRepository.existsByEmail(testUser.getEmail())).thenReturn(false);

        // Мок для метода save
        when(userRepository.save(testUser)).thenReturn(testUser);

        userService.getAdmin();
        User adminUser = userService.getCurrentUser();
        assertEquals(Role.ROLE_ADMIN, adminUser.getRole());
    }

}