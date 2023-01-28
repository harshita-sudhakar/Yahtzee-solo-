import java.util.Scanner;
public class fiveZee {

	static int[] dice = new int[5];
	static int[] keep = new int[5];
	private int[] scoreboard = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
	private String[] options = {"ones", "twos", "threes", "fours", "fives", "sixes", "three of a kind", "four of a kind", "full house", "small straight", "large straight", "chance", "yahtzee"};
	private int totalScore;
	static Scanner keyboard = new Scanner(System.in);
	private String func = "";

	public static void main (String [] args) {
		fiveZee app = new fiveZee ();
	}
	public fiveZee () {
		int z = 1;
		while(z <= 10) {
			turn();
			z++;
		}
	}
	public void turn() {
		roll();
		keep();
		roll();
		keep();
		roll();
		score();
		totalScore();
		int[] keep = new int[5];
	}
	public void roll () {
		for (int i = 0; i < dice.length; i++) {
			if (keep[i] == 1) {
				dice[i] = dice[i];
				System.out.print("roll #" + (i+1) + ": " + dice[i] + " \n");
				keep[i]--;
			}
			else {
				int x = (int) (Math.random()*6)+1;
				dice[i] = x;
				System.out.print("roll #" + (i+1) + ": " + dice[i] + " \n");
			}
		}
	}
	public void keep () {
		System.out.print("type out the roll # that you want to keep: ");
		String y = keyboard.nextLine();
		if (y.contains("one") || y.contains("1")) {
			keep[0] = 1;
		}
		if (y.contains("two") || y.contains("2")) {
			keep[1] = 1;
		}
		if (y.contains("three") || y.contains ("3")) {
			keep[2] = 1;
		}
		if(y.contains("four") || y.contains ("4")) {
			keep[3] = 1;
		}
		if(y.contains("five") || y.contains ("5")) {
			keep[4] = 1;
		}
	}
	public void printBoard() {
			for (int i = 0; i < options.length; i++) {
				System.out.println((i+1) + ": " + options[i] + " - " + scoreboard[i]);
			}
			//totalScore();
	}
	public void score() {
		printBoard();
		System.out.print("select where you wish you score this turn: ");
		int selection = keyboard.nextInt();
		keyboard.nextLine();
			switch (selection) {
			case 1:
				ones();
				break;
			case 2:
				twos();
				break;
			case 3:
				threes();
				break;

			case 4:
				fours();
				break;
			case 5:
				fives();
				break;
			case 6:
				sixes();
				break;
			case 7:
				threeKind();
				break;
			case 8:
				fourKind();
				break;
			case 9:
				fullHouse();
				break;
			case 10:
				smallStraight();
				break;
			case 11:
				largeStraight();
				break;
			case 12:
				chance();
				break;
			case 13:
				fiveZees();
				break;
			default:
				System.out.println("Invalid Score Selection");
			}
		}
		public void ones(){
			for (int i = 0; i < dice.length; i++) {
				if (dice[i] == 1) {
					scoreboard[0]++;
				}
			}
			System.out.println(scoreboard[0]);
		}
		public void twos() {
			for (int i = 0; i < dice.length; i++) {
				if (dice[i] == 2) {
					scoreboard[1]+=2;
				}
			}
			System.out.println(scoreboard[1]);
		}
		public void threes() {
			for (int i = 0; i < dice.length; i++) {
				if (dice[i] == 3) {
					scoreboard[2]+=3;
				}
			}
			System.out.println(scoreboard[2]);
		}
		public void fours() {
			for (int i = 0; i < dice.length; i++) {
				if (dice[i] == 4) {
					scoreboard[3]+=4;
				}
			}
			System.out.println(scoreboard[3]);
		}
		public void fives() {
			for (int i = 0; i < dice.length; i++) {
				if (dice[i] == 5) {
					scoreboard[4]+=5;
				}
			}
			System.out.println(scoreboard[4]);
		}
		public void sixes() {
			for (int i = 0; i < dice.length; i++) {
				if (dice[i] == 6) {
					scoreboard[5]+=6;
				}
			}
			System.out.println(scoreboard[5]);
		}
		public void threeKind() {
			int [] num = {0, 1, 2, 3, 4, 5, 6};
			int [] par = {0, 0, 0, 0, 0, 0, 0};
			for (int i = 0; i < num.length; i++) {
				for (int j = 0; j < dice.length; j++) {
					if (dice[j] == num[i]) {
						par[i]++;
					}
				}
			}
			for (int i = 0; i < par.length; i++) {
				if (par[i] >= 3) {
					scoreboard[6] = dice[0] + dice [1] + dice [2] + dice [3] + dice [4];
				}
			}
			System.out.println(scoreboard[6]);
		}
		public void fourKind () {
			int [] num = {0, 1, 2, 3, 4, 5, 6};
			int [] par = {0, 0, 0, 0, 0, 0, 0};
			for (int i = 0; i < num.length; i++) {
				for (int j = 0; j < dice.length; j++) {
					if (dice[j] == num[i]) {
						par[i]++;
					}
				}
			}
			for (int i = 0; i < par.length; i++) {
				if (par[i] >= 4) {
					scoreboard[7] = dice[0] + dice [1] + dice [2] + dice [3] + dice [4];
				}
			}
			System.out.println(scoreboard[7]);
		}
		public void fullHouse () {
			int [] num = {0, 1, 2, 3, 4, 5, 6};
			int [] par = {0, 0, 0, 0, 0, 0, 0};
			int two = 1;
			int three = 1;
			for (int i = 0; i < num.length; i++) {
				for (int j = 0; j < dice.length; j++) {
					if (dice[j] == num[i]) {
						par[i]++;
					}
				}
			}
			for (int k = 0; k < par.length; k++) {
				if (par[k] == 2) {
					two--;
				}
				else if (par[k] == 3) {
					three--;
				}
			}
			if (two == 0 && three == 0) {
				scoreboard[8] = 25;
			}
			System.out.println(scoreboard[8]);
		}
		public void smallStraight() {
			int [] num = {0, 1, 2, 3, 4, 5, 6};
			int [] par = {0, 0, 0, 0, 0, 0, 0};
			for (int i = 0; i < num.length; i++) {
				for (int j = 0; j < dice.length; j++) {
					if (dice[j] == num[i]) {
						par[i] = 1;
					}
				}
			}
			for (int k = 0; k < par.length-3; k++) {
				if (par[k] == 1 && par[k+1] == 1 && par [k+2] == 1 && par [k+3] == 1) {
					scoreboard[9] = 30;
				}
			}
			System.out.println(scoreboard[9]);
		}
		public void largeStraight() {
			int [] num = {0, 1, 2, 3, 4, 5, 6};
			int [] par = {0, 0, 0, 0, 0, 0, 0};
			for (int i = 0; i < num.length; i++) {
				for (int j = 0; j < dice.length; j++) {
					if (dice[j] == num[i]) {
						par[i] = 1;
					}
				}
			}
			for (int k = 0; k < par.length-4; k++) {
				if (par[k] == 1 && par[k+1] == 1 && par [k+2] == 1 && par [k+3] == 1 && par [k+4] == 1) {
					scoreboard[10] = 40;
				}
			}
			System.out.println(scoreboard[10]);
		}
		public void chance() {
			scoreboard[11] = dice[0] + dice [1] + dice [2] + dice [3] + dice [4];
			System.out.println(scoreboard[11]);
		}
		public void fiveZees() {
			if (dice[0] == dice[1]) {
				if (dice[1] == dice [2]) {
					if (dice[2] == dice [3]) {
						if (dice[3] == dice[4]) {
							scoreboard[12] = 50;
						}
					}
				}
			}
			System.out.println(scoreboard[12]);
		}
		public void totalScore(){
			int total = 0;
			for (int i = 0; i < scoreboard.length; i++) {
				total += scoreboard[i];
			}
			System.out.println("your total score is... " + total + "!");
		}
}
