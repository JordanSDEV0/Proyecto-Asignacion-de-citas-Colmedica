package com.eps.Appointments.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.eps.Appointments.DTOs.SchedulingDTO;
import com.eps.Appointments.DTOs.AppointmentDTO;
import com.eps.Appointments.DTOs.DateDTO;
import com.eps.Appointments.mappers.SchedulingMapper;

@Service
public class SchedulingService{

  @Autowired
  private SchedulingMapper schedulingMapper;
  @Autowired
  private AppointmentService appointmentService;
  @Autowired
  private DateService dateService;

  @Transactional
  public SchedulingDTO create(SchedulingDTO scheduling){
      DateDTO dateDTO= dateService.create(schedulingMapper.toDateDto(scheduling));
      if(dateDTO != null){
          scheduling.setDateId(dateDTO.getId());
          AppointmentDTO appointmentDTO= appointmentService.create(schedulingMapper.toAppointmentDTO(scheduling));
          if(appointmentDTO != null){
            return scheduling;
          }
          return null;
      }
      return null;    
  }
  
}
