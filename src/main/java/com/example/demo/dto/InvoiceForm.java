package com.example.demo.dto;

public class InvoiceForm {
    private String LCno;
    private String LCdate;
    private String References;
    private String ShippingMarks;
    
    public InvoiceForm() {
    }

    // Getters and Setters
    public String getLCno() {
        return LCno;
    }

    public void setLCno(String LCno) {
        this.LCno = LCno;
    }

    public String getLCdate() {
        return LCdate;
    }

    public void setLCdate(String LCdate) {
        this.LCdate = LCdate;
    }

	public String getReferences() {
		return References;
	}

	public void setReferences(String references) {
		References = references;
	}

	public String getShippingMarks() {
		return ShippingMarks;
	}

	public void setShippingMarks(String shippingMarks) {
		ShippingMarks = shippingMarks;
	}
}
