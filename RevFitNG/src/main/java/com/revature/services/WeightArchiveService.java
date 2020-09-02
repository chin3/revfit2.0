package com.revature.services;

import java.util.List;

import com.revature.beans.WeightArchive;

public interface WeightArchiveService {
	public WeightArchive addWeightArchive(WeightArchive w);
	public WeightArchive getWeightArchive(int id);
	public List<WeightArchive> getWeightArchiveByUser(int id);
	public List<WeightArchive> getAllWeightArchives();
	public WeightArchive updateWeightArchive(WeightArchive change);
	public boolean deleteWeightArchive(WeightArchive w);
}
