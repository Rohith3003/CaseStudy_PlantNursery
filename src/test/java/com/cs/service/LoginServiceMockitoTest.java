package com.cs.service;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.cs.bean.Login;
import com.cs.dto.LoginDto;
import com.cs.repository.ILoginRepository;

/** 
 * <h2> Login Service Mockito Test </h2> 
 * This class provides basic Mockito test cases for
 * LoginService.
 *    
 * @author SatyamMishra(EmpId - 46191989) 
 * @version 1.0 
 * @since 2022-03-27 
 */

@ExtendWith(SpringExtension.class)
class LoginServiceMockitoTest {
	// @InjectMock - Creates instance of a class and injects mocks that are created
	// with @Mock

	@InjectMocks
	LoginServiceImpl loginServ;

	// @MockBean - Creates Mock of a class or interface

	@MockBean
	ILoginRepository loginRepo;

	// Initialization of mock objects
	@BeforeEach
	void init() {
		MockitoAnnotations.openMocks(this);
	}


	@Test
	void loginNetwork() {
		Login testLogin = new Login("satyamkkh@yahoo.com", "password", false);
		Login login = new Login("satyamkkh@yahoo.com", "password", false);
		Login loginAfter = new Login("satyamkkh@yahoo.com", "password", true);

		Mockito.when(loginRepo.findById(testLogin.getEmail())).thenReturn(Optional.of(login));
		Mockito.when(loginRepo.save(testLogin)).thenReturn(loginAfter);

		LoginDto testLoginDto = loginServ.loginNetwork(testLogin);
		assertNotEquals(null, testLoginDto);
		assertEquals("satyamkkh@yahoo.com", testLoginDto.getEmail());
		assertEquals(true, testLoginDto.isLogin());
	}

	@Test
	void logoutNetwork() {
		Login testLogin = new Login("satyamkkh@yahoo.com", "password", false);
		Login logout = new Login("satyamkkh@yahoo.com", "password", true);
		Login logoutAfter = new Login("satyamkkh@yahoo.com", "password", false);

		Mockito.when(loginRepo.findById(testLogin.getEmail())).thenReturn(Optional.of(logout));
		Mockito.when(loginRepo.save(testLogin)).thenReturn(logoutAfter);

		LoginDto testLoginDto = loginServ.logoutNetwork(testLogin.getEmail());
		assertNotEquals(null, testLoginDto);
		assertEquals("satyamkkh@yahoo.com", testLoginDto.getEmail());
		assertEquals(false, testLoginDto.isLogin());
	}

	@Test
	void resetPass() {
		Login testLogin = new Login("satyamkkh@yahoo.com", "password", false);
		Login loginReset = new Login("satyamkkh@yahoo.com", "password", false);

		Mockito.when(loginRepo.findById(testLogin.getEmail())).thenReturn(Optional.of(loginReset));

		String mssg = loginServ.resetPassword(testLogin.getEmail());
		assertNotEquals(null, mssg);
		assertEquals("Password reset to 12345678. Please change your password as soon as possible!", mssg);
	}

	@Test
	void forgotPass() {
		Login loginForgot = new Login("satyamkkh@gmail.com", "password", false);

		Mockito.when(loginRepo.findById("satyamkkh@yahoo.com")).thenReturn(Optional.of(loginForgot));

		String mssg = loginServ.forgotPassword("satyamkkh@yahoo.com");
		assertNotEquals(null, mssg);
		assertEquals("Password reset to 12345678. Please change your password as soon as possible!", mssg);
	}

	@Test
	void changePass() {
		Login testLogin = new Login("satyamkkh@yahoo.com", "password", false);
		Login loginOutput = new Login("satyamkkh@yahoo.com", "password1", false);

		Mockito.when(loginRepo.findById(testLogin.getEmail())).thenReturn(Optional.of(testLogin));
		Mockito.when(loginRepo.save(testLogin)).thenReturn(loginOutput);

		LoginDto testLoginPass = loginServ.changePassword(testLogin, "password1");
		assertNotEquals(null, testLoginPass);
		assertEquals("satyamkkh@yahoo.com", testLoginPass.getEmail());
	}
}