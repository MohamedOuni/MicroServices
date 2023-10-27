package com.example.complaint.complaintmanagment;

import java.security.Principal;
import java.util.List;

public interface IComplaintService {
    public List<Complaint> retrieveAllComplaints();
    public Complaint addComplaint (Complaint c);
    public Complaint updateComplaint (Complaint c);
    public Complaint retrieveComplaint(Integer  idComplaint);
    public void removeComplaint(Integer idComplaint);
}
