import java.util.*;

public class Encryption_Program {

    private final Scanner sc;
    private final ArrayList <Character> list;
    private ArrayList <Character> shuffled_list;
    private char character;
    private char[] letters;

    Encryption_Program(){
        // INITIALIZATION
        sc = new Scanner(System.in);
        Random rand = new Random();
        list = new ArrayList<>();
        shuffled_list = new ArrayList<>();
        character = ' ';

        new_key();
        ask_question();

    }

    private void ask_question(){
        while(true){
            System.out.println("-----------------------------------------------------");
            System.out.println("What do you want to do?: ");
            //noinspection SpellCheckingInspection
            System.out.println("(N)ew Key, (G)et Key, (E)ncrypt, (D)ecrypt, (Q)uit");
            char response = Character.toUpperCase(sc.nextLine().charAt(0));

            switch(response){

                case 'N':
                    new_key();
                    break;
                case 'G':
                    get_key();
                    break;
                case 'E':
                    encrypt();
                    break;
                case 'D':
                    decrypt();
                    break;
                case 'Q':
                    quit();
                    break;
                default:
                    System.out.println("Invalid choice");
                    break;
            }


        }
    }

    private void new_key(){
        character = ' ';
        list.clear();
        shuffled_list.clear();

        for (int i = 32; i < 127; i++){
            list.add(character);  // list.add(Character.valueOf((character));
            character++;
        }

        shuffled_list = new ArrayList<>(list);
        Collections.shuffle(shuffled_list);
        System.out.println("\n\nA NEW KEY HAS BEEN GENERATED!");
    }

    private void get_key(){
        System.out.println("Key");
        for (Character x: list){
            System.out.print(x);
        }
        System.out.println();
        for (Character x: shuffled_list){
            System.out.print(x);
        }
        System.out.println();
    }

    private void encrypt(){
        System.out.println("Enter the message to be encrypted: ");
        String message = sc.nextLine();
        letters = message.toCharArray();

        for (int i =0 ; i< message.length(); i++){
            for (int j = 0; j < list.size(); j++) {
                if (letters[i] == list.get(j)){
                    letters[i] = shuffled_list.get(j);
                    break;
                }
            }
        }

        System.out.println("Encrypted Message: ");
        for (Character x: letters){
            System.out.print(x);
        }
        System.out.println();
    }

    private void decrypt(){
        System.out.println("Enter the message to be decrypted: ");
        String message = sc.nextLine();
        letters = message.toCharArray();

        for (int i =0 ; i< message.length(); i++){
            for (int j = 0; j < shuffled_list.size(); j++) {
                if (letters[i] == shuffled_list.get(j)){
                    letters[i] = list.get(j);
                    break;
                }
            }
        }

        System.out.println("Decrypted Message: ");
        for (Character x: letters){
            System.out.print(x);
        }
        System.out.println();
    }

    private void quit(){
        System.out.println("Goodbye!");
        sc.close();
        System.exit(0);
    }

}
