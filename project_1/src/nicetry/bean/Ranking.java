package nicetry.bean;

public class Ranking {
    @Override
    public String toString() {
        return
                "name='" + nickname + '\'' +
                ", score=" + score
                ;
    }

    /**
     * nickname : douniwan
     * score : 4242
     */

    private String nickname;
    private int score;

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }
}
