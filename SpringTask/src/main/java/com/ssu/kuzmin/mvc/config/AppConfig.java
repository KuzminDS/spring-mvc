package com.ssu.kuzmin.mvc.config;

import com.ssu.kuzmin.mvc.dao.IAppointmentDao;
import com.ssu.kuzmin.mvc.dao.IDoctorDao;
import com.ssu.kuzmin.mvc.dao.IUserDao;
import com.ssu.kuzmin.mvc.dao.fake.AppointmentDao;
import com.ssu.kuzmin.mvc.dao.fake.DoctorDao;
import com.ssu.kuzmin.mvc.dao.fake.UserDao;
import com.ssu.kuzmin.mvc.services.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan
public class AppConfig {
    @Bean
    public IUserDao userDao() {
        return new UserDao();
    }
    @Bean
    public IDoctorDao doctorDao() {
        return new DoctorDao();
    }
    @Bean
    public IAppointmentDao appointmentDao() {
        return new AppointmentDao();
    }
    @Bean
    public IDoctorService doctorService() {
        return new DoctorService();
    }
    @Bean
    public IAppointmentService appointmentService() {
        return new AppointmentService();
    }
    @Bean
    public IUserService userService() {
        return new UserService();
    }
}
