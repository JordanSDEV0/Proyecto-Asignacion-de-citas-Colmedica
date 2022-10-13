package com.eps.Appointments.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.eps.Appointments.DTOs.SchedulingDTO;
import com.eps.Appointments.DTOs.AppointmentDTO;
import com.eps.Appointments.DTOs.DateDTO;
import com.eps.Appointments.mappers.SchedulingMapper;
import com.eps.Appointments.mappers.AppointmentMapper;
import com.eps.Appointments.mappers.DateMapper;
import com.eps.Appointments.persistance.entities.Appointment;
import com.eps.Appointments.persistance.entities.Date;
import com.eps.Appointments.persistance.repositories.AppointmentRepository;
import com.eps.Appointments.persistance.repositories.DateRepository;

@Service
public class AppointmentService{

  @Autowired
  private SchedulingMapper schedulingMapper;
  @Autowired
  private AppointmentService appointmentService;
  @Autowired
  private DateService dateService;

  @Transactional
  private SchedulingDTO create(SchedulingDTO scheduling){
      DateDTO dateDTO= dateService.create(schedulingMapper.toDateDTO(sheduling));
      if(dateDTO != null){
          AppointmentDTO appointmentDTO= appointmentService.create(shedulingMapper.toAppointmentDTO(scheduling));
          if(appointmentDTO != null){
            return scheduling;
          }
          return null;
      }
      return null;    
  }
  
}
