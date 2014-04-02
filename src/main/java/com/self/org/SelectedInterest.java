package com.self.org;

public class SelectedInterest implements Comparable<SelectedInterest> {

    Long interest_id;
    String interest_name;
    String status;
    
    public Long getInterest_id() {
        return interest_id;
    }
    public void setInterest_id(Long interest_id) {
        this.interest_id = interest_id;
    }
    public String getInterest_name() {
        return interest_name;
    }
    public void setInterest_name(String interest_name) {
        this.interest_name = interest_name;
    }
    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }
    @Override
    public int compareTo(SelectedInterest anotherCountry) {
        return anotherCountry.getInterest_id().compareTo(this.interest_id);
    }
}
