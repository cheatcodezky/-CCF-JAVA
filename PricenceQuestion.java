

import java.sql.Time;
import java.util.ArrayList;
import java.util.Scanner;


public class PricenceQuestion {
	static int[] dx = {0,-1,0,1};
	static int[] dy = {-1,0,1,0};
	static char map[][][] = new char[2][11][11];
	static int path[][][] = new int[2][11][11];
	static int C,N,M,T,FLAG;
	
	public static void main(String[] args)
	{
		Scanner scanner = new Scanner(System.in);
		C = scanner.nextInt();
		ArrayList<String> answer = new ArrayList<>(); 
		for(int i=0;i<C;i++)
		{
			N = scanner.nextInt();
			M = scanner.nextInt();
			T = scanner.nextInt();
			FLAG  = 0;
			scanner.nextLine();
			String input ;
			for(int b = 0 ; b<2;b++)
			{
				
			for(int j = 0 ; j<N;j++)
			{
					input = scanner.nextLine();
					char[] tmp = input.toCharArray();
					for(int z = 0 ; z<M;z++)
					{
						map[b][j][z] = tmp[z];
						path[b][j][z] = 0;
					}
			}
			if (b==0) 
			scanner.nextLine();
			}
			
			if (check(0, 0, 0, 0)) {
				answer.add("YES");
			}
			else
			{
				answer.add("NO");
			}
		}
		while(!answer.isEmpty())
		{
			System.out.println(answer.get(0));
			answer.remove(0);
		}
	}
	
	public static boolean check(int x,int y,int z,int tim)
	{
		if(tim>T)
			return false;
	
		if (map[z][x][y] == 'P') {
			if (tim<=T) {
				return true;
			}
			else {
				return false;

				}	
		}
		
		for(int i = 0;i<4;i++)
		{
			int fx = x + dx[i];
			int fy = y + dy[i];
		
			
			if (fx>=0&&fx<N&&fy>=0&&fy<M&&path[1-z][fx][fy]==0&&map[1-z][fx][fy]!='*'&&map[z][fx][fy]=='#'&&map[1-z][fx][fy]!='#') {
				System.out.println(fx+ " "+ fy+" "+ z+" #");
				path[1-z][fx][fy] = 1;
				if (check(fx, fy, 1-z, tim+1)) {
					return true;
				}
				path[1-z][fx][fy] = 0;
			}
			else if (fx>=0&&fx<N&&fy>=0&&fy<M&&path[z][fx][fy]==0&&map[z][fx][fy]!='#'&&map[z][fx][fy]!='*'){
				System.out.println(fx+ " "+ fy+" "+ z+" ");
				path[z][fx][fy] = 1;
				if (check(fx, fy, z, tim+1)) {
					return true;
				}
				path[z][fx][fy] = 0;
			}
		}
		return false;
	};
}

