package com.ssu.kuzmin.mvc.dao;


import com.ssu.kuzmin.mvc.entities.Doctor;

import java.util.List;

public interface IDoctorDao {
    Doctor add(Doctor doctor);
    Doctor update(Doctor doctor) throws Exception;
    void delete(Doctor doctor) throws Exception;
    Doctor getById(int id) throws Exception;
    List<Doctor> getAll();
}
