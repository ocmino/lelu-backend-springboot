package com.modelviewer.app;

import javax.persistence.*;

@Entity
@Table(name = "Models")
public class Model {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "ModelName")
    private String modelName;

    @Column(name = "HyperLink")
    private String hyperLink;

    public Model() {
    }

    public Model(String modelName, String hyperLink) {
        this.modelName = modelName;
        this.hyperLink = hyperLink;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getModelName() {
        return modelName;
    }

    public void setModelName(String modelName) {
        this.modelName = modelName;
    }

    public String getHyperLink() {
        return hyperLink;
    }

    public void setHyperLink(String hyperLink) {
        this.hyperLink = hyperLink;
    }
}


