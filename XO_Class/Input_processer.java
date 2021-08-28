import java.io.Console;
public class Input_processer {

    private Console console = System.console();
    private boolean isnumpad;
    private XO_Class xo;
    


    public Input_processer() {

        System.out.println("Phonepad or Numpad");
        isnumpad = truth_input_check(1,2);
        System.out.println("How many block?");
        xo = new XO_Class(number_input_check(3,10));
        while(xo.getTurn_count() < (xo.getTableQuantity() * xo.getTableQuantity())+1) {
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
        if(xo.getTurn_count() == (xo.getTableQuantity() * xo.getTableQuantity())+1) {
            xo.display_board();
            System.out.println("Draw");
        }


    }

    public boolean truth_input_check(int a,int b) {
        int choice;
        boolean result;
        while(true) {
            try {
                choice = Integer.parseInt(console.readLine());
                if(choice >= a && choice <= b ) {
                    if(choice == 1) {
                        result = false;
                    } else {
                        result = true;
                    }
                    break;
                } else {
                    System.out.println("Please input only 1|2");
                }
            } catch (NumberFormatException e) {
                System.out.println("Please input only number");
            }
        }
        return result;
    }

    public int number_input_check(int a,int b) {
        int choice;
        int result;
        while(true) {
            try {
                choice = Integer.parseInt(console.readLine());
                if(choice >= a && choice <= b ) {
                    result = choice;
                    break;
                } else {
                    System.out.println("that's too much Please input number between " + a + " - " + b);
                }
            } catch (NumberFormatException e) {
                System.out.println("Please input only number");
            }
        }
        return result;
    }

    public void input_checker() {
        int position = 0;
        int row;
        int column;
        System.out.println("Turn " +xo.getTurn_count() + " [" + xo.getPlayer() + "] : Insert your position (1-" + (xo.getTableQuantity() * xo.getTableQuantity())+")");
        boolean input_done = false;
        while(!input_done) {
        boolean correct = false;
        while(!correct) {
        try {
            position = Integer.parseInt(console.readLine());
            if(position >= 1 && position <= (xo.getTableQuantity() * xo.getTableQuantity())) {
                correct = true;
            } else {
                System.out.println("Please input only 1-" + (xo.getTableQuantity() * xo.getTableQuantity()));
            }
        } catch (NumberFormatException e) {
            System.out.println("Please input only number");
        }
        position -= 1;
        if(!isnumpad) {
            row = position / xo.getTableQuantity();
            column = position % xo.getTableQuantity();
        }else {
            row = (xo.getTableQuantity() - 1) - position / xo.getTableQuantity();
            column = position % xo.getTableQuantity();
        }
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
