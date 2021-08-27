public class XO_Class{


    private int tableQuantity;
    private String[][] board_array;
    private String player;
    private int turn_count;
   

    XO_Class() {
    	tableQuantity = 3;
    	board_array = new String[tableQuantity][tableQuantity];
    	clear_board();
        player = "X";
        turn_count = 1;
    }
    
    XO_Class(int table) {
    	tableQuantity = table;
    	board_array = new String[tableQuantity][tableQuantity];
    	clear_board();
   	    player = "X";
    	turn_count = 1;
    }
    
    public void clear_board() {
    	for (int i = 0; i < tableQuantity; i++) {
    		for (int j = 0; j < tableQuantity; j++) {
    			board_array[i][j] = " ";
    		}
    		}
    }
    
    
    public void display_board() { // show current board
        int count = 0;
        for (int i = 0; i < ((tableQuantity*2)-1);i++){
            if(i%2 == 1) {
                for(int j = 0; j<tableQuantity; j++) {
                    System.out.print("-----");
                }
                System.out.println("");
            } else {
                for (int j = 0; j < tableQuantity; j++) {
                    System.out.print("| "+ board_array[count][j] +" |");
                }
                count++;
                System.out.println("");
            }
        }
        
    }

    public void add_position(int row,int column) { 
        board_array[row][column] = player;
    }

    public void change_player() {
        if(player == "X") {
            player = "Y";
        } else {
            player = "X";
        }
    }

    public boolean check_winner() {
    boolean isSame = true;
	for (int i = 0; i < tableQuantity; i++) { //horizontal
        isSame = true;
		for (int j = 0; j < tableQuantity-1; j++) {
            if ((board_array[i][j] == board_array[i][j+1]) && (board_array[i][j] == "X" || board_array[i][j] == "Y")) {
				isSame = isSame & true;
			}
			else {
				isSame = isSame & false;
			}
		}

        if (isSame) {
            System.out.println("Horizontal");
            return isSame;
        }
	}
	for (int i = 0; i < tableQuantity; i++) { //vertical
        isSame = true;
		for (int j = 0; j < tableQuantity-1; j++) {
			if (board_array[j][i] == board_array[j+1][i] && (board_array[j][i] == "X" || board_array[j][i] == "Y")) {
				isSame = isSame & true;
			}
			else {
				isSame = isSame & false;
			}
		}

        if (isSame) {
            System.out.println("Vertical");
            return isSame;
        }
	}
    isSame = true;
	for(int i = 0;i < tableQuantity -1; i++) { // left cross
		if (board_array[i][i] == board_array[i+1][i+1] && (board_array[i][i] == "X" || board_array[i][i] == "Y")) { 
			isSame = isSame & true;
		}
		else {
			isSame = isSame & false;
        }
	}
    if (isSame) {
        System.out.println("Left Cross");
        return isSame;
    }

    isSame = true;
	for(int i = 0;i < tableQuantity -1; i++) { // right cross
		if (board_array[i][tableQuantity-1-i] == board_array[i+1][tableQuantity-i-2] && (board_array[i][tableQuantity-1-i] == "X" || board_array[i][tableQuantity-1-i] == "Y")) { 
			isSame = isSame & true;
		}
		else {
			isSame = isSame & false;
        }
		
	}
    if (isSame) {
        System.out.println("Right Cross");
    }
    return isSame;
}
    
    
    public boolean isAvaliable(int row,int column) {
        if(board_array[row][column] == " ") {
            return true;
        } else {
            return false;
        }
    }
    
    public void setPlayer(String text) {
        player = text;
    }

    public String getPlayer() {
        return player;
    }

    public void setTurn_count(int value) {
        turn_count = value;
    }

    public int getTurn_count() {
        return turn_count;
    }

    public int getTableQuantity() {
        return tableQuantity;
    }
}

