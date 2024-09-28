package Main;

public class GameLogic {
    private int BoardSize;
    private int how_many_rounds;
    private int how_many_correct_left = 0;
    private int RealBoard[][];
    public GameLogic(){
        this.BoardSize = 10;
        this.how_many_rounds = 0;
        this.RealBoard = new int[BoardSize][BoardSize];
        setBoard();
    }
    public GuessState Guess(int x, int y){
        if(RealBoard[x][y] == 0){
            this.how_many_rounds++;
            System.out.println("INCORRECT \n");
            return GuessState.INCORRECT_GUESS;
        }
        else{
            System.out.println("CORRECT \n");
            this.how_many_correct_left--;
            return GuessState.CORRECT_GUESS;
        }
    }
    //docelowe bardziej randomowe ale na razie fixed
    private void setBoard(){
        this.how_many_correct_left = 0;
        int[] Statki = {5,4,3,2,1};
        for (int i = 0; i < BoardSize; i++){
            for (int j = 0; j < BoardSize;j++){
                RealBoard[i][j] = 0;
            }
        }
        for (int i = 0; i < Statki.length;i++){
            int ship_length = Statki[i];
            this.how_many_correct_left += ship_length;
            boolean loop_break = false;
            while(!loop_break){
                int x = Losowanie.losuj(0,BoardSize - 1);
                int y = Losowanie.losuj(0,BoardSize - 1);
                int direction = Losowanie.losuj(1,4);
                boolean possible_ship = true;
                if(direction == 1) {
                    for (int j = x; j < x + ship_length; j++) {
                        if (!checkCanAddTile(j, y)) {
                            possible_ship = false;
                        }
                    }
                    if (possible_ship) {
                        for (int j = x; j < x + ship_length; j++) {
                            RealBoard[j][y] = 1;
                        }
                    }
                }
                if(direction == 2){
                    for (int j = x; j > x - ship_length; j--){
                        if(!checkCanAddTile(j,y)){
                            possible_ship = false;
                        }
                    }
                    if(possible_ship){
                        for (int j = x; j > x - ship_length; j--){
                            RealBoard[j][y] = 1;
                        }
                    }
                }
                if(direction == 3) {
                    for (int j = y; j < y + ship_length; j++) {
                        if (!checkCanAddTile(x, j)) {
                            possible_ship = false;
                        }
                    }
                    if (possible_ship) {
                        for (int j = y; j < y + ship_length; j++) {
                            RealBoard[x][j] = 1;
                        }
                    }
                }
                if(direction == 4) {
                    for (int j = y; j > y - ship_length; j--) {
                        if (!checkCanAddTile(x, j)) {
                            possible_ship = false;
                        }
                    }
                    if (possible_ship) {
                        for (int j = y; j > y - ship_length; j--) {
                            RealBoard[x][j] = 1;
                        }
                    }
                }
                if(possible_ship == true) {
                    loop_break = true;
                }
            }
        }
    }
    boolean checkTileEmpty(int x,int y){
        if(x < 0 || x >= BoardSize || y < 0 || y >= BoardSize){
            return true;
        }
        else if(RealBoard[x][y] == 0){
            return true;
        }
        else{
            return false;
        }
    }
    boolean checkCanAddTile(int x, int y){
        if(x < 0 || x >= BoardSize || y < 0 || y >= BoardSize)return false;
        if(checkTileEmpty(x,y-1) && checkTileEmpty(x,y+1) && checkTileEmpty(x-1,y) && checkTileEmpty(x+1,y)){
            return true;
        }
        else{
            return false;
        }
    }

}
