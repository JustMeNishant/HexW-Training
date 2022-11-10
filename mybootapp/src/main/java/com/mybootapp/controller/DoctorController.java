package com.mybootapp.controller;

import java.util.List;
import java.util.Optional;

import org.aspectj.weaver.patterns.ConcreteCflowPointcut.Slot;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.mybootapp.model.Appointment;
import com.mybootapp.model.Doctor;
import com.mybootapp.model.Slots;
import com.mybootapp.repository.AppointmentRepository;
import com.mybootapp.repository.DoctorRepository;
import com.mybootapp.repository.SlotRepository;

@RestController
@CrossOrigin(origins = {"http://localhost:4201"})

public class DoctorController {

	@Autowired
	private DoctorRepository doctorRepository; 
	@Autowired
	private SlotRepository slotRepository; 
	@Autowired
	private AppointmentRepository appointmentRepository;
	@PostMapping("/doctor")
	public Doctor postDoctor(@RequestBody Doctor doctor) {
		return doctorRepository.save(doctor);
	}
	
	@PostMapping("/slot/{did}")
	public Slots postSlot(@RequestBody Slots slot, @PathVariable("did") Long did) {
		Optional<Doctor> optional  = doctorRepository.findById(did);
		
		if(!optional.isPresent())
			throw new RuntimeException("ID is Invalid");	
		
		Doctor d = optional.get();
		slot.setDoctor(d);
		
		return slotRepository.save(slot);
	}
	
	@GetMapping("/doctor/all")
	public List<Doctor> getAllDoctors(){
		return doctorRepository.findAll();
	}
	
	@GetMapping("/slots/all")
	public List<Slots> getAllSlots(){
		return slotRepository.findAll();
	}
	
	@PostMapping("/book/appointment")
	public Appointment insertAppointment(@RequestBody Appointment appointment) {
		return appointmentRepository.save(appointment);
	}
	
	@GetMapping("/doctor/{id}")
	public Doctor getDoctorById(@PathVariable("id") Long id) {
		Optional<Doctor> optional  = doctorRepository.findById(id);
		if(!optional.isPresent())
			throw new RuntimeException("ID is Invalid");	
		
		Doctor d = optional.get();
		return d; 
	}
	
	@GetMapping("/slot/{id}")
	public Slots getSlotById(@PathVariable("id") Long id) {
		Optional<Slots> optional = slotRepository.findById(id);
		if(!optional.isPresent())
			throw new RuntimeException("ID is Invalid");
		Slots s = optional.get();
		return s; 
	}
}
