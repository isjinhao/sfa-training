package headfirst._14_builder;

public class Client {

	public static void main(String[] args) {

		HouseBuilder commonHouseBuilder = new CommonHouseBuilder();

		commonHouseBuilder.buildColor();
		commonHouseBuilder.buildHeight();
		commonHouseBuilder.buildLayers();
		System.out.println(commonHouseBuilder.getHouse());

		System.out.println("-------------------------------------------------------");

		HouseBuilder highBuildingBuilder1 = new HighBuildingBuilder();
		highBuildingBuilder1.buildColor();
		highBuildingBuilder1.buildHeight();
		highBuildingBuilder1.buildLayers();
		System.out.println(highBuildingBuilder1.getHouse());




		HouseDirector houseDirector = new HouseDirector(commonHouseBuilder);
		House house = houseDirector.constructHouse();
		System.out.println(house);
		
		System.out.println("--------------------------");

		HighBuildingBuilder highBuildingBuilder = new HighBuildingBuilder();
		houseDirector.setHouseBuilder(highBuildingBuilder);
		House house1 = houseDirector.constructHouse();
		System.out.println(house1);

	}

}