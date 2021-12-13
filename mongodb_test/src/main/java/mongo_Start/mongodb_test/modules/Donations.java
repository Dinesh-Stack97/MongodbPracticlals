package mongo_Start.mongodb_test.modules;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


public class Donations {

	@Id
	private int id;

	private String liveStocks;

	private String groceries;

	private String Foundations;

	private Double cash;

	private String OnlineDonations;

	private String foodAndHeritage;

	private String land;

	private Donars donar;

	public Donations() {

		// TODO Auto-generated constructor stub
	}

	public Donations(int id, String liveStocks, String groceries, String foundations, Double cash,
			String onlineDonations, String foodAndHeritage, String land, Donars donar) {
		super();
		this.id = id;
		this.liveStocks = liveStocks;
		this.groceries = groceries;
		Foundations = foundations;
		this.cash = cash;
		OnlineDonations = onlineDonations;
		this.foodAndHeritage = foodAndHeritage;
		this.land = land;
		this.donar = donar;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getLiveStocks() {
		return liveStocks;
	}

	public void setLiveStocks(String liveStocks) {
		this.liveStocks = liveStocks;
	}

	public String getGroceries() {
		return groceries;
	}

	public void setGroceries(String groceries) {
		this.groceries = groceries;
	}

	public String getFoundations() {
		return Foundations;
	}

	public void setFoundations(String foundations) {
		Foundations = foundations;
	}

	public Double getCash() {
		return cash;
	}

	public void setCash(Double cash) {
		this.cash = cash;
	}

	public String getOnlineDonations() {
		return OnlineDonations;
	}

	public void setOnlineDonations(String onlineDonations) {
		OnlineDonations = onlineDonations;
	}

	public String getFoodAndHeritage() {
		return foodAndHeritage;
	}

	public void setFoodAndHeritage(String foodAndHeritage) {
		this.foodAndHeritage = foodAndHeritage;
	}

	public String getLand() {
		return land;
	}

	public void setLand(String land) {
		this.land = land;
	}

	public Donars getDonar() {
		return donar;
	}

	public void setDonar(Donars donar) {
		this.donar = donar;
	}

}
