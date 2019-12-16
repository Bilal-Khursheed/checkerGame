import java.io.*;
import java.util.Scanner;
public class CheckersGame {
    
    static String[][] board = {{"  ","A ","B ","C ","D ","E ","F ","G ","H ","  "},
			       {"  ","  ","W ","  ","W ","  ","W ","  ","W "," "},
			       {"  ","W ","  ","W ","  ","W ","  ","W ","  "," "},
			       {"  ","  ","W ","  ","W ","  ","W ","  ","W "," "},
			       {"  ","  ","  ","  ","  ","  ","  ","  ","  "," "},
			       {"  ","  ","  ","  ","  ","  ","  ","  ","  "," "},
			       {"  ","B ","  ","B ","  ","B ","  ","B ","  "," "},
			       {"  ","  ","B ","  ","B ","  ","B ","  ","B "," "},
			       {"  ","B ","  ","B ","  ","B ","  ","B ","  "," "}};
        public static void main_interface() throws IOException{
            Scanner Name_input = new Scanner ( (System.in));
		System.out.print("Enter name of the first to move: ");
		String name = Name_input.next();
		System.out.print("Enter name of " + name + "'s opponent: ");
		String opo = Name_input.next();
                CheckersGame  nn= new CheckersGame();
                         nn.Game_Display(board);
		        System.out.println("You'll handle the BLACK(B) stones " + name+".");
		        System.out.println("You'll handle the WHITE(W) stones " + opo);
                        nn.Move_Compare(board, name, opo);
        } 
	public static void main (String []args) throws IOException {
		
                       main_interface();
        }
        
                        
                        
