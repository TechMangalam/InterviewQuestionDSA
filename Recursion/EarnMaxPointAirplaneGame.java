package recursion;

import java.util.Scanner;

public class EarnMaxPointAirplaneGame {

    static int ans=0;

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int N;
        N = sc.nextInt();
        int[][] game = new int[N][5];
        for(int i = 0;i<N;i++){
            for(int j = 0;j<5;j++){
                game[i][j] = sc.nextInt();
            }
        }
        EarnMaxPointAirplaneGame obj = new EarnMaxPointAirplaneGame();
        obj.solve(game,N,N,2,0,0,true);

        System.out.println("Points Earned => "+ans);

    }

    private void solve(int[][] game ,int N,int x,int y,int points,int power,boolean bomb){

        ans = Math.max(ans,points);
        if(x==0){
            return;
        }

        for(int i = -1;i<=1;i++){

            int r = x-1;
            int c = y + i;

            if(c>=0 && c<5 && r>=0 && r<N){

                if(game[r][c]==0){
                    solve(game, N, r, c, points, power-1, bomb);
                }
                if (game[r][c]==1){
                    solve(game, N, r, c, points+1, power-1, bomb);
                }
                if(game[r][c]==2){
                    if (bomb){
                        solve(game, N, r, c, points, 5, false);
                    }
                    if(points>0){
                        solve(game, N, r, c, points-1, power-1, bomb);
                    }
                    if (power>0){
                        solve(game, N, r, c, points, power-1, false);
                    }
                    if(points==0 && power <=0 && bomb){
                        ans = Math.max(ans,points);
                        return;
                    }
                }

            }//checking move validity if

        }//for loop for all three moves from curr position ends

    }

}

/*
4
7
1 2 0 0 1
2 0 0 1 0
0 1 2 0 1
1 0 0 2 1
0 2 1 0 1
0 1 2 2 2
1 0 1 1 0
5
1 1 0 0 0
1 2 2 2 1
1 1 2 2 1
2 2 2 1 2
2 2 0 2 0
6
2 2 2 2 2
0 0 0 0 0
0 0 2 0 0
2 0 0 0 2
0 0 0 0 0
1 2 2 2 1
12
2 2 2 2 2
1 1 0 1 1
0 1 0 1 0
1 0 1 0 1
2 2 0 0 2
1 1 0 0 1
2 2 2 2 2
1 1 0 1 0
0 1 0 1 0
1 0 1 0 1
2 2 2 2 2
2 2 0 1 1

Answers
6
3
-1
8

*/