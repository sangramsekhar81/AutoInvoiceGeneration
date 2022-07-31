package com.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.dto.IfscDto;
import com.spring.service.IfscService;

@RestController
@CrossOrigin("*")
public class IfscController {
	
	@Autowired
	private IfscService ifscService;
	
	 @GetMapping("/ifsclist")
	   public ResponseEntity<List<IfscDto>> list() {
	      List<IfscDto> ifsc = ifscService.getIfsc();
	      return ResponseEntity.ok().body(ifsc);
	   }

}
