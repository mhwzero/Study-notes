package com.itheima.p6_poker;

import java.util.ArrayList;
import java.util.List;

//玩家类
public class Player {
    private String playerName;//玩家名称
    private List<String> list = new ArrayList<>();//玩家存储自己摸到牌的集合

    //构造方法: 指定玩家名称
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
