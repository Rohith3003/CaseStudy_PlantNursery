package com.cs.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.cs.bean.EndUser;
import com.cs.bean.GardenDecor;
import com.cs.bean.Login;
import com.cs.repository.IEndUserRepository;
import com.cs.repository.IGardenDecorRepository;

/**
 * This class provides Mockito test cases for GardenDecorService.
 * 
 * @author Mayank Kumar(Employee ID: 46191925)
 *
 */
@ExtendWith(SpringExtension.class)
public class GardenDecorSerciveMockitoTest {
	@InjectMocks
	GardenDecorServiceImpl gardenDecorServ;

	@MockBean
	IGardenDecorRepository gardenDecorRepo;

	@MockBean
	IEndUserRepository endUserRepo;

	@BeforeEach
	void init() {
		MockitoAnnotations.openMocks(this);
	}

	@Test
	void addGardenDecor() {
		GardenDecor gd = new GardenDecor(1, "name", "image", 10, "description");
		EndUser endUser = new EndUser();
		Login login = new Login();
		login.setLogin(true);
		endUser.setId(1);
		endUser.setAdmin(true);
		endUser.setLogin(login);
		Mockito.when(endUserRepo.findById(1)).thenReturn(Optional.of(endUser));
		Mockito.when(gardenDecorRepo.save(gd)).thenReturn(gd);
		GardenDecor result = gardenDecorServ.addGardenDecor(1, gd);
		assertEquals(result, gd);
	}

	@Test
	void getGardenDecorById() {
		GardenDecor gd = new GardenDecor(1, "name", "image", 10, "description");
		Mockito.when(gardenDecorRepo.findById(1)).thenReturn(Optional.of(gd));
		GardenDecor result = gardenDecorServ.getGardenDecorById(1);
		assertEquals(1, result.getGardenDecorId());
	}

	@Test
	void getAllGardenDecor() {
		List<GardenDecor> al = new ArrayList<GardenDecor>();
		GardenDecor gd1 = new GardenDecor(1, "name1", "image1", 10, "description1");
		GardenDecor gd2 = new GardenDecor(2, "name2", "image2", 20, "description2");
		GardenDecor gd3 = new GardenDecor(3, "name3", "image3", 30, "description3");
		al.add(gd1);
		al.add(gd2);
		al.add(gd3);
		Mockito.when(gardenDecorRepo.findAll()).thenReturn(al);
		List<GardenDecor> result = gardenDecorServ.getAllGardenDecor();
		assertEquals(3, result.size());
	}

	@Test
	void updateGardenDecorNameById() {
		GardenDecor gd1 = new GardenDecor(1, "name1", "image", 10, "description");
		GardenDecor gd2 = new GardenDecor(1, "name2", "image", 10, "description");
		EndUser endUser = new EndUser();
		Login login = new Login();
		login.setLogin(true);
		endUser.setId(1);
		endUser.setAdmin(true);
		endUser.setLogin(login);
		Mockito.when(endUserRepo.findById(1)).thenReturn(Optional.of(endUser));
		Mockito.when(gardenDecorRepo.findById(1)).thenReturn(Optional.of(gd1));
		Mockito.when(gardenDecorRepo.save(gd1)).thenReturn(gd2);
		GardenDecor result = gardenDecorServ.getGardenDecorById(1);
		assertEquals("name1", result.getGardenDecorName());
		result = gardenDecorServ.updateGardenDecorNameById(1, 1, "name2");
		assertEquals("name2", result.getGardenDecorName());
	}

	@Test
	void updateGardenDecorPriceById() {
		GardenDecor gd1 = new GardenDecor(1, "name", "image", 10, "description");
		GardenDecor gd2 = new GardenDecor(1, "name", "image", 20, "description");
		EndUser endUser = new EndUser();
		Login login = new Login();
		login.setLogin(true);
		endUser.setId(1);
		endUser.setAdmin(true);
		endUser.setLogin(login);
		Mockito.when(endUserRepo.findById(1)).thenReturn(Optional.of(endUser));
		Mockito.when(gardenDecorRepo.findById(1)).thenReturn(Optional.of(gd1));
		Mockito.when(gardenDecorRepo.save(gd1)).thenReturn(gd2);
		GardenDecor result = gardenDecorServ.getGardenDecorById(1);
		assertEquals(10, result.getGardenDecorPrice());
		result = gardenDecorServ.updateGardenDecorPriceById(1, 1, 20);
		assertEquals(20, result.getGardenDecorPrice());
	}

	@Test
	void updateGardenDecorDescriptionById() {
		GardenDecor gd1 = new GardenDecor(1, "name", "image", 10, "description1");
		GardenDecor gd2 = new GardenDecor(1, "name", "image", 10, "description2");
		EndUser endUser = new EndUser();
		Login login = new Login();
		login.setLogin(true);
		endUser.setId(1);
		endUser.setAdmin(true);
		endUser.setLogin(login);
		Mockito.when(endUserRepo.findById(1)).thenReturn(Optional.of(endUser));
		Mockito.when(gardenDecorRepo.findById(1)).thenReturn(Optional.of(gd1));
		Mockito.when(gardenDecorRepo.save(gd1)).thenReturn(gd2);
		GardenDecor result = gardenDecorServ.getGardenDecorById(1);
		assertEquals("description1", result.getGardenDecorDescription());
		result = gardenDecorServ.updateGardenDecorDescriptionById(1, 1, "description2");
		assertEquals("description2", result.getGardenDecorDescription());
	}

	@Test
	void updateGardenDecorImageById() {
		GardenDecor gd1 = new GardenDecor(1, "name", "image1", 10, "description");
		GardenDecor gd2 = new GardenDecor(1, "name", "image2", 10, "description");
		EndUser endUser = new EndUser();
		Login login = new Login();
		login.setLogin(true);
		endUser.setId(1);
		endUser.setAdmin(true);
		endUser.setLogin(login);
		Mockito.when(endUserRepo.findById(1)).thenReturn(Optional.of(endUser));
		Mockito.when(gardenDecorRepo.findById(1)).thenReturn(Optional.of(gd1));
		Mockito.when(gardenDecorRepo.save(gd1)).thenReturn(gd2);
		GardenDecor result = gardenDecorServ.getGardenDecorById(1);
		assertEquals("image1", result.getGardenDecorImage());
		result = gardenDecorServ.updateGardenDecorImageById(1, 1, "image2");
		assertEquals("image2", result.getGardenDecorImage());
	}

	@Test
	void deleteGardenDecorById() {
		GardenDecor gd = new GardenDecor(1, "name", "image", 10, "description");
		EndUser endUser = new EndUser();
		Login login = new Login();
		login.setLogin(true);
		endUser.setId(1);
		endUser.setAdmin(true);
		endUser.setLogin(login);
		Mockito.when(endUserRepo.findById(1)).thenReturn(Optional.of(endUser));
		Mockito.when(gardenDecorRepo.findById(1)).thenReturn(Optional.of(gd));
		Mockito.doNothing().when(gardenDecorRepo).deleteById(1);
		GardenDecor result = gardenDecorServ.deleteGardenDecorById(1, 1);
		assertEquals(result, gd);
	}

}
