package com.example.complaint.complaintmanagment;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ComplaintServiceImp implements IComplaintService {

    @Autowired
    ComplaintRepository complaintRepository ;
    @Override
    public List<Complaint> retrieveAllComplaints() {
        return (List<Complaint>) complaintRepository.findAll();
    }

    @Override
    public Complaint addComplaint(Complaint c) {

        return complaintRepository.save(c);
    }

    @Override
    public Complaint updateComplaint(Complaint c) {
        return complaintRepository.save(c);
    }



    @Override
    public void removeComplaint(Integer id) {
        Complaint c=  complaintRepository.findById(id).orElse(null) ;
        complaintRepository.delete(c);
    }

    @Override
    public Complaint retrieveComplaint(Integer idComplaint) {
        return complaintRepository.findById(idComplaint).get();
    }
}
