package test01;

import java.util.ArrayList;
import java.util.List;

public class Player {
    private String playerName;
    private List<String> list = new ArrayList<>();

    public Player(String playerName) {
        this.playerName = playerName;
    }

    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    public List<String> getList() {
        return list;
    }

    public void setList(List<String> list) {
        this.list = list;
    }
}
