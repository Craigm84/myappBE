package com.lbg.myapp.rest;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lbg.myapp.domain.Profile;
import com.lbg.myapp.service.ProfileService;

@RequestMapping("profile/")
@RestController
@CrossOrigin
public class ProfileController {

	private ProfileService service;

	public ProfileController(ProfileService service) {
		super();
		this.service = service;
	}

	@PostMapping("/create")
	public ResponseEntity<Profile> createProfile(@RequestBody Profile newProfile) {
		return this.service.createProfile(newProfile);
	}

	@GetMapping("/get")
	public List<Profile> getProfile() {
		return this.service.getProfile();
	}

	@GetMapping("/get/{id}")
	public ResponseEntity<Profile> getProfile(@PathVariable int id) {
		return this.service.getProfile(id);
	}

}
