package br.com.codekaffe.Towers.services;

import br.com.codekaffe.Towers.models.Message;
import br.com.codekaffe.Towers.models.Tower;
import br.com.codekaffe.Towers.repository.TowerRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Comparator;
import java.util.List;

public class TowerService {
    @Autowired
    private TowerRepository towerRepository;

    public List<Tower> getAllTowers(){
        return towerRepository.findAll();
    }

    public Tower getTowerById(String id){
        return towerRepository.getTowerById(id);
    }


    public Message addTower(Tower tower){
        if(tower.getHeight() <= 0.0){
            return new Message("Altura Inválida");
        }

        towerRepository.save(tower);
        return new Message("Predio Salvo com sucesso");
    }

    public Message updateTower(Tower tower, String id){
        Tower oldTw = towerRepository.getTowerById(id);
        oldTw.setName(tower.getName());
        oldTw.setHeight(tower.getHeight());
        oldTw.setInagurationDate(tower.getInagurationDate());

        towerRepository.save(oldTw);
        return new Message("Predio Atualizado com sucesso");
    }


    public  Message deleteTower(String id){
        Tower tower = towerRepository.getTowerById(id);
        towerRepository.delete(tower);

        return new Message("Predio deletado com sucesso");
    }

    public Tower getGreaterTower(){
        List<Tower> towers = towerRepository.findAll();
        Tower greaterTower =  towers.stream().max(Comparator.comparing(Tower::getHeight)).get();
        return greaterTower;
    }

    public Tower getOldTower(){
        List<Tower> towers = towerRepository.findAll();
        Tower oldTower = towers.stream().max(Comparator.comparing(Tower::getTowerAge)).get();
        return oldTower;
    }


}