         public void Move_Compare(String[][] board , String name,String opo)throws IOException {  
              Scanner index_input = new Scanner ( (System.in));
              int Black_count=12;
              int White_count=12;
		boolean team = true;
                for(;;){
                    if(Black_count == 0){
                        System.out.println("Winner Winner Chicken Dinner.....");
                        System.out.println(opo + "'s Win the game");
                        System.out.println("Press 1 to play Again and 2 to exit");
                        int x= index_input.nextInt();
                        switch(x){
                            case 1:
                            {
                                main_interface();
                            }
                            default :{
                                System.out.println("Game End...");
                                System.exit(x);
                            }
                        }
                    }else if(White_count==0){
                        System.out.println("Winner Winner Chicken Dinner.....");
                        System.out.println(name + "'s Win the game");
                        System.out.println("Press 1 to play Again and 2 to exit");
                        int x= index_input.nextInt();
                        switch(x){
                            case 1:
                            {
                                main_interface();
                            }
                            default :{
                                System.out.println("Game End...");
                                System.exit(x);
                            }
                        }
                    }
                    else{
			if(team){
                            boolean t=false;
                                int a =0;
                                int b=0;
                                int c =0;
                                int d =0;
                                char alphabet='a';
                                char alphabet_to='a';
                                String move_to="";
                                String move="";
                             while(t!=true){
				System.out.println("\n"+name+"'s BLACK(B) move: ");
                               
				try{
                                    System.out.println("\nKindly Enter index number you want to move(e.g: 5a)");
                                    move = index_input.next();
                                    a = ( Integer.parseInt(""+move.charAt(0))+1 );
                                    alphabet=move.charAt(1);
                                   t=true;
                                }catch(Exception e) {
                                        System.out.println("Input Invalid TRY again");
                                        t=false;
                                        }
                                }
                               t=false;
                             while(t!=true){
				try{
                                    System.out.println("\nKindly Enter diagonal index number you want to move(4b)");
                                    move_to = index_input.next();
                                    c = Integer.parseInt(""+move_to.charAt(0))+1;
                                    alphabet_to=move_to.charAt(1);
                                   t=true;
                                }catch(Exception e) {
                                        System.out.println("Input Invalid TRY again");
                                        t=false;
                                        }
                                }
                                
                                String Alpha=Character.toString(alphabet).trim();
                                if(Alpha.equalsIgnoreCase("A")){
                                    b=1;
                                }else if(Alpha.equalsIgnoreCase("B")){
                                    b=2;
                                }
                                else if(Alpha.equalsIgnoreCase("C")){
                                    b=3;
                                }
                                else if(Alpha.equalsIgnoreCase("D")){
                                    b=4;
                                }
                                else if(Alpha.equalsIgnoreCase("E")){
                                    b=5;
                                }else if(Alpha.equalsIgnoreCase("F")){
                                    b=6;
                                }else if(Alpha.equalsIgnoreCase("G")){
                                    b=7;
                                }else if(Alpha.equalsIgnoreCase("H")){
                                    b=8;
                                }
                                String Alpha_to=Character.toString(alphabet_to).trim();
                                if(Alpha_to.equalsIgnoreCase("A")){
                                    d=1;
                                }else if(Alpha_to.equalsIgnoreCase("B")){
                                    d=2;
                                }
                                else if(Alpha_to.equalsIgnoreCase("C")){
                                    d=3;
                                }
                                else if(Alpha_to.equalsIgnoreCase("D")){
                                    d=4;
                                }
                                else if(Alpha_to.equalsIgnoreCase("E")){
                                    d=5;
                                }else if(Alpha_to.equalsIgnoreCase("F")){
                                    d=6;
                                }else if(Alpha_to.equalsIgnoreCase("G")){
                                    d=7;
                                }else if(Alpha_to.equalsIgnoreCase("H")){
                                    d=8;
                                }
                                
				
				if(board[a][b].equalsIgnoreCase("B ")&&board[c][d].equalsIgnoreCase("  ")&&((a-c==1)||a-c==-1)&&(b-d==1||b-d==-1)){
					board[a][b] = "  ";
					board[c][d] = "B ";
                                        
				}
				else if(board[a+1][b+1].equalsIgnoreCase("W ")&&board[a][b].equalsIgnoreCase("B ")&&board[c][d].equalsIgnoreCase("  ")){
					board[a+1][b+1] = "  ";
					board[a][b] = "  ";
					board[c][d] = "B ";
                                        Black_count--;
				}
				else if(board[a+1][b-1].equalsIgnoreCase("W ")&&board[a][b].equalsIgnoreCase("B ")&&board[c][d].equalsIgnoreCase("  ")){
					board[a+1][b-1] = "  ";
					board[a][b] = "  ";
					board[c][d] = "B ";
                                        Black_count--;
				}
				else if(board[a-1][b+1].equalsIgnoreCase("W ")&&board[a][b].equalsIgnoreCase("B ")&&board[c][d].equalsIgnoreCase("  ")){
					board[a-1][b+1] = "  ";
					board[a][b] = "  ";
					board[c][d] = "B ";
                                        Black_count--;
				}
				else if(board[a-1][b-1].equalsIgnoreCase("W ")&&board[a][b].equalsIgnoreCase("B ")&&board[c][d].equalsIgnoreCase("  ")){
					board[a-1][b-1] = "  ";
					board[a][b] = "  ";
					board[c][d] = "B ";
                                        Black_count--;
				}
				else{
					System.out.println("Invalid input!");
				}
				    Game_Display(board);
				team = false;
				}
			else if(team == false){
                             boolean t=false;
                                int a =0;
                                int b=0;
                                int c =0;
                                int d =0;
                                char alphabet='a';
                                char alphabet_to='a';
                                String move_to="";
                                String move="";
                             while(t!=true){
				System.out.println("\n"+opo+"'s WHITE(W) move: ");
                               
				try{
                                    System.out.println("\nKindly Enter index number you want to move(e.g: 2B)");
                                    move = index_input.next();
                                   // System.out.println("\nKindly Enter diagonal index number you want to move(e.g:3A)");
                                   // move_to = index_input.next();
                                    a = ( Integer.parseInt(""+move.charAt(0))+1 );
                                    alphabet=move.charAt(1);
                                   // c = Integer.parseInt(""+move_to.charAt(0))+1;
                                   // alphabet_to=move_to.charAt(1);
                                   t=true;
                                }catch(Exception e) {
                                        System.out.println("Input Invalid TRY again");
                                        t=false;
                                        }
                                }
                             t=false;
                             while(t!=true){
				try{
                                    System.out.println("\nKindly Enter diagonal index number you want to move(e.g:3A)");
                                    move_to = index_input.next();
                                    c = Integer.parseInt(""+move_to.charAt(0))+1;
                                    alphabet_to=move_to.charAt(1);
                                   t=true;
                                }catch(Exception e) {
                                        System.out.println("Input Invalid TRY again");
                                        t=false;
                                        }
                                }
                                String Alpha=Character.toString(alphabet).trim();                              
                                if(Alpha.equalsIgnoreCase("A")){
                                    b=1;
                                }else if(Alpha.equalsIgnoreCase("B")){
                                    b=2;
                                }
                                else if(Alpha.equalsIgnoreCase("C")){
                                    b=3;
                                }
                                else if(Alpha.equalsIgnoreCase("D")){
                                    b=4;
                                }
                                else if(Alpha.equalsIgnoreCase("E")){
                                    b=5;
                                }else if(Alpha.equalsIgnoreCase("F")){
                                    b=6;
                                }else if(Alpha.equalsIgnoreCase("G")){
                                    b=7;
                                }else if(Alpha.equalsIgnoreCase("H")){
                                    b=8;
                                }
                                String Alpha_to=Character.toString(alphabet_to).trim();
                                if(Alpha_to.equalsIgnoreCase("A")){
                                    d=1;
                                }else if(Alpha_to.equalsIgnoreCase("B")){
                                    d=2;
                                }
                                else if(Alpha_to.equalsIgnoreCase("C")){
                                    d=3;
                                }
                                else if(Alpha_to.equalsIgnoreCase("D")){
                                    d=4;
                                }
                                else if(Alpha_to.equalsIgnoreCase("E")){
                                    d=5;
                                }else if(Alpha_to.equalsIgnoreCase("F")){
                                    d=6;
                                }else if(Alpha_to.equalsIgnoreCase("G")){
                                    d=7;
                                }else if(Alpha_to.equalsIgnoreCase("H")){
                                    d=8;
                                }
				if(board[a][b].equalsIgnoreCase("W ")&&board[c][d].equalsIgnoreCase("  ")&&((a-c==1)||a-c==-1)&&(b-d==1||b-d==-1)){
					board[a][b] = "  ";
					board[c][d] = "W ";
                                        System.out.println("in  W 1st if");
				}
				else if(board[a+1][b+1].equalsIgnoreCase("B ")&&board[a][b].equalsIgnoreCase("W ")&&board[c][d].equalsIgnoreCase("  ")){
					board[a+1][b+1] = "  ";
					board[a][b] = "  ";
					board[c][d] = "W ";
                                        White_count--;
                                        System.out.println("in  W 2st if");
				}
				else if(board[a+1][b-1].equalsIgnoreCase("B ")&&board[a][b].equalsIgnoreCase("W ")&&board[c][d].equalsIgnoreCase("  ")){
					board[a+1][b-1] = "  ";
					board[a][b] = "  ";
					board[c][d] = "W ";
                                        White_count--;
                                        System.out.println("in  W 3st if");
				}
				else if(board[a-1][b+1].equalsIgnoreCase("B ")&&board[a][b].equalsIgnoreCase("W ")&&board[c][d].equalsIgnoreCase("  ")){
					board[a-1][b+1] = "  ";
					board[a][b] = "  ";
					board[c][d] = "W ";
                                        White_count--;
                                        System.out.println("in  W 4st if");
				}
				else if(board[a-1][b-1].equalsIgnoreCase("B ")&&board[a][b].equalsIgnoreCase("W ")&&board[c][d].equalsIgnoreCase("  ")){
					board[a-1][b-1] = "  ";
					board[a][b] = "  ";
					board[c][d] = "W ";
                                        White_count--;
                                        System.out.println("in  W 5st if");
				}
				else{
					System.out.println("Invalid input!");
				}
				Game_Display(board);
				team = true;
			}
		     }
                }
         }
	
        public static void Game_Display(String[][] board){
             for(int x=0; x<1; x++){
                     System.out.print("     ");
			for(int y=1; y<9; y++){
                                
				System.out.print(board[x][y] + " ");
                                
			}
		}
                for(int x=1; x<9; x++){
                    System.out.println("\n     __ __ __ __ __ __ __ __");
                    System.out.print(x-1+ ">  |");
			for(int y=1; y<9; y++){
				System.out.print(board[x][y]);
                                System.out.print("|");
			}
                        System.out.print("  <" +( x-1));
			
		}
                for(int x=0; x<1; x++){
                    System.out.println("\n     __ __ __ __ __ __ __ __");
                     System.out.print("     ");
			for(int y=1; y<9; y++){
				System.out.print(board[x][y] + " ");
                                
			}
                }
                System.out.println("\n    _________________________");
                    
                
        }
}