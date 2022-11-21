package com.modelviewer.app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ModelService {

    @Autowired
    private ModelRepository modelRepository;

    public List<Model> getModels(){
        return modelRepository.findAll();
    }

    public void addNewModel(Model model) {
        modelRepository.save(model);
    }

    public void deleteModel(Integer modelId) {
        boolean exists = modelRepository.existsById(modelId);
        if(!exists){
            throw new IllegalStateException("model with id " + modelId + " does not exist");
        }
        modelRepository.deleteById(modelId);
    }

    public List<Model> findModelByName(String modelName) {
        return modelRepository.findByModelNameContaining(modelName);
    }

    public void updateModel(Integer modelId, String modelName, String hyperLink) {
        Model model = modelRepository.findById(modelId).orElseThrow(() -> new IllegalStateException(
                "model with id " + modelId + " does not exist"
        ));

        if(modelName != null && modelName.length() > 0 && !modelName.equals(model.getModelName())){
            model.setModelName(modelName);
        }

        if(hyperLink != null && hyperLink.length() > 0 && !hyperLink.equals(model.getHyperLink())){
            model.setHyperLink(hyperLink);
        }

        modelRepository.save(model);
    }


}

