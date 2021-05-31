package za.com.csg.model;

import za.com.csg.model.ActionStatusType;

public class UserTypeModel {
    private Integer typeId;

    private String typeName;

    private ActionStatusType actionStatusType;

    public UserTypeModel() {}

    public UserTypeModel(ActionStatusType actionStatusType) {
        this.actionStatusType = actionStatusType;
    }

    public Integer getTypeId() {
        return this.typeId;
    }

    public void setTypeId(Integer typeId) {
        this.typeId = typeId;
    }

    public String getTypeName() {
        return this.typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }
}
