package org.example;

public class Main {
    public static void main(String[] args) {
        int[][] chess = new int[4][4];
        arrayFiller(chess);
        chessBoard(chess);
        arrayPrint(chess);
    }
    public static int[][] arrayFiller(int[][] arg){
        for(int i = 0; i < arg.length; i++){
            for(int j = 0; j < arg.length; j++){
                arg[i][j] = 0;
            }
        }
        return arg;
    }
    public static void arrayPrint(int[][] arg){
        for (int i = 0; i < arg.length; i++) {
            for (int j = 0; j < arg.length; j++) {
                System.out.print(" " + arg[i][j] + " ");
            }
            System.out.println();
        }
    }
    public static boolean check(int[][] arg, int row, int column){
        boolean res = true;
        for (int i = 0; i < row; i++){ // Проверка сверху по вертикали
            if (arg[i][column] == 1){
                res = false;
            }
        }
        for(int i = 0; i < arg.length; i++){
            if (arg[row][i] == 1){
                res = false;
            }
        }
        for (int i = row; i >= 0; i--){ // Проверка по диагонали влево
            for(int j = column; j >= 0; j--){
                if(arg[i][j] == 1){
                    res = false;
                }
                if(i != 0){
                    i--;
                }
                else{
                    j = 0;
                }
            }
        }
        for (int i = row; i >= 0; i--){ // Проверка по диагонали вправо
            for(int j = column; j < arg.length; j++){
                if(arg[i][j] == 1){
                    res = false;
                }
                if(i != 0){
                    i--;
                }
                else{
                    j = arg.length;
                }

            }
        }
        return res;
    }
    public static int[][] chessBoard(int[][] arg) {
        int cnt = 0;
        int attempt = 0;
        while (cnt != 4 && attempt != 16) {
            arg[attempt / 4][attempt % 4] = 1;
            cnt = 1;
            for (int i = 0; i < arg.length; i++) {
                for (int j = 0; j < arg.length; j++) {
                    if (check(arg, i, j) == true) {
                        arg[i][j] = 1;
                        cnt++;
                        j = arg.length - 1;
                    }
                }
            }
            if(cnt != 4) { // Проверка испольщования всех фигур
                attempt++;
                arrayFiller(arg);
            }
        }
        return arg;
    }
}
