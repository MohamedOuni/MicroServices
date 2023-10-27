package com.example.complaint.complaintmanagment;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/complaint")
@CrossOrigin(origins = "http://localhost:4200")
public class ComplaintRestController {
    @Autowired
    IComplaintService complaintService;
    @GetMapping("/retrieve-all-complaints")
    public List<Complaint> getComplaints() {
        List<Complaint> listComplaints = complaintService.retrieveAllComplaints();
        return listComplaints;
    }

    @PostMapping("/add-complaint")
    public Complaint addComplaint(@RequestBody Complaint c) {
        Complaint complaint = complaintService.addComplaint(c);
        return complaint;
    }


    @DeleteMapping("/remove-complaint/{id}")
    public void removeComplaint(@PathVariable("id") Integer id) {
        complaintService.removeComplaint(id);
    }


    @PutMapping("/update-complaint")
    public Complaint updateComplaint(@RequestBody Complaint c) {
        Complaint complaint = complaintService.updateComplaint(c);
        return complaint;
    }



    @GetMapping("/retrieve-complaint/{complaint-id}")
    public Complaint retrieveComplaint(@PathVariable("complaint-id") Integer complaintId) {
        return complaintService.retrieveComplaint(complaintId);
    }


}
