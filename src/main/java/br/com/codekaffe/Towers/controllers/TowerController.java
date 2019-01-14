package br.com.codekaffe.Towers.controllers;

import br.com.codekaffe.Towers.models.Message;
import br.com.codekaffe.Towers.models.Tower;
import br.com.codekaffe.Towers.services.TowerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class TowerController {
    @Autowired
    private TowerService towerService;

    @RequestMapping(method = RequestMethod.GET, value = "/towers")
    public List<Tower> getAllTowers(){
        return towerService.getAllTowers();
    }

    @RequestMapping(method = RequestMethod.GET, value = "/towers/{id}")
    public Tower getTowerById(@Valid @PathVariable String id){
        return towerService.getTowerById(id);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/towers/{id}")
    public Message deleteTower(@Valid @PathVariable String id){
        return towerService.deleteTower(id);
    }

    @RequestMapping(method = RequestMethod.PUT,value = "/towers/{id}")
    public Message updateTower(@Valid @PathVariable String id, @Valid @RequestBody Tower tower){
        return towerService.updateTower(tower,id);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/towers/newTower")
    public Message addTower(@Valid @RequestBody Tower tower){
        return towerService.addTower(tower);
    }


    @RequestMapping(method = RequestMethod.GET, value = "/towers/torreAlta")
    public Tower getTorreAlta(){
        return towerService.getGreaterTower();
    }

    @RequestMapping(method = RequestMethod.GET, value = "/towers/oldTower")
    public Tower getTorreVelha(){
        return towerService.getOldTower();
    }
}
