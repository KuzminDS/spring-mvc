package com.ssu.kuzmin.mvc.dao.fake;


import com.ssu.kuzmin.mvc.dao.IDoctorDao;
import com.ssu.kuzmin.mvc.entities.Doctor;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DoctorDao implements IDoctorDao {
    private static Map<Integer, Doctor> doctors;

    static {
        doctors = new HashMap<>();
        doctors.put(1, new Doctor(1, "Иванов", "Иван", "Иванович", "doctor1@hosp.com", "123", "doctor1", Doctor.Position.Dentist));
        doctors.put(2, new Doctor(2, "Василий", "Васильев", "Васильевич", "doctor2@hosp.com", "321", "doctor2", Doctor.Position.Therapist));
    }

    @Override
    public Doctor add(Doctor doctor) {
        int id = doctors.keySet().stream().mapToInt(v -> v).max().getAsInt() + 1;
        doctor.setId(id);
        doctors.put(id, doctor);
        return doctor;
    }

    @Override
    public Doctor update(Doctor doctor) throws Exception {
        if (!doctors.containsKey(doctor.getId())) {
            throw new Exception("Doctor with id " + doctor.getId() + " does not exist");
        }
        doctors.replace(doctor.getId(), doctor);
        return doctor;
    }

    @Override
    public void delete(Doctor doctor) throws Exception {
        if (!doctors.containsKey(doctor.getId())) {
            throw new Exception("Doctor with id " + doctor.getId() + " does not exist");
        }
        doctors.remove(doctor.getId());
    }

    @Override
    public Doctor getById(int id) throws Exception {
        if (!doctors.containsKey(id)) {
            throw new Exception("Doctor with id " + id + " does not exist");
        }
        return doctors.get(id);
    }

    @Override
    public List<Doctor> getAll() {
        return new ArrayList<>(doctors.values());
    }
}
