package codeexcel.model;

import java.io.Serializable;

/**
 * @author fxf
 *         营销费用台账
 * @create 2017-10-27 13:29
 **/

public class YXFYTZModel implements Serializable {

	private static final long serialVersionUID = -2282781002796095977L;

	//隶属公司
	private String company;

	//一级部门
	private String firstDepartment;

	//二级部门
	private String twoDepartment;

	//金蝶月份
	private String kingdeeMonth;

	//费用发生月份
	private String costMonth;

	//用途
	private String purpose;

	//费用大类
	private String firstCost;

	//费用细类
	private String twoCost;

	//金额
	private String money;

	//报销人
	private String reimbursementPerson;

	//凭证号
	private String voucherNo;

	//业务种类
	private String BusinessType;

	//对方名称
	private String otherName;

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public String getFirstDepartment() {
		return firstDepartment;
	}

	public void setFirstDepartment(String firstDepartment) {
		this.firstDepartment = firstDepartment;
	}

	public String getTwoDepartment() {
		return twoDepartment;
	}

	public void setTwoDepartment(String twoDepartment) {
		this.twoDepartment = twoDepartment;
	}

	public String getKingdeeMonth() {
		return kingdeeMonth;
	}

	public void setKingdeeMonth(String kingdeeMonth) {
		this.kingdeeMonth = kingdeeMonth;
	}

	public String getCostMonth() {
		return costMonth;
	}

	public void setCostMonth(String costMonth) {
		this.costMonth = costMonth;
	}

	public String getPurpose() {
		return purpose;
	}

	public void setPurpose(String purpose) {
		this.purpose = purpose;
	}

	public String getFirstCost() {
		return firstCost;
	}

	public void setFirstCost(String firstCost) {
		this.firstCost = firstCost;
	}

	public String getTwoCost() {
		return twoCost;
	}

	public void setTwoCost(String twoCost) {
		this.twoCost = twoCost;
	}

	public String getMoney() {
		return money;
	}

	public void setMoney(String money) {
		this.money = money;
	}

	public String getReimbursementPerson() {
		return reimbursementPerson;
	}

	public void setReimbursementPerson(String reimbursementPerson) {
		this.reimbursementPerson = reimbursementPerson;
	}

	public String getVoucherNo() {
		return voucherNo;
	}

	public void setVoucherNo(String voucherNo) {
		this.voucherNo = voucherNo;
	}

	public String getBusinessType() {
		return BusinessType;
	}

	public void setBusinessType(String businessType) {
		BusinessType = businessType;
	}

	public String getOtherName() {
		return otherName;
	}

	public void setOtherName(String otherName) {
		this.otherName = otherName;
	}
}