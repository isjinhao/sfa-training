package headfirst._14_builder;

public class HouseDirector {
	
	HouseBuilder houseBuilder;

	public HouseDirector(HouseBuilder houseBuilder) {
		this.houseBuilder = houseBuilder;
	}

	public void setHouseBuilder(HouseBuilder houseBuilder) {
		this.houseBuilder = houseBuilder;
	}

	/**
	 * 开发时应该将复杂的处理过程应该放在这里
	 * @return
	 */
	public House constructHouse() {
		houseBuilder.buildHeight();
		houseBuilder.buildColor();
		houseBuilder.buildLayers();
		return houseBuilder.buildHouse();
	}

}