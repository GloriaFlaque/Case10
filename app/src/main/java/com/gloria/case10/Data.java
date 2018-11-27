package com.gloria.case10;

public class Data {

    private StatsData score;
    private StatsData scorePerMatch;
    private StatsData matches;
    private StatsData kills;

    public StatsData getScore() {
        return score;
    }

    public void setScore(StatsData score) {
        this.score = score;
    }

    public StatsData getScorePerMatch() {
        return scorePerMatch;
    }

    public void setScorePerMatch(StatsData scorePerMatch) {
        this.scorePerMatch = scorePerMatch;
    }

    public StatsData getMatches() {
        return matches;
    }

    public void setMatches(StatsData matches) {
        this.matches = matches;
    }

    public StatsData getKills() {
        return kills;
    }

    public void setKills(StatsData kills) {
        this.kills = kills;
    }

}
