package com.example.pojo;

public class Questions {
    private Integer id;

    private String quetionName;

    private String type;

    private String options;

    private Integer bagId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getQuetionName() {
        return quetionName;
    }

    public void setQuetionName(String quetionName) {
        this.quetionName = quetionName == null ? null : quetionName.trim();
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type == null ? null : type.trim();
    }

    public String getOptions() {
        return options;
    }

    public void setOptions(String options) {
        this.options = options == null ? null : options.trim();
    }

    public Integer getBagId() {
        return bagId;
    }

    public void setBagId(Integer bagId) {
        this.bagId = bagId;
    }

	@Override
	public String toString() {
		return "Questions [id=" + id + ", quetionName=" + quetionName
				+ ", type=" + type + ", options=" + options + ", bagId="
				+ bagId + "]";
	}
    
}