package com.modelviewer.app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "models")
public class ModelController {

    private final ModelService modelService;

    @Autowired
    public ModelController(ModelService modelService) {
        this.modelService = modelService;
    }

    @GetMapping("/getModels")
    public List<Model> getModels(){
        return modelService.getModels();
    }

    @PostMapping("/addModel")
    public void registerNewModel(@RequestBody Model model){
        modelService.addNewModel(model);
    }

    @DeleteMapping(path = "{modelId}")
    public void deleteModel(@PathVariable("modelId") Integer modelId){
        modelService.deleteModel(modelId);
    }

    @PutMapping(path = "{modelId}")
    public void updateModel(
            @PathVariable("modelId") Integer modelId,
            @RequestParam(required = false) String modelName,
            @RequestParam(required = false) String hyperLink){
        modelService.updateModel(modelId, modelName, hyperLink);
    }




    @GetMapping(path = "find")
    public List<Model> findModelByName(@RequestParam(required = false) String modelName){
        return modelService.findModelByName(modelName);
    }

}

