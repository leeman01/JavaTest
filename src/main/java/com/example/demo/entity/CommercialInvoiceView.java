package com.example.demo.entity;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.Table;

@Entity
@Table(name = "commercial_invoice_view")  // VIEW 이름을 명시합니다.
public class CommercialInvoiceView {

    @Id
    private String invoiceNo;  // VIEW에 ID 필드가 있어야 합니다.
    
    @Column(name="shipperName")
    private String shipperName;
    @Column(name="shipperAddress")
    private String shipperAddress;
    @Lob
    @Column(name = "shipperSignature")
    private byte[] shipperSignature;  // BLOB 필드 추가
    @Column(name="consigneeName")
    private String consigneeName;
    @Column(name="consigneeAddress")
    private String consigneeAddress;
    @Column(name="expectedShippingDate")
    private LocalDate expectedShippingDate;
    @Column(name="loadingPort")
    private String loadingPort;
    @Column(name="buyerCountry")
    private String buyerCountry;
    @Column(name="unloadingPort")
    private String unloadingPort;
    @Column(name="paymentMethod")
    private String paymentMethod;
    @Column(name="incoterm")
    private String incoterm;
    @Column(name="invoiceDate")
    private LocalDate invoiceDate;
    @Column(name="productDescription")
    private String productDescription;
    @Column(name="productQuantity")
    private int productQuantity;
    @Column(name="unitPrice")
    private double unitPrice;
    
    
    public byte[] getshipperSignature() {
		return shipperSignature;
	}
	public void setshipperSignature(byte[] shipperSignature) {
		this.shipperSignature = shipperSignature;
	}
	@Column(name="totalAmount")
    private double totalAmount;
    
    
    
    
	public String getInvoiceNo() {
		return invoiceNo;
	}
	public void setInvoiceNo(String invoiceNo) {
		this.invoiceNo = invoiceNo;
	}
	public String getShipperName() {
		return shipperName;
	}
	public void setShipperName(String shipperName) {
		this.shipperName = shipperName;
	}
	public String getShipperAddress() {
		return shipperAddress;
	}
	public void setShipperAddress(String shipperAddress) {
		this.shipperAddress = shipperAddress;
	}
	public String getConsigneeName() {
		return consigneeName;
	}
	public void setConsigneeName(String consigneeName) {
		this.consigneeName = consigneeName;
	}
	public String getConsigneeAddress() {
		return consigneeAddress;
	}
	public void setConsigneeAddress(String consigneeAddress) {
		this.consigneeAddress = consigneeAddress;
	}
	public LocalDate getExpectedShippingDate() {
		return expectedShippingDate;
	}
	public void setExpectedShippingDate(LocalDate expectedShippingDate) {
		this.expectedShippingDate = expectedShippingDate;
	}
	public String getLoadingPort() {
		return loadingPort;
	}
	public void setLoadingPort(String loadingPort) {
		this.loadingPort = loadingPort;
	}
	public String getBuyerCountry() {
		return buyerCountry;
	}
	public void setBuyerCountry(String buyerCountry) {
		this.buyerCountry = buyerCountry;
	}
	public String getUnloadingPort() {
		return unloadingPort;
	}
	public void setUnloadingPort(String unloadingPort) {
		this.unloadingPort = unloadingPort;
	}
	public String getPaymentMethod() {
		return paymentMethod;
	}
	public void setPaymentMethod(String paymentMethod) {
		this.paymentMethod = paymentMethod;
	}
	public String getIncoterm() {
		return incoterm;
	}
	public void setIncoterm(String incoterm) {
		this.incoterm = incoterm;
	}
	public LocalDate getInvoiceDate() {
		return invoiceDate;
	}
	public void setInvoiceDate(LocalDate invoiceDate) {
		this.invoiceDate = invoiceDate;
	}
	public String getProductDescription() {
		return productDescription;
	}
	public void setProductDescription(String productDescription) {
		this.productDescription = productDescription;
	}
	public int getProductQuantity() {
		return productQuantity;
	}
	public void setProductQuantity(int productQuantity) {
		this.productQuantity = productQuantity;
	}
	public double getUnitPrice() {
		return unitPrice;
	}
	public void setUnitPrice(double unitPrice) {
		this.unitPrice = unitPrice;
	}
	public double getTotalAmount() {
		return totalAmount;
	}
	public void setTotalAmount(double totalAmount) {
		this.totalAmount = totalAmount;
	}
    
    
}
