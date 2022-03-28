package com.cs.service;
import java.util.List;
//import org.springframework.stereotype.Service;



import com.cs.bean.Seed;



public interface ISeedService {
	    //Add new Seed
		 public Seed addSeed(Seed seed);
		
		//Update Seed information
		 public Seed updateSeedPrice(int id,double price);
		
		//Get Seed by Id
		 public Seed getSeedById(int id);
		
		//Get Seed by name
		 public Seed getSeedByName(String name);
		
		//delete Seed by Id
		 Seed deleteSeedById(int id);
		void deleteSeed(int id);
		 
		//Update seed location
		public Seed updateSeedPhoto(int id, String photoLoc);
		
		//Get all seeds
		public List<Seed> getAllSeeds();

	
}
