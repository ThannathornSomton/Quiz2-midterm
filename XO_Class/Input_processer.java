import java.io.Console;
public class Input_processer {

    private Console console = System.console();
    private boolean isnumpad;
    private XO_Class xo;
    


    public Input_processer() {
        xo = new XO_Class();
        System.out.println("Phonepad or Numpad");
        int choice;
        while(true) {
            try {
                choice = Integer.parseInt(console.readLine());
                if(choice >= 1 && choice <= 2 ) {
                    if(choice == 1) {
                        isnumpad = false;
                    } else {
                        isnumpad = true;
                    }
                    break;
                } else {
                    System.out.println("Please input only 1|2");
                }
            } catch (NumberFormatException e) {
                System.out.println("Please input only 1|2");
            }
        }
        while(xo.getTurn_count() < 10) {
            xo.display_board();
            input_checker();
            if(xo.check_winner()) {
                xo.display_board();
                System.out.println(xo.getPlayer() + " is the winner ");
                break;
            } else {
                xo.change_player();
            }
            xo.setTurn_count(xo.getTurn_count()+1);
        }
        if(xo.getTurn_count() == 10) {
            xo.display_board();
            System.out.println("Draw");
        }


    }

    public void input_checker() {
        int position = 0;
        System.out.println("Turn " +xo.getTurn_count() + " [" + xo.getPlayer() + "] : Insert your position (1-9)");
        boolean input_done = false;
        while(!input_done) {
        boolean correct = false;
        while(!correct) {
        try {
            position = Integer.parseInt(console.readLine());
            if(position >= 1 && position <= 9 ) {
                correct = true;
            } else {
                System.out.println("Please input only 1-9");
            }
        } catch (NumberFormatException e) {
            System.out.println("Wrong input!");
        } 
        }
        if(!isnumpad){
            position -= 1;
            int row = position/3;
            int column = position%3;
            if(xo.isAvaliable(row, column)){
                xo.add_position(row, column);
                input_done = true;
            } else {
                System.out.println("This position is already added");
            }
        }else {
            position = (10-position)-1;
            int row = position/3;
            int column = 2-position%3;
            if(xo.isAvaliable(row, column)){
                xo.add_position(row, column);
                input_done = true;
            } else {
                System.out.println("This position is already added");
            }

        }
    }

}


}
