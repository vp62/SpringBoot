package com.villain.location.service;

import java.util.List;

import com.villain.location.entities.Location;

public interface LocaionService {
Location saveLocation(Location loc);
Location updateLocation(Location loc);
void deleteLocation(int id);
List<Location> getAllLoc();


}
