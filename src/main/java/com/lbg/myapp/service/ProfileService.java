package com.lbg.myapp.service;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.lbg.myapp.domain.Profile;
import com.lbg.myapp.repo.ProfileRepo;

@Service
public class ProfileService {

	private ProfileRepo repo;

	public ProfileService(ProfileRepo repo) {
		super();
		this.repo = repo;
	}

	public ResponseEntity<Profile> createProfile(Profile newProfile) {
		Profile created = this.repo.save(newProfile);
		return new ResponseEntity<Profile>(created, HttpStatus.CREATED);
	}

	public List<Profile> getProfile() {
		return this.repo.findAll();
	}

	public ResponseEntity<Profile> getProfile(int id) {
		Optional<Profile> found = this.repo.findById(id);

		if (found.isEmpty()) {
			return new ResponseEntity<Profile>(HttpStatus.NOT_FOUND);
		}
		Profile body = found.get();
		return ResponseEntity.ok(body);
	}

}
