package com.ywGroup.ieCloud.wenZhouIntelligentGas.pojo.activitipo;

public class HistoryProcess {
	String processDefinitionId;
	String businessKey;
	Supervision supervision;
	public String getProcessDefinitionId() {
		return processDefinitionId;
	}
	public void setProcessDefinitionId(String processDefinitionId) {
		this.processDefinitionId = processDefinitionId;
	}
	public String getBusinessKey() {
		return businessKey;
	}
	public void setBusinessKey(String businessKey) {
		this.businessKey = businessKey;
	}

	public Supervision getSupervision() {
		return supervision;
	}

	public void setSupervision(Supervision supervision) {
		this.supervision = supervision;
	}
}
