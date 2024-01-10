package com.senmash.postservice.controller;

import com.senmash.postservice.model.Status;
import com.senmash.postservice.service.StatusService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@CrossOrigin("*")
@RestController
@RequestMapping("/api/status")
@AllArgsConstructor
public class MakeStatusController {

    private StatusService statusService;
    @PostMapping("/save")
    public Status save(@RequestBody Status status){
        return statusService.statusSave(status);
    }


    @GetMapping("/all")
    public List<Status> getAllStaus(){
        return  statusService.getAllStaus()  ;
    }



    @GetMapping("/{id}")
    public ResponseEntity<?> getStatusById(@PathVariable ("id") int id){
        return statusService.getStatusById(id);
    }




    //need to make allow for delete status just only their own (still implementing security)
    @DeleteMapping("delete/{id}")
    public  ResponseEntity<?>deleteStatusById(@PathVariable("id") int id){
          return statusService.deleteStatusById(id);
    }


    @PutMapping("update")
    public ResponseEntity<?>updateStatusById(@RequestBody Status status){
        return statusService.updateStatus(status);

    }


}
