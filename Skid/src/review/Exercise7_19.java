package review;

public class Exercise7_19 {
	public static void main(String args[]) {
		Buyer b = new Buyer();
		b.buy(new Tv());
		b.buy(new Computer());
		b.buy(new Tv());
		b.buy(new Audio());
		b.buy(new Computer());
		b.buy(new Computer());
		b.buy(new Computer());
		b.summary();
	}
}

class Buyer {
	int money = 1000;
	Product[] cart = new Product[3]; // 구입한 제품을 저장하기 위한 배열
	int i = 0; // Product배열 cart에 사용될 index

	void buy(Product p) {
		if(money < p.price) {
			System.out.println("잔액이 부족하여"+p+"을/를 살수 없습니다.");
			return;
		}
		money -= p.price;
		add(p);
	}



	void add(Product p) {
		if(i >= cart.length) {
			Product[] tmp = new Product[cart.length*2];
			System.arraycopy(cart, 0, tmp, 0, cart.length);
			cart = tmp; // 이해 x 
		}
		cart[i++] = p;
		
	} // add(Product p)

	void summary() {
		String itemList = "";
		int sum = 0;
		
		for (int i = 0; i < cart.length; i++) {
			if(cart[i] == null)
				break;
			itemList += cart[i] + ",";
			sum += cart[i].price;
		}
		
		System.out.println(itemList);
		System.out.println(sum);
		System.out.println(money);
		/*
		 * (3) 아래의 로직에 맞게 코드를 작성하시오. 1.1 장바구니에 담긴 물건들의 목록을 만들어 출력한다. 1.2 장바구니에 담긴 물건들의
		 * 가격을 모두 더해서 출력한다. 1.3 물건을 사고 남은 금액(money)를 출력한다.
		 */
	} // summary()
}

class Product {
	int price; // 제품의 가격

	Product(int price) {
		this.price = price;
	}
}

class Tv extends Product {
	Tv() {
		super(100);
	}

	public String toString() {
		return "Tv";
	}
}

class Computer extends Product {
	Computer() {
		super(200);
	}

	public String toString() {
		return "Computer";
	}
}

class Audio extends Product {
	Audio() {
		super(50);
	}

public String toString() { return "Audio"; } 
}
