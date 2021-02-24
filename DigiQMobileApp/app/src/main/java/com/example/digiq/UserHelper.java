package com.example.digiq;

public class UserHelper {
    private String name, application_no, phone_no, email,ticket_no,time_rem;
    private String form_fill, verified, file_created, payment, email_create;

    public UserHelper(String name, String application_no, String phone_no, String email, String ticket_no, String form_fill, String verified, String file_created, String payment, String email_create, String time_rem) {
        this.name = name;
        this.application_no = application_no;
        this.phone_no = phone_no;
        this.email = email;
        this.ticket_no = ticket_no;
        this.form_fill = form_fill;
        this.verified = verified;
        this.file_created = file_created;
        this.payment = payment;
        this.email_create = email_create;
        this.time_rem = time_rem;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getApplication_no() {
        return application_no;
    }

    public void setApplication_no(String app_no) {
        this.application_no = app_no;
    }

    public String getPhone_no() {
        return phone_no;
    }

    public void setPhone_no(String phone_no) {
        this.phone_no = phone_no;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTicket_no() {
        return ticket_no;
    }

    public void setTicket_no(String ticket_no) {
        this.ticket_no = ticket_no;
    }

    public String getForm_fill() {
        return form_fill;
    }

    public void setForm_fill(String form_fill) {
        this.form_fill = form_fill;
    }

    public String getVerified() {
        return verified;
    }

    public void setVerified(String verified) {
        this.verified = verified;
    }

    public String getFile_created() {
        return file_created;
    }

    public void setFile_created(String file_created) {
        this.file_created = file_created;
    }

    public String getPayment() {
        return payment;
    }

    public void setPayment(String payment) {
        this.payment = payment;
    }

    public String getEmail_create() {
        return email_create;
    }

    public void setEmail_create(String email_create) {
        this.email_create = email_create;
    }

    public String getTime_rem() {
        return time_rem;
    }

    public void setTime_rem(String time_rem) {
        this.time_rem = time_rem;
    }
}
