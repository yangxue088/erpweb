package com.erp.service.aliexpress;

public class TpOpenAddressDTO {

	private String address;// 地址1
	private String address2;// 地址2
	private String city;// 城市
	private String contactPerson;// 收件人
	private String country;// 国家
	private String detailAddress;// 街道详细地址
	private String faxArea;// 传真区号
	private String faxCountry;// 传真国家码
	private String faxNumber;// 传真号
	private String mobileNo;// 手机
	private String phoneArea;// 区号
	private String phoneCountry;// 国家码
	private String phoneNumber;// 电话
	private String province;// 省份
	private String zip;// 邮编

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getAddress2() {
		return address2;
	}

	public void setAddress2(String address2) {
		this.address2 = address2;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getContactPerson() {
		return contactPerson;
	}

	public void setContactPerson(String contactPerson) {
		this.contactPerson = contactPerson;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getDetailAddress() {
		return detailAddress;
	}

	public void setDetailAddress(String detailAddress) {
		this.detailAddress = detailAddress;
	}

	public String getFaxArea() {
		return faxArea;
	}

	public void setFaxArea(String faxArea) {
		this.faxArea = faxArea;
	}

	public String getFaxCountry() {
		return faxCountry;
	}

	public void setFaxCountry(String faxCountry) {
		this.faxCountry = faxCountry;
	}

	public String getFaxNumber() {
		return faxNumber;
	}

	public void setFaxNumber(String faxNumber) {
		this.faxNumber = faxNumber;
	}

	public String getMobileNo() {
		return mobileNo;
	}

	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}

	public String getPhoneArea() {
		return phoneArea;
	}

	public void setPhoneArea(String phoneArea) {
		this.phoneArea = phoneArea;
	}

	public String getPhoneCountry() {
		return phoneCountry;
	}

	public void setPhoneCountry(String phoneCountry) {
		this.phoneCountry = phoneCountry;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getProvince() {
		return province;
	}

	public void setProvince(String province) {
		this.province = province;
	}

	public String getZip() {
		return zip;
	}

	public void setZip(String zip) {
		this.zip = zip;
	}

	@Override
	public String toString() {
		return "TpOpenAddressDTO [address=" + address + ", address2=" + address2 + ", city=" + city + ", contactPerson=" + contactPerson + ", country=" + country + ", detailAddress=" + detailAddress + ", faxArea=" + faxArea + ", faxCountry=" + faxCountry + ", faxNumber=" + faxNumber + ", mobileNo=" + mobileNo + ", phoneArea=" + phoneArea + ", phoneCountry=" + phoneCountry + ", phoneNumber=" + phoneNumber + ", province=" + province + ", zip=" + zip + "]";
	}

}
