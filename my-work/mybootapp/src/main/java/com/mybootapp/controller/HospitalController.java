package com.mybootapp.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.mybootapp.model.Appointment;
import com.mybootapp.model.Doctor;
import com.mybootapp.model.Slot;
import com.mybootapp.repository.AppointmentRepository;
import com.mybootapp.repository.DoctorRepository;
import com.mybootapp.repository.SlotRepository;

@RestController
@CrossOrigin(origins = { "http://localhost:5199/" })
public class HospitalController {
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

	@PostMapping("/slot/{id}")
	public Slot postSlot(@RequestBody Slot slot, @PathVariable("id") Long id) {
		Optional<Doctor> optional = doctorRepository.findById(id);
		if (!optional.isPresent())
			throw new RuntimeException("Invalid Id");
		Doctor d = optional.get();
		slot.setDoctor(d);
		return slotRepository.save(slot);
	}

	@GetMapping("/doctor/all")
	public List<Doctor> getAllDoctors() {
		return doctorRepository.findAll();
	}

	@GetMapping("slot/all")
	public List<Slot> getAllSlots() {
		return slotRepository.findAll();
	}

	@PostMapping("/book/appointment")
	public Appointment bookAppointment(@RequestBody Appointment appointment) {
		return appointmentRepository.save(appointment);
	}

	@GetMapping("/doctor/one/{id}")
	public Doctor getDoctorById(@PathVariable("id") Long id) {
		Optional<Doctor> optional = doctorRepository.findById(id);

		if (!optional.isPresent())
			throw new RuntimeException("Invalid ID");
		Doctor d = optional.get();
		return d;
	}

	@GetMapping("/slot/one/{id}")
	public Slot getSlotById(@PathVariable("id") Long id) {
		Optional<Slot> optional = slotRepository.findById(id);

		if (!optional.isPresent())
			throw new RuntimeException("Invalid ID");
		Slot s = optional.get();
		return s;
	}
	
	@GetMapping("/appointments/all")
	public List<Appointment> getAllDetails() {
		return appointmentRepository.findAll();
	}

}
