package tictactoe.game;

public class GameStats {
    public String lastResult;
    
    public GameStats() {
        this.lastResult = "";
    }
    
    public void addResult(String result) {
        this.lastResult = result;
    }
} 