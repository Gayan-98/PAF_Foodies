package com.senmash.postservice.service;

import com.senmash.postservice.dto.StatusResponse;
import com.senmash.postservice.dto.User;
import com.senmash.postservice.model.Status;
import com.senmash.postservice.reopository.StatusRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class StatusService {

    private RestTemplate restTemplate;

    public StatusRepository statusRepository;
    public Status statusSave(Status status){
        return statusRepository.save(status);
    }
    public List<Status> getAllStaus(){
        return statusRepository.findAll();
    }



    public ResponseEntity<?> getStatusById(Integer id){

        Optional<Status> status =  statusRepository.findById(id);

        if(status.isPresent()){

            User user=restTemplate.getForObject("http://USER-SERVICE/api/user/get/"+status.get().getUserId(), User.class);

            StatusResponse statusResponse=new StatusResponse(
                    status.get().getId(),
                    status.get().getPath(),
                    status.get().getTimestamp(),
                    user
            );
            return new ResponseEntity<>(statusResponse, HttpStatus.OK);
        }else{
            return new ResponseEntity<>("No Student Found",HttpStatus.NOT_FOUND);
        }
    }



    public ResponseEntity<?> deleteStatusById(int id){

        try {
            Optional<Status> status = statusRepository.findById(id);

            if (status.isPresent()) {

                statusRepository.deleteById(id);
                return new ResponseEntity<>("successfully deleted ", HttpStatus.OK);
            } else {
                return new ResponseEntity<>("No Student Found", HttpStatus.NOT_FOUND);
            }
        }catch (Exception e){
            return new ResponseEntity<>("An error occurred while deleting the status.", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    public ResponseEntity<?>updateStatus(Status status){
        statusRepository.save(status);
      return new ResponseEntity<>(status,HttpStatus.OK);
    }



}
