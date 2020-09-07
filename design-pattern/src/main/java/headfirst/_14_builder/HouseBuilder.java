package headfirst._14_builder;


import org.apache.commons.lang.StringUtils;

public abstract class HouseBuilder {

	protected House house = new House();

	protected abstract void buildHeight();
	protected abstract void buildColor();
	protected abstract void buildLayers();
	
	public House buildHouse() {
		if(StringUtils.isBlank(house.getHeight()) || StringUtils.isBlank(house.getColor()) || StringUtils.isBlank(house.getLayers()))
			throw new NullPointerException("house 没有建造好");
		return house;
	}

	public House getHouse() {
		return house;
	}
}
