import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

import com.sun.jdi.Value;

/**
 * B0341058 徐聖鈞
 * Try to write some comments for your codes (methods, 15 points)
 */
public class HW2 {

	public static void main(String[] args) {
		//建立輸入的物件, 並以testn 保存輸入的值
		Scanner sc = new Scanner(System.in);
		System.out.println("input N (deck of cards):");
		String testn= sc.nextLine(); 
        
		int nDeck=Integer.parseInt(testn);
		Deck deck=new Deck(nDeck);
		//TODO: please check your output, make sure that you print all cards on your screen (10 points)
		deck.printDeck();
		
		
		
		
		
		
		
		if(isAllCardsCorrect(deck.getAllCards(),nDeck)){
			System.out.println("Well done!");
		}else{
			System.out.println("Error, please check your sourse code");
		}
	}
	

	/**
	 * This method is used for checking your result, not a part of your HW2
	 * @param allCards 所有的牌
	 * @param nDeck 總共有幾副牌
	 * @return
	 */
	private static boolean isAllCardsCorrect(ArrayList<Card> allCards,int nDeck){
		//check the output 
		boolean isCorrect=true;;
		HashMap <String,Integer> checkHash=new HashMap<String,Integer>();
		for(Card card:allCards){
			int suit= card.getSuit();
			int rank = card.getRank();
			if(suit>4||suit<1||rank>13||rank<1){
				isCorrect=false;
				break;
			}
			if(checkHash.containsKey(suit+","+rank)){
				checkHash.put(suit+","+rank, 
						checkHash.get(suit+","+rank)+1);
			}else{
				checkHash.put(suit+","+rank, 1);
			}

		}
		if(checkHash.keySet().size()==52){
			for(int value:checkHash.values()){
				if(value!=nDeck){
					isCorrect=false;
					break;
				}
			}
		}else{
			isCorrect=false;
		}
		return isCorrect;
	}


}
	
/**
 * Description: TODO: 用來進行把排洗入牌堆的動作
 */
//用來進行把排洗入牌堆的動作
class Deck{
	private ArrayList<Card> cards;
	private int i,j,k;
	//TODO: Please implement the constructor (30 points)
	public Deck(int nDeck){
		cards=new ArrayList<Card>();	
		for(i=0;i<nDeck;i++) {
			for(j=1;j<5;j++) {
				for(k=1;k<14;k++){
				Card card=new Card(j,k);
				cards.add(card);
				//System.out.println(card);
				//card.printCard();
				}
			}
		}
		//cards.add(card);
		//1 Deck have 52 cards, https://en.wikipedia.org/wiki/Poker
		//Hint: Use new Card(x,y) and 3 for loops to add card into deck
		//Sample code start
		//Card card=new Card(1,1); ->means new card as clubs ace
		//cards.add(card);
		//Sample code end

	}	
	//TODO: Please implement the method to print all cards on screen (10 points)
	public void printDeck(){
		//Hint: print all items in ArrayList<Card> cards, 
		//TODO: please implement and reuse printCard method in Card class (5 points)
		for(Card value:cards) {
		 value.printCard();
		}
	}
		
	public ArrayList<Card> getAllCards(){
		return cards;
	}
}
/**
 * Description:將花色的編碼改為文字，並print出來
 */
class Card{
	private int suit; //Definition: 1~4, Clubs=1, Diamonds=2, Hearts=3, Spades=4
	private int rank; //1~13
	private String[] arrayS = {"Clubs", "Diamonds", "Heart", "spades"};
	private String res1,res2;
	/**
	 * @param s suit
	 * @param r rank
	 */
	public Card(int s,int r){
		suit=s;
		rank=r;
		res1= arrayS[s-1];
		res2= Integer.toString(r);
		//printCard();
	}
	
	//TODO: 1. Please implement the printCard method (20 points, 10 for suit, 10 for rank)
	
	public void printCard(){
		//Hint: print (System.out.println) card as suit,rank, for example: print 1,1 as Clubs Ace
		System.out.println(res1+","+res2);
	}
	public int getSuit(){
		return suit;
	}
	public int getRank(){
		return rank;
	}
}
