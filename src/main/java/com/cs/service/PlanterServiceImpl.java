package com.cs.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.cs.bean.EndUser;
import com.cs.bean.Planter;
import com.cs.dto.PlanterDto;
import com.cs.exception.PlanterNotFoundException;
import com.cs.repository.IEndUserRepository;
import com.cs.repository.IPlanterRepository;

/**
 * Planter service implementation class used by PlanterController
 * to interact with database.
 * @author Hemanth
 *
 */
@Service
public class PlanterServiceImpl implements IPlanterService {
	@Autowired
	IPlanterRepository planterRepo;
	@Autowired
	IEndUserRepository endUserRepo;

	@Override
	public Planter addPlanter(Planter planter, int userId) {
		Optional<EndUser> endUser = endUserRepo.findById(userId);
		if(!endUser.isPresent())
		{
			throw new PlanterNotFoundException("admin not found with the given id:" + userId);
		}
		else if(!endUser.get().isAdmin())
		{
			throw new PlanterNotFoundException("only admin can add planter to the database");
		}
		else
		{
		return planterRepo.save(planter);
		}
	}


	@Override
	public Planter getPlanterById(int id) {
		Optional<Planter> planter=planterRepo.findById(id);
		if(!planter.isPresent())
			throw new PlanterNotFoundException("Planter not found with id: "+id);
		return planter.get();
	}

	@Override
	public Planter getPlanterByName(String name) {

		Planter returned_planter=planterRepo.getByName(name);
		if(returned_planter==null)
			throw new PlanterNotFoundException("Planter with name: "+name+" not found");
		return returned_planter;
	}

	@Override
	public Planter deletePlanterById(int id, int userId) {
		Optional<EndUser> endUser = endUserRepo.findById(userId);
		if(!endUser.isPresent())
		{
			throw new PlanterNotFoundException("admin not found with the given id:" + userId);
		}
		else if(!endUser.get().isAdmin())
		{
			throw new PlanterNotFoundException("only admin can add planter to the database");
		}
		else if(!endUser.get().getLogin().isLogin())
		{
			throw new PlanterNotFoundException("first login to add planter to the database");
		}
		else
		{
		// Fetch the existing record from database
		Optional<Planter> planter=planterRepo.findById(id);
		if(!planter.isPresent())
			throw new PlanterNotFoundException("Planter not found with id: "+id);
		//Use JPARepository method
		planterRepo.delete(planter.get());
		return planter.get();
		}
	}

	@Override
	public Planter updatePlanterPrice(int id, float price, int userId) {
		Optional<EndUser> endUser = endUserRepo.findById(userId);
		if(!endUser.isPresent())
		{
			throw new PlanterNotFoundException("admin not found with the given id:" + userId);
		}
		else if(!endUser.get().isAdmin())
		{
			throw new PlanterNotFoundException("only admin can add planter to the database");
		}
		else if(!endUser.get().getLogin().isLogin())
		{
			throw new PlanterNotFoundException("first login to add planter to the database");
		}
		else
		{
			Optional<Planter> planter=planterRepo.findById(id);
			if(!planter.isPresent())
				throw new PlanterNotFoundException("Planter not found with id: "+id);
			Planter updatedPlanter=planter.get();
			updatedPlanter.setPrice(price);
			return planterRepo.save(updatedPlanter);
		}
	}

	@Override
	public List<PlanterDto> getAllPlanters() {
		// Fetches all the planter records from DB
		List<PlanterDto> planters=new ArrayList<>();
		planterRepo.findAll().forEach(planter->{
			PlanterDto planterDto=new PlanterDto(planter.getName(),planter.getPhotoLoc(),planter.getPrice());
			planters.add(planterDto);
		});
		return planters;
	}

	@Override
	public Planter updatePlanterPhoto(int planterId,String photoLoc, int userId) {
		Optional<EndUser> endUser = endUserRepo.findById(userId);
		if(!endUser.isPresent())
		{
			throw new PlanterNotFoundException("admin not found with the given id:" + userId);
		}
		else if(!endUser.get().isAdmin())
		{
			throw new PlanterNotFoundException("only admin can add planter to the database");
		}
		else if(!endUser.get().getLogin().isLogin())
		{
			throw new PlanterNotFoundException("first login to add planter to the database");
		}
		else
		{
			Optional<Planter> planter=planterRepo.findById(planterId);
			if(!planter.isPresent())
				throw new PlanterNotFoundException("Planter not found with id: "+planterId);
			Planter updatedPlanter=planter.get();
			updatedPlanter.setPhotoLoc(photoLoc);
			return planterRepo.save(updatedPlanter);
		}
	}

	@Override
	public Planter deletePlanterByName(String name, int userId) {
		//Delete record by matching name
		Optional<EndUser> endUser = endUserRepo.findById(userId);
		if(!endUser.isPresent())
		{
			throw new PlanterNotFoundException("admin not found with the given id:" + userId);
		}
		else if(!endUser.get().isAdmin())
		{
			throw new PlanterNotFoundException("only admin can add planter to the database");
		}
		else if(!endUser.get().getLogin().isLogin())
		{
			throw new PlanterNotFoundException("first login to add planter to the database");
		}
		else
		{
		Planter returned_planter=planterRepo.getByName(name);
		if(returned_planter==null)
			throw new PlanterNotFoundException("Planter with name: "+name+" not found");
		return returned_planter;
		}
	}

	@Override
	public Planter updatePlanterPrice(String name,float price, int userId) {
		Optional<EndUser> endUser = endUserRepo.findById(userId);
		if(!endUser.isPresent())
		{
			throw new PlanterNotFoundException("admin not found with the given id:" + userId);
		}
		else if(!endUser.get().isAdmin())
		{
			throw new PlanterNotFoundException("only admin can add planter to the database");
		}
		else if(!endUser.get().getLogin().isLogin())
		{
			throw new PlanterNotFoundException("first login to add planter to the database");
		}
		else
		{
			Planter returned_planter=planterRepo.getByName(name);
			if(returned_planter==null)
				throw new PlanterNotFoundException("Planter with name: "+name+" not found");
			returned_planter.setPrice(price);
			return planterRepo.save(returned_planter);
		}
	}

	@Override
	public List<PlanterDto> getPlantersByCustomerId(int customerId) {
		// TODO Auto-generated method stub
		List<PlanterDto> planters=new ArrayList<>();
		planterRepo.getPlantersByCustomerId(customerId).forEach(planter->{
			PlanterDto planterDto=new PlanterDto(planter.getName(),planter.getPhotoLoc(),planter.getPrice());
			planters.add(planterDto);
		});
		return planters;
	}

	@Override
	public List<PlanterDto> getAllPlantersInSortingOrder(String field) {
		// TODO Auto-generated method stub
		List<PlanterDto> planters=new ArrayList<>();
		planterRepo.findAll(Sort.by(Direction.ASC, field)).forEach(planter->{
			PlanterDto planterDto=new PlanterDto(planter.getName(),planter.getPhotoLoc(),planter.getPrice());
			planters.add(planterDto);
		});
		return planters;
	}

	@Override
	public Page<Planter> getAllPlantersWithPagination(int offset, int pageSize) {
		// TODO Auto-generated method stub
//		List<PlanterDto> planters=new ArrayList<>();
//		planterRepo.findAll(PageRequest.of(pageSize, pageSize)).forEach(planter->{
//			PlanterDto planterDto=new PlanterDto(planter.getName(),planter.getPhotoLoc(),planter.getPrice());
//			planters.add(planterDto);
//		});
		return planterRepo.findAll(PageRequest.of(offset, pageSize));
	}
	
	
}
