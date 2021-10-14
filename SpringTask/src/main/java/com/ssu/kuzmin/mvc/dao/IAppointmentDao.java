package com.ssu.kuzmin.mvc.dao;

import com.ssu.kuzmin.mvc.entities.Appointment;

import java.util.ArrayList;

public interface IAppointmentDao {
    Appointment add(Appointment appointment);
    Appointment update(Appointment appointment) throws Exception;
    void delete(Appointment appointment) throws Exception;
    Appointment getById(int id) throws Exception;
    ArrayList<Appointment> getAll();
}
