package com.example.pojo;

import java.util.List;

public class Survey {
    private Integer id;

    private String surveyName;

    private String status;

    private String logoPath;

    private String createTime;

    private String finishTime;

    private Integer userId;
    
    private List<Bag> bags;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSurveyName() {
        return surveyName;
    }

    public void setSurveyName(String surveyName) {
        this.surveyName = surveyName == null ? null : surveyName.trim();
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    public String getLogoPath() {
        return logoPath;
    }

    public void setLogoPath(String logoPath) {
        this.logoPath = logoPath == null ? null : logoPath.trim();
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime == null ? null : createTime.trim();
    }

    public String getFinishTime() {
        return finishTime;
    }

    public void setFinishTime(String finishTime) {
        this.finishTime = finishTime == null ? null : finishTime.trim();
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

	public List<Bag> getBags() {
		return bags;
	}

	public void setBags(List<Bag> bags) {
		this.bags = bags;
	}

	@Override
	public String toString() {
		return "Survey [id=" + id + ", surveyName=" + surveyName + ", status="
				+ status + ", logoPath=" + logoPath + ", createTime="
				+ createTime + ", finishTime=" + finishTime + ", userId="
				+ userId + "]";
	}
    
}