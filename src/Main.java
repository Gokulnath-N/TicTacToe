import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        char[][] board = new char[3][3];
        for(int row=0;row < board.length;row++) {
            for(int col=0; col < board[row].length; col++) {
                board[row][col] = ' ';
            }
        }
        char player ='X';
        boolean gameOver = false;
        Scanner scanner = new Scanner(System.in);

        while(!gameOver) {
            printBoard(board);
            System.out.println("Player "+player+ " enter the move: ");
            int row = scanner.nextInt();
            int col = scanner.nextInt();
            if(board[row][col]== ' '){
                board[row][col]=player;
                gameOver = haveWon(board,player);
                if(gameOver){
                    System.out.println("Player "+ player +"has won.");
                }else{
//                    if (player=='X') {
//                        player='O';
//                    } else {
//                        player='X';
//                    }
//                    shorthand if statement syntax: variable = (condition) ? expressionTrue :  expressionFalse;
                    player = (player=='X') ? 'O' : 'X';
                }
            }else{
                System.out.println("Invalid Move!, try again.");
            }
        }
        printBoard(board);
    }
    public static boolean haveWon(char[][] board, char player){
        //rows check
        for(int row=0;row < board.length;row++){
            if(board[row][0]==player && board[row][1]==player && board[row][2]==player){
                return true;
            }
        }
        //column check
        for(int col=0;col<board.length;col++){
            if(board[0][col]==player && board[1][col]==player && board[2][col]==player){
                return true;
            }
        }
        //diagonal check
        if(board[0][0]==player && board[1][1]==player && board[2][2]==player)
            return true;

        if(board[2][0]==player && board[1][1]==player && board[0][2]==player)
            return true;

        return false;
    }
    public static void printBoard(char[][] board){
        for(int row=0;row< board.length;row++){
            for(int col=0;col<board[row].length;col++){
                System.out.print(board[row][col]+" | ");
            }
            System.out.println();
        }
    }
}
