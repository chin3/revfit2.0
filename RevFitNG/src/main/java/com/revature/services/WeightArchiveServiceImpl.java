package com.revature.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.beans.WeightArchive;
import com.revature.repositories.WeightArchiveRepository;

@Service
public class WeightArchiveServiceImpl implements WeightArchiveService {

	@Autowired
	WeightArchiveRepository war;
	
	@Override
	public WeightArchive addWeightArchive(WeightArchive w) {
		return war.save(w);
	}

	@Override
	public WeightArchive getWeightArchive(int id) {
		return war.findById(id).get();
	}

	@Override
	public List<WeightArchive> getWeightArchiveByUser(int id) {
		List<WeightArchive> archives = (List<WeightArchive>) war.findAll();
		List<WeightArchive> userArchives = new ArrayList<WeightArchive>();
		
		for(WeightArchive wa : archives) {
			if(wa.getUser().getId() == id) {
				userArchives.add(wa);
			}
		}
		
		return userArchives;
	}

	@Override
	public List<WeightArchive> getAllWeightArchives() {
		return (List<WeightArchive>) war.findAll();
	}

	@Override
	public WeightArchive updateWeightArchive(WeightArchive change) {
		return war.save(change);
	}

	@Override
	public boolean deleteWeightArchive(WeightArchive w) {
		try {
			war.delete(w);
			return true;
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
			return false;
		}
	}

}
