package Main;

public class Board {
    GameLogic GL;
    int size;
    private TileState[][] Board;
    public Board(GameLogic GL){
        this.GL = GL;
        int BoardSize = 10;
        this.size = BoardSize;
        this.Board = new TileState[BoardSize][BoardSize];
        for (int i = 0; i < BoardSize;i++){
            for (int j = 0; j < BoardSize;j++){
                this.Board[i][j] = TileState.STATE_UNGUESSED;
            }
        }
    }
    public void updateBoard(int x, int y, TileState S){
        this.Board[x][y] = S;
    }
    public TileState getTile(int x, int y){
        return Board[x][y];
    }
    public void Click(int x,int y){
        if(Board[x][y] == TileState.STATE_UNGUESSED){
            if( GL.Guess(x,y) == GuessState.CORRECT_GUESS ){
                updateBoard(x,y,TileState.STATE_SHIP);
            }
            else{
                updateBoard(x,y,TileState.STATE_EMPTY);
            }
        }
    }
}
