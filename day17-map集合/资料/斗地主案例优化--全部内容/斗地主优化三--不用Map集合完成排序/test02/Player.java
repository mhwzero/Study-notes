package test02;

import java.util.ArrayList;
import java.util.List;

public class Player {
    private String playerName;
    private List<Poker> list = new ArrayList<>();

    public Player(String playerName) {
        this.playerName = playerName;
    }

    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    public List<Poker> getList() {
        return list;
    }

    public void setList(List<Poker> list) {
        this.list = list;
    }
}
