package com.addon.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.addon.model.AddOn;


@Repository
public interface IAddOnRepositoryt extends JpaRepository<AddOn, Long> {
	public List<AddOn> findByFeatureName(String name);
	public List<AddOn> findByCost(String cost);
}
