package com.lbg.myapp.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lbg.myapp.domain.Profile;

public interface ProfileRepo extends JpaRepository<Profile, Integer> {

}
