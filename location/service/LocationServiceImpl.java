package com.villain.location.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.villain.location.entities.Location;
import com.villain.location.repo.LocationRepo;
@Service
public class LocationServiceImpl implements LocaionService {
@Autowired
private LocationRepo repo;

	@Override
	public Location saveLocation(Location loc) {
		return repo.save(loc);
	}

	@Override
	public Location updateLocation(Location loc) {
		return repo.save(loc);
	}

	@Override
	public void deleteLocation(int id) {
	repo.deleteById(id);	
	}

	@Override
	public List<Location> getAllLoc() {
		
		return repo.findAll();
	}
	public Location getLocationById(int id) {
		return repo.findById(id).get();
	}
//	public List<Object[]> getT()
//	{
//return repo.findTypeAndCount();
//}
}